package personaluebersicht.java.view;

import personaluebersicht.java.facade.StammdatenFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StammdatenGUI extends JPanel {

    public StammdatenGUI(StammdatenFacade stammdatenFacade) {
        this.setBackground(Color.white);
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        JPanel centerPanel2 = new JPanel(new GridLayout(4, 2));
        JPanel functionPanel1 = new JPanel(new BorderLayout());
        JPanel functionPanel3 = new JPanel(new GridLayout(1, 3));
        DefaultListModel<String> functionListModel = new DefaultListModel<>(); //todo
        JList<String> functionList = new JList<>(functionListModel);
        if (stammdatenFacade != null) {
            for (String p : stammdatenFacade.getJobFunctionList()) {
                functionListModel.addElement(p);
            }
        }
        JScrollPane functionPanel2 = new JScrollPane(functionList);

        JPanel partyPanel1 = new JPanel(new BorderLayout());
        JPanel partyPanel3 = new JPanel(new GridLayout(1, 3));
        DefaultListModel<String> partyListModel = new DefaultListModel<>(); //todo
        JList<String> partyList = new JList<>(partyListModel);
        if (stammdatenFacade != null) {
            for (String p : stammdatenFacade.getDepartmentList()) {
                partyListModel.addElement(p);
            }
        }
        JScrollPane partyPanel2 = new JScrollPane(partyList);

        JPanel teamPanel1 = new JPanel(new BorderLayout());
        JPanel teamPanel3 = new JPanel(new GridLayout(1, 3));
        DefaultListModel<String> teamListModel = new DefaultListModel<>(); //todo
        JList<String> teamList = new JList<>(teamListModel);
        if (stammdatenFacade != null) {
            for (String p : stammdatenFacade.getTeamList()) {
                teamListModel.addElement(p);
            }
        }
        JScrollPane teamPanel2 = new JScrollPane(teamList);


        JLabel companyLabel = new JLabel("Firma:");
        JTextField company = new JTextField(stammdatenFacade.getCompanyName());
        JLabel partyLabel = new JLabel("Abteilungen:");
        JLabel functionLabel = new JLabel("Funktionen:");
        JLabel teamLabel = new JLabel("Teams:");
        JTextField text = new JTextField("Text");
        text.setEditable(false);
        JButton addParty = new JButton("+");
        class AddPartyListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string = "Abteilung";
                String btnType = "add";
                EditStammdatenGUI editStammdatenGUI = new EditStammdatenGUI(string, btnType, stammdatenFacade, null);
                if (editStammdatenGUI.getResult() != null) {
                    partyListModel.addElement(editStammdatenGUI.getResult());
                }
            }
        }
        addParty.addActionListener(new AddPartyListener());
        JButton deleteParty = new JButton("x");
        class DeletePartyListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (partyList.getSelectedValue() != null) {
                    if (stammdatenFacade.deleteDepartment(stammdatenFacade.getDepartment(partyList.getSelectedValue()))) {
                        partyListModel.removeElement(partyList.getSelectedValue());
                    }

                }
            }
        }
        deleteParty.addActionListener(new DeletePartyListener());
        JButton editParty = new JButton("edit");
        class EditPartyListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string = "Abteilung";
                String btnType = "edit";
                int index = partyList.getSelectedIndex();
                if (index >= 0) {
                    String oldTeam = partyList.getSelectedValue();
                    EditStammdatenGUI editStammdatenGUI = new EditStammdatenGUI(string, btnType, stammdatenFacade, oldTeam);
                    if (editStammdatenGUI.getResult() != null) {
                        partyListModel.set(index, editStammdatenGUI.getResult());
                    }
                }
            }
        }
        editParty.addActionListener(new EditPartyListener());
        JButton addFunction = new JButton("+");
        class AddFunctionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string = "Funktion";
                String btnType = "add";
                EditStammdatenGUI editStammdatenGUI = new EditStammdatenGUI(string, btnType, stammdatenFacade, null);
                if (editStammdatenGUI.getResult() != null) {
                    functionListModel.addElement(editStammdatenGUI.getResult());
                }
            }
        }
        addFunction.addActionListener(new AddFunctionListener());
        JButton deleteFunction = new JButton("x");
        class DeleteFunctionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (functionList.getSelectedValue() != null) {
                    if (stammdatenFacade.deleteJobFunction(functionList.getSelectedValue())) {
                        functionListModel.removeElement(functionList.getSelectedValue());
                    }
                }
            }
        }
        deleteFunction.addActionListener(new DeleteFunctionListener());
        JButton editFunction = new JButton("edit");
        class EditFunctionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string = "Funktion";
                String btnType = "edit";
                int index = functionList.getSelectedIndex();
                if (index >= 0) {
                    String oldTeam = functionList.getSelectedValue();
                    EditStammdatenGUI editStammdatenGUI = new EditStammdatenGUI(string, btnType, stammdatenFacade, oldTeam);
                    if (editStammdatenGUI.getResult() != null) {
                        functionListModel.set(index, editStammdatenGUI.getResult());
                    }
                }
            }
        }
        editFunction.addActionListener(new EditFunctionListener());
        JButton addTeam = new JButton("+");
        class AddTeamListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string = "Team";
                String btnType = "add";
                EditStammdatenGUI editStammdatenGUI = new EditStammdatenGUI(string, btnType, stammdatenFacade, null);
                if (editStammdatenGUI.getResult() != null) {
                    teamListModel.addElement(editStammdatenGUI.getResult());
                }
            }
        }
        addTeam.addActionListener(new AddTeamListener());
        JButton deleteTeam = new JButton("x");
        class DeleteTeamListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (teamList.getSelectedValue() != null) {
                    if (stammdatenFacade.deleteTeam(teamList.getSelectedValue())) {
                        teamListModel.removeElement(teamList.getSelectedValue());
                    }
                }
            }
        }
        deleteTeam.addActionListener(new DeleteTeamListener());
        JButton editTeam = new JButton("edit");
        class EditTeamListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string = "Team";
                String btnType = "edit";
                int index = teamList.getSelectedIndex();
                if (index >= 0) {
                    String oldTeam = teamList.getSelectedValue();
                    EditStammdatenGUI editStammdatenGUI = new EditStammdatenGUI(string, btnType, stammdatenFacade, oldTeam);
                    if (editStammdatenGUI.getResult() != null) {
                        teamListModel.set(index, editStammdatenGUI.getResult());
                    }
                }
            }
        }
        editTeam.addActionListener(new EditTeamListener());

        partyPanel3.add(addParty);
        partyPanel3.add(deleteParty);
        partyPanel3.add(editParty);
        functionPanel3.add(addFunction);
        functionPanel3.add(deleteFunction);
        functionPanel3.add(editFunction);
        teamPanel3.add(addTeam);
        teamPanel3.add(deleteTeam);
        teamPanel3.add(editTeam);

        partyPanel1.add(partyPanel2, BorderLayout.NORTH);
        partyPanel1.add(partyPanel3, BorderLayout.CENTER);
        functionPanel1.add(functionPanel2, BorderLayout.NORTH);
        functionPanel1.add(functionPanel3, BorderLayout.CENTER);
        teamPanel1.add(teamPanel2, BorderLayout.NORTH);
        teamPanel1.add(teamPanel3, BorderLayout.CENTER);

        topPanel.add(companyLabel);
        topPanel.add(company);
        centerPanel2.add(partyLabel);
        centerPanel2.add(partyPanel1);
        centerPanel2.add(functionLabel);
        centerPanel2.add(functionPanel1);
        centerPanel2.add(teamLabel);
        centerPanel2.add(teamPanel1);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel2, BorderLayout.SOUTH);

        JScrollPane mainScrollPane = new JScrollPane(mainPanel);
        mainScrollPane.setBackground(Color.white);


        super.update(this.getGraphics());

        this.add(mainScrollPane);
        setVisible(true);
    }
}
