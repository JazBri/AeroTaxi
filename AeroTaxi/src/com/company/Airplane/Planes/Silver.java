package com.company.Airplane.Planes;

import com.company.Airplane.Airplane;
import com.company.Airplane.Catering;
import com.company.Airplane.PlaneCategory;
import com.company.Airplane.PropulsionType;
import com.company.Airplane.Wifi;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Silver extends Airplane implements Catering {

    private static final int costPerKilometer = 225;
    private static final int fixCost = 4000;
    private static final int fuelCapacity = 300;
    private static final String serviceSilver = Catering.catering;

    public Silver(PropulsionType propulsionType, boolean available, PlaneCategory category) {
        super(propulsionType, available, category);
    }

    public Silver() {
    }

    public static int getCostPerKilometer() {
        return costPerKilometer;
    }

    public static int getFixCost() {
        return fixCost;
    }

    public static int getFuelCapacity() {
        return fuelCapacity;
    }

    public static String getServiceSilver() {
        return serviceSilver;
    }


    @Override
    public String toString() {
        return super.toString() + " service -> " + getServiceSilver() + '\'';
    }
}
