package com.pzpwr.core.storage;

import com.pzpwr.core.appenum.JobEnum;
import com.pzpwr.core.appenum.RightEnum;
import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.Person;

import java.util.List;

public interface PersonStorage {

    void add(Person person) throws StorageException;

    void remove(String personLogin) throws StorageException;

    void update(String personLogin, Person newPersonData) throws StorageException;

    Person get(String personLogin) throws StorageException;

    List<Person> filterByJob(JobEnum job);

    List<Person> filterByRights(RightEnum right);

    List<Person> filterBySurname(String surname);

    List<Person> getAllObjects();
}
