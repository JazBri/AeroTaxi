package com.company.MainFile;

import com.company.Airplane.PlaneCategory;
import com.company.Airplane.Planes.Bronze;
import com.company.Airplane.Planes.Gold;
import com.company.Airplane.Planes.Silver;
import com.company.Airplane.PropulsionType;
import com.company.City.City;
import com.company.CompanyAdmin.Company;
import com.company.Main;
import com.company.User.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ActualFile {


    public static void archivos() {

        String pathFlight = "vuelos.json";
        File myFileFlight = new File(pathFlight);

        //Cargamos algunos usuarios al archivo
        User user1 = new User("Jazmin", "Briasco", 39338563, 23, true);
        User user2 = new User("Luciano", "Sassano", 41333010, 21, true);
        User user3 = new User("Matias", "Gonzalez", 35789651, 58, true);


        String pathUser = "usuarios.json";
        File myFileUser = new File(pathUser);

        //Se cargan las ciudades al archivo
        City city1 = new City("Buenos Aires");
        City city2 = new City("Cordoba");
        City city3 = new City("Montevideo");
        City city4 = new City("Santiago");


        String pathCities = "ciudades.json";
        File myFileCity = new File(pathCities);


        //Se cargan aviones al archivo
        PropulsionType pistones = PropulsionType.PISTONES;
        PropulsionType helice = PropulsionType.HELICE;
        PropulsionType reaction = PropulsionType.REACTION;

        PlaneCategory bronzeC = PlaneCategory.Bronze;
        PlaneCategory silverC = PlaneCategory.Silver;
        PlaneCategory goldC = PlaneCategory.Gold;

        Bronze bronze = new Bronze(helice, true, bronzeC);
        Silver silver = new Silver(pistones, true, silverC);
        Gold gold = new Gold(reaction, true, goldC);


        String pathAirplaneBr = "avionesBronze.json";
        File myFileAirplaneBr = new File(pathAirplaneBr);

        String pathAirplaneSl = "avionesSilver.json";
        File myFileAirplaneSl = new File(pathAirplaneSl);

        String pathAirplaneGl = "avionesGold.json";
        File myFileAirplaneGl = new File(pathAirplaneGl);


        try {
            if (!myFileUser.exists() || !myFileCity.exists() || !myFileAirplaneBr.exists() || !myFileAirplaneSl.exists() || !myFileAirplaneGl.exists() || !myFileFlight.exists()) {
                JOptionPane.showMessageDialog(null, "El archivo no existe, se creará...");
                JOptionPane.showMessageDialog(null, "\nArchivo creado con éxito, reiniciando el programa");
                myFileUser.createNewFile();
                myFileCity.createNewFile();
                myFileAirplaneBr.createNewFile();
                myFileAirplaneSl.createNewFile();
                myFileAirplaneGl.createNewFile();
                myFileFlight.createNewFile();

                try {
                    Thread.sleep(3 * 1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                //Reiniciamos el programa para dejar que los archivos se creen
                Main.main(null);

            } else {
                if (!myFileUser.canWrite()) {
                    myFileUser.setWritable(true);
                }
                if (!myFileCity.canWrite()) {
                    myFileCity.setWritable(true);
                }
                if (!myFileAirplaneBr.canWrite()) {
                    myFileAirplaneBr.setWritable(true);
                }
                if (!myFileAirplaneSl.canWrite()) {
                    myFileAirplaneSl.setWritable(true);
                }
                if (!myFileAirplaneGl.canWrite()) {
                    myFileAirplaneGl.setWritable(true);
                }
                if (!myFileFlight.canWrite()) {
                    myFileFlight.setWritable(true);
                }
                //Usamos Company.getInstance() para usar el objeto global, agregamos los usuarios, ciudades y aviones a las colecciones de Company.
                Company companyInstance = Company.getSingletonInstance();


                if (myFileUser.length() == 0) {
                    ArrayList<User> us1 = new ArrayList<>();
                    us1.add(user1);
                    us1.add(user2);
                    us1.add(user3);
                    ObjectMapper mapperUser = new ObjectMapper();
                    mapperUser.writerWithDefaultPrettyPrinter().writeValue(new File(pathUser), us1);

                }
                if (myFileUser.length() != 0) {
                    //Lectura del archivo, se levantan los datos de los usuarios
                    if (companyInstance.getUserArrayList().size() == 0) {
                        companyInstance.getUserArrayList().add(user1);
                        companyInstance.getUserArrayList().add(user2);
                        companyInstance.getUserArrayList().add(user3);
                    }

                    ObjectMapper mapperReaderUser = new ObjectMapper();
                    ObjectMapper mapperUser1 = new ObjectMapper();
                    ArrayList<User> us = mapperUser1.readValue(myFileUser, mapperReaderUser.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
                    for (User myUser : us) {
                        companyInstance.addToCollection(myUser);

                    }

                }

                if (myFileCity.length() == 0) {
                    //Escritura del archivo, se guardan las ciudades
                    ArrayList<City> ct1 = new ArrayList<>();
                    ct1.add(city1);
                    ct1.add(city2);
                    ct1.add(city3);
                    ct1.add(city4);

                    ObjectMapper mapperCities = new ObjectMapper();
                    mapperCities.writerWithDefaultPrettyPrinter().writeValue(new File(pathCities), ct1);

                }

                if (myFileCity.length() != 0) {

                    if (companyInstance.getCitiesArrayList().size() == 0) {
                        companyInstance.getCitiesArrayList().add(city1);
                        companyInstance.getCitiesArrayList().add(city2);
                        companyInstance.getCitiesArrayList().add(city3);
                        companyInstance.getCitiesArrayList().add(city4);
                    }
                    //Lectura del archivo, se levantan los datos de las ciudades
                    ObjectMapper mapperReaderCities = new ObjectMapper();
                    ObjectMapper mapperCities1 = new ObjectMapper();
                    ArrayList<City> cit = mapperReaderCities.readValue(myFileCity, mapperCities1.getTypeFactory().constructCollectionType(ArrayList.class, City.class));
                    for (City myCity : cit) {
                        companyInstance.addToCollection(myCity);

                    }

                }

                if (myFileAirplaneBr.length() == 0) {
                    //Escritura del archivo, se guardan los aviones
                    ArrayList<Bronze> airplanesBr = new ArrayList<>();
                    airplanesBr.add(bronze);

                    ObjectMapper mapperAirplane = new ObjectMapper();
                    companyInstance.addToCollection(bronze);

                    mapperAirplane.writerWithDefaultPrettyPrinter().writeValue(new File(pathAirplaneBr), airplanesBr);

                }
                if (myFileAirplaneBr.length() != 0) {

                    if (companyInstance.getAirplaneArrayListBronze().size() == 0) {
                        companyInstance.addToCollection(bronze);
                    }
                    //Lectura del archivo, se levantan los datos de los aviones
                    ObjectMapper mapperReaderAirplane = new ObjectMapper();
                    ObjectMapper mapperAirplane1 = new ObjectMapper();
                    ArrayList<Bronze> airplaneArrayListBr = mapperAirplane1.readValue(myFileAirplaneBr, mapperReaderAirplane.getTypeFactory().constructCollectionType(ArrayList.class, Bronze.class));

                }


                if (myFileAirplaneSl.length() == 0) {
                    //Escritura del archivo, se guardan los aviones
                    ArrayList<Silver> airplanesSl = new ArrayList<>();
                    airplanesSl.add(silver);

                    ObjectMapper mapperAirplane = new ObjectMapper();
                    companyInstance.addToCollection(silver);
                    mapperAirplane.writerWithDefaultPrettyPrinter().writeValue(new File(pathAirplaneSl), airplanesSl);

                }
                if (myFileAirplaneSl.length() != 0) {

                    if (companyInstance.getAirplaneArrayListSilver().size() == 0) {
                        companyInstance.addToCollection(silver);
                    }
                    //Lectura del archivo, se levantan los datos de los aviones
                    ObjectMapper mapperReaderAirplane = new ObjectMapper();
                    ObjectMapper mapperAirplane1 = new ObjectMapper();
                    ArrayList<Silver> airplaneArrayListBr = mapperAirplane1.readValue(myFileAirplaneSl, mapperReaderAirplane.getTypeFactory().constructCollectionType(ArrayList.class, Silver.class));

                }

                if (myFileAirplaneGl.length() == 0) {
                    //Escritura del archivo, se guardan los aviones
                    ArrayList<Gold> airplanesGl = new ArrayList<>();
                    airplanesGl.add(gold);

                    ObjectMapper mapperAirplane = new ObjectMapper();
                    companyInstance.addToCollection(gold);
                    mapperAirplane.writerWithDefaultPrettyPrinter().writeValue(new File(pathAirplaneGl), airplanesGl);

                }
                if (myFileAirplaneGl.length() != 0) {

                    if (companyInstance.getAirplaneArrayListGold().size() == 0) {
                        companyInstance.addToCollection(gold);
                    }
                    //Lectura del archivo, se levantan los datos de los aviones
                    ObjectMapper mapperReaderAirplane = new ObjectMapper();
                    ObjectMapper mapperAirplane1 = new ObjectMapper();
                    ArrayList<Gold> airplaneArrayListGl = mapperAirplane1.readValue(myFileAirplaneGl, mapperReaderAirplane.getTypeFactory().constructCollectionType(ArrayList.class, Gold.class));

                }

                /*System.out.println("bronze " + companyInstance.getAirplaneArrayListBronze());
                System.out.println("silver " + companyInstance.getAirplaneArrayListSilver());
                System.out.println("gold " + companyInstance.getAirplaneArrayListGold());*/

                //Lectura del archivo, se levantan los datos de los vuelos
               /* ObjectMapper mapperReaderFlights = new ObjectMapper();
                ObjectMapper mapperFlight1 = new ObjectMapper();
                ArrayList<Flight> fli = mapperFlight1.readValue(myFileFlight, mapperFlight1.getTypeFactory().constructCollectionType(ArrayList.class, Flight.class));
                for (Flight myFlight : fli) {
                    companyInstance.addToCollection(myFlight);
                    System.out.println("vuelo -> " + myFlight);

                }
*/

            }
        } catch (IOException e) {
            System.out.println("No se pudo leer o escrbir el archivo " + e.getMessage());
            e.printStackTrace();
        }
    }
}


/**
 * Creamos usuarios, los agregamos a la colección de Compnay, lo subimos al archivo.
 * Para usarlos los bajamos del archivo a la misma colección.
 */