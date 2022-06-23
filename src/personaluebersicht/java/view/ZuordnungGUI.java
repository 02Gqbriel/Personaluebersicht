package personaluebersicht.java.view;

import personaluebersicht.java.facade.ZuordnungFacade;
import personaluebersicht.java.model.employees.Person;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ZuordnungGUI extends JPanel {
    String personName;
    Person person;

    public ZuordnungGUI(ZuordnungFacade zuordnungFacade) {

        JPanel personPanel = new JPanel(new BorderLayout());
        personPanel.setBackground(Color.white);
        JPanel selectionPanel = new JPanel(new BorderLayout());
        selectionPanel.setBackground(Color.white);
//        JScrollPane personListScrollPanel = new JScrollPane();
//        personListScrollPanel.setBackground(Color.white);
//        JPanel personListPanel = new JPanel(new GridLayout(10, 1));
//        personListPanel.setBackground(Color.white);
        DefaultListModel<String> personListModel = new DefaultListModel<>(); //todo
        JList<String> personList = new JList<>(personListModel);
        if (zuordnungFacade != null) {
            for (String p : zuordnungFacade.getPersonsList()) {
                personListModel.addElement(p);
            }
        }
        personList.setSelectedIndex(0);
        personName = personList.getSelectedValue();
        person = zuordnungFacade.getPerson(personName);
        JScrollPane personListScrollPanel = new JScrollPane(personList);
        personListScrollPanel.setBackground(Color.white);
        personListScrollPanel.setPreferredSize(new Dimension(150, 80));


        JPanel overviewPanel = new JPanel(new BorderLayout());
        overviewPanel.setBackground(Color.white);
        JPanel overviewPanel2 = new JPanel(new BorderLayout());
        overviewPanel2.setBackground(Color.white);
        JPanel overviewBottomPanel2 = new JPanel(new GridLayout(4,2));
        overviewBottomPanel2.setBackground(Color.white);
        JPanel overviewTopPanel1 = new JPanel(new GridLayout(1,2));
        overviewTopPanel1.setBackground(Color.white);

        TitledBorder detailBoarder;
        detailBoarder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray), "Detail:");

        TitledBorder personBoarder;
        personBoarder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray), "Personen barbeiten:");

        Border border;
        border = BorderFactory.createLineBorder(Color.gray);



        String[] optionsToChoose = {"Apple", "Orange", "Banana", "Pineapple", "None of the listed"};




        JLabel overview = new JLabel("Übersicht:");

        JLabel nameLabel = new JLabel("Name:");
        JTextField name = new JTextField(personName);
        name.setEditable(false);
        JLabel partyLabel = new JLabel("Abteilung:");
        JLabel party = new JLabel("Finanzen");
        JLabel functionLabel = new JLabel("Funktionen:");
        JComboBox<String> function = new JComboBox<>(optionsToChoose);
        JLabel teamLabel = new JLabel("Teams:");
        JComboBox<String> team = new JComboBox<>(optionsToChoose);
        JLabel img = new JLabel("img");


        overviewBottomPanel2.add(partyLabel);
        overviewBottomPanel2.add(party);
        overviewBottomPanel2.add(functionLabel);
        overviewBottomPanel2.add(function);
        overviewBottomPanel2.add(teamLabel);
        overviewBottomPanel2.add(team);

        overviewTopPanel1.add(nameLabel);
        overviewTopPanel1.add(name);

        overviewPanel2.add(overviewTopPanel1, BorderLayout.NORTH);
        overviewPanel2.add(img, BorderLayout.CENTER);
        overviewPanel2.add(overviewBottomPanel2, BorderLayout.SOUTH);

        overviewPanel.add(overviewPanel2, BorderLayout.CENTER);
        overviewPanel.setBorder(detailBoarder);

        selectionPanel.add(overview, BorderLayout.NORTH);
        selectionPanel.add(personListScrollPanel, BorderLayout.CENTER);
        selectionPanel.setBorder(border);

        personPanel.add(overviewPanel, BorderLayout.EAST);
        personPanel.add(selectionPanel, BorderLayout.WEST);
        personPanel.setBorder(personBoarder);

        setBackground(Color.white);
        this.add(personPanel);

        setVisible(true);
    }
}
