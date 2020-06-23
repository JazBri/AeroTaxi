package com.company.JFrames;

import com.company.CompanyAdmin.Company;
import com.company.User.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class VerifyUser extends JFrame {
    private JPanel verifyUser;
    private JTextField dniField;
    private JButton okButton;
    private JButton registerButton;
    private User user;
    private int dni;
    private static VerifyUser vu;


    public VerifyUser(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(verifyUser);
        this.setResizable(false);
        this.pack();

        registerButton.addActionListener(event -> {
            verifyUser.setVisible(false);
            Register register = new Register("Registro");
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
                        UserMenu userMenu = new UserMenu();
                        userMenu.setBounds(650, 180, 500, 500);
                        userMenu.setVisible(true);
                    }
                }

                if (!found) {
                    //En caso de encontrarlo se abre el registro de Usuario
                    JOptionPane.showMessageDialog(null, "DNI: " + dniField.getText() + "\nUsted no se encuentra registrado.");
                    verifyUser.setVisible(false);
                    Register register = new Register("Registro");
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

    }

    //getSingletonInstance devuelve la instancia del objeto, de esta manera se puede llamar en distintas clases.
    public static VerifyUser getSingletonInstance() {
        if (vu == null) {
            vu = new VerifyUser("Aero Taxi");
            System.out.println("Objeto Company creado exitosamente!");
            vu.setVisible(true);
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
