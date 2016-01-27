package com.pzpwr.core.scheduler;

import com.pzpwr.core.appenum.JobEnum;
import com.pzpwr.core.appenum.VisitTypeEnum;
import com.pzpwr.core.connection.VisitTypeToJobConnection;
import com.pzpwr.core.exception.NoFreeRoomException;
import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.generator.TimeGenerator;
import com.pzpwr.core.storage.PatientRegistrationStorage;
import com.pzpwr.core.storage.RoomReservationStorage;
import com.pzpwr.core.storage.UserStorage;
import com.pzpwr.core.storage.VisitStorage;
import com.pzpwr.core.type.PatientRegistration;
import com.pzpwr.core.type.RoomReservation;
import com.pzpwr.core.type.User;
import com.pzpwr.core.type.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class Scheduler {

    private static final int VISIT_LENGTH = 10;

    @Autowired
    private VisitStorage visitStorage;

    @Autowired
    private PatientRegistrationStorage patientRegistrationStorage;

    @Autowired
    private RoomReservationStorage roomReservationStorage;

    @Autowired
    private UserStorage userStorage;

    @Autowired
    private TimeGenerator timeGenerator;

    @Autowired
    private VisitTypeToJobConnection visitTypeToJobConnection;

    @Autowired
    private DoctorScheduler doctorScheduler;

    private List<String> reserveQueue = new ArrayList<>();

    public void schedule() throws Exception {

        reserveQueue.clear();
        cleanStorages();
        doctorScheduler.initialize();
        timeGenerator.initialize(100);

        List<PatientRegistration> patientRegistrationList = patientRegistrationStorage.getAllObjects();
        Map<VisitTypeEnum, JobEnum> jobMap = visitTypeToJobConnection.getVisitTypeEnumToJobEnumConnectionMap();

        Collections.sort(patientRegistrationList, (p1, p2) -> Integer.valueOf(p2.getRisk()).compareTo(p1.getRisk()));
        int i = 0;

        for (PatientRegistration patientRegistration : patientRegistrationList) {
            timeGenerator.reset();
            int patientId = patientRegistration.getPatientId();
            VisitTypeEnum type = patientRegistration.getType();

            String patientLogin = userStorage.getById(patientId).getLogin();

            User availableDoctor = null;
            int roomNumber = -1;

            LocalDateTime dateTime;
            while( (dateTime = timeGenerator.generateNextFreeDate(VISIT_LENGTH)) != null) {

                JobEnum job = jobMap.get(type);
                availableDoctor = doctorScheduler.getDoctorAvailableInTime(job, dateTime, dateTime.plusMinutes(VISIT_LENGTH));

                if (availableDoctor == null) {
                    continue;
                }

                roomNumber = reserveRoom(dateTime, dateTime.plusMinutes(VISIT_LENGTH));

                if (roomNumber == -1) {
                    doctorScheduler.releaseDoctor(availableDoctor, dateTime, dateTime.plusMinutes(VISIT_LENGTH));
                } else {
                    break;
                }
            }

            if (availableDoctor == null || roomNumber == -1) {
                addToReserveQueue(patientLogin);
                continue;
            }

            Visit visit = new Visit();

            List<Integer> neededDoctors = new ArrayList<>();
            neededDoctors.add(availableDoctor.getId());

            visit.setId(i);
            visit.setRoomNumber(roomNumber);
            visit.setDoctorIdList(neededDoctors);
            visit.setDateTime(dateTime);
            visit.setDurationInMinutes(VISIT_LENGTH);
            visit.setPatientLogin(patientLogin);
            visit.setType(type);

            visitStorage.add(visit);
            i++;
        }
    }

    private void cleanStorages() {
        visitStorage.removeAll();
        roomReservationStorage.removeAll();
    }

    private int reserveRoom(LocalDateTime startTime, LocalDateTime endTime) throws StorageException, NoFreeRoomException {
        try {
            int roomNumber = roomReservationStorage.getFreeRoomAtTime(startTime, endTime);

            if (roomNumber != -1) {
                RoomReservation reservation = new RoomReservation();
                reservation.setRoomNumber(roomNumber);
                reservation.setReservationStartTime(startTime);
                reservation.setReservationEndTime(endTime);

                roomReservationStorage.add(reservation);
                return roomNumber;
            } else {
                return -1;
            }
        } catch (NoFreeRoomException e) {
            return -1;
        }
    }

    private void addToReserveQueue(String patientLogin) {
        reserveQueue.add(patientLogin);
    }
}
