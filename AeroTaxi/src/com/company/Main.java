package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {


                //Toma el dni, lo buscaría, si lo encuentra va al cuestionario, si no al registro
                JFrame verifyUser = new verifyUser("Verificar Usuario");
                verifyUser.setBounds(650, 180, 500, 500);
                verifyUser.setVisible(true);



                verifyUser v = new verifyUser(" ");
                System.out.println("DNI: " + v.getDniField());

                //Registro
                JFrame JFrame = new register("Registro de usuario");
                JFrame.setBounds(650, 180, 500, 500);
                JFrame.setVisible(true);
            }
        });

    }

}
