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


    public int getDistance(String destination) {

        int km = 0;

        if (this.name == "Buenos Aires") {
            switch (destination) {
                case ("Cordoba"):
                    km = 695;
                    break;
                case ("Santiago"):
                    km = 1400;
                    break;
                case ("Montevideo"):
                    km = 950;
                    break;
                default:
                    km = 0;
            }

        }

        if (this.name == "Cordoba") {
            switch (destination) {
                case ("Buenos Aires"):
                    km = 695;
                    break;
                case ("Montevideo"):
                    km = 1190;
                    break;
                case ("Santiago"):
                    km = 1050;
                    break;
                default:
                    km = 0;
            }

        }

        if (this.name == "Montevideo") {
            switch (destination) {
                case ("Buenos Aires"):
                    km = 950;
                    break;
                case ("Cordoba"):
                    km = 1190;
                    break;
                case ("Santiago"):
                    km = 2100;
                    break;
                default:
                    km = 0;
            }

        }

        if (this.name == "Santiago") {

            switch (destination) {
                case ("Buenos Aires"):
                    km = 1400;
                    break;
                case ("Cordoba"):
                    km = 1050;
                    break;
                case ("Montevideo"):
                    km = 2100;
                    break;
                default:
                    km = 0;
            }

        }

        return km;
    }

    @Override
    public String toString() {
        return " City -> " +
                "name = '" + name + '\'';
    }
}
