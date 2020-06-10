package com.company.JFrames;

import com.company.Airplane.Airplane;
import com.company.Airplane.Planes.Gold;
import com.company.Airplane.PropulsionType;
import com.company.Company;
import com.company.Flight.Flight;
import com.company.Flight.User;

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
                try{

                    int dni = Integer.parseInt(dniTextField.getText());
                    int edad = Integer.parseInt(edadTextField.getText());

                    User user1 = new User (nombreTextField.getText(), apellidoTextField.getText(), dni, edad);
                    User user2 = new User ("juan", apellidoTextField.getText(), dni, edad);
                    user1.setRegistered(true);
                    PropulsionType pt =  PropulsionType.HELICE;
                    Gold a = new Gold(1321, 321, 321, pt, true);

                    Company c = new Company();
                    c.addToCollection(user1);
                    c.addToCollection(user2);
                    c.showCollection(user1);

                    c.addToCollection(a);
                    c.showCollection(a);

                    JOptionPane.showMessageDialog(null, user1.toString());

                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(null, " Por favor introduzca valores válidos ");
                    System.out.println("No se puede convertir a número.");
                    e1.getMessage();
                }

            }
        });
    }

}
