package com.company.JFrames;

import com.company.CompanyAdmin.Company;
import com.company.Flight.Flight;
import com.company.MainFile.ActualFile;
import com.company.User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

import com.toedter.calendar.JDateChooser;

public class Listado extends JFrame {
    private JPanel listado;
    private JButton clientesButton;
    private JButton vuelosButton;
    private JLabel labelUsers;
    private JList listUser;
    private JList listFlights;
    private JPanel jPanCalendar;
    private JButton volverButton;

    public Listado(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(listado);
        this.pack();

        Calendar calendar = Calendar.getInstance();
        JDateChooser dateChooser = new JDateChooser(calendar.getTime());
        jPanCalendar.add(dateChooser);


        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se levantan los usuarios para listarlos.
                try {
                    ArrayList<User> userList = ActualFile.readUserFile();
                    DefaultListModel lista = new DefaultListModel();
                    listUser.setModel(lista);

                    //Listar los datos personales
                    for (User jl : userList) {
                        lista.addElement(jl.showListUser());
                    }


                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        });
        vuelosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int flag = 0;
                    Date localDate = dateChooser.getDate();
                    ArrayList<Flight> flights = ActualFile.readFlightFile();
                    DefaultListModel lista = new DefaultListModel();
                    listFlights.setModel(lista);
                    for (Flight flight : flights) {
                        if (flight.getFlightDate().equals(localDate)) {
                            flag = 1;
                            lista.addElement(flight.showList());
                        }
                    }
                    if (flag == 0) {
                        lista.addElement("No se han encontrado vuelos en la fecha seleccionada");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        volverButton.addActionListener(e -> {
            listado.setVisible(false);
            this.dispose();
            UserMenu userMenu = new UserMenu();
            userMenu.setBounds(650, 180, 500, 500);
            userMenu.setVisible(true);
        });
    }


}


