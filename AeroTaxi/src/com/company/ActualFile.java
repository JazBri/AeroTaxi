package com.company;

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

        String path = "/home/luciano/Escritorio/tp_taxi/mi_archivo.json";
        File myFile = new File(path);


        try {


            if (!myFile.exists()) {
                System.out.println("El archivo no existe, se creará...");
                myFile.createNewFile();
                System.out.println("Archivo: " + myFile.getName() + " creado con éxito, reinicie el programa.");

            } else {
                if (!myFile.canWrite()) {
                    myFile.setWritable(true);
                }

                Date lastUpdate = new Date(myFile.lastModified());
                System.out.println("\nUltima modificacion: " + lastUpdate.toString());

                ObjectMapper mapper = new ObjectMapper();

                //Escritura del archivo
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), userArray);

                //Lectura del archivo
                ObjectMapper mapperReader = new ObjectMapper();
                ArrayList<User> us = mapper.readValue(myFile, mapperReader.getTypeFactory().constructCollectionType(ArrayList.class, User.class));


                us.forEach(System.out::println);

            }

        } catch (IOException e) {
            System.out.println("No se pudo leer o escrbir el archivo " + e.getMessage());
            e.printStackTrace();
        }
    }
}
