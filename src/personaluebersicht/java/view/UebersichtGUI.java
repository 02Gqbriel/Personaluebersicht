package personaluebersicht.java.view;

import personaluebersicht.java.facade.UebersichtFacade;
import personaluebersicht.java.model.employees.Person;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class UebersichtGUI extends JPanel {

    String personName;
    Person person;

    public UebersichtGUI(UebersichtFacade uebersichtFacade) {


        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.white);

        JPanel personPanel = new JPanel(new BorderLayout());
        personPanel.setBackground(Color.white);
        TitledBorder personBoarder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray), "Personen:");
        personPanel.setBorder(personBoarder);

        JPanel selectionPanel = new JPanel(new BorderLayout());
        selectionPanel.setBackground(Color.white);

        DefaultListModel<String> personListModel = new DefaultListModel<>(); //todo
        JList<String> personList = new JList<>(personListModel);
        if (uebersichtFacade != null) {
            for (String p : uebersichtFacade.getPersonsList()) {
                personListModel.addElement(p);
            }
        }
        personList.setSelectedIndex(1);
        personName = personList.getSelectedValue();
        person = uebersichtFacade.getPerson(personName);
        JScrollPane personListScrollPanel = new JScrollPane(personList);
        personListScrollPanel.setBackground(Color.white);
        personListScrollPanel.setPreferredSize(new Dimension(150, 100));

        class PersonListSelectionListener implements ListSelectionListener {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                personName = personList.getSelectedValue();
                person = uebersichtFacade.getPerson(personName);
            }
        }
        personList.addListSelectionListener(new PersonListSelectionListener());


        JPanel detailOverviewPanel = new JPanel(new BorderLayout());
        detailOverviewPanel.setBackground(Color.white);

        JPanel detailOverviewTopPanel = new JPanel(new BorderLayout());
        detailOverviewTopPanel.setBackground(Color.white);
        JPanel detailBottomPanel = new JPanel(new BorderLayout());
        detailBottomPanel.setBackground(Color.white);
        JPanel detailTopPanel = new JPanel(new GridLayout(1, 2));
        detailTopPanel.setBackground(Color.white);
        JPanel sortPanel = new JPanel(new BorderLayout());
        sortPanel.setBackground(Color.white);
        JPanel filterPanel = new JPanel(new GridLayout(3, 2));
        filterPanel.setBackground(Color.white);


        TitledBorder detailBoarder;
        detailBoarder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray), "Detail:");

        TitledBorder sortBoarder;
        sortBoarder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray), "Sortierung:");

        TitledBorder filterBoarder;
        filterBoarder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray), "Filter:");


        Border border;
        border = BorderFactory.createLineBorder(Color.gray);


        JLabel overview = new JLabel("Übersicht:");
        JLabel nameLabel = new JLabel("Name:");
        JTextField name = new JTextField(personName);
        name.setEditable(false);
        JLabel partyLabel = new JLabel("Abteilung:");
        JLabel partyLabelFilter = new JLabel("Abteilung:");
        JTextField party = new JTextField(uebersichtFacade.getDepartmentName(person));
        party.setEditable(false);
        JComboBox<String> partyComboBox = new JComboBox<>();
        JLabel functionLabel = new JLabel("Funktion:");
        JLabel detailFunctionLabel = new JLabel("Funktion:");
        JComboBox<String> function = new JComboBox<>(uebersichtFacade.getFunctionList(person));
        JLabel teamLabel = new JLabel("Team:");
        JLabel detailTeamLabel = new JLabel("Teams:");
        JComboBox<String> team = new JComboBox<>(uebersichtFacade.getTeamList(person));
        JLabel img = new JLabel("Img");

        JRadioButton noSort = new JRadioButton("keine");
        noSort.setSelected(true);
        noSort.setBackground(Color.white);
        JRadioButton aZSort = new JRadioButton("A-Z");
        aZSort.setBackground(Color.white);
        JRadioButton zASort = new JRadioButton("Z-A");
        zASort.setBackground(Color.white);

        ButtonGroup group = new ButtonGroup();
        group.add(noSort);
        group.add(aZSort);
        group.add(zASort);

        detailBottomPanel.add(partyLabel, BorderLayout.WEST);
        detailBottomPanel.add(party, BorderLayout.EAST);
