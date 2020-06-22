package com.company.Flight;

import com.company.Airplane.Airplane;
import com.company.City.City;
import com.company.User.User;

public class Flight {
    private City origen;
    private City destino;
    private User activeLoggedUser;
    private int totalCost;
    private Airplane airplane;
    private boolean statusConfirm;

    public Flight(City origen, City destino, User activeLoggedUser, int totalCost, Airplane airplane, boolean statusConfirm) {
        this.origen = origen;
        this.destino = destino;
        this.activeLoggedUser = activeLoggedUser;
        this.totalCost = totalCost;
        this.airplane = airplane;
        this.statusConfirm = statusConfirm;
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

    public String showList(){
        return "  origen = " + origen.getName() +
                "\ndestino = " + destino.getName();
    }

    @Override
    public String toString() {
        return "  origen = " + origen.getName() +
                "\ndestino = " + destino.getName() +
                "\nactiveLoggedUser =" + activeLoggedUser.getName() +
                "\n totalCost =" + totalCost;
    }
}
