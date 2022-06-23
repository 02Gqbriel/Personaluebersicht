package personaluebersicht.java.view;

import personaluebersicht.java.facade.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PersonaluebersichtGUIFinal extends JFrame {
    JPanel panel1 = new JPanel();


    JLabel label2 = new JLabel("Second");

    JTabbedPane tabbedPane = new JTabbedPane();

    private boolean loggedIn;


    public PersonaluebersichtGUIFinal(
            PersonsFacade personsFacade,
            ZuordnungFacade zuordnungFacade,
            UebersichtFacade uebersichtFacade,
            StammdatenFacade stammdatenFacade,
            LogbuchFacade logbuchFacade) {

        setTitle("I am looking for");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.white);

        tabbedPane.add("Übersicht", new UebersichtGUI(uebersichtFacade));
        tabbedPane.add("Zuordnung", new ZuordnungGUI(zuordnungFacade));
        tabbedPane.add("Personen", new PersonenGUI(personsFacade));
        tabbedPane.add("Stammdaten", new StammdatenGUI(stammdatenFacade));
        tabbedPane.add("Logbuch", new LogbuchGUI(logbuchFacade));


        tabbedPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ((tabbedPane.getSelectedIndex() > 0) && !loggedIn) {
                    tabbedPane.setSelectedIndex(0);
                    LoginGUI loginGUI = new LoginGUI(uebersichtFacade);
                    loggedIn = loginGUI.isLoggedIn();
                }

            }
        });

        this.add(tabbedPane);

        pack();
        setVisible(true);
    }
}

