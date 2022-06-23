package personaluebersicht.java.view;

import personaluebersicht.java.facade.LogbuchFacade;

import javax.swing.*;
import java.awt.*;

public class LogbuchGUI extends JPanel {
    public LogbuchGUI(LogbuchFacade logbuchFacade) {
        DefaultListModel<String> logListModel = new DefaultListModel<>();
        if (logbuchFacade != null) {
            for (String p : logbuchFacade.getLogList()) {
                logListModel.addElement(p);
            }
        }
        JList<String> loglist = new JList<>(logListModel);
        JScrollPane scrollPane = new JScrollPane(loglist);
        scrollPane.setBackground(Color.white);

        this.add(scrollPane);
        setVisible(true);
    }
}
