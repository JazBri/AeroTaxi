package com.company.Flight;

import com.company.Airplane.Airplane;
import com.company.City;
import com.company.Questionary;
import com.company.User;

import java.util.ArrayList;
import java.util.HashMap;

public class Flight {
    private String citiesMap;
    private User userM;
    private float totalCost;
    private Questionary questionary;
    private Airplane airplane;
    private boolean statusConfirm;

    public Flight(String citiesMap, User userM, float totalCost, Questionary questionary, boolean statusConfirm) {
        this.citiesMap = citiesMap;
        this.userM = userM;
        this.totalCost = totalCost;
        this.questionary = questionary;
        this.airplane = airplane;
        this.statusConfirm = statusConfirm;
    }

    public Flight() {
    }

    public String getCitiesMap() {
        return citiesMap;
    }

    public void setCitiesMap(String citiesMap) {
        this.citiesMap = citiesMap;
    }

    public User getUserM() {
        return userM;
    }

    public void setUserM(User userM) {
        this.userM = userM;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public Questionary getQuestionary() {
        return questionary;
    }

    public void setQuestionary(Questionary questionary) {
        this.questionary = questionary;
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

    @Override
    public String toString() {
        return "Flight{" +
                "\nDatos del usuario: " + userM +
                "\nCosto total: " + totalCost +
                "\nDatos del cuestionairo: " + questionary +
                "\nEstado: " + statusConfirm +
                '}';
    }
}
