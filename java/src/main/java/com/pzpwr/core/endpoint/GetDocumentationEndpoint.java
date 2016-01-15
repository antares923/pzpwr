package com.pzpwr.core.endpoint;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.storage.PersonStorage;
import com.pzpwr.core.type.Person;
import com.pzpwr.core.type.Visit;
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
public class GetDocumentationEndpoint {

    @Autowired
    private PersonStorage personStorage;

    private Logger logger = Logger.getLogger("GetDocumentationEndpoint");

    @RequestMapping(value = "get_documentation", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Visit>> getDocumentation(@RequestBody(required = true) String login)
            throws StorageException {
        logger.debug("getDocumentation(login: " + login + ") called");
        logger.info("Trying to get documentation of user (" + login + ")");
        Person person = personStorage.get(login);
        List<Visit> documentation = person.getMedicalDocumentation();
        ResponseEntity<List<Visit>> response = new ResponseEntity<>(documentation, HttpStatus.OK);
        logger.info("Documentation for patient (" + login + ")[" + documentation.size() + "] returned");
        logger.debug("getDocumentation() returned " + response);
        return response;
    }

    @ExceptionHandler(StorageException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,
            reason = "Uzytkownik o podanym id nie istnieje")
    public void handleFailingToGetUser(StorageException e, HttpServletResponse response) {
        logger.warn("User with id " + e.getProblematicId() + " doesn't exists");
    }
}