//        detailBottomPanel.add(functionLabel);
//        detailBottomPanel.add(teamLabel);
//

        detailTopPanel.add(nameLabel);
        detailTopPanel.add(name);

        detailOverviewTopPanel.add(detailTopPanel, BorderLayout.NORTH);
        detailOverviewTopPanel.add(img, BorderLayout.CENTER);
        detailOverviewTopPanel.add(detailBottomPanel, BorderLayout.SOUTH);

        JPanel detailOverviewBottomPanel = new JPanel(new GridLayout(1, 2));
        JPanel detailOverviewBottomPanelL = new JPanel(new BorderLayout());
        detailOverviewBottomPanelL.setBackground(Color.white);
        detailOverviewBottomPanelL.add(detailFunctionLabel, BorderLayout.NORTH);
        JPanel detailOverviewBottomPanelR = new JPanel(new BorderLayout());
        detailOverviewBottomPanelR.setBackground(Color.white);
        detailOverviewBottomPanelR.add(detailTeamLabel, BorderLayout.NORTH);

        DefaultListModel<String> functionListModel = new DefaultListModel<>(); //todo
        JList<String> functionList = new JList<>(functionListModel);
        if (uebersichtFacade != null) {
            for (String p : uebersichtFacade.getFunctionList(person)) {
                functionListModel.addElement(p);
            }
        }
        JScrollPane functionListScrollPanel = new JScrollPane(functionList);
        functionListScrollPanel.setBackground(Color.white);
        functionListScrollPanel.setPreferredSize(new Dimension(150, 80));
        detailOverviewBottomPanel.add(functionListScrollPanel);
        detailOverviewBottomPanelL.add(functionListScrollPanel, BorderLayout.SOUTH);


        DefaultListModel<String> teamListModel = new DefaultListModel<>(); //todo
        JList<String> teamList = new JList<>(teamListModel);
        if (uebersichtFacade != null) {
            for (String p : uebersichtFacade.getTeamList(person)) {
                teamListModel.addElement(p);
            }
        }
        JScrollPane teamListScrollPanel = new JScrollPane(teamList);
        teamListScrollPanel.setBackground(Color.white);
        teamListScrollPanel.setPreferredSize(new Dimension(150, 80));
        detailOverviewBottomPanel.add(teamListScrollPanel);
        detailOverviewBottomPanelR.add(teamListScrollPanel, BorderLayout.SOUTH);

        detailOverviewBottomPanel.add(detailOverviewBottomPanelL);
        detailOverviewBottomPanel.add(detailOverviewBottomPanelR);

        detailOverviewPanel.add(detailOverviewTopPanel, BorderLayout.CENTER);
        detailOverviewPanel.add(detailOverviewBottomPanel, BorderLayout.SOUTH);
        detailOverviewPanel.setBorder(detailBoarder);

        selectionPanel.add(overview, BorderLayout.NORTH);
//        selectionPanel.add(personList, BorderLayout.CENTER);
        selectionPanel.add(personListScrollPanel, BorderLayout.CENTER);
        selectionPanel.setBorder(border);

        sortPanel.add(noSort, BorderLayout.NORTH);
        sortPanel.add(aZSort, BorderLayout.CENTER);
        sortPanel.add(zASort, BorderLayout.SOUTH);
        sortPanel.setBorder(sortBoarder);


        filterPanel.add(partyLabelFilter);
        filterPanel.add(partyComboBox);
        filterPanel.add(functionLabel);
        filterPanel.add(function);
        filterPanel.add(teamLabel);
        filterPanel.add(team);
        filterPanel.setBorder(filterBoarder);

        bottomPanel.add(sortPanel, BorderLayout.WEST);
        bottomPanel.add(filterPanel, BorderLayout.EAST);

        personPanel.add(detailOverviewPanel, BorderLayout.EAST);
        personPanel.add(selectionPanel, BorderLayout.WEST);
        personPanel.add(bottomPanel, BorderLayout.SOUTH);


        setBackground(Color.white);
        this.add(personPanel);

        setVisible(true);
    }

}

