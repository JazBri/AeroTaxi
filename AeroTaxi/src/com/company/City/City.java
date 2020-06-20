package com.company.City;

public class City {
    private String name;
    private String destination;


    public City(String name, String destination) {
        this.name = name;
        this.destination = destination;
    }

    public City(String name) {
        this.name = name;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getDistance() {

        int km = 0;

        if (this.name == "Buenos Aires") {
            switch (destination) {
                case ("Cordoba") -> km = 695;
                case ("Santiago") -> km = 1400;
                case ("Montevideo") -> km = 950;
            }
        }

        if (this.name == "Cordoba") {
            km = switch (destination) {
                case ("Buenos Aires") -> 695;
                case ("Montevideo") -> 1190;
                case ("Santiago") -> 1050;
                default -> km;
            };
        }

        if (this.name == "Montevideo") {
            km = switch (destination) {
                case ("Buenos Aires") -> 950;
                case ("Cordoba") -> 1190;
                case ("Santiago") -> 2100;
                default -> km;
            };
        }

        return km;
    }

    @Override
    public String toString() {
        return " City -> " +
                "name = '" + name + '\'' +
                ", destination = '" + destination + '\'';
    }
}
