package com.company.Airplane.Planes;

import com.company.Airplane.Airplane;
import com.company.Airplane.PropulsionType;

public class Bronze extends Airplane {

    private static String category = "Bronze";


    public Bronze(float fuelCapacity, int costPerKilometer, int passengerCapacity, PropulsionType propulsionType, boolean available) {
        super(fuelCapacity, costPerKilometer, passengerCapacity, propulsionType, available);
        this.cost = 3000;
        this.service = "Bronze";
    }

    public Bronze() {
        super();
        this.cost = 3000;
        this.service = "Bronze";
    }


    @Override
    public String toString() {
        return "\n\nServicio: " + this.service +
                "\nCosto del servicio: " + cost;
    }
}
