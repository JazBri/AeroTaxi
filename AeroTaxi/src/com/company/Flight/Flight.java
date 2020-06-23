package com.company.Flight;

import com.company.Airplane.Airplane;
import com.company.City.City;
import com.company.User.User;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;

import java.util.Date;

public class Flight {
    private City origen;
    private City destino;
    private User activeLoggedUser;
    private Date flightDate;
    private int totalCost;
    private Airplane airplane;
    private boolean statusConfirm;



    public Flight(City origen, City destino, User activeLoggedUser, Date flightDate, int totalCost, Airplane airplane, boolean statusConfirm) {

        this.origen = origen;
        this.destino = destino;
        this.activeLoggedUser = activeLoggedUser;
        this.flightDate = flightDate;
        this.totalCost = totalCost;
        this.airplane = airplane;
        this.statusConfirm = statusConfirm;
    }

    public Flight() {
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public City getOrigen() {
        return origen;
    }

    public void setOrigen(City origen) {
        this.origen = origen;
    }

    public City getDestino() {
        return destino;
    }

    public void setDestino(City destino) {
        this.destino = destino;
    }

    public User getActiveLoggedUser() {
        return activeLoggedUser;
    }

    public void setActiveLoggedUser(User activeLoggedUser) {
        this.activeLoggedUser = activeLoggedUser;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public boolean isStatusConfirm() {
        return statusConfirm;
    }

    public void setStatusConfirm(boolean statusConfirm) {
        this.statusConfirm = statusConfirm;
    }

    public String showList(){
        return " \nOrigen:  " + origen.getName() +
                "\n  Destino:  " + destino.getName() +
                "\n  Servicio: " + airplane.getCategory() +
                "\n  Costo Total:  " + totalCost +
                "\n  Datos del Usuario:  " + activeLoggedUser.showListFlights();

    }


    @Override
    public String toString() {
        return "  origen = " + origen.getName() +
                "\ndestino = " + destino.getName() +
                "\nfecha de vuelo =" + flightDate +
                "\nactiveLoggedUser =" + activeLoggedUser.getName() +
                "\ntotalCost =" + totalCost ;
    }
}
