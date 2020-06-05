package com.company.Airplane;

import com.company.Services.Service;

import java.time.LocalDate;

public class Airplane {
    private float fuelCapacity;
    private int costPerKilometer;
    private int passengerCapacity;
    private int propulsionType;
    private Service service;
    private boolean available;
    private Cost cost;
    private int actualPassengers;
    private LocalDate dateSelected;

    public Airplane(float fuelCapacity, int costPerKilometer, int passengerCapacity, int propulsionType, Service service, boolean available, Cost cost, int actualPassengers, LocalDate dateSelected) {
        this.fuelCapacity = fuelCapacity;
        this.costPerKilometer = costPerKilometer;
        this.passengerCapacity = passengerCapacity;
        this.propulsionType = propulsionType;
        this.service = service;
        this.available = available;
        this.cost = cost;
        this.actualPassengers = actualPassengers;
        this.dateSelected = dateSelected;
    }

    public Airplane() {
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getCostPerKilometer() {
        return costPerKilometer;
    }

    public void setCostPerKilometer(int costPerKilometer) {
        this.costPerKilometer = costPerKilometer;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getPropulsionType() {
        return propulsionType;
    }

    public void setPropulsionType(int propulsionType) {
        this.propulsionType = propulsionType;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public boolean isvAvailable() {
        return available;
    }

    public void setAviable(boolean available) {
        this.available = available;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public int getActualPassengers() {
        return actualPassengers;
    }

    public void setActualPassengers(int actualPassengers) {
        this.actualPassengers = actualPassengers;
    }

    public LocalDate getDateSelected() {
        return dateSelected;
    }

    public void setDateSelected(LocalDate dateSelected) {
        this.dateSelected = dateSelected;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "fuelCapacity=" + fuelCapacity +
                ", costPerKilometer=" + costPerKilometer +
                ", passengerCapacity=" + passengerCapacity +
                ", propulsionType=" + propulsionType +
                ", service=" + service +
                ", available=" + available +
                ", cost=" + cost +
                ", actualPassengers=" + actualPassengers +
                ", dateSelected=" + dateSelected +
                '}';
    }
}
