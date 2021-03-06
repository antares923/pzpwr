package com.pzpwr.core.storage;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.PatientRegistration;

import java.util.List;

public interface PatientRegistrationStorage {

    void add(List<PatientRegistration> registration) throws StorageException;

    void remove(int patientId) throws StorageException;

    PatientRegistration get(int patientId) throws StorageException;

    List<PatientRegistration> getAllObjects();
}
