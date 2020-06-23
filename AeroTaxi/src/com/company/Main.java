package com.company;

import com.company.JFrames.VerifyUser;
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

                VerifyUser.getSingletonInstance().setBounds(650, 180, 500, 500);
                VerifyUser.getSingletonInstance().setVisible(true);
            }
        });
    }
}
