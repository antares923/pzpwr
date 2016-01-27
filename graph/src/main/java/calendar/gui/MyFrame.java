package calendar.gui;

import calendar.connector.Connector;
import calendar.storage.Storage;
import calendar.type.Visit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFrame extends JFrame {

    private static final int WIDTH = 40;
    private static final int HEIGHT = 40;
    private static final int STEP = 10;

    JButton[][] buttons;

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
            setLayout(new GridLayout(15, 16));
            setBounds(0, 0, 800, 800);

            add(new JLabel(""));
            for (int i = 0; i < 15; i++) {
                add(new JLabel(10 * i + ""));
            }
            buttons = new JButton[14][15];

            for (int i = 0; i < 14; i++) {
                add(new JLabel((i + 1) + ""));

                for (int j = 0; j < 15; j++) {
                    buttons[i][j] = new JButton();
                    buttons[i][j].setBounds(i * WIDTH, j * HEIGHT, WIDTH, HEIGHT);
                    buttons[i][j].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

                        }
                    });
                    add(buttons[i][j]);
                }
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            visitList = connector.connect();
            System.out.println(visitList);
            showData();
        }

        public void showData() {
            Map<Integer, Integer> roomCounter = new HashMap<>();

            for (int i = 0; i < visitList.size(); i++) {
                Visit v = visitList.get(i);
                int roomNumber = v.getRoomNumber();
                LocalDateTime startTime = v.getDateTime();
                LocalDateTime endTime = v.getDateTime().plusMinutes(v.getDurationInMinutes());

                LocalDateTime now = LocalDateTime.now();

                int startLength = 0;
                while (now.isBefore(startTime) || now.isEqual(startTime)) {
                    now = now.plusMinutes(STEP);
                    startLength++;
                }

                now = LocalDateTime.now();

                int endLength = 0;
                while (now.isBefore(endTime) || now.isEqual(endTime)) {
                    now = now.plusMinutes(STEP);
                    endLength++;
                }

                for (int j = startLength; j <= endLength; j++) {
                    buttons[roomNumber - 1][j].setText(v.getId() + "");
                }
            }
        }
    }
}
