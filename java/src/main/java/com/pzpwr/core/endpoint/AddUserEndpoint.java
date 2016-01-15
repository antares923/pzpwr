package com.pzpwr.core.endpoint;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.storage.PersonStorage;
import com.pzpwr.core.type.Person;
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
public class AddUserEndpoint {

    @Autowired
    private PersonStorage personStorage;

    private Logger logger = Logger.getLogger("AddUserEndpoint");

    @RequestMapping(value = "admin/add_user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addUser(@RequestBody(required = true) Person person) throws StorageException {
        logger.debug("addUser(person: " + person + ") called");
        logger.info("Trying to add user (" + person + ")");
        personStorage.add(person);
        ResponseEntity response = new ResponseEntity<>(HttpStatus.OK);
        logger.info("User: " + person + " added");
        logger.debug("addUser() returned " + response);
        return response;
    }

    @ExceptionHandler(StorageException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,
            reason = "Uzytkownik o podanym id juz istnieje")
    public void handleFailingToAddUser(StorageException e, HttpServletResponse response) {
        logger.warn("User with id " + e.getProblematicId() + " already exists");
    }
}
