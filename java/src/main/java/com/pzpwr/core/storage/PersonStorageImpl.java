package com.pzpwr.core.storage;

import com.pzpwr.core.appenum.JobEnum;
import com.pzpwr.core.appenum.RightEnum;
import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.Person;
import org.apache.log4j.Logger;

import java.util.List;

public class PersonStorageImpl extends BaseStorage<String, Person> implements PersonStorage {

    Logger logger = Logger.getLogger("PersonStorge");

    @Override
    public void add(Person person) throws StorageException {
        person.setId(map.size());
        super.add(person.getLogin(), person);
    }

    @Override
    public void remove(String personLogin) throws StorageException {
        super.remove(personLogin);
    }

    @Override
    public void update(String personLogin, Person newPersonData) throws StorageException {
        super.update(personLogin, newPersonData);
    }

    public List<Person> filterByJob(JobEnum job) {
        logger.debug("filterByJob(job: " + job + ") called");
        List<Person> persons = getListByFilter((person) -> person.getJob().equals(job));
        logger.debug("filterByJob() returned " + persons);
        return persons;
    }

    public List<Person> filterByRights(RightEnum right) {
        logger.debug("filterByJob(right: " + right + ") called");
        List<Person> persons = getListByFilter((person) -> person.getRights().equals(right));
        logger.debug("filterByJob() returned " + persons);
        return persons;
    }

    public List<Person> filterBySurname(String surname) {
        logger.debug("filterByJob(surname: " + surname + ") called");
        List<Person> persons = getListByFilter((person) -> person.getSurname().equals(surname));
        logger.debug("filterByJob() returned " + persons);
        return persons;
    }
}
