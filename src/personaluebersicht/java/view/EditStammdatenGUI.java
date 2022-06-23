package personaluebersicht.java.view;

import personaluebersicht.java.facade.StammdatenFacade;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditStammdatenGUI extends JDialog {

    private String result;

    public EditStammdatenGUI(String string, String btnType, StammdatenFacade stammdatenFacade, String oldValue) {
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setModal(true);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(Color.white);
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBackground(Color.white);
        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBackground(Color.white);
        JPanel panel4 = new JPanel(new GridLayout(1,2));
        panel4.setBackground(Color.white);

        JLabel titleLabel = new JLabel(string + " erfassen/bearbeiten");
        JLabel label = new JLabel(string + ":");
        JTextField jTextField = new JTextField();
        if (oldValue != null) {
            jTextField.setText(oldValue);
        }
        JButton quitButton = new JButton("Abbrechen");
        class QuitListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        }
        quitButton.addActionListener(new QuitListener());
        JButton continueButton = new JButton("Speichern");
        class ContListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (btnType.equals("add")) {
                    if (string.equals("Abteilung")) {
                        stammdatenFacade.addDepartment(jTextField.getText());
                    } else if (string.equals("Funktion")) {
                        stammdatenFacade.addJobFunction(jTextField.getText());
                    } else if (string.equals("Team")) {
                        stammdatenFacade.addTeam(jTextField.getText());
                    }
                    result =jTextField.getText();
                } else { // edit
                    if (string.equals("Abteilung")) {
                       if ( stammdatenFacade.editDepartment(stammdatenFacade.getDepartment(oldValue), jTextField.getText())){
                           result =jTextField.getText();
                       }
                    } else if (string.equals("Funktion")) {
                        if ( stammdatenFacade.editJobFunction(oldValue, jTextField.getText())){
                            result =jTextField.getText();
                        }
                    } else if (string.equals("Team")) {
                        if ( stammdatenFacade.editTeam(oldValue, jTextField.getText())){
                            result =jTextField.getText();
                        }
                    }
                }

                pack();
                setVisible(false);
            }
        }
        continueButton.addActionListener(new ContListener());

        Border border;
        border = BorderFactory.createLineBorder(Color.gray);

        panel4.add(label);
        panel4.add(jTextField);

        panel3.add(quitButton, BorderLayout.WEST);
        panel3.add(continueButton, BorderLayout.EAST);

        panel2.add(panel4, BorderLayout.NORTH);
        panel2.add(panel3, BorderLayout.SOUTH);
        panel2.setBorder(border);

        panel1.add(titleLabel, BorderLayout.NORTH);
        panel1.add(panel2, BorderLayout.CENTER);

        this.add(panel1);

        this.pack();
        this.setVisible(true);
    }

    public java.lang.String getResult() {
        return result;
    }


}
