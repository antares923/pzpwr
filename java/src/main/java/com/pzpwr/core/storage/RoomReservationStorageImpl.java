package com.pzpwr.core.storage;

import com.pzpwr.core.exception.NoFreeRoomException;
import com.pzpwr.core.exception.StorageException;
import org.apache.log4j.Logger;
import com.pzpwr.core.type.RoomReservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomReservationStorageImpl implements RoomReservationStorage {

    private Map<Integer, List<RoomReservation>> map = new HashMap<>();
    private List<Integer> availableRoomNumbers = new ArrayList<>();
    private Logger logger = Logger.getLogger("RoomReservationStorage");

    @Override
    public void add(RoomReservation roomReservation) throws StorageException {
        logger.debug("add(roomReservation: " + roomReservation + ") called");
        List<RoomReservation> roomReservationList = map.get(roomReservation.getRoomNumber());
        if (roomReservationList == null) {
            roomReservationList = new ArrayList<>();
            map.put(roomReservation.getRoomNumber(), roomReservationList);
        }
        if (!checkRoomAvailability(roomReservation.getRoomNumber(), roomReservation.getReservationStartTime(),
                roomReservation.getReservationEndTime())) {
            throw new StorageException("Cannot add reservation on this date. Room is already reserved");
        }
        roomReservationList.add(roomReservation);
        logger.debug("add() executed");
    }

    @Override
    public void release(RoomReservation roomReservation) throws StorageException {
        List<RoomReservation> roomReservationList = map.get(roomReservation.getRoomNumber());
        if (roomReservationList == null) {
            throw new StorageException("There is no reservation " + roomReservation);
        }
        roomReservationList.remove(roomReservation);
    }

    @Override
    public int getFreeRoomAtTime(LocalDateTime startTime, LocalDateTime endTime) throws NoFreeRoomException {
        logger.debug("getFreeRoomAtTime(startTime: " + startTime + ", endTime: " + endTime + ") called");
        for (int roomNumber : availableRoomNumbers) {
            logger.debug("Checking room " + roomNumber);
            if (checkRoomAvailability(roomNumber, startTime, endTime)) {
                logger.debug("getFreeRoomAtTime() returned " + roomNumber);
                return roomNumber;
            }
        }
        logger.debug("getFreeRoomAtTime() returned -1");
        return -1;
    }

    private boolean checkRoomAvailability(int roomNumber, LocalDateTime startTime, LocalDateTime endTime) {
        logger.debug("checkRoomAvailability(roomNumber: " + roomNumber + ", startTime: " + startTime + ", endTime: "
                + endTime + ") called");
        List<RoomReservation> roomReservationList = map.get(roomNumber);
        if (roomReservationList == null || roomReservationList.isEmpty()) {
            logger.debug("checkRoomAvailability() returned true - empty list");
            return true;
        }
        logger.debug("reservation list: " + map);
        for (RoomReservation roomReservation : roomReservationList) {
            logger.debug("Checked room: " + roomReservation.getRoomNumber());
            logger.debug(" Times: ");
            logger.debug("  " + roomReservation.getReservationStartTime());
            logger.debug("  " + roomReservation.getReservationEndTime());
            if ((startTime.isAfter(roomReservation.getReservationStartTime()) && startTime.isBefore(roomReservation.getReservationEndTime()) ||
                    startTime.isEqual(roomReservation.getReservationStartTime())) ||
                    (endTime.isAfter(roomReservation.getReservationStartTime()) && endTime.isBefore(roomReservation.getReservationEndTime())) ||
                    endTime.isEqual(roomReservation.getReservationEndTime())) {
                logger.debug("checkRoomAvailability() returned false - room reserved");
                logger.debug("Room reservation times: ");
                logger.debug("  " + roomReservation.getReservationStartTime());
                logger.debug("  " + roomReservation.getReservationEndTime());
                return false;
            }
        }
        logger.debug("checkRoomAvailability() returned true - no reservation");
        return true;
    }

    public void setAvailableRoomNumbers(List<Integer> availableRoomNumbers) {
        this.availableRoomNumbers = availableRoomNumbers;
    }
}
