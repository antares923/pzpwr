package creator;

import appenum.JobEnum;
import appenum.RightEnum;
import exception.StorageException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import storage.PersonStorage;
import storage.PersonStorageImpl;
import type.Person;

@Configuration
@PropertySource("application.properties")
public class PersonStorageCreator {

    @Value("${admin_login}")
    private String login;

    @Value("${admin_password}")
    private String password;

    private Logger logger = Logger.getLogger("PersonStorageCreator");

    @Bean(name = "personStorage")
    public PersonStorage createPersonStorage() {
        logger.debug("createPersonStorage() called");
        PersonStorage personStorage = new PersonStorageImpl();
        Person admin = getAdmin();
        try {
            personStorage.add(admin);
        } catch (StorageException e) {
            logger.warn("Problems with adding admin account");
        }
        logger.debug("createPersonStorage() returned " + personStorage);
        return personStorage;
    }

    private Person getAdmin() {
        Person person = new Person();
        person.setLogin(login);
        person.setPassword(password);
        person.setName("Admin");
        person.setSurname("Admin");
        person.setRights(RightEnum.ADMIN);
        person.setJob(JobEnum.ADMIN);
        return person;
    }
}
