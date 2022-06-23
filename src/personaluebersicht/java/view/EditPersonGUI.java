package personaluebersicht.java.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPersonGUI extends JDialog {

    public EditPersonGUI() {
        setUndecorated(true);
        setModal(true);

        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        JPanel overviewPanel = new JPanel(new BorderLayout());
        overviewPanel.setBackground(Color.white);
        JPanel overviewPanel2 = new JPanel(new BorderLayout());
        overviewPanel2.setBackground(Color.white);
        JPanel overviewBottomPanel1 = new JPanel(new BorderLayout());
        overviewBottomPanel1.setBackground(Color.white);
        JPanel overviewBottomPanel2 = new JPanel(new GridLayout(1,2));
        overviewBottomPanel2.setBackground(Color.white);
        JPanel overviewTopPanel1 = new JPanel(new GridLayout(2,2));
        overviewTopPanel1.setBackground(Color.white);
        JPanel overviewMiddlePanel = new JPanel(new GridLayout(2,2));
        overviewMiddlePanel.setBackground(Color.white);

        Border border;
        border = BorderFactory.createLineBorder(Color.gray);


        JLabel titleLabel = new JLabel("Person erfassen");

        JLabel nameLabel = new JLabel("Name:");
        JTextField name = new JTextField();
        JLabel hrLabel = new JLabel("HR-Mitarbeiter:");
        JCheckBox hr = new JCheckBox();
        hr.setBackground(Color.white);
        JLabel adminLabel = new JLabel("Administrator:");
        JCheckBox admin = new JCheckBox();
        admin.setBackground(Color.white);
        JLabel imgLabel = new JLabel("Foto:");
        JLabel img = new JLabel("img");
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

                setVisible(false);
            }
        }
        continueButton.addActionListener(new ContListener());

        overviewMiddlePanel.add(hrLabel);
        overviewMiddlePanel.add(hr);
        overviewMiddlePanel.add(adminLabel);
        overviewMiddlePanel.add(admin);

        overviewTopPanel1.add(nameLabel);
        overviewTopPanel1.add(name);

        overviewTopPanel1.add(imgLabel);
        overviewTopPanel1.add(img);

        overviewBottomPanel2.add(quitButton);
        overviewBottomPanel2.add(continueButton);

        overviewPanel2.add(overviewTopPanel1, BorderLayout.NORTH);
        overviewPanel2.add(overviewMiddlePanel, BorderLayout.CENTER);
        overviewPanel2.add(overviewBottomPanel2, BorderLayout.SOUTH);

        overviewPanel.add(overviewPanel2, BorderLayout.CENTER);
        overviewPanel.setBorder(border);

        this.add(titleLabel, BorderLayout.NORTH);
        this.add(overviewPanel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

}
