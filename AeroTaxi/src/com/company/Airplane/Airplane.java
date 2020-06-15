package com.company.Airplane;

public  class Airplane {
    private float fuelCapacity;
    private int costPerKilometer;
    private int passengerCapacity;
    private PropulsionType propulsionType;
    private boolean available;
    protected int cost;
    protected String service;

    public Airplane(float fuelCapacity, int costPerKilometer, int passengerCapacity, PropulsionType propulsionType, boolean available) {
        this.fuelCapacity = fuelCapacity;
        this.costPerKilometer = costPerKilometer;
        this.passengerCapacity = passengerCapacity;
        this.propulsionType = propulsionType;
        this.available = available;
        this.service = service;

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

    public PropulsionType getPropulsionType() {
        return propulsionType;
    }

    public void setPropulsionType(PropulsionType propulsionType) {
        this.propulsionType = propulsionType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "fuelCapacity=" + fuelCapacity +
                ", costPerKilometer=" + costPerKilometer +
                ", passengerCapacity=" + passengerCapacity +
                ", propulsionType=" + propulsionType +
                ", available=" + available +
                ", cost=" + cost +
                ", service='" + service + '\'' +
                '}';
    }
}
