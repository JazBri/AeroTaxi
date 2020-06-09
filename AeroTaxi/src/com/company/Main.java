package com.company;

import com.company.Airplane.Planes.Bronze;
import com.company.Airplane.PropulsionType;
import com.company.Flight.User;
import com.company.JFrames.register;
import com.company.JFrames.verifyUser;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.*;
import java.io.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        PropulsionType p = PropulsionType.HELICE;
        //System.out.println(p.name());
        //p.values();

        Bronze bronze = new Bronze(200, 200, 200, p, true);
       // System.out.println(bronze.toString());


        SwingUtilities.invokeLater(new Runnable() {
            @Override
               public void run() {
                  //String path = "C:\\Users\\jaabr\\Desktop\\AeroTaxiDesk";
                   String path = "C:\\Users\\jaabr\\Desktop\\AeroTaxiDesk\\miArchivo.txt";
                   File myFile = new File(path);
                   try {
                       if (!myFile.exists()) {
                           System.out.println("El archivo no existe, se creará...");
                           myFile.createNewFile();
                           System.out.println("Archivo: " + myFile.getName() + " Creado con éxito");
                       }

                       if (myFile.isDirectory()) {
                           File[] fileList = myFile.listFiles();

                           for (File fichero : fileList) {
                               System.out.println(fichero.getName());
                           }

                   }else{
                       System.out.println("Nombre : " + myFile.getName());
                       System.out.println("Ruta : " + myFile.getPath());
                       System.out.println("Tamaño : " + myFile.length());

                       Date lastUpdate = new Date(myFile.lastModified());
                           System.out.println("Ultima modificacion: " + lastUpdate.toString());

                           FileWriter fileWriter = new FileWriter(myFile);
                           BufferedWriter bWriter = new BufferedWriter(fileWriter);

                           if(!myFile.canWrite()){
                               myFile.setWritable(true);
                           }

                           System.out.println("Escribiendo el archivo");
                           bWriter.write("Laboratorio 3");
                           bWriter.newLine();
                           bWriter.write("Hola");
                           bWriter.write("Mundo");
                           System.out.println("Cerrando escritura");
                          //Si no lo cerramos no se va a poder leer. El puntero del archivo esta al final, por lo que va a devolver null.
                           bWriter.close();


                           FileReader reader = new FileReader(myFile);
                           BufferedReader bReader = new BufferedReader(reader);
                           String line = null;
                           if(!myFile.canRead()){
                               myFile.setReadable(true);
                           }
                           line = bReader.readLine();

                           System.out.println("Iniciando lectura");
                           while (line != null){
                               System.out.println(line);
                               line = bReader.readLine();
                           }

                           System.out.println("Cerrando lectura");
                           bReader.close();

                   }
               }catch(
               IOException e)

               {
                   System.out.println("No se pudo leer/escribir el archivo_ " + e.getMessage());
                   e.printStackTrace();

           }


                //Toma el dni, lo buscaría, si lo encuentra va al cuestionario, si no al registro
                //JFrame verifyUser = new verifyUser("Verificar Usuario");
                verifyUser verifyUser = new verifyUser("Aero Taxi Usuario ->");
                verifyUser.setBounds(650, 180, 500, 500);
                verifyUser.setVisible(true);
                //verifyUser v = new verifyUser(" ");
                //System.out.println("DNI: " + verifyUser.getDniField());


                //Registro
              /*  JFrame JFrame = new register("Registro de usuario");
                JFrame.setBounds(650, 180, 500, 500);
                JFrame.setVisible(true);*/
            }
        });

    }

}
