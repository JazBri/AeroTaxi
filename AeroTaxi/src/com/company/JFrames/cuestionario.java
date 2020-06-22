package com.company.JFrames;

import com.company.Airplane.Airplane;
import com.company.Airplane.PlaneCategory;
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

    //todo -> validar disponbilidad del avion en la fecha designada.


    public cuestionario(String title) throws HeadlessException {
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

                //Carga de mi vuelo
                City cityFlight = new City(cityDestino);

//revisar
                //Se modifica el valor del costo total invertido
                Flight flight = new Flight(cityOrigen, cityFlight, companyInstance.getCurrentLoggedUser(), travelCost, selectedPlane, true, localDate1);
                ArrayList<User>arrayListUser = ActualFile.readUserFile();
                for(User u : arrayListUser){
                    if(u.getDNI() == (companyInstance.getCurrentLoggedUser().getDNI())){
                        u.addTotalSpent(travelCost);
                        companyInstance.getCurrentLoggedUser().addTotalSpent(travelCost);
                    }
                }
                ActualFile.writeUserFile(arrayListUser);

                //Se modifica el mejor avión utilizado.
                ArrayList<User>arrayListUserAirplane = ActualFile.readUserFile();
                for(User u : arrayListUserAirplane){
                    if(u.getDNI() == (companyInstance.getCurrentLoggedUser().getDNI())){
                        if(u.getBestAirplane() == null){
                            System.out.println(u.getBestAirplane());
                            u.setBestAirplane(selectedPlane.getCategory());
                            System.out.println(u.getBestAirplane());
                        }else{
                            if(u.getBestAirplane().equals(selectedPlane.getCategory())){
                                u.setBestAirplane(selectedPlane.getCategory());
                            }
                            if(u.getBestAirplane().equals(PlaneCategory.Bronze) || selectedPlane.getCategory().equals(PlaneCategory.Silver)){
                                u.setBestAirplane(selectedPlane.getCategory());
                            }
                            if(selectedPlane.getCategory().equals(PlaneCategory.Gold)){
                                u.setBestAirplane(selectedPlane.getCategory());
                            }
                        }
                        ActualFile.writeUserFile(arrayListUserAirplane);
                    }
                }
              //revisar

                ArrayList<Flight> flightArrayList2 = companyInstance.getFlightArrayList();
                for (Flight flightInCompany : flightArrayList2) {

                    if (flightInCompany.getFlightDate() == localDate1 && flightInCompany.getAirplane().getCategory() == selectedPlane.getCategory()) {
                        System.out.println("hola3 entro");
                        System.out.println(flightInCompany.getAirplane().getCategory());
                        System.out.println(selectedPlane.getCategory());
                        selectedPlane.setAvailable(false);
                        availablePlane = false;
                        JOptionPane.showMessageDialog(null, "El avion seleccionado se encuentra ocupado en la fecha especificada");
                    }
                    if (flightInCompany.getFlightDate() == localDate1 && flightInCompany.getAirplane().getCategory() != selectedPlane.getCategory()) {
                        System.out.println("entro capoeira");
                        selectedPlane.setAvailable(false);
                        availablePlane = true;
                    }

                }

                System.out.println("Avion seleccionado " + selectedPlane);

                Flight flight = new Flight(cityOrigen, cityFlight, companyInstance.getCurrentLoggedUser(), localDate1, travelCost, selectedPlane, true);



                String pathFlight = "vuelos.json";
                File myFileFlight = new File(pathFlight);

                
                //posible error
                ArrayList<Flight> flightArrayLis = new ArrayList<>();
                flightArrayLis.add(flight);

                ObjectMapper mapper = new ObjectMapper();
                Company.getSingletonInstance().addToCollection(flight);
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File(pathFlight), flightArrayLis);
                //ActualFile.writeFlight(flightArrayLis);
                 //posible error


                int option = JOptionPane.showConfirmDialog(null, q);



                if (valid ) {
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
                                ArrayList<Flight> flightArrayList = new ArrayList<>();
                                flightArrayList.add(flight);
                                ObjectMapper mapperFlight1 = new ObjectMapper();
                                mapperFlight1.writerWithDefaultPrettyPrinter().writeValue(new File(pathFlight), flightArrayList);
                            }


                        }

                    }

                    if (option == 1 || option == 2) {
                        flight.setStatusConfirm(false);
                        JOptionPane.showMessageDialog(null, "Volviendo, no se ha registrado ningún viaje");

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
               verifyUser.getSingletonInstance().setVisible(true);
            }
        });
    }
}
