package com.company.JFrames;

import com.company.Airplane.Airplane;
import com.company.City;
import com.company.Company;
import com.company.Questionary;
import com.company.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class cuestionario extends JFrame {
    private JPanel cuestionario;
    private JTextField fechaField;
    private JTextField ocupantesField;
    private JCheckBox goldCheckBox;
    private JCheckBox bronzeCheckBox;
    private JButton okButton;
    private JCheckBox silverCheckBox;
    private JComboBox origenComboBox;
    private JButton volverAInicioButton;
    private String recorrido;

    public cuestionario(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(cuestionario);
        this.pack();
        verifyUser verifyUser = new verifyUser("Aero Taxi Usuario ->");

    //Agregamos las opciones de las ciudades
    for (Object c : Company.getSingletonInstance().returnCities()){
        origenComboBox.addItem(c.toString());
    }

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    /**ALGUNA VALIDACION PARA LA CANTIDAD DE OCUPANTES*/
                    int ocupantes = Integer.parseInt(ocupantesField.getText());
                    LocalDate localDate1 = LocalDate.parse(fechaField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.println("String -> java.time.LocalDate: " + localDate1);
                    String servicio = null;

                    /**Esto esta HORRIBLE, pero por ahora es lo que se me ocurre.*/
                    if(goldCheckBox.isSelected()){
                        servicio = "Gold";
                    }else{
                        if(silverCheckBox.isSelected()){
                            servicio = "Silver";
                        }else{
                            if(bronzeCheckBox.isSelected()){
                                servicio = "Bronze";
                            }
                        }
                    }
                    if(recorrido == null) {

                        JOptionPane.showMessageDialog(null, "Ingrese un recorrido");
                    }else {
                        Questionary q = new Questionary(localDate1, recorrido, ocupantes, servicio);
                        System.out.println("q:" + q.toString());
                        int option = JOptionPane.showConfirmDialog(null, q);

                        //0 si, 1 no, 2 cancel
                        if (option == 0) {
                            JOptionPane.showMessageDialog(null, "Vuelo reservado\nBuen viaje!!");
                        }

                        if (option == 1 || option == 2) {
                            JOptionPane.showMessageDialog(null, "Volviendo, no se ha registrado ningún viaje");
                            //cuestionario.setVisible(false);
                            //verifyUser.setVisible(true);
                        }
                    }
                } catch (Exception e1) {
                    e1.getMessage();
                    JOptionPane.showMessageDialog(null, "Alguno de los datos ingresados es incorrecto, por favor revíselos");
                }
            }
        });

        //Estos 3 eventos manejan que solo se pueda seleccionar 1 tipo de avión.
        goldCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(goldCheckBox.isSelected()){
                    silverCheckBox.setSelected(false);
                    bronzeCheckBox.setSelected(false);

                }
            }
        });
        silverCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(silverCheckBox.isSelected()){
                    goldCheckBox.setSelected(false);
                    bronzeCheckBox.setSelected(false);

                }
            }
        });
        bronzeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bronzeCheckBox.isSelected()){
                    silverCheckBox.setSelected(false);
                    goldCheckBox.setSelected(false);

                }
            }
        });
        origenComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recorrido = (String)origenComboBox.getSelectedItem();
                }
        });

        volverAInicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**ESTO TAMBIÉN HAY QUE CAMBIARLO, NO SÉ COMO OCULTAR LOS OTROS FRAMES. */
                cuestionario.setVisible(false);
                verifyUser.setBounds(650, 180, 500, 500);
                verifyUser.setVisible(true);
            }
        });
    }
}
