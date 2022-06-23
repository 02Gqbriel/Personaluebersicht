package personaluebersicht.java.view;

import personaluebersicht.java.facade.UebersichtFacade;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JDialog {

    private boolean loggedIn;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public LoginGUI(UebersichtFacade uebersichtFacade) {
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        setModal(true);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.white);
        JPanel bottomPanel2 = new JPanel(new GridLayout(3, 2));
        bottomPanel2.setBackground(Color.white);

        Border border;
        border = BorderFactory.createLineBorder(Color.gray);

        String[] optionsToChoose = {"Apple", "Orange", "Banana", "Pineapple", "None of the listed"};

        JLabel authLabel = new JLabel("Authentifizierung");
        JLabel nameLabel = new JLabel("Name:");
        JComboBox<String> name = new JComboBox<>(uebersichtFacade.getPersonsList());
        JLabel codeLabel = new JLabel("Code:");
        JTextField code = new JTextField();
        JButton quitButton = new JButton("Abbrechen");
        class QuitListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        }
        quitButton.addActionListener(new QuitListener());
        JButton continueButton = new JButton("Weiter");
        class ContListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("1234".equals(code.getText())) {
                    loggedIn = true;
                    setVisible(false);
                }
            }
        }
        continueButton.addActionListener(new ContListener());

        bottomPanel2.add(nameLabel);
        bottomPanel2.add(name);
        bottomPanel2.add(codeLabel);
        bottomPanel2.add(code);
        bottomPanel2.add(quitButton);
        bottomPanel2.add(continueButton);

        bottomPanel.add(bottomPanel2, BorderLayout.CENTER);
        bottomPanel.setBorder(border);

        this.add(authLabel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);


    }


}
