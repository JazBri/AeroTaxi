package com.company.Airplane.Planes;

import com.company.Airplane.Airplane;
import com.company.Airplane.PlaneCategory;
import com.company.Airplane.PropulsionType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Bronze")
public class Bronze extends Airplane {


    private static final int costPerKilometer = 150;
    private static final int fixCost = 3000;
    private static final int fuelCapacity = 200;


    public Bronze(PropulsionType propulsionType, boolean available, PlaneCategory category) {
        super(propulsionType, available, category);
    }

    public Bronze() {
        super();
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


}
