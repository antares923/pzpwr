package calendar.configurator;

import calendar.gui.GUI;
import calendar.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.swing.*;

@Configuration
public class GUIConfigurator {

    @Autowired
    private Storage storage;

    @PostConstruct
    public void initialize() {
        GUI gui = new GUI();
        SwingUtilities.invokeLater(gui::createAndShowGUI);
    }
}
