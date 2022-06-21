package personaluebersicht.java.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyEvent;

public class UebersichtGUI extends JPanel {

        public UebersichtGUI() {

                JPanel personPanel = new JPanel(new BorderLayout());
                personPanel.setBackground(Color.white);
                JPanel bottomPanel = new JPanel(new BorderLayout());
                bottomPanel.setBackground(Color.white);
                JPanel selectionPanel = new JPanel(new BorderLayout());
                selectionPanel.setBackground(Color.white);
                JScrollPane personListScrollPanel = new JScrollPane();
                personListScrollPanel.setBackground(Color.white);
                JPanel personListPanel = new JPanel(new GridLayout(10, 1));
                personListPanel.setBackground(Color.white);
                JPanel overviewPanel = new JPanel(new BorderLayout());
                overviewPanel.setBackground(Color.white);
                JPanel overviewPanel2 = new JPanel(new BorderLayout());
                overviewPanel2.setBackground(Color.white);
                JPanel overviewBottomPanel2 = new JPanel(new BorderLayout());
                overviewBottomPanel2.setBackground(Color.white);
                JPanel overviewTopPanel1 = new JPanel(new GridLayout(1, 2));
                overviewTopPanel1.setBackground(Color.white);
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

                TitledBorder personBoarder;
                personBoarder = BorderFactory.createTitledBorder(
                                BorderFactory.createLineBorder(Color.gray), "Personen barbeiten:");

                Border border;
                border = BorderFactory.createLineBorder(Color.gray);

                String[] optionsToChoose = { "Apple", "Orange", "Banana", "Pineapple", "None of the listed" };

                personListScrollPanel.add(personListPanel);

                JLabel overview = new JLabel("Übersicht:");
                JLabel nameLabel = new JLabel("Name:");
                JTextField name = new JTextField("Quandale Dingle");
                name.setEditable(false);
                JLabel partyLabel = new JLabel("Abteilung:");
                JLabel partyLabel2 = new JLabel("Abteilung:");
                JLabel party = new JLabel("Finanzen");
                JComboBox<String> partyComboBox = new JComboBox<>(optionsToChoose);
                JLabel functionLabel = new JLabel("Funktionen:");
                JComboBox<String> function = new JComboBox<>(optionsToChoose);
                JLabel teamLabel = new JLabel("Teams:");
                JComboBox<String> team = new JComboBox<>(optionsToChoose);
                JLabel img = new JLabel("img");

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

                overviewBottomPanel2.add(partyLabel, BorderLayout.NORTH);
                overviewBottomPanel2.add(party, BorderLayout.NORTH);
                overviewBottomPanel2.add(functionLabel);
                overviewBottomPanel2.add(teamLabel);

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

                sortPanel.add(noSort, BorderLayout.NORTH);
                sortPanel.add(aZSort, BorderLayout.CENTER);
                sortPanel.add(zASort, BorderLayout.SOUTH);
                sortPanel.setBorder(sortBoarder);

                filterPanel.add(partyLabel2);
                filterPanel.add(partyComboBox);
                filterPanel.add(functionLabel);
                filterPanel.add(function);
                filterPanel.add(teamLabel);
                filterPanel.add(team);
                filterPanel.setBorder(filterBoarder);

                bottomPanel.add(sortPanel, BorderLayout.WEST);
                bottomPanel.add(filterPanel, BorderLayout.EAST);

                personPanel.add(overviewPanel, BorderLayout.EAST);
                personPanel.add(selectionPanel, BorderLayout.WEST);
                personPanel.add(bottomPanel, BorderLayout.SOUTH);

                personPanel.setBorder(personBoarder);

                setBackground(Color.white);
                this.add(personPanel);

                setVisible(true);
        }
}
