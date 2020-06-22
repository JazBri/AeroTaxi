package com.company.Flight;

import com.company.Airplane.Airplane;
import com.company.City.City;
import com.company.User.User;

import java.util.Date;

public class Flight {
    private City origen;
    private City destino;
    private User activeLoggedUser;
    private int totalCost;
    private Airplane airplane;
    private boolean statusConfirm;
    private Date date;

    public Flight(City origen, City destino, User activeLoggedUser, int totalCost, Airplane airplane, boolean statusConfirm, Date date) {
        this.origen = origen;
        this.destino = destino;
        this.activeLoggedUser = activeLoggedUser;
        this.totalCost = totalCost;
        this.airplane = airplane;
        this.statusConfirm = statusConfirm;
        this.date = date;
    }

    public Flight() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
                "\nactiveLoggedUser =" + activeLoggedUser.getName() +
                "\ntotalCost =" + totalCost +
                "\nDate = " + date;
    }
}
