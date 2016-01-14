package storage;

import exception.NoFreeRoomException;
import exception.StorageException;
import type.RoomReservation;

import java.time.LocalDateTime;

public interface RoomReservationStorage {

    void add(RoomReservation roomReservation) throws StorageException;

    void release(RoomReservation roomReservation) throws StorageException;

    int getFreeRoomAtTime(LocalDateTime startTime, LocalDateTime endTime) throws NoFreeRoomException;
}
