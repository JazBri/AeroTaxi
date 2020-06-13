package com.company;

import com.company.Flight.User;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;


public class ActualFile {
    public static void archivos() throws IOException {
        User user1 = new User("Jazmin", "Briasco", 36987412, 23);
        User user2 = new User("Jose", "Velez", 32147896, 11);
        User user3 = new User("Matias", "Gonzalez", 35789651, 58);

        ArrayList<User> userArray = new ArrayList<User>();
        userArray.add(user1);
        userArray.add(user2);
        userArray.add(user3);

        String path = "C:\\Users\\jaabr\\Desktop\\AeroTaxiDesk\\mi_archivo.json";
        File myFile = new File(path);


        try{
            if (!myFile.exists()) {
            System.out.println("El archivo no existe, se creará...");
            myFile.createNewFile();
            System.out.println("Archivo: " + myFile.getName() + " creado con éxito, reinicie el programa.");

            }else {
                if (!myFile.canWrite()) {
                    myFile.setWritable(true);
                }

                Date lastUpdate = new Date(myFile.lastModified());
                System.out.println("\nUltima modificacion: " + lastUpdate.toString());

                //         File file = new File("mi_archivo.json");
                ObjectMapper mapper = new ObjectMapper();

                String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userArray);
                //System.out.println("JSON " + json);

                mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\Users\\jaabr\\Desktop\\AeroTaxiDesk\\mi_archivo.json"), userArray);


                ObjectMapper mapperReader = new ObjectMapper();
                ArrayList<User> us = mapper.readValue(json, mapperReader.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
                //ArrayList<User> us = mapper.readValue(json, new TypeReference<ArrayList<User>>(){});

                us.forEach(System.out::println);
            }

            } catch (IOException e) {
                System.out.println("No se pudo leer o escrbir el archivo " + e.getMessage());
                System.out.println(e.getStackTrace());
        }
    }
}
