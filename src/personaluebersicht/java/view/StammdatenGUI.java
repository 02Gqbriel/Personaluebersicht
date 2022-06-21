package personaluebersicht.java.view;

import javax.swing.*;
import java.awt.*;

public class StammdatenGUI extends JPanel {

    public StammdatenGUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JScrollPane centerPanel = new JScrollPane();
        JPanel centerPanel2 = new JPanel(new GridLayout(4, 2));
        JPanel functionPanel1 = new JPanel(new BorderLayout());
        JScrollPane functionPanel2 = new JScrollPane();
        JPanel functionPanel3 = new JPanel(new GridLayout(1, 3));
        JPanel functionPanel4 = new JPanel(new GridLayout(10, 1));
        JPanel partyPanel1 = new JPanel(new GridLayout(10, 1));
        JScrollPane partyPanel2 = new JScrollPane();
        JPanel partyPanel3 = new JPanel(new GridLayout(1, 3));
        JPanel partyPanel4 = new JPanel(new GridLayout(10, 1));
        JPanel teamPanel1 = new JPanel(new GridLayout(10, 1));
        JScrollPane teamPanel2 = new JScrollPane();
        JPanel teamPanel3 = new JPanel(new GridLayout(1, 3));
        JPanel teamPanel4 = new JPanel(new GridLayout(10, 1));

        JLabel companyLabel = new JLabel("Firma:");
        JTextField company = new JTextField();
        JLabel partyLabel = new JLabel("Abteilungen:");
        JLabel functionLabel = new JLabel("Funktionen:");
        JLabel teamLabel = new JLabel("Teams:");
        JTextField text = new JTextField("Text");
        text.setEditable(false);
        JButton addParty = new JButton("+");
        JButton deleteParty = new JButton("x");
        JButton editParty = new JButton("edit");
        JButton addFunction = new JButton("edit");
        JButton deleteFunction = new JButton("+");
        JButton editFunction = new JButton("x");
        JButton addTeam = new JButton("+");
        JButton deleteTeam = new JButton("x");
        JButton editTeam = new JButton("edit");

        partyPanel4.add(text);
        functionPanel4.add(text);
        teamPanel4.add(text);

        partyPanel3.add(addParty);
        partyPanel3.add(deleteParty);
        partyPanel3.add(editParty);
        functionPanel3.add(addFunction);
        functionPanel3.add(deleteFunction);
        functionPanel3.add(editFunction);
        teamPanel3.add(addTeam);
        teamPanel3.add(deleteTeam);
        teamPanel3.add(editTeam);
        partyPanel2.add(partyPanel4);
        functionPanel2.add(functionPanel4);
        teamPanel2.add(teamPanel4);

        partyPanel1.add(partyPanel2, BorderLayout.NORTH);
        partyPanel1.add(partyPanel3, BorderLayout.CENTER);
        functionPanel1.add(functionPanel2, BorderLayout.NORTH);
        functionPanel1.add(functionPanel3, BorderLayout.CENTER);
        teamPanel1.add(teamPanel2, BorderLayout.NORTH);
        teamPanel1.add(teamPanel3, BorderLayout.CENTER);

        centerPanel2.add(companyLabel);
        centerPanel2.add(company);
        centerPanel2.add(partyLabel);
        centerPanel2.add(partyPanel1);
        centerPanel2.add(functionLabel);
        centerPanel2.add(functionPanel1);
        centerPanel2.add(teamLabel);
        centerPanel2.add(teamPanel1);

        mainPanel.add(centerPanel2, BorderLayout.CENTER);

        this.add(mainPanel);

        setVisible(true);
    }
}
