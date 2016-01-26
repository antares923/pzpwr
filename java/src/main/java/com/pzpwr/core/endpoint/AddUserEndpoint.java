package com.pzpwr.core.endpoint;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.storage.UserStorage;
import com.pzpwr.core.type.User;
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
    private UserStorage userStorage;

    private Logger logger = Logger.getLogger("AddUserEndpoint");

    @RequestMapping(value = "admin/add_user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addUser(@RequestBody(required = true) User user) throws StorageException {
        logger.debug("addUser(user: " + user + ") called");
        logger.info("Trying to add user (" + user + ")");
        userStorage.add(user);
        ResponseEntity response = new ResponseEntity<>(HttpStatus.OK);
        logger.info("User: " + user + " added");
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
