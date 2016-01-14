package com.pzpwr.core.storage;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.PatientQuery;

public class WaitingRoomStorageImpl extends BaseStorage<Integer, PatientQuery> implements WaitingRoomStorage {

    @Override
    public void add(PatientQuery patientQuery) throws StorageException {
        super.add(patientQuery.getPatientId(), patientQuery);
    }

    @Override
    public void remove(PatientQuery patientQuery) throws StorageException {
        super.remove(patientQuery.getPatientId());
    }
}
