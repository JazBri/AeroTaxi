package com.company.CompanyAdmin;

import com.company.Airplane.Airplane;
import com.company.City.City;
import com.company.Flight.Flight;
import com.company.User.User;

import java.util.ArrayList;

public class Company {
    private ArrayList<Object> userArrayList = new ArrayList<>();
    private ArrayList<Object> flightArrayList = new ArrayList<>();
    private ArrayList<Object> airplaneArrayList = new ArrayList<>();
    private ArrayList<Object> citiesArrayList = new ArrayList<>();
    private User currentLoggedUser;

    //Atributo estático para usar singleton.
    private static Company miCompany;

    //El constructor privado no permite que se genere uno por defecto.
    private Company() {
    }

    //getSingletonInstance devuelve la instancia del objeto, de esta manera se puede llamar en distintas clases.
    public static Company getSingletonInstance() {
        if (miCompany == null) {
            miCompany = new Company();
            //System.out.println("Objeto Company creado exitosamente!");
        }
        return miCompany;
    }


    //Hacerlo generico
    public void addToCollection(Object object) {
        try {
            if (object instanceof User) {
                userArrayList.add(object);
            }
            if (object instanceof Airplane) {
                airplaneArrayList.add(object);
            }
            if (object instanceof Flight) {
                flightArrayList.add(object);
            }
            if (object instanceof City) {
                citiesArrayList.add(object);
            }
        } catch (Exception e) {
            e.getStackTrace();
            e.getMessage();
        }
    }

    public void showCollection(Object object) {
        try {
            if (object instanceof User) {
                System.out.println("\nUSER userArrayList");
                for (Object c : userArrayList) {
                    System.out.println(c.toString());
                }
            }
            if (object instanceof Airplane) {
                System.out.println("\nAIRPLANE");
                for (Object c : airplaneArrayList) {
                    System.out.println(c.toString());
                }
            }
            if (object instanceof Flight) {
                System.out.println("\nFLIGHT");
                for (Object c : flightArrayList) {
                    System.out.println(c.toString());
                }
            }
            if (object instanceof City) {
                System.out.println("\nCITIES");
                for (Object c : citiesArrayList) {
                    System.out.println(c.toString());
                }
            }
        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
        }
    }

    public ArrayList<Object> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<Object> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public ArrayList<Object> getFlightArrayList() {
        return flightArrayList;
    }

    public void setFlightArrayList(ArrayList<Object> flightArrayList) {
        this.flightArrayList = flightArrayList;
    }

    public ArrayList<Object> getAirplaneArrayList() {
        return airplaneArrayList;
    }

    public void setAirplaneArrayList(ArrayList<Object> airplaneArrayList) {
        this.airplaneArrayList = airplaneArrayList;
    }

    public ArrayList<Object> getCitiesArrayList() {
        return citiesArrayList;
    }

    public void setCitiesArrayList(ArrayList<Object> citiesArrayList) {
        this.citiesArrayList = citiesArrayList;
    }

    public static Company getMiCompany() {
        return miCompany;
    }

    public static void setMiCompany(Company miCompany) {
        Company.miCompany = miCompany;
    }

    public User getCurrentLoggedUser() {
        return currentLoggedUser;
    }

    public void setCurrentLoggedUser(User currentLoggedUser) {
        this.currentLoggedUser = currentLoggedUser;
    }

    @Override
    public String toString() {
        return "Company ->" +
                "userArrayList=" + userArrayList +
                ", flightArrayList=" + flightArrayList +
                ", airplaneArrayList=" + airplaneArrayList +
                ", citiesArrayList=" + citiesArrayList +
                ", currentLogedUser=" + currentLoggedUser;
    }
}

