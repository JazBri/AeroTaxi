package com.company.MainFile;

import com.company.Airplane.Planes.Bronze;
import com.company.Airplane.Planes.Gold;
import com.company.Airplane.Planes.Silver;
import com.company.Airplane.PropulsionType;
import com.company.City.City;
import com.company.CompanyAdmin.Company;
import com.company.Flight.Flight;
import com.company.Main;
import com.company.User.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ActualFile {

    Company companyInstance = Company.getSingletonInstance();

    public static ArrayList readUserFile() throws IOException {
        String pathUser = "usuarios.json";
        File myFileUser = new File(pathUser);
        ObjectMapper mapperReaderUser = new ObjectMapper();
        ObjectMapper mapperUser1 = new ObjectMapper();
        ArrayList<User> users = new ArrayList<>();
        if (myFileUser.length() != 0) {
            users = mapperUser1.readValue(myFileUser, mapperReaderUser.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
        }
        return users;
    }

    public static ArrayList readCitiesFile() throws IOException {
        String pathCities = "ciudades.json";
        File myFileCity = new File(pathCities);
        ObjectMapper mapperReaderCities = new ObjectMapper();
        ArrayList<City> cities = new ArrayList<>();
        if (myFileCity.length() != 0) {
            cities = mapperReaderCities.readValue(myFileCity, mapperReaderCities.getTypeFactory().constructCollectionType(ArrayList.class, City.class));
        }
        return cities;
    }

    public static ArrayList readBronze() throws IOException {
        String pathAirplaneBr = "avionesBronze.json";
        File myFileAirplaneBr = new File(pathAirplaneBr);
        ObjectMapper mapperReaderAirplane = new ObjectMapper();
        ArrayList<Bronze> airplaneArrayListBr = new ArrayList<>();
        if (myFileAirplaneBr.length() != 0) {
            airplaneArrayListBr = mapperReaderAirplane.readValue(myFileAirplaneBr, mapperReaderAirplane.getTypeFactory().constructCollectionType(ArrayList.class, Bronze.class));
        }
        return airplaneArrayListBr;
    }

    public static ArrayList readSilver() throws IOException {
        String pathAirplaneSl = "avionesSilver.json";
        File myFileAirplaneSl = new File(pathAirplaneSl);
        ObjectMapper mapperReaderAirplane = new ObjectMapper();
        ArrayList<Silver> airplaneArrayListSl = new ArrayList<>();
        if (myFileAirplaneSl.length() != 0) {
            airplaneArrayListSl = mapperReaderAirplane.readValue(myFileAirplaneSl, mapperReaderAirplane.getTypeFactory().constructCollectionType(ArrayList.class, Silver.class));
        }
        return airplaneArrayListSl;
    }

    public static ArrayList readGold() throws IOException {
        String pathAirplaneGl = "avionesGold.json";
        File myFileAirplaneGl = new File(pathAirplaneGl);
        ObjectMapper mapperReaderAirplane = new ObjectMapper();
        ArrayList<Gold> airplaneArrayListGl = new ArrayList<>();
        if (myFileAirplaneGl.length() != 0) {
            airplaneArrayListGl = mapperReaderAirplane.readValue(myFileAirplaneGl, mapperReaderAirplane.getTypeFactory().constructCollectionType(ArrayList.class, Gold.class));
        }
        return airplaneArrayListGl;
    }

    public static ArrayList readFlightFile() throws IOException {
        String pathFlight = "vuelos.json";
        File myFileFlight = new File(pathFlight);
        ObjectMapper mapperReaderUser = new ObjectMapper();
        ArrayList<Flight> flights = new ArrayList<>();
        if (myFileFlight.length() != 0) {
            flights = mapperReaderUser.readValue(myFileFlight, mapperReaderUser.getTypeFactory().constructCollectionType(ArrayList.class, Flight.class));
        }
        return flights;
    }

    public static void writeFlight(ArrayList<Flight> flight) throws IOException {
        String pathFlight = "vuelos.json";
        ObjectMapper mapperReaderFlight = new ObjectMapper();
        mapperReaderFlight.writerWithDefaultPrettyPrinter().writeValue(new File(pathFlight), flight);
    }

    public static void writeBronze(ArrayList<Bronze> airplanesBr) throws IOException {
        String pathAirplaneBr = "avionesBronze.json";
        ObjectMapper mapperAirplane = new ObjectMapper();
        mapperAirplane.writerWithDefaultPrettyPrinter().writeValue(new File(pathAirplaneBr), airplanesBr);
    }

    public static void writeSilver(ArrayList<Silver> airplanesSl) throws IOException {
        String pathAirplaneSl = "avionesSilver.json";
        ObjectMapper mapperAirplane = new ObjectMapper();
        mapperAirplane.writerWithDefaultPrettyPrinter().writeValue(new File(pathAirplaneSl), airplanesSl);
    }

    public static void writeGold(ArrayList<Gold> airplanesGl) throws IOException {
        String pathAirplaneGl = "avionesGold.json";
        ObjectMapper mapperAirplane = new ObjectMapper();
        mapperAirplane.writerWithDefaultPrettyPrinter().writeValue(new File(pathAirplaneGl), airplanesGl);
    }

    public static void writeUserFile(ArrayList<User> user) throws IOException {
        String pathUser = "usuarios.json";
        ObjectMapper mapperUser = new ObjectMapper();
        mapperUser.writerWithDefaultPrettyPrinter().writeValue(new File(pathUser), user);
    }

    public static void writeCitiesFile(ArrayList<City> city) throws IOException {
        String pathCities = "ciudades.json";
        ObjectMapper mapperCities = new ObjectMapper();
        mapperCities.writerWithDefaultPrettyPrinter().writeValue(new File(pathCities), city);
    }

    public static void archivos() throws IOException {

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

        Bronze bronze = new Bronze(helice, true, "Bronze");
        Silver silver = new Silver(pistones, true, "Silver");
        Gold gold = new Gold(reaction, true, "Gold");

        String pathAirplaneBr = "avionesBronze.json";
        File myFileAirplaneBr = new File(pathAirplaneBr);

        String pathAirplaneSl = "avionesSilver.json";
        File myFileAirplaneSl = new File(pathAirplaneSl);

        String pathAirplaneGl = "avionesGold.json";
        File myFileAirplaneGl = new File(pathAirplaneGl);

        String pathFlight = "vuelos.json";
        File myFileFlight = new File(pathFlight);

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
                    writeUserFile(us1);
                }

                if (myFileUser.length() != 0) {
                    //Lectura del archivo, se levantan los datos de los usuarios


                    ArrayList<User> us = readUserFile();
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

                    writeCitiesFile(ct1);

                }

                if (myFileCity.length() != 0) {

                    //Lectura del archivo, se levantan los datos de las ciudades
                    ArrayList<City> cit = readCitiesFile();
                    for (City myCity : cit) {
                        companyInstance.addToCollection(myCity);
                    }
                }

                if (myFileAirplaneBr.length() == 0) {
                    //Escritura del archivo, se guardan los aviones
                    ArrayList<Bronze> airplanesBr = new ArrayList<>();
                    airplanesBr.add(bronze);
                    companyInstance.addToCollection(bronze);
                    writeBronze(airplanesBr);
                }


                if (myFileAirplaneBr.length() != 0) {
                    if (companyInstance.getAirplaneArrayListBronze().size() == 0) {
                        companyInstance.addToCollection(bronze);
                    }
                    //Lectura del archivo, se levantan los datos de los aviones
                    ArrayList<Bronze> airplaneBr = readBronze();

                    //Lectura del archivo, se levantan los datos de los aviones
                    //ObjectMapper mapperReaderAirplane = new ObjectMapper();
                    //mapperReaderAirplane.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
                    //ObjectMapper mapperAirplane1 = new ObjectMapper();
                    //mapperAirplane1.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
                    //ArrayList<Bronze> airplaneArrayListBr = mapperAirplane1.readValue(myFileAirplaneBr, mapperReaderAirplane.getTypeFactory().constructCollectionType(ArrayList.class, Bronze.class));
                    //for (Bronze brPlane : airplaneArrayListBr) {
                    // brPlane.setCategory("Bronze");
                    //companyInstance.addToCollection(brPlane);
                    //System.out.println(companyInstance.getAirplaneArrayListBronze());

                    //}

                }

                if (myFileAirplaneSl.length() == 0) {
                    //Escritura del archivo, se guardan los aviones
                    ArrayList<Silver> airplanesSl = new ArrayList<>();
                    airplanesSl.add(silver);
                    companyInstance.addToCollection(silver);
                    writeSilver(airplanesSl);

                }
                if (myFileAirplaneSl.length() != 0) {

                    //Lectura del archivo, se levantan los datos de los aviones
                    ArrayList<Silver> airplaneArrayListSl = readSilver();
                    for (Silver silverPlane : airplaneArrayListSl) {
                        companyInstance.addToCollection(silverPlane);

                    }


                }

                if (myFileAirplaneGl.length() == 0) {
                    //Escritura del archivo, se guardan los aviones
                    ArrayList<Gold> airplanesGl = new ArrayList<>();
                    airplanesGl.add(gold);

                    writeGold(airplanesGl);

                }
                if (myFileAirplaneGl.length() != 0) {

                    //Lectura del archivo, se levantan los datos de los aviones

                    ArrayList<Gold> airplaneArrayListGl = readGold();
                    for (Gold goldPLane : airplaneArrayListGl) {
                        companyInstance.addToCollection(goldPLane);

                    }


                }

            }

            //Lectura del archivo, se levantan los datos de los vuelos
            if (myFileFlight.length() != 0) {
                ObjectMapper mapperReaderFlights = new ObjectMapper();


                ArrayList<Flight> fligtsArray = mapperReaderFlights.readValue(myFileFlight, mapperReaderFlights.getTypeFactory().constructCollectionType(ArrayList.class, Flight.class));
                for (Flight myFlight : fligtsArray) {

                    Company.getSingletonInstance().addToCollection(myFlight);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 * Creamos usuarios, los agregamos a la colección de Compnay, lo subimos al archivo.
 * Para usarlos los bajamos del archivo a la misma colección.
 */