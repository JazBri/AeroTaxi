package com.company;

import com.company.Airplane.Planes.Bronze;
import com.company.Airplane.PropulsionType;
import com.company.JFrames.verifyUser;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
      User u = new User("Sin", "gleton", 23, 45);
/*        Company company = Company.getSingletonInstance();
        company.addToCollection(u);
        Company company1 = Company.getSingletonInstance();
*/

        //Se instancia un objeto de tipo  Company, que será usada por todas las clases que lo requieran
        Company company = Company.getSingletonInstance();
        company.addToCollection(u);
        //System.out.println(p.name());
        //p.values();

       // System.out.println(bronze.toString());
//////////////////////////////////////////////////////////////


        //Creamos el archivo.
        ActualFile.archivos();

        //Swing
        SwingUtilities.invokeLater(new Runnable() {
               @Override
               public void run() {
                //Lo primero que se hace es verificar si el usuario que quiere ingresar esta regitrado, esta misma clase se encargará de agregarlo al archivo en cado de no estarlo.
                verifyUser verifyUser = new verifyUser("Aero Taxi Usuario ->");
                verifyUser.setBounds(650, 180, 500, 500);
                verifyUser.setVisible(true);
            }
       });
    }
}
