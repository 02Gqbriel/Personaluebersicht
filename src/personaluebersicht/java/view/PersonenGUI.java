package personaluebersicht.java.view;

import personaluebersicht.java.facade.PersonsFacade;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonenGUI extends JPanel {

    public PersonenGUI(PersonsFacade personsFacade) {

        JPanel personPanel = new JPanel(new BorderLayout());
        personPanel.setBackground(Color.white);
        JPanel selectionPanel = new JPanel(new BorderLayout());
        selectionPanel.setBackground(Color.white);
        JPanel selectionPanel2 = new JPanel(new GridLayout(1, 3));
        selectionPanel2.setBackground(Color.white);
//
        DefaultListModel<String> personListModel = new DefaultListModel<>(); //todo
        JList<String> personList = new JList<>(personListModel);
        JScrollPane personListScrollPanel = new JScrollPane(personList);
        personListScrollPanel.setBackground(Color.white);
        personListScrollPanel.setPreferredSize(new Dimension(150, 80));

        if (personsFacade != null) {
            for (String p : personsFacade.getPersonsList()) {
                personListModel.addElement(p);
            }
        }


        //todo
        personListModel.addElement("Person A");
        personListModel.addElement("Person AA");
        personListModel.addElement("Person AAA");
        personListModel.addElement("Person dddA");
        personListModel.addElement("Person ddA");

        JPanel overviewPanel = new JPanel(new BorderLayout());
        overviewPanel.setBackground(Color.white);
        JPanel overviewPanel2 = new JPanel(new BorderLayout());
        overviewPanel2.setBackground(Color.white);
        JPanel overviewBottomPanel2 = new JPanel(new GridLayout(2,2));
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








        JLabel overview = new JLabel("Übersicht:");

        JLabel nameLabel = new JLabel("Name:");
        JTextField name = new JTextField("Quandale Dingle");
        name.setEditable(false);
        JLabel functionLabel = new JLabel("Funktionen:");
        JCheckBox function = new JCheckBox();
        function.setEnabled(false);
        function.setBackground(Color.white);
        JLabel teamLabel = new JLabel("Teams:");
        JCheckBox team = new JCheckBox();
        team.setEnabled(false);
        team.setBackground(Color.white);
        JLabel img = new JLabel("img");
        JButton add = new JButton("+");
        class AddListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditPersonGUI editPersonGUI = new EditPersonGUI();
            }
        }
        add.addActionListener(new AddListener());
        JButton delete = new JButton("x");
        class DeleteListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        delete.addActionListener(new DeleteListener());
        JButton edit = new JButton("edit");
        class EditListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
        edit.addActionListener(new EditListener());

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

        selectionPanel2.add(add);
        selectionPanel2.add(delete);
        selectionPanel2.add(edit);

        selectionPanel.add(overview, BorderLayout.NORTH);
        selectionPanel.add(personListScrollPanel, BorderLayout.CENTER);
        selectionPanel.add(selectionPanel2, BorderLayout.SOUTH);
        selectionPanel.setBorder(border);

        personPanel.add(overviewPanel, BorderLayout.EAST);
        personPanel.add(selectionPanel, BorderLayout.WEST);
        personPanel.setBorder(personBoarder);

        setBackground(Color.white);
        this.add(personPanel);

        setVisible(true);
    }
}
