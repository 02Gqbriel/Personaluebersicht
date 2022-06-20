package personaluebersicht.view;

import javax.swing.*;

public class PersonaluebersichtGUIFinal extends JFrame {
    JPanel panel1 = new JPanel();

    JLabel label2 = new JLabel("Second");

    JTabbedPane tabbedPane = new JTabbedPane();

    public PersonaluebersichtGUIFinal() {
        setTitle("I am looking for");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.add(label2);

        tabbedPane.add("Übersicht", new UebersichtGUI());
        tabbedPane.add("Zuordnung", new ZuordnungGUI());
        tabbedPane.add("Personen", new PersonenGUI());
        tabbedPane.add("Stammdaten", new StammdatenGUI());
        tabbedPane.add("Logbuch", new LogbuchGUI());
        this.setSize(450, 300);

        this.add(tabbedPane);

        setVisible(true);
    }

}
