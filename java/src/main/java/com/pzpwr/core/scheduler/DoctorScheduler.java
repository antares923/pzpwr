package com.pzpwr.core.scheduler;

import com.pzpwr.core.appenum.JobEnum;
import com.pzpwr.core.storage.UserStorage;
import com.pzpwr.core.type.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DoctorScheduler {

    @Autowired
    private UserStorage userStorage;

    private Map<JobEnum, List<User>> jobMap = new HashMap<>();
    private Map<User, List<ReservationTime>> reservationMap = new HashMap<>();

    public void initialize() {
        reservationMap.clear();
        for (int i = 0; i < JobEnum.values().length; i++) {
            List<User> listofJobUsers = userStorage.filterByJob(JobEnum.values()[i]);
            jobMap.put(JobEnum.values()[i], listofJobUsers);

            for (User user : listofJobUsers) {
                reservationMap.put(user, new ArrayList<ReservationTime>());
            }
        }

    }

    public List<User> getListOfJobUsers(JobEnum jobEnum) {
        return jobMap.get(jobEnum);
    }

    public User getDoctorAvailableInTime(JobEnum jobType, LocalDateTime startTime, LocalDateTime endTime) {
        List<User> doctorList = jobMap.get(jobType);

        for (User doctor : doctorList) {
            if (checkDoctorAvailability(doctor, startTime, endTime)) {
                ReservationTime reservationTime = new ReservationTime(startTime, endTime);
                List<ReservationTime> doctorReservationTime = reservationMap.get(doctor);
                doctorReservationTime.add(reservationTime);
                reservationMap.replace(doctor, doctorReservationTime);
                return doctor;
            }
        }
        return null;
    }

    private boolean checkDoctorAvailability(User doctor, LocalDateTime startTime, LocalDateTime endTime) {
        List<ReservationTime> timesReservationList = reservationMap.get(doctor);

        for (ReservationTime reservationTime : timesReservationList) {
            if ((startTime.isAfter(reservationTime.getStartTime()) && startTime.isBefore(reservationTime.getEndTime()) ||
                    startTime.isEqual(reservationTime.getStartTime())) ||
                    (endTime.isAfter(reservationTime.getStartTime()) && endTime.isBefore(reservationTime.getEndTime())) ||
                    endTime.isEqual(reservationTime.getEndTime())) {
                return false;
            }
        }
        return true;
    }

    public void releaseDoctor(User doctor, LocalDateTime startTime, LocalDateTime endTime) {
        List<ReservationTime> doctorsReservationTimeList = reservationMap.get(doctor);

        for (ReservationTime reservationTime : doctorsReservationTimeList) {
            if (reservationTime.getStartTime() == startTime && reservationTime.getEndTime() == endTime) {
                doctorsReservationTimeList.remove(reservationTime);
                break;
            }
        }
    }

}
