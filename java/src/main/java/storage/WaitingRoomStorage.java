package storage;

import exception.StorageException;
import type.PatientQuery;

import java.util.List;

public interface WaitingRoomStorage {

    void add(PatientQuery patientQuery) throws StorageException;

    void remove(PatientQuery patientQuery) throws StorageException;

    List<PatientQuery> getAllObjects();
}
