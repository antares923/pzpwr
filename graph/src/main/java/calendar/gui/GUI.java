package calendar.gui;

import calendar.connector.Connector;
import calendar.storage.Storage;

import javax.swing.*;

public class GUI {

    private Connector connector;

    public GUI(Connector connector) {
        this.connector = connector;
    }

    public void createAndShowGUI(Storage storage) {
        JFrame jFrame = new MyFrame("Calendar graph", storage, connector);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(800, 600);
        jFrame.setVisible(true);
    }
}
