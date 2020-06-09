package com.company.JFrames;

import com.company.Flight.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class verifyUser extends JFrame {
    private JPanel verifyUser;
    private JTextField dniField;
    private JButton okButton;
    private JLabel dniShowLabel;
    private int dni;

    public verifyUser(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(verifyUser);
        this.pack();
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    setDniField(Integer.parseInt(dniField.getText()));
                    //Lo tomaría del Archivo
                    User user = new User("Usuario", "De Prueba", getDniField(), 12);
                    System.out.println(user.toString());
                    // dniShowLabel.setText(user.getDNI());
                    //Comprobación del dni en el archivo con la colección de usuarios
                    //if (getDniField() == user.getDNI()) {
                    if (getDniField() == 1) {
                        JOptionPane.showMessageDialog(null, "Bienvenido/a " + user.getName() + " " + user.getLastName() + " !!! ");
                    } else {
                        JOptionPane.showMessageDialog(null, "DNI: " + dniField.getText() + "\nUsted no se encuentra registrado.");
                        verifyUser.setVisible(false);
                        register register = new register("Registro");
                        register.setBounds(650, 180, 500, 500);
                        register.setVisible(true);
                    }
                }catch (NumberFormatException e1){
                    System.out.println("Imposible convertir");
                    JOptionPane.showMessageDialog(null, "Ingrese su DNI numérico, sin espacios ni puntos");

                    e1.getMessage();
                }
                //System.out.println("DNI : " + dniField.getText());
                //System.out.println("DNI: " + getDniField());

            }




        });
    }

    public int getDniField() {
        return dni;
    }

    public void setDniField(int dni) {
        this.dni = dni;
    }

/* public String getDniField() {
        return dni;
    }

     public void setDniField(String dni) {
        this.dni = dni;

    }*/
}
