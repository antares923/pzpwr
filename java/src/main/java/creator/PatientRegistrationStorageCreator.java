package creator;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import storage.PatientRegistrationStorage;
import storage.PatientRegistrationStorageImpl;

@Configuration
public class PatientRegistrationStorageCreator {

    private Logger logger = Logger.getLogger("PatientRegistrationStorageCreator");

    @Bean(name = "patientRegistrationStorage")
    public PatientRegistrationStorage createPatientRegistrationStorage() {
        logger.debug("createPatientRegistrationStorage() called");
        PatientRegistrationStorage patientRegistrationStorage = new PatientRegistrationStorageImpl();
        logger.debug("createPatientRegistrationStorage() returned " + patientRegistrationStorage);
        return patientRegistrationStorage;
    }
}
