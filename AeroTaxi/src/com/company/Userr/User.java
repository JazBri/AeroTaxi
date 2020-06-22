package com.company.Userr;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String lastName;
    private int DNI;
    private int age;
    private boolean isRegistered;


    public User(String name, String lastName, int DNI, int age, boolean isRegistered) {
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
        this.age = age;
        this.isRegistered = isRegistered;
    }

    public User() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }


    public String showMessageRegistered() {
        return "\nNombre: " + name +
                "\nApellido: " + lastName +
                "\nDNI: " + DNI +
                "\nEdad: " + age;
    }

    public String showList() {
        return  "Nombre completo: " + name + " " + lastName +  " DNI: " + DNI + " Edad: " + age;

    }

    @Override
    public String toString() {
        return " User ->" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DNI=" + DNI +
                ", age=" + age +
                ", isRegistered=" + isRegistered;
    }
}

