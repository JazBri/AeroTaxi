package com.company;
import com.company.Airplane.Airplane;
import com.company.Flight.Flight;

import java.util.ArrayList;

public class Company <T>{
    private ArrayList<T> userArrayList = new ArrayList<T>();
    private ArrayList<T> flightArrayList = new ArrayList<T>();
    private ArrayList<T> airplaneArrayList = new ArrayList<T>();
    private ArrayList<T> citiesArrayList = new ArrayList<T>();

    //Atributo estático para usar singleton.
    private static Company miCompany;

    //El constructor privado no permite que se genere uno por defecto.
    private Company() {
    }

    //getSingletonInstance devuelve la instancia del objeto, de esta manera se puede llamar en distintas clases.
    public static Company getSingletonInstance(){
        if( miCompany == null ){
            miCompany = new Company();
            System.out.println("Objeto Company creado exitosamente!");
        }else{
         //   System.out.println("El objeto Company ya se encuentra instanciado.");
        }
        return miCompany;
    }


    //Hacerlo generico
    public void addToCollection(T t){
        try{
            if(t instanceof User) {
                userArrayList.add(t);
            }
             if(t instanceof Airplane) {
                 airplaneArrayList.add(t);
             }
             if(t instanceof Flight) {
                 flightArrayList.add(t);
             }
            if(t instanceof City) {
                citiesArrayList.add(t);
            }
    }catch (Exception e) {
            e.getStackTrace();
            e.getMessage();
        }
    }

    public void showCollection(T t){
        try {
            if (t instanceof User) {
                System.out.println("\nUSER userArrayList");
                for (T c : userArrayList) {
                    System.out.println(c.toString());
                }
            }
            if (t instanceof Airplane) {
                System.out.println("\nAIRPLANE");
                for (T c : airplaneArrayList) {
                    System.out.println(c.toString());
                }
            }
            if (t instanceof Flight) {
                System.out.println("\nFLIGHT");
                for (T c : flightArrayList) {
                    System.out.println(c.toString());
                }
            }
            if (t instanceof City) {
                System.out.println("\nCITIES");
                for (T c : citiesArrayList) {
                    System.out.println(c.toString());
                }
            }
        }catch (Exception e){
            e.getMessage();
            e.getStackTrace();
        }
    }

    public ArrayList<T> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<T> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public ArrayList<T> getFlightArrayList() {
        return flightArrayList;
    }

    public void setFlightArrayList(ArrayList<T> flightArrayList) {
        this.flightArrayList = flightArrayList;
    }

    public ArrayList<T> getAirplaneArrayList() {
        return airplaneArrayList;
    }

    public void setAirplaneArrayList(ArrayList<T> airplaneArrayList) {
        this.airplaneArrayList = airplaneArrayList;
    }

    public ArrayList<T> getCitiesArrayList() {
        return citiesArrayList;
    }

    public void setCitiesArrayList(ArrayList<T> citiesArrayList) {
        this.citiesArrayList = citiesArrayList;
    }

    public static Company getMiCompany() {
        return miCompany;
    }

    public static void setMiCompany(Company miCompany) {
        Company.miCompany = miCompany;
    }



    @Override
    public String toString() {
        return "COMPANY:" +
                "\nUSUARIOS: " + userArrayList +
                "\n\nCIUDADES: " + citiesArrayList +
                "\n\nVUELOS: " + flightArrayList +
                "\n\nAVIONES: " + airplaneArrayList +
                '}';
    }
}

