package com.pzpwr.core.endpoint;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.storage.WaitingRoomStorage;
import com.pzpwr.core.type.PatientQuery;
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

import javax.servlet.http.HttpServletResponse;

@RestController
public class PatientRegisterEndpoint {

    @Autowired
    private WaitingRoomStorage waitingRoomStorage;

    private Logger logger = Logger.getLogger("PatientRegisterEndpoint");

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity registerPatient(@RequestBody(required = true) PatientQuery patientQuery)
            throws StorageException {
        logger.debug("registerPatient(patientQuery: " + patientQuery + ") called");
        logger.info("Trying to register patient (" + patientQuery + ")");
        waitingRoomStorage.add(patientQuery);
        ResponseEntity response = new ResponseEntity<>(HttpStatus.OK);
        logger.info("Patient registered changed");
        logger.debug("registerPatient() returned " + response);
        return response;
    }

    @ExceptionHandler(StorageException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,
            reason = "Uzytkownik o podanym id nie istnieje")
    public void handleFailingToGetUser(StorageException e, HttpServletResponse response) {
        logger.warn("User with id " + e.getProblematicId() + " doesn't exists");
    }
}
