package com.company;

import com.company.Airplane.Planes.Bronze;
import com.company.Airplane.PropulsionType;
import com.company.Flight.User;
import com.company.JFrames.register;
import com.company.JFrames.verifyUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.*;
import java.io.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        ActualFile.archivos();

        PropulsionType p = PropulsionType.HELICE;
        //System.out.println(p.name());
        //p.values();

        Bronze bronze = new Bronze(200, 200, 200, p, true);
       // System.out.println(bronze.toString());


        SwingUtilities.invokeLater(new Runnable() {
                  @Override
               public void run() {




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
