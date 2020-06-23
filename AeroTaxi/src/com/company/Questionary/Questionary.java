package com.company.Questionary;

import com.company.Airplane.Airplane;
import com.company.City.City;

import java.util.Date;

public class Questionary {
    private Date date;
    private City origen;
    private int companionsNumbers;
    private Airplane airplane;
    private String destino;


    public Questionary(Date date, City origen, int companionsNumbers, Airplane airplane, String destino) {
        this.date = date;
        this.origen = origen;
        this.companionsNumbers = companionsNumbers;
        this.airplane = airplane;
        this.destino = destino;
    }


    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Questionary() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public int getCompanionsNumbers() {
        return companionsNumbers;
    }

    public void setCompanionsNumbers(int companionsNumbers) {
        this.companionsNumbers = companionsNumbers;
    }

    @Override
    public String toString() {
        return "Fecha de viaje : " + date +
                "\nCantidad de ocupantes: " + companionsNumbers +
                "\nOrigen: " + origen.getName() +
                "\nDestino: " + destino +
                "\nDistancia al destino en km: " + origen.getDistance(this.destino);

    }

}
