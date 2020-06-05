package com.company.Flight;

public class User {
    private String name;
    private String lastName;
    private String DNI;
    private int age;
    private boolean isRegistered;

    public User(String name, String lastName, String DNI, int age) {
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
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
