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

public class verifyUser extends JFrame {
    private JPanel verifyUser;
    private JTextField dniField;
    private JButton okButton;
    private JButton registerButton;
    private JButton másOpcionesButton;
    private User user;
    private int dni;
    private static verifyUser vu;


    private verifyUser(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(verifyUser);
        this.pack();

        registerButton.addActionListener(event -> {
            verifyUser.setVisible(false);
            register register = new register("Registro");
            register.setBounds(650, 180, 500, 500);
            register.setVisible(true);


        });

        okButton.addActionListener(e -> {
            String path = "usuarios.json";
            File myFile = new File(path);

            try {
                //Se levanta los datos de usuarios del archivo
                ObjectMapper mapper = new ObjectMapper();
                ObjectMapper mapperReader = new ObjectMapper();
                ArrayList<User> usersJson = mapper.readValue(myFile, mapperReader.getTypeFactory().constructCollectionType(ArrayList.class, User.class));

                //Se parsea el valor del dni (textField) a Integer para su comparación.
                setDniField(Integer.parseInt(dniField.getText()));
                boolean found = false;
                for (User usuario : usersJson) {
                    if (usuario.getDNI() == getDniField() && usuario.isRegistered()) {

                        Company.getSingletonInstance().setCurrentLoggedUser(usuario);
                        found = true;
                        setUser(usuario);
                        JOptionPane.showMessageDialog(null, "Bienvenido/a " + usuario.getName() + " " + usuario.getLastName() + " !!! ");
                        verifyUser.setVisible(false);
                        cuestionario questionary = new cuestionario("Vuelo");
                        questionary.setBounds(650, 180, 500, 500);
                        questionary.setVisible(true);
                    }
                }

                if (!found) {
                    //En caso de encontrarlo se abre el registro de Usuario
                    JOptionPane.showMessageDialog(null, "DNI: " + dniField.getText() + "\nUsted no se encuentra registrado.");
                    verifyUser.setVisible(false);
                    register register = new register("Registro");
                    register.setBounds(650, 180, 500, 500);
                    register.setVisible(true);
                }

            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(null, "Ingrese su DNI numérico, sin espacios ni puntos");
                e1.getMessage();
            } catch (IOException jsonParseException) {
                jsonParseException.printStackTrace();
            }


        });
        másOpcionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listado listado = new listado("Listado");
                verifyUser.setVisible(false);
                listado.setBounds(650, 180, 1200, 500);
                listado.setVisible(true);
            }
        });
    }

    //getSingletonInstance devuelve la instancia del objeto, de esta manera se puede llamar en distintas clases.
    public static verifyUser getSingletonInstance() {
        if (vu == null) {
            vu = new verifyUser("Aero Taxi");
            System.out.println("Objeto Company creado exitosamente!");
        } else {
            //   System.out.println("El objeto Company ya se encuentra instanciado.");
        }
        return vu;
    }


    //Getters y setters del JFrame
    public int getDniField() {
        return dni;
    }

    public void setDniField(int dni) {
        this.dni = dni;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
