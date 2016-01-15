package com.pzpwr.core.manager;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.observator.StorageObserver;
import com.pzpwr.core.storage.PersonStorage;
import com.pzpwr.core.storage.VisitStorage;
import com.pzpwr.core.type.Person;
import com.pzpwr.core.type.Visit;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class VisitStorageManager implements StorageObserver<Integer> {

    @Autowired
    @Qualifier(value = "visitStorage")
    private VisitStorage visitStorage;

    @Autowired
    @Qualifier(value = "archievedVisitStorage")
    private VisitStorage archievedVisitStorage;

    @Autowired
    private PersonStorage personStorage;

    private Logger logger = Logger.getLogger("VisitStorageManager");

    @PostConstruct
    public void initialize() {
        logger.info("Visit storage manager initialized");
    }

    @Override
    public void add(Integer id) {

    }

    @Override
    public void update(Integer id) {

    }

    @Override
    public void remove(Integer id) {
        try {
            Visit visit = visitStorage.get(id);
            Person person = personStorage.get(visit.getPatientLogin());
            person.addVisitToDocumentation(visit);
            archievedVisitStorage.add(visit);
        } catch (StorageException e) {
            logger.warn("Encountered problem: " + e.getMessage());
        }
    }
}
