package com.company.JFrames;

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

public class listado extends JFrame{
    private JPanel listado;
    private JButton clientesButton;
    private JButton vuelosButton;
    private JLabel labelUsers;
    private JList listUser;
    private JList listFlights;
    private JPanel jPanCalendar;
    private JButton volverButton;

    public listado(String title) throws HeadlessException {
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

                    //Mejor avión utilizado
                    ArrayList<Flight> flights = ActualFile.readFlightFile();



                    //Total invertido
               /*     float totalSpent = 0;
                    for (int i = 1; i < flights.size(); i++) {
                        if(flights.get(i).getActiveLoggedUser().equals(flights.get(i+1).getActiveLoggedUser())) {
                            totalSpent += flights.get(i).getTotalCost();
                            lista.addElement("Total Invertido: " + totalSpent);
                        }
                    }*/



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
                        if (flight.getDate().equals(localDate)) {
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
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listado.setVisible(false);
                verifyUser.getSingletonInstance().setVisible(true);
            }
        });
    }


}


