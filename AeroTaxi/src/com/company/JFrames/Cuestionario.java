package com.company.JFrames;

import com.company.Airplane.Airplane;
import com.company.Airplane.Planes.Bronze;
import com.company.Airplane.Planes.Gold;
import com.company.Airplane.Planes.Silver;
import com.company.City.City;
import com.company.CompanyAdmin.Company;
import com.company.Flight.Flight;
import com.company.MainFile.ActualFile;
import com.company.Questionary.Questionary;
import com.company.User.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Cuestionario extends JFrame {
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

    //todo -> validar disponbilidad del avion en la fecha designada.


    public Cuestionario(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(cuestionario);
        this.setResizable(false);
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

        volverAInicioButton.addActionListener(e -> {
            cuestionario.setVisible(false);
            UserMenu userMenu = new UserMenu();
            userMenu.setBounds(650, 180, 500, 500);
            userMenu.setVisible(true);
        });


        okButton.addActionListener(e -> {
            try {

                boolean valid = false;

                //Fecha de viaje
                Date localDate1 = dateChooser.getDate();

                //Cantidad de ocupantes
                int ocupantes = (int) ocupantesField.getSelectedItem();


                //Validaciones de la seleccion de ciudad de orignen y destino
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

                //Ciudad de origen
                City cityOrigen = new City((String) origenCB.getSelectedItem());

                //Ciudad de destino
                String cityDestino = (String) destinoCB.getSelectedItem();

                //Categoria de avion seleccionada
                String planeSelection = (String) planeCategory.getSelectedItem();
                boolean availablePlane = false;

                Airplane selectedPlane = null;
                int travelCost = 0;


                //Asignacion del avion en base a la categoria seleccionada previamente
                if (planeSelection == "Bronze") {
                    selectedPlane = companyInstance.getAirplaneArrayListBronze().get(0);
                    travelCost = (cityOrigen.getDistance(cityDestino) * Bronze.getCostPerKilometer()) + (ocupantes * 3500) + (Bronze.getFixCost());
                    selectedPlane.setCategory("Bronze");
                }
                if (planeSelection == "Silver") {
                    selectedPlane = companyInstance.getAirplaneArrayListSilver().get(0);
                    travelCost = (cityOrigen.getDistance(cityDestino) * Silver.getCostPerKilometer()) + (ocupantes * 3500) + (Silver.getFixCost());
                    selectedPlane.setCategory("Silver");

                }
                if (planeSelection == "Gold") {
                    selectedPlane = companyInstance.getAirplaneArrayListGold().get(0);
                    travelCost = (cityOrigen.getDistance(cityDestino) * Gold.getCostPerKilometer()) + (ocupantes * 3500) + (Gold.getFixCost());
                    selectedPlane.setCategory("Gold");

                }


                Questionary q = new Questionary(localDate1, cityOrigen, ocupantes, selectedPlane, cityDestino);

                //Carga de mi vuelo
                City cityFlight = new City(cityDestino);
                Flight flight = new Flight(cityOrigen, cityFlight, companyInstance.getCurrentLoggedUser(), localDate1, travelCost, selectedPlane, true);

                //Se modifica el valor del costo total invertido

                ArrayList<User> arrayListUser = ActualFile.readUserFile();
                for (User u : arrayListUser) {
                    if (u.getDNI() == (companyInstance.getCurrentLoggedUser().getDNI())) {
                        u.addTotalSpent(travelCost);
                        companyInstance.getCurrentLoggedUser().addTotalSpent(travelCost);
                    }
                }
                ActualFile.writeUserFile(arrayListUser);


                ArrayList<Flight> flightArrayList2 = companyInstance.getFlightArrayList();
                for (Flight flightInCompany : flightArrayList2) {

                    if (flightInCompany.getFlightDate() == localDate1 && flightInCompany.getAirplane().getCategory() == selectedPlane.getCategory()) {
                        System.out.println(flightInCompany.getAirplane().getCategory());
                        System.out.println(selectedPlane.getCategory());
                        selectedPlane.setAvailable(false);
                        availablePlane = false;
                        JOptionPane.showMessageDialog(null, "El avion seleccionado se encuentra ocupado en la fecha especificada");
                    }
                    if (flightInCompany.getFlightDate() != localDate1 && flightInCompany.getAirplane().getCategory() != selectedPlane.getCategory()) {

                        selectedPlane.setAvailable(false);
                        availablePlane = true;
                    }

                }


                //Se modifica el mejor avión utilizado.
                ArrayList<Flight> flightArrayList = ActualFile.readFlightFile();
                ArrayList<User> userArrayList = ActualFile.readUserFile();
                int gold = 0;
                int silver = 0;
                int bronze = 0;
                for (Flight flightFromFile : flightArrayList) {
                    if (flightFromFile.getActiveLoggedUser().getDNI() == companyInstance.getCurrentLoggedUser().getDNI()) {
                        if (flightFromFile.getAirplane().getCategory() == "Gold") {
                            gold += 1;
                        }
                        if (flightFromFile.getAirplane().getCategory() == "Silver") {
                            silver += 1;
                        }
                        if (flightFromFile.getAirplane().getCategory() == "Bronze") {
                            bronze += 1;
                        }
                        if (gold > silver && gold > bronze) {
                            for (int i = 0; i < userArrayList.size(); i++) {
                                if (userArrayList.get(i).getDNI() == companyInstance.getCurrentLoggedUser().getDNI()) {
                                    userArrayList.get(i).setBestAirplane("Gold");
                                    ActualFile.writeUserFile(userArrayList);
                                }
                            }
                        }
                        if (silver > gold && silver > bronze) {
                            for (int i = 0; i < userArrayList.size(); i++) {
                                if (userArrayList.get(i).getDNI() == companyInstance.getCurrentLoggedUser().getDNI()) {
                                    userArrayList.get(i).setBestAirplane("Silver");
                                    ActualFile.writeUserFile(userArrayList);
                                }
                            }
                        }
                        if (bronze > gold && bronze > silver) {
                            for (int i = 0; i < userArrayList.size(); i++) {
                                if (userArrayList.get(i).getDNI() == companyInstance.getCurrentLoggedUser().getDNI()) {
                                    userArrayList.get(i).setBestAirplane("Bronze");
                                    ActualFile.writeUserFile(userArrayList);
                                }
                            }
                        }

                    }

                }


                String pathFlight = "vuelos.json";
                File myFileFlight = new File(pathFlight);


                int option = JOptionPane.showConfirmDialog(null, q);


                if (valid) {
                    if (option == 0) {

                        System.out.println("\n\n VUELOS \n");

                        int confirm = JOptionPane.showConfirmDialog(null, flight);

                        if (confirm == 0) {

                            Company.getSingletonInstance().addToCollection(flight);

                            JOptionPane.showMessageDialog(null, "Vuelo reservado\nBuen viaje!!");

                            //Persistencia en arhivo de nuestro vuelo

                            if (myFileFlight.length() > 0) {
                                ObjectMapper mapperFlight1 = new ObjectMapper();
                                ArrayList<Flight> fli = mapperFlight1.readValue(myFileFlight, mapperFlight1.getTypeFactory().constructCollectionType(ArrayList.class, Flight.class));
                                fli.add(flight);
                                mapperFlight1.writerWithDefaultPrettyPrinter().writeValue(new File(pathFlight), fli);
                            }
                            if (myFileFlight.length() == 0) {
                                ArrayList<Flight> flightArrayList3 = new ArrayList<>();
                                flightArrayList3.add(flight);
                                ObjectMapper mapperFlight1 = new ObjectMapper();
                                mapperFlight1.writerWithDefaultPrettyPrinter().writeValue(new File(pathFlight), flightArrayList3);
                            }


                        }

                    }

                    if (option == 1 || option == 2) {
                        flight.setStatusConfirm(false);
                        JOptionPane.showMessageDialog(null, "Volviendo, no se ha registrado ningún viaje");
                        cuestionario.setVisible(false);
                        UserMenu userMenu = new UserMenu();
                        userMenu.setBounds(650, 180, 500, 500);
                        userMenu.setVisible(true);

                    }

                }


            } catch (Exception e1) {
                e1.getMessage();
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Alguno de los datos ingresados es incorrecto, por favor revíselos");
            }
        });


        volverAInicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cuestionario.setVisible(false);
                VerifyUser.getSingletonInstance().setVisible(true);
            }
        });
    }
}
