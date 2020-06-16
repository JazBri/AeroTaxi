package com.company.JFrames;

import com.company.Airplane.Airplane;
import com.company.Airplane.Planes.Bronze;
import com.company.Airplane.Planes.Gold;
import com.company.Airplane.Planes.Silver;
import com.company.City;
import com.company.Company;
import com.company.Flight.Flight;
import com.company.Questionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class cuestionario extends JFrame {
    private JPanel cuestionario;
    private JTextField fechaField;
    private JTextField ocupantesField;
    private JCheckBox goldCheckBox;
    private JCheckBox bronzeCheckBox;
    private JButton okButton;
    private JCheckBox silverCheckBox;
    private JComboBox destinoCB;
    private JButton volverAInicioButton;
    private JComboBox origenCB;
    private String origen;
    private String destino;
    private Airplane avion;

    public cuestionario(String title) throws HeadlessException, IOException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(cuestionario);
        this.pack();

        //Agregamos las opciones de las ciudades
        /**VER CÓMO AGREGAR LAS CIUDADES DESDE LA COLECCIÓN*/
        origenCB.addItem("Buenos Aires");
        origenCB.addItem("Córdoba");
        origenCB.addItem("Montevideo");
        destinoCB.addItem("Córdoba");
        destinoCB.addItem("Santiago");
        destinoCB.addItem("Montevideo");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    /**ALGUNA VALIDACION PARA LA CANTIDAD DE OCUPANTES*/
                    int ocupantes = Integer.parseInt(ocupantesField.getText());
                    LocalDate localDate1 = LocalDate.parse(fechaField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.println("String -> java.time.LocalDate: " + localDate1);


                    /**Esto esta HORRIBLE, pero por ahora es lo que se me ocurre.*/
                    if(goldCheckBox.isSelected()){
                        avion = new Gold();
                    }else{
                        if(silverCheckBox.isSelected()){
                            avion = new Silver();
                        }else{
                            if(bronzeCheckBox.isSelected()){
                                avion = new Bronze();
                            }
                        }
                    }

                    if(origen == null || destino == null || origen == destino) {
                        JOptionPane.showMessageDialog(null, "Ingrese un recorrido válido");
                    }else {
                        City city = new City(origen, destino);


                        Questionary q = new Questionary(localDate1, city, ocupantes, avion);
                        System.out.println("q:" + q.toString());


                        int option = JOptionPane.showConfirmDialog(null, q);


                        //0 si, 1 no, 2 cancel
                        if (option == 0) {
                        //Al aceptar se crea un Flight que deberá guardarse en un archivo.
                            /**HACER MÉTODOS DE GUARDADO Y LEVANTE EN LA CLASE FILE*/
                            Flight flight = new Flight(city, verifyUser.getSingletonInstance().getUser() ,  q, true);
                            System.out.println("\n\n VUELOS \n");
                            Company.getSingletonInstance().showCollection(flight);
                            int confirm = JOptionPane.showConfirmDialog(null, flight);
                            if(confirm == 0){
                                Company.getSingletonInstance().addToCollection(flight);
                                JOptionPane.showMessageDialog(null, "Vuelo reservado\nBuen viaje!!");
                            }


                            /*******************************************************/

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
        destinoCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                origen = (String) origenCB.getSelectedItem();

                }
        });

        volverAInicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**ESTO TAMBIÉN HAY QUE CAMBIARLO, NO SÉ COMO OCULTAR LOS OTROS FRAMES. */
                cuestionario.setVisible(false);
            /*    verifyUser.setBounds(650, 180, 500, 500);
                verifyUser.setVisible(true);*/
                verifyUser.getSingletonInstance().setBounds(650,180,500,500);
            verifyUser.getSingletonInstance().setVisible(true);
            }
        });
        origenCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destino = (String) destinoCB.getSelectedItem();
            }
        });
    }
}
