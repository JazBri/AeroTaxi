package com.company.Flight;

import java.io.Serializable;

public class User implements Serializable {
    public static final long serialVersionUID = 1L;
    private String name;
    private String lastName;
    private int DNI;
    private int age;
    private boolean isRegistered;

    public User(String name, String lastName, int DNI, int age) {
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
        this.age = age;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DNI='" + DNI + '\'' +
                ", age=" + age +
                ", isRegistered=" + isRegistered +
                '}';
    }
}
