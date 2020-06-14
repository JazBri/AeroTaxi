package com.company;

public class City {
    private String origin;
    private String destination;
    private int km;

    public City(String origin, String destination, int km) {
        this.origin = origin;
        this.destination = destination;
        this.km = km;
    }

    public City() {
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }


    @Override
    public String toString() {
       /* return "City{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", km=" + km +
                '}';*/
        return origin + " - " + destination;
    }
}
