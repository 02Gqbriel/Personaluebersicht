package personaluebersicht.view;

import javax.swing.*;
import java.awt.*;

public class LogbuchGUI extends JPanel {
    public LogbuchGUI() {
        JScrollPane scrollPane = new JScrollPane();
        JPanel panel = new JPanel();
        JTextArea logbook = new JTextArea();
        logbook.setEditable(false);
        logbook.setText("LOGBUCH");
        logbook.setBackground(Color.white);

        panel.add(logbook);
        panel.setBackground(Color.white);

        scrollPane.add(panel);
        scrollPane.setBackground(Color.white);

        this.add(scrollPane);
        setVisible(true);
    }
}
