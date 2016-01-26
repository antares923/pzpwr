package com.pzpwr.core.creator;

import com.pzpwr.core.appenum.JobEnum;
import com.pzpwr.core.appenum.RightEnum;
import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.type.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.pzpwr.core.storage.UserStorage;
import com.pzpwr.core.storage.UserStorageImpl;

@Configuration
@PropertySource("application.properties")
public class PersonStorageCreator {

    @Value("${admin_login}")
    private String login;

    @Value("${admin_password}")
    private String password;

    private Logger logger = Logger.getLogger("PersonStorageCreator");

    @Bean(name = "personStorage")
    public UserStorage createPersonStorage() {
        logger.debug("createPersonStorage() called");
        UserStorage userStorage = new UserStorageImpl();
        User admin = getAdmin();
        try {
            userStorage.add(admin);
        } catch (StorageException e) {
            logger.warn("Problems with adding admin account");
        }
        logger.info("User storage created");
        logger.debug("createPersonStorage() returned " + userStorage);
        return userStorage;
    }

    private User getAdmin() {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setName("Admin");
        user.setSurname("Admin");
        user.setRights(RightEnum.ADMIN);
        user.setJob(JobEnum.ADMIN);
        return user;
    }
}
