package com.pzpwr.core.endpoint;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.storage.VisitStorage;
import com.pzpwr.core.type.Visit;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class CalendarEndpoint {

    @Autowired
    @Qualifier(value = "visitStorage")
    private VisitStorage visitStorage;

    @Autowired
    @Qualifier(value = "archievedVisitStorage")
    private VisitStorage archievedVisitStorage;

    private Logger logger = Logger.getLogger("CalendarEndpoint");

    @RequestMapping(value = "calendar/get", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Visit>> getVisitsCalendar() {
        logger.debug("getVisitsCalendar() called");
        logger.info("Trying to get visit calendar");
        List<Visit> allVisitList = visitStorage.getAllObjects();
        ResponseEntity<List<Visit>> response = new ResponseEntity<>(allVisitList, HttpStatus.OK);
        logger.info("List of (" + allVisitList.size() + ") visits returned");
        logger.debug("getVisitsCalendar() returned " + response);
        return response;
    }

    @RequestMapping(value = "calendar/set", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity setVisitCalendar(@RequestBody(required = true) List<Visit> visitCalendar)
            throws StorageException {
        logger.debug("setVisitCalendar(visitCalendar: " + visitCalendar + ") called");
        logger.info("Trying to set new calendar: " + visitCalendar);
        visitStorage.setNewValues(visitCalendar);
        ResponseEntity response = new ResponseEntity<>(HttpStatus.OK);
        logger.info("New visit calendar (" + visitCalendar.size() + ") set");
        logger.debug("setVisitCalendar() returned " + response);
        return response;
    }

    @ExceptionHandler(StorageException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,
            reason = "Blad przy dodawaniu nowego kalendarza. Przywrocono stara wersje")
    public void handleFailingToAddUser(StorageException e, HttpServletResponse response) {
        logger.warn("User with id " + e.getProblematicId() + " already exists");
    }
}
