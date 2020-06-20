package com.company.MainFile;

import com.company.Airplane.Airplane;
import com.company.Airplane.Planes.Bronze;
import com.company.Airplane.Planes.Gold;
import com.company.Airplane.Planes.Silver;
import com.company.Airplane.PropulsionType;
import com.company.City.City;
import com.company.CompanyAdmin.Company;
import com.company.Flight.Flight;
import com.company.JFrames.verifyUser;
import com.company.Main;
import com.company.Questionary.Questionary;
import com.company.User.User;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.swing.*;
import java.io.*;
import java.util.*;

public class ActualFile {


    public static void archivos() {

        String pathFlight = "vuelos.json";
        File myFileFlight = new File(pathFlight);

        //Cargamos algunos usuarios al archivo
        User user1 = new User("Jazmin", "Briasco", 39338563, 23, true, false);
        user1.setRegistered(true);
        User user2 = new User("Luciano", "Sassano", 41333010, 21, true, false);
        user2.setRegistered(true);
        User user3 = new User("Matias", "Gonzalez", 35789651, 58, true, false);
        user3.setRegistered(true);


        String pathUser = "usuarios.json";
        File myFileUser = new File(pathUser);

        //Se cargan las ciudades al archivo
        City city1 = new City("Buenos Aires", "Córdoba", 695);
        City city2 = new City("Cordoba", "Buenos Aires", 695);
        City city3 = new City("Montevideo", "Cordoba", 1190);
        City city4 = new City("Córdoba", "Montevideo", 1190);
        City city5 = new City("Santiago", "Montevideo", 2100);
        City city6 = new City("Montevideo", "Santiago", 2100);


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


                //Lectura del archivo, se levantan los datos de los usuarios
                ObjectMapper mapperReaderUser = new ObjectMapper();
                ObjectMapper mapperUser1 = new ObjectMapper();
                ArrayList<User> us = mapperUser1.readValue(myFileUser, mapperReaderUser.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
                for (User myUser : us) {
                    companyInstance.addToCollection(myUser);
                }


                //Lectura del archivo, se levantan los datos de las ciudades
                ObjectMapper mapperReaderCities = new ObjectMapper();
                ObjectMapper mapperCities1 = new ObjectMapper();
                ArrayList<City> cit = mapperReaderCities.readValue(myFileCity, mapperCities1.getTypeFactory().constructCollectionType(ArrayList.class, City.class));
                for (City myCity : cit) {
                    companyInstance.addToCollection(myCity);

                }


                //Lectura del archivo, se levantan los datos de los aviones
                ObjectMapper mapperReaderAirplane = new ObjectMapper();
                ObjectMapper mapperAirplane1 = new ObjectMapper();
                ArrayList<Airplane> air = mapperAirplane1.readValue(myFileAiplane, mapperReaderAirplane.getTypeFactory().constructCollectionType(ArrayList.class, Airplane.class));
                for (Airplane myPlane : air) {
                    companyInstance.addToCollection(myPlane);

                }

                //Lectura del archivo, se levantan los datos de los vuelos
                ObjectMapper mapperReaderFlights = new ObjectMapper();
                ObjectMapper mapperFlight1 = new ObjectMapper();
                ArrayList<Flight> fli = mapperFlight1.readValue(myFileFlight, mapperFlight1.getTypeFactory().constructCollectionType(ArrayList.class, Flight.class));
                for (Flight myFlight : fli) {
                    companyInstance.addToCollection(myFlight);

                }



                /**ESTO ESTA PARA VERIFICAR SI ANDA EL TEMA DEL ARCHIVO, HAY QUE HACER ADDTOFILE***********************************************/
                Questionary q = new Questionary();
                q.setCompanionsNumbers(5);
                q.setAirplane(gold);
                Flight flight = new Flight(city1, verifyUser.getSingletonInstance().getUser(), q, true);
                Company.getSingletonInstance().addToCollection(flight);


                //Escritura del archivo, se guardan los usuarios
                ObjectMapper mapperUser = new ObjectMapper();
                mapperUser.writerWithDefaultPrettyPrinter().writeValue(new File(pathUser), Company.getSingletonInstance().getUserArrayList());

                //Escritura del archivo, se guardan las ciudades
                //ObjectMapper mapperC = new ObjectMapper();
                ObjectMapper mapperCities = new ObjectMapper();
                mapperCities.writerWithDefaultPrettyPrinter().writeValue(new File(pathCities), Company.getSingletonInstance().getCitiesArrayList());

                //Escritura del archivo, se guardan los aviones
                ObjectMapper mapperAirplane = new ObjectMapper();
                mapperAirplane.writerWithDefaultPrettyPrinter().writeValue(new File(pathAirplane), Company.getSingletonInstance().getAirplaneArrayList());

                //Escritura del archivo, se guardan los vuelos
                ObjectMapper mapperFlight = new ObjectMapper();
                mapperFlight.writerWithDefaultPrettyPrinter().writeValue(new File(pathFlight), Company.getSingletonInstance().getFlightArrayList());


            }
        } catch (JsonMappingException e1) {
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