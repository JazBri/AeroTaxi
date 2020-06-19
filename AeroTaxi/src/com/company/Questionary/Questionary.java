package com.company;

import com.company.Airplane.Airplane;
import com.company.City.City;

import java.time.LocalDate;

public class Questionary {
    private LocalDate date;
    private City recorrido;
    private int companionsNumbers;
    private Airplane airplane;



    public Questionary(LocalDate date, City recorrido, int companionsNumbers, Airplane airplane) {
        this.date = date;
        this.recorrido = recorrido;
        this.companionsNumbers = companionsNumbers;
        this.airplane = airplane;
    }




    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Questionary() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public City getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(City recorrido) {
        this.recorrido = recorrido;
    }

    public int getCompanionsNumbers() {
        return companionsNumbers;
    }

    public void setCompanionsNumbers(int companionsNumbers) {
        this.companionsNumbers = companionsNumbers;
    }

    @Override
    public String toString() {
        /*return "Questionary{" +
                "date=" + date +
                ", recorrido='" + recorrido + '\'' +
                ", companionsNumbers=" + companionsNumbers +
                '}';
    */
        return "Fecha: " + date +
                "\nDestino - origen: " + recorrido +
                "\nCantidad de ocupantes: " + companionsNumbers;


    }

}
