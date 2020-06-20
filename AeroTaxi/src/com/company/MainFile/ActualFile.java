package com.company.MainFile;

import com.company.Airplane.Airplane;
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
        PropulsionType p = PropulsionType.PISTONES;
        PropulsionType h = PropulsionType.HELICE;
        PropulsionType r = PropulsionType.REACTION;
        Bronze bronze = new Bronze(2154, 200, 123, p, true);
        Silver silver = new Silver(2874, 158, 78, p, true);
        Silver silver2 = new Silver(2874, 158, 78, h, true);
        Gold gold = new Gold(700, 541, 854, r, true);
        Gold gold2 = new Gold(540, 542, 563, r, true);


        String pathAirplane = "aviones.json";
        File myFileAiplane = new File(pathAirplane);


        try {
            if (!myFileUser.exists() || !myFileCity.exists() || !myFileAiplane.exists() || !myFileFlight.exists()) {
                JOptionPane.showMessageDialog(null, "El archivo no existe, se creará...");
                JOptionPane.showMessageDialog(null, "\nArchivo creado con éxito, reiniciando el programa");
                myFileUser.createNewFile();
                myFileCity.createNewFile();
                myFileAiplane.createNewFile();
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
                if (!myFileAiplane.canWrite()) {
                    myFileAiplane.setWritable(true);
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
                    ObjectMapper mapperReaderUser = new ObjectMapper();
                    ObjectMapper mapperUser1 = new ObjectMapper();
                    ArrayList<User> us = mapperUser1.readValue(myFileUser, mapperReaderUser.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
                    for (User myUser : us) {
                        companyInstance.addToCollection(myUser);

                    }

                }

                if (myFileCity.length() == 0) {
                    //Escritura del archivo, se guardan las ciudades
                    ObjectMapper mapperCities = new ObjectMapper();
                    companyInstance.addToCollection(city1);
                    companyInstance.addToCollection(city2);
                    companyInstance.addToCollection(city3);
                    companyInstance.addToCollection(city4);

                    mapperCities.writerWithDefaultPrettyPrinter().writeValue(new File(pathCities), Company.getSingletonInstance().getCitiesArrayList());

                }

                if (myFileCity.length() != 0) {
                    //Lectura del archivo, se levantan los datos de las ciudades
                    ObjectMapper mapperReaderCities = new ObjectMapper();
                    ObjectMapper mapperCities1 = new ObjectMapper();
                    ArrayList<City> cit = mapperReaderCities.readValue(myFileCity, mapperCities1.getTypeFactory().constructCollectionType(ArrayList.class, City.class));
                    for (City myCity : cit) {
                        companyInstance.addToCollection(myCity);

                    }

                }

                if (myFileAiplane.length() == 0) {
                    //Escritura del archivo, se guardan los aviones
                    companyInstance.addToCollection(bronze);
                    companyInstance.addToCollection(silver);
                    companyInstance.addToCollection(silver2);
                    companyInstance.addToCollection(gold);
                    companyInstance.addToCollection(gold2);
                    ObjectMapper mapperAirplane = new ObjectMapper();
                    mapperAirplane.writerWithDefaultPrettyPrinter().writeValue(new File(pathAirplane), Company.getSingletonInstance().getAirplaneArrayList());

                }
                if (myFileAiplane.length() != 0) {
                    //Lectura del archivo, se levantan los datos de los aviones
                    ObjectMapper mapperReaderAirplane = new ObjectMapper();
                    ObjectMapper mapperAirplane1 = new ObjectMapper();
                    ArrayList<Airplane> air = mapperAirplane1.readValue(myFileAiplane, mapperReaderAirplane.getTypeFactory().constructCollectionType(ArrayList.class, Airplane.class));
                    for (Airplane myPlane : air) {
                        companyInstance.addToCollection(myPlane);
                    }

                }


                //Lectura del archivo, se levantan los datos de los vuelos
               /* ObjectMapper mapperReaderFlights = new ObjectMapper();
                ObjectMapper mapperFlight1 = new ObjectMapper();
                ArrayList<Flight> fli = mapperFlight1.readValue(myFileFlight, mapperFlight1.getTypeFactory().constructCollectionType(ArrayList.class, Flight.class));
                for (Flight myFlight : fli) {
                    companyInstance.addToCollection(myFlight);

                }*/





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