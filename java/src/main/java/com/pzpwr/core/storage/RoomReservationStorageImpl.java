package com.pzpwr.core.storage;

import com.pzpwr.core.exception.NoFreeRoomException;
import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.RoomReservation;
import org.apache.log4j.Logger;

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
            throw new StorageException(String.valueOf(roomReservation.getRoomNumber()),
                    "Cannot add reservation on this date. Room is already reserved");
        }
        roomReservationList.add(roomReservation);
        logger.debug("add() executed");
    }

    @Override
    public void release(RoomReservation roomReservation) throws StorageException {
        List<RoomReservation> roomReservationList = map.get(roomReservation.getRoomNumber());
        if (roomReservationList == null) {
            throw new StorageException(String.valueOf(roomReservation.getRoomNumber()),
                    "There is no reservation " + roomReservation);
        }
        roomReservationList.remove(roomReservation);
    }

    @Override
    public List<RoomReservation> get(int roomNumber) throws StorageException {
        logger.debug("get(roomNumber: " + roomNumber + ") called");
        List<RoomReservation> roomReservationList = map.get(roomNumber);
        if (roomReservationList == null) {
            throw new StorageException(String.valueOf(roomNumber),
                    "Object (" + roomNumber + ") not found in storage");
        }
        return null;
    }

    @Override
    public int getFreeRoomAtTime(LocalDateTime startTime, LocalDateTime endTime) throws NoFreeRoomException {
        logger.debug("getFreeRoomAtTime(startTime: " + startTime + ", endTime: " + endTime + ") called");
        for (int roomNumber : availableRoomNumbers) {
            logger.info("Checking room " + roomNumber);
            if (checkRoomAvailability(roomNumber, startTime, endTime)) {
                logger.debug("getFreeRoomAtTime() returned " + roomNumber);
                return roomNumber;
            }
        }
        logger.debug("getFreeRoomAtTime() returned -1");
        return -1;
    }

    private boolean checkRoomAvailability(int roomNumber, LocalDateTime startTime, LocalDateTime endTime) {
        logger.info("checkRoomAvailability(roomNumber: " + roomNumber + ", startTime: " + startTime + ", endTime: "
                + endTime + ") called");
        List<RoomReservation> roomReservationList = map.get(roomNumber);
        if (roomReservationList == null || roomReservationList.isEmpty()) {
            logger.debug("checkRoomAvailability() returned true - empty list");
            return true;
        }
        for (RoomReservation roomReservation : roomReservationList) {
            if ((startTime.isAfter(roomReservation.getReservationStartTime()) && startTime.isBefore(roomReservation.getReservationEndTime()) ||
                    startTime.isEqual(roomReservation.getReservationStartTime())) ||
                    (endTime.isAfter(roomReservation.getReservationStartTime()) && endTime.isBefore(roomReservation.getReservationEndTime())) ||
                    endTime.isEqual(roomReservation.getReservationEndTime())) {
                logger.debug("checkRoomAvailability() returned false");
                return false;
            }
        }
        logger.debug("checkRoomAvailability() returned true - no reservation");
        return true;
    }

    public void setAvailableRoomNumbers(List<Integer> availableRoomNumbers) {
        this.availableRoomNumbers = availableRoomNumbers;
    }

    public void removeAll() {
        map.clear();
    }
}
