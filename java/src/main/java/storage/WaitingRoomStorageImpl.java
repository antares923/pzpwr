package storage;

import exception.StorageException;
import type.PatientQuery;

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
