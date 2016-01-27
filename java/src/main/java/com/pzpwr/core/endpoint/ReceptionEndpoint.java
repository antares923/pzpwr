package com.pzpwr.core.endpoint;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.scheduler.Scheduler;
import com.pzpwr.core.storage.PatientRegistrationStorage;
import com.pzpwr.core.storage.WaitingRoomStorage;
import com.pzpwr.core.type.PatientQuery;
import com.pzpwr.core.type.PatientRegistration;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ReceptionEndpoint {

    @Autowired
    private WaitingRoomStorage waitingRoomStorage;

    @Autowired
    private PatientRegistrationStorage patientRegistrationStorage;

    @Autowired
    private Scheduler scheduler;

    private Logger logger = Logger.getLogger("ReceptionEndpoint");

    @RequestMapping(value = "reception/patients", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<PatientQuery>> getWaitingPatients() {
        logger.debug("getWaitingPatients() called");
        logger.info("Trying to get list of waiting patients");
        List<PatientQuery> patientQueryList = waitingRoomStorage.getAllObjects();
        ResponseEntity<List<PatientQuery>> response = new ResponseEntity<>(patientQueryList, HttpStatus.OK);
        logger.info("List of (" + patientQueryList.size() + ") returned");
        logger.debug("getWaitingPatients() returned " + response);
        return response;
    }

    @RequestMapping(value = "reception/patient_acceptation", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity patientAcceptation(@RequestBody(required = true)
                                             List<PatientRegistration> patientRegistrationList)
            throws StorageException {
        logger.debug("patientAcceptation(patientRegistrationList: " + patientRegistrationList + ") called");
        logger.info("Trying to accept list of patients: " + patientRegistrationList);
        patientRegistrationStorage.add(patientRegistrationList);
        try {
            scheduler.schedule();
        } catch (Exception e) {
            logger.info("somethings going wrong: " + e.getMessage());
            e.printStackTrace();
        }
        ResponseEntity response = new ResponseEntity<>(HttpStatus.OK);
        logger.info("List of (" + patientRegistrationList.size() + ") added");
        logger.debug("patientAcceptation() returned " + response);
        return response;
    }

    @ExceptionHandler(StorageException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,
            reason = "Uzytkownik o podanym id juz istnieje")
    public void handleFailingToAddUser(StorageException e, HttpServletResponse response) {
        logger.warn("User with id " + e.getProblematicId() + " already exists");
    }
}
