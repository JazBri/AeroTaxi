package com.company;
import com.company.Airplane.Airplane;
import com.company.Airplane.Planes.Bronze;
import com.company.Airplane.Planes.Gold;
import com.company.Airplane.Planes.Silver;
import com.company.Airplane.PropulsionType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class ActualFile {
    public static void archivos() throws IOException {
        //Cargamos algunos usuarios al archivo
        User user1 = new User("Jazmin", "Briasco", 39338563, 23);
        user1.setRegistered(true);
        User user2 = new User("Luciano", "Sassano", 32147896, 11);
        user2.setRegistered(true);
        User user3 = new User("Matias", "Gonzalez", 35789651, 58);
        user3.setRegistered(true);

        ArrayList<User> userArray = new ArrayList<User>();
        userArray.add(user1);
        userArray.add(user2);
        userArray.add(user3);

        String pathUser = "usuarios.json";
        File myFileUser = new File(pathUser);

        //Se cargan las ciudades al archivo
        //Se usa un Integer para asignarle un ID a cada ciudad y un Object para el objeto City
        City city1 = new City("Buenos Aires", "Córdoba", 695);
        City city2 = new City("Buenos Aires", "Santiago", 1400);
        City city3 = new City("Buenos Aires", "Montevideo", 950);
        City city4 = new City("Córdoba", "Montevideo", 1190);
        City city5 = new City("Córdoba", "Santiago", 1050);
        City city6 = new City("Montevideo", "Santiago", 2100);

        HashMap<Integer, Object> cityHashMap = new HashMap<Integer, Object>();
        cityHashMap.put(1, city1);
        cityHashMap.put(2, city2);
        cityHashMap.put(3, city3);
        cityHashMap.put(4, city4);
        cityHashMap.put(5, city5);
        cityHashMap.put(6, city6);

        String pathCities = "ciudades.json";
        File myFileCity = new File(pathCities);

        //Se cargan aviones al archivo
        PropulsionType p = PropulsionType.HELICE;
        Bronze bronze = new Bronze(2154, 200, 123, p, true);
        Silver silver = new Silver(2874, 158, 78, p, true);
        Gold gold = new Gold(200, 300, 15, p, true);

        ArrayList<Airplane> airplaneArray = new ArrayList<Airplane>();
        airplaneArray.add(bronze);
        airplaneArray.add(silver);
        airplaneArray.add(gold);

        String pathAirplane = "aviones.json";
        File myFileAiplane = new File(pathAirplane);


        try {
            if (!myFileUser.exists() || !myFileCity.exists() || !myFileAiplane.exists()) {
                JOptionPane.showMessageDialog(null, "El archivo no existe, se creará...");
                JOptionPane.showMessageDialog(null, "\nArchivo creado con éxito, reiniciando el programa");
                myFileUser.createNewFile();
                myFileCity.createNewFile();
                myFileAiplane.createNewFile();

                try {
                    Thread.sleep(3*1000);
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



                //Escritura del archivo, se guardan los usuarios
                ObjectMapper mapperUser = new ObjectMapper();
                mapperUser.writerWithDefaultPrettyPrinter().writeValue(new File(pathUser), userArray);

                //Escritura del archivo, se guardan las ciudades
                //ObjectMapper mapperC = new ObjectMapper();
                ObjectMapper mapperCities = new ObjectMapper();
                mapperCities.writerWithDefaultPrettyPrinter().writeValue(new File(pathCities), cityHashMap);

                //Escritura del archivo, se guardan los aviones
                ObjectMapper mapperAirplane = new ObjectMapper();
                mapperAirplane.writerWithDefaultPrettyPrinter().writeValue(new File(pathAirplane), airplaneArray);


                //Lectura del archivo, se levantan los datos de los usuarios
                ObjectMapper mapperReaderUser = new ObjectMapper();
                ArrayList<User> us = mapperUser.readValue(myFileUser, mapperReaderUser.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
                for (User u: us            ) {
                    System.out.println(u.toString());
                }

                //Lectura del archivo, se levantan los datos de las iudades
                ObjectMapper mapperReaderCities = new ObjectMapper();

                //HashMap<Integer, Object> cities = mapperCities.readValue(myFileUser, mapperReaderCities.getTypeFactory().constructCollectionType((Class<? extends Collection>) HashMap.class, City.class));
                //Map<Integer, Object> cities = mapperCities.readValue(myFileUser, new TypeReference<HashMap<Integer,Object>>(){});
                //List<HashMap> cities = mapperReaderCities.readValue(pathCities, List.class);

                /**No puedo conseguir que paree del archivo a un hashmap*/

                //Lectura del archivo, se levantan los datos de los aviones
                ObjectMapper mapperReaderAirplane = new ObjectMapper();

                /**Acá no sé manejar el tema de la clase Airplane que es abstracta en realidad, cómo guardamos los aviones?*/
                ArrayList<Airplane> air = mapperAirplane.readValue(myFileAiplane, mapperReaderAirplane.getTypeFactory().constructCollectionType(ArrayList.class, Airplane.class));
                for (Airplane u: air  ) {
                    System.out.println(u.toString());
                }



            }
        } catch (IOException e) {
            System.out.println("No se pudo leer o escrbir el archivo " + e.getMessage());
            e.printStackTrace();
        }
    }
}
