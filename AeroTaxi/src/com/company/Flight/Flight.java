package com.company.Flight;

import com.company.Airplane.Airplane;
import com.company.Questionary;
import com.company.User;

import java.util.HashMap;

public class Flight {
    private HashMap citiesMap;
    private User userM;
    private float totalCost;
    private Questionary questionary;
    private Airplane airplane;
    private boolean statusConfirm;

    public Flight(HashMap citiesMap, User userM, float totalCost, Questionary questionary, Airplane airplane, boolean statusConfirm) {
        this.citiesMap = citiesMap;
        this.userM = userM;
        this.totalCost = totalCost;
        this.questionary = questionary;
        this.airplane = airplane;
        this.statusConfirm = statusConfirm;
    }

    public Flight() {
    }

    public HashMap getCitiesMap() {
        return citiesMap;
    }

    public void setCitiesMap(HashMap citiesMap) {
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
                "citiesMap=" + citiesMap +
                ", userM=" + userM +
                ", totalCost=" + totalCost +
                ", questionary=" + questionary +
                ", airplane=" + airplane +
                ", statusConfirm=" + statusConfirm +
                '}';
    }
}
