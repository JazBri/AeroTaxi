package com.company.JFrames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class register extends JFrame{
    private JPanel register;
    private JLabel labelRegister;
    private JTextField nombreTextField;
    private JTextField introduzcaSuApellidoTextField;
    private JTextField dniTextField;
    private JButton OKButton;
    private JTextField edadTextField;
    private JTextField apellidoTextField;
    private JLabel salida;

    public register(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(register);
        this.pack();
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, nombreTextField.getText());

            }
        });
    }

}
