package com.company;

import com.company.Airplane.Airplane;

import java.time.LocalDate;

public class Questionary {
    private LocalDate date;
    private String recorrido;
    private int companionsNumbers;
    private String airplane;

    public Questionary(LocalDate date, String recorrido, int companionsNumbers, String airplane) {
        this.date = date;
        this.recorrido = recorrido;
        this.companionsNumbers = companionsNumbers;
        this.airplane = airplane;
    }




    public String getAirplane() {
        return airplane;
    }

    public void setAirplane(String airplane) {
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

    public String getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(String recorrido) {
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
                "\nCantidad de ocupantes: " + companionsNumbers +
                "\nServicio: " + airplane ;

    }

}
