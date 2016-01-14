package com.pzpwr.core.storage;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.PatientRegistration;

public class PatientRegistrationStorageImpl extends BaseStorage<Integer, PatientRegistration>
        implements PatientRegistrationStorage {

    @Override
    public void add(PatientRegistration registration) throws StorageException {
        super.add(registration.getPatientId(), registration);
    }

    @Override
    public void remove(int patientId) throws StorageException {
        super.remove(patientId);
    }
}
