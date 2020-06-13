package com.company.JFrames;

import com.company.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
                String path = "/home/luciano/Escritorio/tp_facu_taxi/mi_archivo.json";
                File myFile = new File(path);

                try {
                    ObjectMapper mapper = new ObjectMapper();
                    ObjectMapper mapperReader = new ObjectMapper();
                    ArrayList<User> usersJson = mapper.readValue(myFile, mapperReader.getTypeFactory().constructCollectionType(ArrayList.class, User.class));


                    setDniField(Integer.parseInt(dniField.getText()));
                    boolean found = false;
                    for (User usuario : usersJson) {
                        if (usuario.getDNI() == getDniField() && usuario.isRegistered()) {
                            found = true;
                            JOptionPane.showMessageDialog(null, "Bienvenido/a " + usuario.getName() + " " + usuario.getLastName() + " !!! ");
                            verifyUser.setVisible(false);
                            cuestionario questionary = new cuestionario("Cuestionario");
                            questionary.setBounds(650, 180, 500, 500);
                            questionary.setVisible(true);

                        }
                    }

                    if (!found){
                        JOptionPane.showMessageDialog(null, "DNI: " + dniField.getText() + "\nUsted no se encuentra registrado.");
                        verifyUser.setVisible(false);
                        register register = new register("Registro");
                        register.setBounds(650, 180, 500, 500);
                        register.setVisible(true);
                    }

                } catch (NumberFormatException e1) {
                    System.out.println("Imposible convertir");
                    JOptionPane.showMessageDialog(null, "Ingrese su DNI numérico, sin espacios ni puntos");

                    e1.getMessage();
                } catch (JsonParseException jsonParseException) {
                    jsonParseException.printStackTrace();
                } catch (JsonMappingException jsonMappingException) {
                    jsonMappingException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


            }


        });
    }

    public int getDniField() {
        return dni;
    }

    public void setDniField(int dni) {
        this.dni = dni;
    }


}
