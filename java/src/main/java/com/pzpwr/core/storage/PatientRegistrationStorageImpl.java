package com.pzpwr.core.storage;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.PatientRegistration;

import java.util.List;

public class PatientRegistrationStorageImpl extends BaseStorage<Integer, PatientRegistration>
        implements PatientRegistrationStorage {

    @Override
    public void add(List<PatientRegistration> registration) throws StorageException {
        for (PatientRegistration patientRegistration : registration) {
            super.add(patientRegistration.getPatientId(), patientRegistration);
        }
    }

    @Override
    public void remove(int patientId) throws StorageException {
        super.remove(patientId);
    }

    @Override
    public PatientRegistration get(int patientId) throws StorageException {
        return super.get(patientId);
    }
}
