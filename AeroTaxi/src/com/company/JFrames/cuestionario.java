package com.company.JFrames;

import com.company.Airplane.Airplane;
import com.company.Airplane.Planes.Bronze;
import com.company.Airplane.Planes.Gold;
import com.company.Airplane.Planes.Silver;
import com.company.City.City;
import com.company.CompanyAdmin.Company;
import com.company.Flight.Flight;
import com.company.Questionary.Questionary;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class cuestionario extends JFrame {
    private JPanel cuestionario;
    private JComboBox<Integer> ocupantesField;
    private JButton okButton;
    private JComboBox<String> origenCB;
    private JComboBox<String> destinoCB;
    private JButton volverAInicioButton;
    private JPanel jPanCalendar;
    private JComboBox<String> planeCategory;
    private JLabel ciudadOrigen;
    private JLabel ciudadDestino;
    private JCalendar calendar;


    public cuestionario(String title) throws HeadlessException, IOException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(cuestionario);
        this.pack();

        Company companyInstance = Company.getSingletonInstance();
        companyInstance.getCitiesArrayList();
        Calendar calendar = Calendar.getInstance();
        JDateChooser dateChooser = new JDateChooser(calendar.getTime());

        planeCategory.addItem("Select");
        planeCategory.addItem("Gold");
        planeCategory.addItem("Silver");
        planeCategory.addItem("Bronze");


        jPanCalendar.add(dateChooser);
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


        String pathAirplane = "aviones.json";
        File myFileAiplane = new File(pathAirplane);


        okButton.addActionListener(e -> {
            try {

                boolean valid = false;
                Date localDate1 = dateChooser.getDate();
                System.out.println("Selected date -> " + dateChooser.getDate());


                int ocupantes = (int) ocupantesField.getSelectedItem();
                System.out.println("ocupantes  -> " + ocupantes);


                if (origenCB.getSelectedItem() == "Seleccionar" || destinoCB.getSelectedItem() == "Seleccionar") {
                    JOptionPane.showMessageDialog(null, "Ingrese un recorrido válido");
                }

                if (origenCB.getSelectedItem() != "Seleccionar" && destinoCB.getSelectedItem() != "Seleccionar") {
                    if (origenCB.getSelectedItem() == destinoCB.getSelectedItem()) {
                        JOptionPane.showMessageDialog(null, "Origen y destino iguales , ingrese valores validos");
                    }
                }

                if ((origenCB.getSelectedItem() != "Seleccionar" && destinoCB.getSelectedItem() != "Seleccionar") && (origenCB.getSelectedItem() != destinoCB.getSelectedItem())) {
                    valid = true;
                }


                City cityOrigen = new City((String) origenCB.getSelectedItem());
                String cityDestino = (String) destinoCB.getSelectedItem();


                String planeSelection = (String) planeCategory.getSelectedItem();

                Airplane selectedPlane = null;
                int travelCost = 0;

                if (planeSelection == "Bronze") {
                    selectedPlane = companyInstance.getAirplaneArrayListBronze().get(0);
                    travelCost = (cityOrigen.getDistance(cityDestino) * Bronze.getCostPerKilometer()) + (ocupantes * 3500) + (Bronze.getFixCost());
                    System.out.println("Selected plane -> " + selectedPlane);
                }
                if (planeSelection == "Silver") {
                    selectedPlane = companyInstance.getAirplaneArrayListSilver().get(0);
                    travelCost = (cityOrigen.getDistance(cityDestino) * Silver.getCostPerKilometer()) + (ocupantes * 3500) + (Silver.getFixCost());
                    System.out.println("Selected plane -> " + selectedPlane);
                }
                if (planeSelection == "Gold") {
                    selectedPlane = companyInstance.getAirplaneArrayListGold().get(0);
                    travelCost = (cityOrigen.getDistance(cityDestino) * Gold.getCostPerKilometer()) + (ocupantes * 3500) + (Gold.getFixCost());
                    System.out.println("Selected plane -> " + selectedPlane);
                }


                Questionary q = new Questionary(localDate1, cityOrigen, ocupantes, selectedPlane, cityDestino);
                System.out.println("q:" + q.toString());

                City cityFlight = new City(cityDestino);
                Flight flight = new Flight(cityOrigen, cityFlight, companyInstance.getCurrentLoggedUser(), travelCost, selectedPlane, true);

                String pathFlight = "vuelos.json";
                File myFileFlight = new File(pathFlight);


                if (valid == true) {
                    int option = JOptionPane.showConfirmDialog(null, q);

                    if (option == 0) {
                        //Al aceptar se crea un Flight que deberá guardarse en un archivo.

                        System.out.println("\n\n VUELOS \n");
                        /*Company.getSingletonInstance().showCollection(flight);*/
                        int confirm = JOptionPane.showConfirmDialog(null, flight);
                        if (confirm == 0) {
                            Company.getSingletonInstance().addToCollection(flight);
                            JOptionPane.showMessageDialog(null, "Vuelo reservado\nBuen viaje!!");

                            //Persistencia en arhivo
                            ObjectMapper mapperFlight1 = new ObjectMapper();
                            ArrayList<Flight> fli = mapperFlight1.readValue(myFileFlight, mapperFlight1.getTypeFactory().constructCollectionType(ArrayList.class, Flight.class));
                            fli.add(flight);
                            mapperFlight1.writerWithDefaultPrettyPrinter().writeValue(new File(pathFlight), fli);

                        }

                    }

                    if (option == 1 || option == 2) {
                        flight.setStatusConfirm(false);
                        JOptionPane.showMessageDialog(null, "Volviendo, no se ha registrado ningún viaje");

                    }
                }

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
