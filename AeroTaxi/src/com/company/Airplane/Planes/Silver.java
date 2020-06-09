package com.company.Airplane.Planes;

import com.company.Airplane.Airplane;
import com.company.Airplane.PropulsionType;

public class Silver extends Airplane implements Catering{
    private int cost;

    public Silver(float fuelCapacity, int costPerKilometer, int passengerCapacity, PropulsionType propulsionType, boolean available, int cost) {
        super(fuelCapacity, costPerKilometer, passengerCapacity, propulsionType, available);
        this.cost = cost;
    }

    public Silver() {
        super();
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Silver{" + super.toString() +
                "cost=" + cost +
                '}';
    }
}
