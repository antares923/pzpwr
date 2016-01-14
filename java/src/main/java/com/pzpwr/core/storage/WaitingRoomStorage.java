package com.pzpwr.core.storage;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.PatientQuery;

import java.util.List;

public interface WaitingRoomStorage {

    void add(PatientQuery patientQuery) throws StorageException;

    void remove(PatientQuery patientQuery) throws StorageException;

    List<PatientQuery> getAllObjects();
}
