package calendar.gui;

import calendar.type.Visit;

import javax.swing.*;

public class VisitFrame extends JFrame {

    public VisitFrame(Visit visit) {
        add(new JPanel(visit));
    }

    class Panel extends JPanel {

        private Visit visit;

        class Panel(Visit visit) {
            this.visit = visit;
        }
    }
}
