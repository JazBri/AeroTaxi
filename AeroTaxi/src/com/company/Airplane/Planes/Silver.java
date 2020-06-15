package com.company.Airplane.Planes;

import com.company.Airplane.Airplane;
import com.company.Airplane.PropulsionType;

public class Silver extends Airplane implements Catering{


    public Silver(float fuelCapacity, int costPerKilometer, int passengerCapacity, PropulsionType propulsionType, boolean available) {
        super(fuelCapacity, costPerKilometer, passengerCapacity, propulsionType, available);
        this.cost = 2000;
        this.service = "Silver";
    }

    public Silver() {
        super();
    }


    @Override
    public String toString() {
        return "Silver{" +
                "cost=" + cost +
                ", service='" + service + '\'' +
                '}';
    }
}
