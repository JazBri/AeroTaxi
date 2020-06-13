package com.company;

import com.company.Airplane.Planes.Bronze;
import com.company.Airplane.PropulsionType;
import com.company.JFrames.verifyUser;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ActualFile.archivos();

        User u = new User("Sin", "gleton", 23, 45);

        Company company = Company.getSingletonInstance();
        company.addToCollection(u);
        Company company1 = Company.getSingletonInstance();


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
