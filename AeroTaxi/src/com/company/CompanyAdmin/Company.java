package com.company.CompanyAdmin;

import com.company.Airplane.Airplane;
import com.company.Airplane.Planes.Bronze;
import com.company.Airplane.Planes.Gold;
import com.company.Airplane.Planes.Silver;
import com.company.Cityy.City;
import com.company.Flight.Flight;
import com.company.Userr.User;

import java.util.ArrayList;

public class Company {

    private ArrayList<Object> userArrayList = new ArrayList<>();
    private ArrayList<Object> flightArrayList = new ArrayList<>();
    private ArrayList<Bronze> airplaneArrayListBronze = new ArrayList<>();
    private ArrayList<Silver> airplaneArrayListSilver = new ArrayList<>();
    private ArrayList<Gold> airplaneArrayListGold = new ArrayList<>();
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
            if (object instanceof Bronze) {
                airplaneArrayListBronze.add((Bronze) object);
            }
            if (object instanceof Silver) {
                airplaneArrayListSilver.add((Silver) object);
            }
            if (object instanceof Gold) {
                airplaneArrayListGold.add((Gold) object);
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
                for (Object c : airplaneArrayListBronze) {
                    System.out.println(c.toString());
                }
                for (Object c : airplaneArrayListSilver) {
                    System.out.println(c.toString());
                }
                for (Object c : airplaneArrayListGold) {
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

    public ArrayList<Bronze> getAirplaneArrayListBronze() {
        return airplaneArrayListBronze;
    }

    public void setAirplaneArrayListBronze(ArrayList<Bronze> airplaneArrayListBronze) {
        this.airplaneArrayListBronze = airplaneArrayListBronze;
    }

    public ArrayList<Silver> getAirplaneArrayListSilver() {
        return airplaneArrayListSilver;
    }

    public void setAirplaneArrayListSilver(ArrayList<Silver> airplaneArrayListSilver) {
        this.airplaneArrayListSilver = airplaneArrayListSilver;
    }

    public ArrayList<Gold> getAirplaneArrayListGold() {
        return airplaneArrayListGold;
    }

    public void setAirplaneArrayListGold(ArrayList<Gold> airplaneArrayListGold) {
        this.airplaneArrayListGold = airplaneArrayListGold;
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
        return "Company{" +
                "userArrayList=" + userArrayList +
                ", flightArrayList=" + flightArrayList +
                ", airplaneArrayListBronze=" + airplaneArrayListBronze +
                ", airplaneArrayListSilver=" + airplaneArrayListSilver +
                ", airplaneArrayListGold=" + airplaneArrayListGold +
                ", citiesArrayList=" + citiesArrayList +
                ", currentLoggedUser=" + currentLoggedUser +
                '}';
    }
}

