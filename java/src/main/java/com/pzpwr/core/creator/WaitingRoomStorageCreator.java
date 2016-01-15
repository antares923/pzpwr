package com.pzpwr.core.creator;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.pzpwr.core.storage.WaitingRoomStorage;
import com.pzpwr.core.storage.WaitingRoomStorageImpl;

@Configuration
public class WaitingRoomStorageCreator {

    private Logger logger = Logger.getLogger("WaitingRoomStorageCreator");

    @Bean(name = "waitingRoomStorage")
    public WaitingRoomStorage createWaitingRoomStorage() {
        logger.debug("createWaitingRoomStorage() called");
        WaitingRoomStorage waitingRoomStorage = new WaitingRoomStorageImpl();
        logger.info("Waiting room storage created");
        logger.debug("createWaitingRoomStorage() returned " + waitingRoomStorage);
        return waitingRoomStorage;
    }
}
