package creator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import storage.RoomReservationStorage;
import storage.RoomReservationStorageImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("application.properties")
public class RoomReservationStorageCreator {

    @Value("${available_rooms_file_path}}")
    private String availableRoomsFilePath;

    private Logger logger = Logger.getLogger("RoomReservationStorageCreator");

    @Bean(name = "roomReservationStorage")
    public RoomReservationStorage createRoomReservationStorage() {
        RoomReservationStorage roomReservationStorage = new RoomReservationStorageImpl();
        List<Integer> availableRoomList = getAvailableRooms();
        roomReservationStorage.setAvailableRoomNumbers(availableRoomList);
        return roomReservationStorage;
    }

    private List<Integer> getAvailableRooms() {
        List<Integer> availableRoomList = new ArrayList<>();
        logger.debug("getAvailableRooms() called");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                new File(availableRoomsFilePath)), "UTF-8"))) {
            String line = reader.readLine();
            while (line != null) {
                int roomNumber = Integer.parseInt(line);
                availableRoomList.add(roomNumber);
                line = reader.readLine();
            }
            logger.info(availableRoomsFilePath + " file loaded");
        } catch (IOException e) {
            logger.warn("Problems with loading rooms file: " + e.getMessage());
        }
        logger.debug("getAvailableRooms() executed");
        return availableRoomList;
    }
}
