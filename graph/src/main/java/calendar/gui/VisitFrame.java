package calendar.gui;

import calendar.type.Visit;

import javax.swing.*;
import java.awt.*;

public class VisitFrame extends JFrame {

    public VisitFrame(Visit visit) {
        setBounds(100, 100, 300, 500);
        add(new Panel(visit));
    }

    class Panel extends JPanel {

        private Visit visit;

        public Panel(Visit visit) {
            this.visit = visit;
            setLayout(new GridLayout(6, 2));

            setBounds(0, 0, 300, 500);

            add(new JLabel("Patient: "));
            add(new JLabel(visit.getPatientLogin()));

            add(new JLabel("Doctors ids:: "));
            add(new JLabel(visit.getDoctorIdList() + ""));

            add(new JLabel("Start date: "));
            add(new JLabel(visit.getDateTime().toString()));

            add(new JLabel("Duration (mins): "));
            add(new JLabel(visit.getDurationInMinutes() + ""));

            add(new JLabel("Room: "));
            add(new JLabel(visit.getRoomNumber() + ""));

            add(new JLabel("Visit type: "));
            add(new JLabel(visit.getType().toString()));
        }
    }
}
