package com.company;

import com.company.JFrames.verifyUser;
import com.company.MainFile.ActualFile;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        //Creamos el archivo.
        ActualFile.archivos();

        //Swing
        SwingUtilities.invokeLater(new Runnable() {
               @Override
               public void run() {
                //Lo primero que se hace es verificar si el usuario que quiere ingresar esta regitrado, esta misma clase se encargará de agregarlo al archivo en cado de no estarlo.
                /*verifyUser verifyUser = new verifyUser("Aero Taxi Usuario ->");
                verifyUser.setBounds(650, 180, 500, 500);
                verifyUser.setVisible(true);*/
                verifyUser.getSingletonInstance().setBounds(650,180,500,500);
                verifyUser.getSingletonInstance().setVisible(true);
            }
       });
    }
}
