package com.company.Airplane.Planes;

import com.company.Airplane.Airplane;
import com.company.Airplane.Catering;
import com.company.Airplane.PropulsionType;
import com.company.Airplane.Wifi;

public class Gold extends Airplane implements Wifi, Catering {


    public Gold(float fuelCapacity, int costPerKilometer, int passengerCapacity, PropulsionType propulsionType, boolean available) {
        super(fuelCapacity, costPerKilometer, passengerCapacity, propulsionType, available);
        this.cost = 4000;
        this.service = "Gold";
    }

    public Gold() {
        super();
        this.cost = 4000;
        this.service = "Gold";
    }


    @Override
    public String toString() {
        return  "\n\nServicio: " + this.service +
                "\nCosto del servicio: " + cost;
    }
}
