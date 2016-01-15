package com.pzpwr.core.creator;

import com.pzpwr.core.storage.ArchivedVisitStorageImpl;
import com.pzpwr.core.storage.VisitStorage;
import com.pzpwr.core.storage.VisitStorageImpl;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VisitStorageCreator {

    private Logger logger = Logger.getLogger("VisitStorageCreator");

    @Bean(name = "visitStorage")
    public VisitStorage createVisitStorage() {
        logger.debug("createVisitStorage() calleD");
        VisitStorage visitStorage = new VisitStorageImpl();
        logger.info("Visit storage created");
        logger.debug("createVisitStorage() returned " + visitStorage);
        return visitStorage;
    }

    @Bean(name = "archievedVisitStorage")
    public VisitStorage createArchievedVisitStorage() {
        logger.debug("createArchievedVisitStorage() calleD");
        VisitStorage archievedVisitStorage = new ArchivedVisitStorageImpl();
        logger.info("Archieved visit storage created");
        logger.debug("createArchievedVisitStorage() returned " + archievedVisitStorage);
        return archievedVisitStorage;
    }
}
