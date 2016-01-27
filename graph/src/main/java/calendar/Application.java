package calendar;

import calendar.connector.Connector;
import calendar.gui.GUI;
import calendar.storage.Storage;

public class Application {

    public static void main(String[] args) {

        Storage storage = new Storage();

        Connector connector = new Connector();
        GUI gui = new GUI(connector);
        gui.createAndShowGUI(storage);

    }
}
