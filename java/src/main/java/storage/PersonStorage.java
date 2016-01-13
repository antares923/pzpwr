package storage;

import org.apache.log4j.Logger;
import type.Person;

import java.util.List;

public class PersonStorage extends BaseStorage<Person> {

    Logger logger = Logger.getLogger("PersonStorge");

    public List<Person> filterByJob(String job) {
        logger.debug("filterByJob(job: " + job + ") called");
        List<Person> persons = getListByFilter((person) -> person.getJob().equals(job));
        logger.debug("filterByJob() returned " + persons);
        return persons;
    }

    public List<Person> filterByRights(String right) {
        logger.debug("filterByJob(right: " + right + ") called");
        List<Person> persons = getListByFilter((person) -> person.getJob().equals(right));
        logger.debug("filterByJob() returned " + persons);
        return persons;
    }

    public List<Person> filterByRisk(String risk) {
        logger.debug("filterByJob(risk: " + risk + ") called");
        List<Person> persons = getListByFilter((person) -> person.getJob().equals(risk));
        logger.debug("filterByJob() returned " + persons);
        return persons;
    }

    public List<Person> filterBySurname(String surname) {
        logger.debug("filterByJob(surname: " + surname + ") called");
        List<Person> persons = getListByFilter((person) -> person.getJob().equals(surname));
        logger.debug("filterByJob() returned " + persons);
        return persons;
    }
}
