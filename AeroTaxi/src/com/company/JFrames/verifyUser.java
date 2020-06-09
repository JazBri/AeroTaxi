package com.company.JFrames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class verifyUser extends JFrame {
    private JPanel verifyUser;
    private JTextField dniField;
    private JButton okButton;
    private String dni;

    public verifyUser(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(verifyUser);
        this.pack();
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null," DNI: " + dniField.getText());
                setDniField(dniField.getText());
                System.out.println("DNI: " + getDniField());
            }
        });
    }


    public String getDniField() {
        return dni;
    }

     public void setDniField(String dni) {
        this.dni = dni;

    }
}
