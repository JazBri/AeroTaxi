package com.company.JFrames;

import com.company.CompanyAdmin.Company;
import com.company.Flight.Flight;
import com.company.MainFile.ActualFile;
import com.company.Userr.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class listado extends JFrame{
    private JPanel listado;
    private JButton clientesButton;
    private JButton vuelosButton;
    private JLabel labelUsers;
    private JList listUser;
    private JList listFlights;

    public listado(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(listado);
        this.pack();

        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se levantan los usuarios para listarlos.
                try {
                    ArrayList<User> userList = ActualFile.readUserFile();
                    DefaultListModel lista = new DefaultListModel();
                    listUser.setModel(lista);
                    for (User jl : userList){
                        lista.addElement(jl.showList());
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
          }
        });
        vuelosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*String path = "vuelos.json";
                File myFile = new File(path);
                ObjectMapper mapper = new ObjectMapper();
                ObjectMapper mapperReader = new ObjectMapper();
                try {
                    ArrayList<Flight> flights = mapper.readValue(myFile, mapperReader.getTypeFactory().constructCollectionType(ArrayList.class, Flight.class));
                    DefaultListModel lista = new DefaultListModel();
                    listUser.setModel(lista);
                    for (Flight flight : flights){
                        lista.addElement(flight.showList());
                    }


                } catch (IOException ex) {
                    ex.printStackTrace();
                }*/
                try {
                    ArrayList<User> userList = ActualFile.readUserFile();
                    DefaultListModel lista = new DefaultListModel();
                    listUser.setModel(lista);
                    for (User jl : userList){
                        lista.addElement(jl.showList());
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


}


