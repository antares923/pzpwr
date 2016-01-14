package creator;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import storage.WaitingRoomStorage;
import storage.WaitingRoomStorageImpl;

@Configuration
public class WaitingRoomStorageCreator {

    private Logger logger = Logger.getLogger("WaitingRoomStorageCreator");

    @Bean(name = "waitingRoomStorage")
    public WaitingRoomStorage createWaitingRoomStorage() {
        logger.debug("createWaitingRoomStorage() called");
        WaitingRoomStorage waitingRoomStorage = new WaitingRoomStorageImpl();
        logger.debug("createWaitingRoomStorage() returned " + waitingRoomStorage);
        return waitingRoomStorage;
    }
}
