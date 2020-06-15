package com.company.JFrames;
import com.company.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class verifyUser extends JFrame {
    private JPanel verifyUser;
    private JTextField dniField;
    private JButton okButton;

    private int dni;

    public verifyUser(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(verifyUser);
        this.pack();
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
                        //En caso de encontrarlo se abre el cuestionario del vuelo
                        found = true;
                        JOptionPane.showMessageDialog(null, "Bienvenido/a " + usuario.getName() + " " + usuario.getLastName() + " !!! ");
                        verifyUser.setVisible(false);
                        cuestionario questionary = new cuestionario("Vuelo");
                        questionary.setBounds(650, 180, 500, 500);
                        questionary.setVisible(true);
                    }
                }

                if (!found){
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
            } catch (JsonParseException jsonParseException) {
                jsonParseException.printStackTrace();
            } catch (JsonMappingException jsonMappingException) {
                jsonMappingException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    //Getters y setters del JFrame
    public int getDniField() {
        return dni;
    }

    public void setDniField(int dni) {
        this.dni = dni;
    }
}
