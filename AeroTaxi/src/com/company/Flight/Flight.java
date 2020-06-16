package com.company.Flight;

import com.company.Airplane.Airplane;
import com.company.City;
import com.company.Questionary;
import com.company.User;

public class Flight {
    private City citiesMap;
    private User userM;
    private float totalCost;
    private Questionary questionary;
    private Airplane airplane;
    private boolean statusConfirm;

    public Flight(City citiesMap, User userM, Questionary questionary, boolean statusConfirm) {
        this.citiesMap = citiesMap;
        this.userM = userM;
        this.totalCost = totalCost;
        this.questionary = questionary;
        this.airplane = airplane;
        this.statusConfirm = statusConfirm;
    }

    public Flight() {
    }

    public City getCitiesMap() {
        return citiesMap;
    }

    public void setCitiesMap(City citiesMap) {
        this.citiesMap = citiesMap;
    }

    public User getUserM() {
        return userM;
    }

    public void setUserM(User userM) {
        this.userM = userM;
    }

    public float getTotalCost() {
        //float total = ((citiesMap.getKm() * 500) + (questionary.getCompanionsNumbers() * 3500) + airplane.getCost());
        float total = ((400 * 500) + (questionary.getCompanionsNumbers() * 3500) + questionary.getAirplane().getCost());
        setTotalCost(total);
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
        return  userM +
                "\n\n" + questionary +
                "\n\nCosto total: " + getTotalCost() +
                "\n\n";
    }
}
