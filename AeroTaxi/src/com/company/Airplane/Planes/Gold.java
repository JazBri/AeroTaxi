package com.company.Airplane.Planes;

import com.company.Airplane.Airplane;
import com.company.Airplane.PropulsionType;

public class Gold extends Airplane implements Wifi, Catering{


    public Gold(float fuelCapacity, int costPerKilometer, int passengerCapacity, PropulsionType propulsionType, boolean available) {
        super(fuelCapacity, costPerKilometer, passengerCapacity, propulsionType, available);
        this.cost = 4000;
    }

    public Gold() {
        super();
    }



    @Override
    public String toString() {
        return "Gold{" + super.toString() +
                "cost=" + cost +
                '}';
    }
}
