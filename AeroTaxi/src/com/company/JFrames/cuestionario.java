package com.company.JFrames;

import com.company.Flight.Questionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class cuestionario extends JFrame {
    private JPanel cuestionario;
    private JTextField fechaField;
    private JTextField origenField;
    private JTextField ocupantesField;
    private JTextField destinoField;
    private JButton OKButton;


    public cuestionario(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(cuestionario);
        this.pack();

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ocupantes = Integer.parseInt(ocupantesField.getText());
                    LocalDate localDate1 = LocalDate.parse(fechaField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.println("String -> java.time.LocalDate: " + localDate1);
                    Questionary q = new Questionary(localDate1, origenField.getText(), destinoField.getText(), ocupantes);

                    int option = JOptionPane.showConfirmDialog(null, q);
                    //0 si, 1 no, 2 cancel
                    if(option == 0){
                        JOptionPane.showMessageDialog(null, "Vuelo reservado\nBuen viaje!!");
                    }

                } catch (Exception e1) {
                    e1.getMessage();
                    JOptionPane.showMessageDialog(null, "Alguno de los datos ingresados es incorrecto, por favor revíselos");
                }
            }
        });
    }
}
