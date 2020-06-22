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

public class register extends JFrame {
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

                    /**FALTARÍA QUE EL USUARIO CONFIRME LOS DATOS.*/
                    /**FALTARÍA REDIRIGIR, UNA VEZ CONFIRME DATOS A CUENTIONARIO, SI NO QUE LOS VUELVA A CARGAR.*/
                    /**VER DE VOLVER A BUSCAR EL USUARIO EN EL ARCHIVO ANTES DE AGREGARLO.*/
                    User user1 = new User(nombreTextField.getText(), apellidoTextField.getText(), dni, edad, true);
                    user1.setRegistered(true);

                    //Agregamos a la colección d eusuarios del objeto instanciado en el main.
                    Company.getSingletonInstance().addToCollection(user1);
                    ObjectMapper mapperUser = new ObjectMapper();
                    ObjectMapper mapperReaderUser = new ObjectMapper();
                    ArrayList<User> us = mapperUser.readValue(myFileUser, mapperReaderUser.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
                    us.add(user1);
                    mapperUser.writerWithDefaultPrettyPrinter().writeValue(new File(pathUser), us);

                    JOptionPane.showMessageDialog(null, user1.showMessageRegistered(), "Nuevo Usuario", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException | IOException e1) {
                    JOptionPane.showMessageDialog(null, " Por favor introduzca valores válidos ");
                    System.out.println("No se puede convertir a número.");
                    e1.getMessage();
                }

            }
        });
    }

}
