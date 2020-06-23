package com.company.JFrames;

import com.company.CompanyAdmin.Company;
import com.company.Flight.Flight;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class UserMenu extends JFrame {
    private JPanel userMenu;
    private JButton flightCancelBtn;
    private JButton newFlightBtn;
    private JButton goBackBtn;
    private JButton mostrarInfoButton;

    public UserMenu() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(userMenu);
        this.setResizable(false);
        this.pack();

        Company companyInstance = Company.getSingletonInstance();

        goBackBtn.addActionListener(e -> {
            userMenu.setVisible(false);
            VerifyUser verifyUser = new VerifyUser("Menu");
            verifyUser.setBounds(650, 180, 500, 500);
            verifyUser.setVisible(true);
        });

        newFlightBtn.addActionListener(e -> {
            Cuestionario cuestionarioUser = new Cuestionario(Company.getSingletonInstance().getCurrentLoggedUser().getName());
            cuestionarioUser.setBounds(650, 180, 500, 500);
            cuestionarioUser.setVisible(true);
        });

        mostrarInfoButton.addActionListener(e -> {
            Listado listado = new Listado("Listado info usuario");
            userMenu.setVisible(false);
            listado.setBounds(100, 180, 1650, 500);
            listado.setVisible(true);
        });

        flightCancelBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Se borrara su ultimo vuelo agendado");
            ArrayList<Flight> flightArrayList = new ArrayList<>();
            Flight flightToDelete = new Flight();
            Date actualDate = new Date();
            if (companyInstance.getFlightArrayList().size() == 0) {
                JOptionPane.showMessageDialog(null, "No tiene vuelos agendados");
            }
            if (companyInstance.getFlightArrayList().size() > 0) {
                flightToDelete = companyInstance.getFlightArrayList().get(0);
                for (int i = 0; i < companyInstance.getFlightArrayList().size(); i++) {
                    if (companyInstance.getCurrentLoggedUser().getDNI() == companyInstance.getFlightArrayList().get(i).getActiveLoggedUser().getDNI()) {
                        flightArrayList.add(companyInstance.getFlightArrayList().get(i));

                        if (flightToDelete.getFlightDate().getTime() < companyInstance.getFlightArrayList().get(i).getFlightDate().getTime()) {
                            flightToDelete = companyInstance.getFlightArrayList().get(i);
                            System.out.println("Vuelo a borrar ->" + flightToDelete.getTotalCost());

                        }
                    }
                }

                if (flightToDelete.getFlightDate().getTime() <= actualDate.getTime()) {
                    JOptionPane.showMessageDialog(null, "Su vuelo carece del tiempo valido para ser cancelado , minimo 24 hs de anticipacion");
                }

                if (flightToDelete.getFlightDate().getTime() > actualDate.getTime()) {
                    System.out.println("prior to delete -> " + flightArrayList);
                    flightArrayList.remove(flightToDelete);
                    ObjectMapper deleteMapper = new ObjectMapper();
                    try {
                        deleteMapper.writerWithDefaultPrettyPrinter().writeValue(new File("vuelos.json"), flightArrayList);
                        System.out.println("after delete -> " + flightArrayList);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }


        });
    }


}
