package com.company.City;

public class City {
    private String name;


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


    public Integer getDistance(String destination) {

        int km = 0;

        if (this.name == "Buenos Aires") {
            km = switch (destination) {
                case ("Cordoba") -> km = 695;
                case ("Santiago") -> km = 1400;
                case ("Montevideo") -> km = 950;
                default -> km;
            };
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

        if (this.name == "Santiago") {
            km = switch (destination) {
                case ("Buenos Aires") -> 1400;
                case ("Cordoba") -> 1050;
                case ("Montevideo") -> 2100;
                default -> km;
            };
        }

        return km;
    }

    @Override
    public String toString() {
        return " City -> " +
                "name = '" + name + '\'';
    }
}