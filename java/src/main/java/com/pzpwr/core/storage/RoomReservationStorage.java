package com.pzpwr.core.storage;

import com.pzpwr.core.exception.NoFreeRoomException;
import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.RoomReservation;

import java.time.LocalDateTime;
import java.util.List;

public interface RoomReservationStorage {

    void add(RoomReservation roomReservation) throws StorageException;

    void release(RoomReservation roomReservation) throws StorageException;

    List<RoomReservation> get(int roomNumber) throws StorageException;

    void setAvailableRoomNumbers(List<Integer> availableRoomNumbers);

    int getFreeRoomAtTime(LocalDateTime startTime, LocalDateTime endTime) throws NoFreeRoomException;
}
