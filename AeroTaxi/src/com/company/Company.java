package com.company;

import com.company.Airplane.Airplane;
import com.company.Flight.Flight;
import com.company.Flight.User;

import java.util.HashSet;

public class Company <T>{
    private HashSet <T> userHashSet;
    private HashSet <T> flightHashSet;
    private HashSet <T> airplaneHashSet;
    private static Company miCompany;

    //El constructor privado no permite que se genere uno por defecto.
    private Company() {
        this.userHashSet = new HashSet<T>();
        this.flightHashSet = new HashSet<T>();
        this.airplaneHashSet = new HashSet<T>();
    }

    public static Company getSingletonInstance(){
        if( miCompany == null ){
            miCompany = new Company();
            System.out.println("Objeto Company creado exitosamente!");
        }else{
            System.out.println("No se puede instanciar el objeto, ya existe uno de la clase Company");
        }
        return miCompany;
    }


    //Hacerlo generico
    public void addToCollection(T t){
        if(t instanceof User){
            userHashSet.add(t);
            if(t instanceof Airplane){
                airplaneHashSet.add(t);
            }else{
                if(t instanceof Flight){
                    flightHashSet.add(t);
                }
            }
        }else{
            System.out.println("No corresponde a una colección");
        }
    }

    public void showCollection(T t){
        if(t instanceof User) {
            System.out.println("User");
            for (T c : userHashSet) {
                System.out.println(c.toString());
            }

            if (t instanceof Airplane) {
                System.out.println("Airplane");
                for (T c : airplaneHashSet) {
                    System.out.println(c.toString());
                }
            } else {
                if (t instanceof Flight) {
                    System.out.println("Flight");
                    for (T c : flightHashSet) {
                        System.out.println(c.toString());
                    }
                }
            }
                } else {
                    System.out.println("No corresponde a una colección");
                }
            }

    @Override
    public String toString() {
        return "Company{" +
                "userHashSet=" + userHashSet +
                ", flightHashSet=" + flightHashSet +
                ", airplaneHashSet=" + airplaneHashSet +
                '}';
    }
}

