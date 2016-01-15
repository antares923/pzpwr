package com.pzpwr.core.endpoint;

import com.pzpwr.core.appenum.RightEnum;
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
public class ChangeRightsEndpoint {

    @Autowired
    private PersonStorage personStorage;

    private Logger logger = Logger.getLogger("ChangeRightsEndpoint");

    @RequestMapping(value = "admin/change_rights", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity changeRights(@RequestBody(required = true) String login, RightEnum right)
            throws StorageException {
        logger.debug("changeRights(login: " + login + ", right: " + right + ") called");
        logger.info("Trying to change rights of user (" + login + ") to " + right);
        Person person = personStorage.get(login);
        person.setRights(right);
        personStorage.update(login, person);
        ResponseEntity response = new ResponseEntity<>(HttpStatus.OK);
        logger.info("Rights changed");
        logger.debug("changeRights() returned " + response);
        return response;
    }

    @ExceptionHandler(StorageException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,
            reason = "Uzytkownik o podanym id nie istnieje")
    public void handleFailingToGetUser(StorageException e, HttpServletResponse response) {
        logger.warn("User with id " + e.getProblematicId() + " doesn't exists");
    }
}
