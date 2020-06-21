package com.company.Airplane;

public abstract class Airplane {
    private static final int passengerCapacity = 10;
    private PropulsionType propulsionType;
    private boolean available;
    private PlaneCategory category;


    public Airplane(PropulsionType propulsionType, boolean available, PlaneCategory category) {
        this.propulsionType = propulsionType;
        this.available = available;
        this.category = category;
    }

    public Airplane() {

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

    public static int getPassengerCapacity() {
        return passengerCapacity;
    }

    public PlaneCategory getCategory() {
        return category;
    }

    public void setCategory(PlaneCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Airplane -> " + "propulsionType = " + propulsionType + ", available = " + available + ", category = '" + category + '\'';
    }
}
