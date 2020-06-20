package com.company.JFrames;

import com.company.Airplane.Airplane;
import com.company.City.City;
import com.company.CompanyAdmin.Company;
import com.company.Flight.Flight;
import com.company.Questionary.Questionary;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class cuestionario extends JFrame {
    private JPanel cuestionario;
    private JTextField fechaField;
    private JComboBox<Integer> ocupantesField;

    private JButton okButton;
    private JComboBox<String> origenCB;
    private JComboBox<String> destinoCB;
    private JButton volverAInicioButton;
    private JPanel jPanCalendar;
    private JComboBox<String> planeCategory;
    private JLabel ciudadOrigen;
    private JLabel ciudadDestino;
    private String origen;
    private String destino;
    private JCalendar calendar;

    //Cambiar gold /silver / bronze por dropdown con opciones -> lee del archivo los aviones disponibles y en base a eso muestra las opciones
    //agregar en aviones boolean de disponible
    //lo mismo para cantidad de ocupantes


    public cuestionario(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(cuestionario);
        this.pack();

        Company companyInstance = Company.getSingletonInstance();
        companyInstance.getCitiesArrayList();
        /*origenCB.addItem("Buenos Aires");
        origenCB.addItem("Córdoba");
        origenCB.addItem("Montevideo");*/
        /*destinoCB.addItem("Córdoba");
        destinoCB.addItem("Santiago");
        destinoCB.addItem("Montevideo");*/
        Calendar calendar = Calendar.getInstance();
        JDateChooser dateChooser = new JDateChooser(calendar.getTime());

        planeCategory.addItem("Select");
        planeCategory.addItem("Gold");
        planeCategory.addItem("Silver");
        planeCategory.addItem("Bronze");


        jPanCalendar.add(dateChooser);
        ocupantesField.addItem(0);
        ocupantesField.addItem(1);
        ocupantesField.addItem(2);
        ocupantesField.addItem(3);
        ocupantesField.addItem(4);
        ocupantesField.addItem(5);
        ocupantesField.addItem(6);
        ocupantesField.addItem(7);
        ocupantesField.addItem(8);
        ocupantesField.addItem(9);
        ocupantesField.addItem(10);

        origenCB.addItem("Seleccionar");
        origenCB.addItem("Buenos Aires");
        origenCB.addItem("Cordoba");
        origenCB.addItem("Montevideo");
        origenCB.addItem("Santiago");

        destinoCB.addItem("Seleccionar");
        destinoCB.addItem("Buenos Aires");
        destinoCB.addItem("Cordoba");
        destinoCB.addItem("Montevideo");
        destinoCB.addItem("Santiago");


        okButton.addActionListener(e -> {
            try {
                Date localDate1 = dateChooser.getDate();
                System.out.println("Selected date -> " + dateChooser.getDate());


                int ocupantes = (int) ocupantesField.getSelectedItem();
                System.out.println("ocupantes  -> " + ocupantes);


                if (origenCB.getSelectedItem() == null || destinoCB.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "Ingrese un recorrido válido");
                }
                City city = new City((String) origenCB.getSelectedItem());
                destinoCB.removeItem(origenCB.getSelectedItem());
                city.setDestination((String) destinoCB.getSelectedItem());
                System.out.println("Ciudad ->" + city);
                System.out.println("DISTANCIA A RECORRER -> " + city.getDistance());

                String avionSelected = (String) planeCategory.getSelectedItem();

                /*Questionary q = new Questionary(localDate1, city, ocupantes, avion);
                System.out.println("q:" + q.toString());*/


                /*int option = JOptionPane.showConfirmDialog(null, q);*/


                //0 si, 1 no, 2 cancel
               /* if (option == 0) {
                    //Al aceptar se crea un Flight que deberá guardarse en un archivo.
                    *//**HACER MÉTODOS DE GUARDADO Y LEVANTE EN LA CLASE FILE*//*
                    Flight flight = new Flight(city, verifyUser.getSingletonInstance().getUser(), q, true);
                    //Cambiar por constructor con avion asignado
                    System.out.println("\n\n VUELOS \n");
                    Company.getSingletonInstance().showCollection(flight);
                    int confirm = JOptionPane.showConfirmDialog(null, flight);
                    if (confirm == 0) {
                        Company.getSingletonInstance().addToCollection(flight);
                        JOptionPane.showMessageDialog(null, "Vuelo reservado\nBuen viaje!!");
                    }

                    *//*******************************************************//*

                }

                if (option == 1 || option == 2) {
                    JOptionPane.showMessageDialog(null, "Volviendo, no se ha registrado ningún viaje");

                }*/

            } catch (Exception e1) {
                e1.getMessage();
                JOptionPane.showMessageDialog(null, "Alguno de los datos ingresados es incorrecto, por favor revíselos");
            }
        });


       /* destinoCB.addActionListener(e -> origen = (String) origenCB.getSelectedItem());

        volverAInicioButton.addActionListener(e -> {
            *//**ESTO TAMBIÉN HAY QUE CAMBIARLO, NO SÉ COMO OCULTAR LOS OTROS FRAMES. *//*
            cuestionario.setVisible(false);
        *//*    verifyUser.setBounds(650, 180, 500, 500);
            verifyUser.setVisible(true);*//*
            verifyUser.getSingletonInstance().setBounds(650, 180, 500, 500);
            verifyUser.getSingletonInstance().setVisible(true);
        });
        origenCB.addActionListener(e -> destino = (String) destinoCB.getSelectedItem());*/
    }
}
