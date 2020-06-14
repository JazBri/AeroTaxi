package com.company.JFrames;


import com.company.Airplane.Planes.Gold;
import com.company.Airplane.PropulsionType;
import com.company.Company;
import com.company.User;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class register extends JFrame{
    private JPanel register;
    private JLabel labelRegister;
    private JTextField nombreTextField;
    private JTextField introduzcaSuApellidoTextField;
    private JTextField dniTextField;
    private JButton OKButton;
    private JTextField edadTextField;
    private JTextField apellidoTextField;
    private JLabel salida;

    public register(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(register);
        this.pack();
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //Parseamos los valores TextField del documento y edad.
                    int dni = Integer.parseInt(dniTextField.getText());
                    int edad = Integer.parseInt(edadTextField.getText());

                    /**FALTARÍA QUE EL USUARIO CONFIRME LOS DATOS.*/
                    /**FALTARÍA REDIRIGIR, UNA VEZ CONFIRME DATOS A CUENTIONARIO, SI NO QUE LOS VUELVA A CARGAR.*/
                    /**VER DE VOLVER A BUSCAR EL USUARIO EN EL ARCHIVO ANTES DE AGREGARLO.*/
                    User user = new User (nombreTextField.getText(), apellidoTextField.getText(), dni, edad);
                    user.setRegistered(true);

                    //Agregamos a la colección d eusuarios del objeto instanciado en el main.
                    Company.getSingletonInstance().addToCollection(user);

                    JOptionPane.showMessageDialog(null, user.showMessageRegistered(), "Nuevo Usuario", JOptionPane.INFORMATION_MESSAGE);

                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(null, " Por favor introduzca valores válidos ");
                    System.out.println("No se puede convertir a número.");
                    e1.getMessage();
                }

            }
        });
    }

}
