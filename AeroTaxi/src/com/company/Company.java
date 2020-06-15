package com.company;
import com.company.Airplane.Airplane;
import com.company.Flight.Flight;
import java.util.HashSet;

public class Company <T>{
    private HashSet <T> userHashSet;
    private HashSet <T> flightHashSet;
    private HashSet <T> airplaneHashSet;
    private HashSet <T> citiesHashSet;

    //Atributo estático para usar singleton.
    private static Company miCompany;

    //El constructor privado no permite que se genere uno por defecto.
    private Company() {
        this.userHashSet = new HashSet<T>();
        this.flightHashSet = new HashSet<T>();
        this.airplaneHashSet = new HashSet<T>();
        this.citiesHashSet = new HashSet<T>();
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
                userHashSet.add(t);
            }
             if(t instanceof Airplane) {
                 airplaneHashSet.add(t);
             }
             if(t instanceof Flight) {
                 flightHashSet.add(t);
             }
            if(t instanceof City) {
                citiesHashSet.add(t);
            }
    }catch (Exception e) {
            e.getStackTrace();
            e.getMessage();
        }
    }

    public void showCollection(T t){
        try {
            if (t instanceof User) {
                System.out.println("\nUSER");
                for (T c : userHashSet) {
                    System.out.println(c.toString());
                }
            }
            if (t instanceof Airplane) {
                System.out.println("\nAIRPLANE");
                for (T c : airplaneHashSet) {
                    System.out.println(c.toString());
                }
            }
            if (t instanceof Flight) {
                System.out.println("\nFLIGHT");
                for (T c : flightHashSet) {
                    System.out.println(c.toString());
                }
            }
            if (t instanceof City) {
                System.out.println("\nCITIES");
                for (T c : citiesHashSet) {
                    System.out.println(c.toString());
                }
            }
        }catch (Exception e){
            e.getMessage();
            e.getStackTrace();
        }
    }

    public HashSet<T> returnCities(){
        return citiesHashSet;
    }


    @Override
    public String toString() {
        return "COMPANY:" +
                "\nUSUARIOS: " + userHashSet +
                "\n\nCIUDADES: " + citiesHashSet +
                "\n\nVUELOS: " + flightHashSet +
                "\n\nAVIONES: " + airplaneHashSet +
                '}';
    }
}

