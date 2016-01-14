package storage;

import exception.StorageException;
import org.apache.log4j.Logger;
import type.Person;
import appenum.JobEnum;

import java.util.List;

public class PersonStorageImpl extends BaseStorage<String, Person> implements PersonStorage {

    Logger logger = Logger.getLogger("PersonStorge");

    @Override
    public void add(Person person) throws StorageException {
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

    public List<Person> filterByRights(String right) {
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
