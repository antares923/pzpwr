package com.pzpwr.core.storage;

import com.pzpwr.core.appenum.JobEnum;
import com.pzpwr.core.appenum.RightEnum;
import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.User;

import java.util.List;

public interface UserStorage {

    void add(User user) throws StorageException;

    void remove(String personLogin) throws StorageException;

    void update(String personLogin, User newUserData) throws StorageException;

    User get(String personLogin) throws StorageException;

    User getById(int id) throws StorageException;

    List<User> filterByJob(JobEnum job);

    List<User> filterByRights(RightEnum right);

    List<User> filterBySurname(String surname);

    List<User> getAllObjects();
}
