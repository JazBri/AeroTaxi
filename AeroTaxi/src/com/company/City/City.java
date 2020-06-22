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
            switch (destination) {
                case ("Cordoba") : km = 695;
                case ("Santiago") : km = 1400;
                case ("Montevideo") : km = 950;
                default : km = 0;
            };
        }

        if (this.name == "Cordoba") {
             switch (destination) {
                 case ("Buenos Aires") : km = 695;
                 case ("Montevideo") : km = 1190;
                 case ("Santiago") : km = 1050;
                 default : km = 0;
            };
        }

        if (this.name == "Montevideo") {
             switch (destination) {
                 case ("Buenos Aires") : km = 950;
                case ("Cordoba") : km = 1190;
                case ("Santiago") : km = 2100;
                 default : km = 0;
            };
        }

        if (this.name == "Santiago") {
             switch (destination) {
                case ("Buenos Aires") : km = 1400;
                case ("Cordoba") : km = 1050;
                case ("Montevideo") : km = 2100;
                default : km = 0;
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
