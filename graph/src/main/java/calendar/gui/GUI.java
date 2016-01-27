package calendar.gui;

import calendar.storage.Storage;
import calendar.type.Visit;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class GUI {

    private static final int WIDTH = 100;
    private static final int HEIGHT = 50;

    private Storage storage;

    static JFrame jFrame;

    public void initialize(Storage storage) {
    }


    public void createAndShowGUI() {
        jFrame = new JFrame("Calendar graph");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(800, 600);
        jFrame.setVisible(true);
        jFrame.add(new MyPanel(storage));
    }

    class MyPanel extends JPanel {

        Storage storage;
        List<Visit> visitList = new ArrayList<>();

        public MyPanel(Storage storage) {
            this.storage = storage;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            visitList = storage.getVisitList();
            showData();
        }

        public void showData() {
            for (int i = 0; i < visitList.size(); i++) {
                Visit v = visitList.get(0);
                int roomNumber = v.getRoomNumber();
                LocalDateTime startTime = v.getDateTime();
                LocalDateTime endTime = v.getDateTime().plusMinutes(v.getDurationInMinutes());

                JLabel label = new JLabel(v.getPatientLogin() + " TO " + v.getDoctorIdList());
                label.setBounds(i * WIDTH, (roomNumber - 1) * HEIGHT, WIDTH, HEIGHT);

                add(label);
            }
        }
    }
}
