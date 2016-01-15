package com.pzpwr.core.creator;

import com.pzpwr.core.storage.PatientRegistrationStorage;
import com.pzpwr.core.storage.PatientRegistrationStorageImpl;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientRegistrationStorageCreator {

    private Logger logger = Logger.getLogger("PatientRegistrationStorageCreator");

    @Bean(name = "patientRegistrationStorage")
    public PatientRegistrationStorage createPatientRegistrationStorage() {
        logger.debug("createPatientRegistrationStorage() called");
        PatientRegistrationStorage patientRegistrationStorage = new PatientRegistrationStorageImpl();
        logger.info("Patient registration storage created");
        logger.debug("createPatientRegistrationStorage() returned " + patientRegistrationStorage);
        return patientRegistrationStorage;
    }
}
