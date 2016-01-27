package calendar.gui;

import calendar.connector.Connector;
import calendar.storage.Storage;
import calendar.type.Visit;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFrame extends JFrame {

    private static final int WIDTH = 100;
    private static final int HEIGHT = 50;
    private static final int STEP = 10;

    public MyFrame(String text, Storage storage, Connector connector) {
        super(text);
        add(new MyPanel(storage, connector));
    }

    class MyPanel extends JPanel {

        Storage storage;
        Connector connector;
        List<Visit> visitList = new ArrayList<>();

        public MyPanel(Storage storage, Connector connector) {
            this.storage = storage;
            this.connector = connector;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            visitList = connector.connect();
            System.out.println(visitList);
            //showData();
        }

        public void showData() {

            Map<Integer, Integer> roomCounter = new HashMap<>();

            for (int i = 0; i < visitList.size(); i++) {
                Visit v = visitList.get(0);
                int roomNumber = v.getRoomNumber();
                LocalDateTime startTime = v.getDateTime();
                LocalDateTime endTime = v.getDateTime().plusMinutes(v.getDurationInMinutes());

                LocalDateTime copy = LocalDateTime.from(startTime);

                int length = 0;
                while (copy.isBefore(endTime) || copy.isEqual(endTime)) {
                    copy = copy.plusMinutes(STEP);
                    length++;
                }

                int counter = roomCounter.get(roomNumber);

                JLabel label = new JLabel(v.getPatientLogin() + " TO " + v.getDoctorIdList());
                label.setBounds(counter * WIDTH, roomNumber * HEIGHT, length * WIDTH, HEIGHT);
                add(label);
                counter += length;
                roomCounter.replace(roomNumber, counter);

            }
        }
    }
}
