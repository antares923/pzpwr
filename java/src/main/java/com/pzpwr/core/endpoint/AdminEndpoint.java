package com.pzpwr.core.endpoint;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.storage.PatientRegistrationStorage;
import com.pzpwr.core.storage.UserStorage;
import com.pzpwr.core.storage.RoomReservationStorage;
import com.pzpwr.core.storage.WaitingRoomStorage;
import com.pzpwr.core.type.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "admin/special")
public class AdminEndpoint {

    @Autowired
    private UserStorage userStorage;

    @Autowired
    private RoomReservationStorage roomReservationStorage;

    @Autowired
    private WaitingRoomStorage waitingRoomStorage;

    @Autowired
    private PatientRegistrationStorage patientRegistrationStorage;

    private Logger logger = Logger.getLogger("AdminEndpoint");

    @RequestMapping(value = "get_persons", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<User>> getAllPersons() {
        logger.debug("getAllPersons() called");
        List<User> allPersonsList = userStorage.getAllObjects();
        ResponseEntity<List<User>> response = new ResponseEntity<>(allPersonsList, HttpStatus.OK);
        logger.info("LIST OF ALL PERSONS: ");
        for (User user : allPersonsList) {
            logger.info(user.getLogin() + " | " + user.getPassword() + " | " + user.getName() + " | " +
                    user.getSurname() + " | " + user.getJob() + " | " + user.getRights() + " | " +
                    user.getMedicalDocumentation());
        }
        logger.debug("getAllPersons() returned " + response);
        return response;
    }

    @ExceptionHandler(StorageException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,
            reason = "Uzytkownik o podanym id juz istnieje")
    public void handleFailingToAddUser(StorageException e, HttpServletResponse response) {
        logger.warn("User with id " + e.getProblematicId() + " already exists");
    }
}
