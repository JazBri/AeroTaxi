package com.company.Airplane.Planes;

import com.company.Airplane.Airplane;
import com.company.Airplane.Catering;
import com.company.Airplane.PlaneCategory;
import com.company.Airplane.PropulsionType;
import com.company.Airplane.Wifi;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Gold extends Airplane implements Wifi, Catering {

    private static final int costPerKilometer = 300;
    private static final int fixCost = 6000;
    private static final int fuelCapacity = 400;
    private static final String serviceGold = Wifi.wifi + " , " + Catering.catering;


    public Gold(PropulsionType propulsionType, boolean available, PlaneCategory category) {
        super(propulsionType, available, category);
    }

    public Gold() {
    };


    public static int getCostPerKilometer() {
        return costPerKilometer;
    }

    public static int getFixCost() {
        return fixCost;
    }

    public static int getFuelCapacity() {
        return fuelCapacity;
    }

    public static String getServiceGold() {
        return serviceGold;
    }



    @Override
    public String toString() {
        return super.toString() + " service -> " + serviceGold + '\'';
    }
}
