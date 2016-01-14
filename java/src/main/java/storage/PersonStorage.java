package storage;

import exception.StorageException;
import type.Person;
import appenum.JobEnum;

import java.util.List;

public interface PersonStorage {

    void add(Person person) throws StorageException;

    void remove(String personLogin) throws StorageException;

    void update(String personLogin, Person newPersonData) throws StorageException;

    List<Person> filterByJob(JobEnum job);

    List<Person> filterByRights(String right);

    List<Person> filterBySurname(String surname);
}
