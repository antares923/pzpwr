package storage;

import exception.StorageException;
import type.PatientRegistration;

import java.util.List;

public interface PatientRegistrationStorage {

    void add(PatientRegistration registration) throws StorageException;

    void remove(int patientId) throws StorageException;

    List<PatientRegistration> getAllObjects();
}
