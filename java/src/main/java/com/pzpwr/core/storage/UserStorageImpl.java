package com.pzpwr.core.storage;

import com.pzpwr.core.appenum.JobEnum;
import com.pzpwr.core.appenum.RightEnum;
import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.User;
import org.apache.log4j.Logger;

import java.util.List;

public class UserStorageImpl extends BaseStorage<String, User> implements UserStorage {

    Logger logger = Logger.getLogger("PersonStorge");

    @Override
    public void add(User user) throws StorageException {
        user.setId(map.size());
        super.add(user.getLogin(), user);
    }

    @Override
    public void remove(String personLogin) throws StorageException {
        super.remove(personLogin);
    }

    @Override
    public void update(String personLogin, User newUserData) throws StorageException {
        super.update(personLogin, newUserData);
    }

    public User getById(int id) throws StorageException {
        User user = getListByFilter((u) -> u.getId() == id).get(0);
        return user;
    }

    public List<User> filterByJob(JobEnum job) {
        logger.debug("filterByJob(job: " + job + ") called");
        List<User> users = getListByFilter((person) -> person.getJob().equals(job));
        logger.debug("filterByJob() returned " + users);
        return users;
    }

    public List<User> filterByRights(RightEnum right) {
        logger.debug("filterByJob(right: " + right + ") called");
        List<User> users = getListByFilter((person) -> person.getRights().equals(right));
        logger.debug("filterByJob() returned " + users);
        return users;
    }

    public List<User> filterBySurname(String surname) {
        logger.debug("filterByJob(surname: " + surname + ") called");
        List<User> users = getListByFilter((person) -> person.getSurname().equals(surname));
        logger.debug("filterByJob() returned " + users);
        return users;
    }
}
