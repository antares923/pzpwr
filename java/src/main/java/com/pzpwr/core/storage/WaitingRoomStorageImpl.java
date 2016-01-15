package com.pzpwr.core.storage;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.PatientQuery;

import java.util.List;

public class WaitingRoomStorageImpl extends BaseStorage<Integer, PatientQuery> implements WaitingRoomStorage {

    @Override
    public void add(PatientQuery patientQuery) throws StorageException {
        super.add(patientQuery.getPatientId(), patientQuery);
    }

    @Override
    public void remove(PatientQuery patientQuery) throws StorageException {
        super.remove(patientQuery.getPatientId());
    }

    @Override
    public PatientQuery get(int patientId) throws StorageException {
        return super.get(patientId);
    }

    @Override
    public List<PatientQuery> getAllObjects() {
        List<PatientQuery> allObjectsList = super.getAllObjects();
        super.removeAll();
        return allObjectsList;
    }
}
