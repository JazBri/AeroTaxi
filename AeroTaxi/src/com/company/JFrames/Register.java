package com.company.JFrames;


import com.company.CompanyAdmin.Company;
import com.company.User.User;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Register extends JFrame {
    private JPanel register;
    private JLabel labelRegister;
    private JTextField nombreTextField;
    private JTextField introduzcaSuApellidoTextField;
    private JTextField dniTextField;
    private JButton OKButton;
    private JTextField edadTextField;
    private JTextField apellidoTextField;
    private JLabel salida;

    public Register(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(register);
        this.setResizable(false);
        this.pack();

        String pathUser = "usuarios.json";
        File myFileUser = new File(pathUser);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Parseamos los valores TextField del documento y edad.
                    int dni = Integer.parseInt(dniTextField.getText());
                    int edad = Integer.parseInt(edadTextField.getText());

                    User user1 = new User(nombreTextField.getText(), apellidoTextField.getText(), dni, edad, true);
                    user1.setRegistered(true);

                    //Agregamos a la colección d eusuarios del objeto instanciado en el main.
                    Company.getSingletonInstance().addToCollection(user1);
                    ObjectMapper mapperUser = new ObjectMapper();
                    ObjectMapper mapperReaderUser = new ObjectMapper();
                    ArrayList<User> us = mapperUser.readValue(myFileUser, mapperReaderUser.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
                    boolean canRegister = true;
                    for (int i = 0; i < us.size(); i++) {
                        if (dni == us.get(i).getDNI()) {
                            canRegister = false;
                            JOptionPane.showMessageDialog(null, "El dni ingresad ya se encuentra registrado , ingrese un valor valido");


                        }

                    }

                    if (canRegister) {
                        us.add(user1);
                        mapperUser.writerWithDefaultPrettyPrinter().writeValue(new File(pathUser), us);
                        JOptionPane.showMessageDialog(null, user1.showMessageRegistered(), "Nuevo Usuario", JOptionPane.INFORMATION_MESSAGE);
                        register.setVisible(false);
                        VerifyUser verifyUser = new VerifyUser("menu");
                        verifyUser.setBounds(650,180,500,500);
                        verifyUser.setVisible(true);
                    }


                } catch (NumberFormatException | IOException e1) {
                    JOptionPane.showMessageDialog(null, " Por favor introduzca valores válidos ");
                    System.out.println("No se puede convertir a número.");
                    e1.getMessage();
                }

            }
        });
    }

}
