package com.company.JFrames;

import com.company.CompanyAdmin.Company;
import com.company.Flight.Flight;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ConcurrentMap;

public class userMenu extends JFrame {
    private JPanel userMenu;
    private JButton flightCancelBtn;
    private JButton newFlightBtn;
    private JButton flightHistoryBtn;
    private JButton goBackBtn;

    public userMenu() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(userMenu);
        this.setResizable(false);
        this.pack();

        Company companyInstance = Company.getSingletonInstance();

        newFlightBtn.addActionListener(e -> {
            cuestionario cuestionarioUser = new cuestionario(Company.getSingletonInstance().getCurrentLoggedUser().getName());
            cuestionarioUser.setBounds(650, 180, 500, 500);
            cuestionarioUser.setVisible(true);
        });

        flightHistoryBtn.addActionListener(e -> {

            String col[] = {"Origen", "Destino", "Fecha", "Costo", "Avion"};
            DefaultTableModel table = new DefaultTableModel(col, 0);


            System.out.println("1");
            for (int i = 0; i < Company.getSingletonInstance().getFlightArrayList().size(); i++) {
                System.out.println("2");
                if (Company.getSingletonInstance().getFlightArrayList().get(i).getActiveLoggedUser().getDNI() == Company.getSingletonInstance().getCurrentLoggedUser().getDNI()) {
                    System.out.println("3");

                    String origen = companyInstance.getFlightArrayList().get(i).getOrigen().getName();
                    String destino = companyInstance.getFlightArrayList().get(i).getDestino().getName();
                    String fecha = companyInstance.getFlightArrayList().get(i).getFlightDate().toString();
                    int costo = companyInstance.getFlightArrayList().get(i).getTotalCost();
                    /*String avion = companyInstance.getFlightArrayList().get(i).getAirplane().getCategory().toString();*/
                    Object[] data = {origen, destino, fecha, costo};
                    System.out.println("data" + data);
                    table.addRow(data);
                }
            }
            System.out.println("tabla " + table);
            JTable jTable = new JTable(table);

            jTable.setBounds(650, 180, 500, 500);
            jTable.setVisible(true);
        });

        flightCancelBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Se borrara su ultimo vuelo agendado");
            ArrayList<Flight> flightArrayList = new ArrayList<>();
            Flight flightToDelete = new Flight();
            Date actualDate = new Date();
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
                System.out.println("prior to delete -> " +flightArrayList);
                flightArrayList.remove(flightToDelete);
                ObjectMapper deleteMapper = new ObjectMapper();
                try {
                    deleteMapper.writerWithDefaultPrettyPrinter().writeValue(new File("vuelos.json"), flightArrayList);
                    System.out.println("after delete -> " +flightArrayList);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }


        });
    }


}
