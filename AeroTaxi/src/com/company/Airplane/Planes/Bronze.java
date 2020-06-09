package com.company.Airplane.Planes;
import com.company.Airplane.Airplane;
import com.company.Airplane.PropulsionType;

public class Bronze extends Airplane {
    private int cost;

    public Bronze(float fuelCapacity, int costPerKilometer, int passengerCapacity, PropulsionType propulsionType, boolean available) {
        super(fuelCapacity, costPerKilometer, passengerCapacity, propulsionType, available);
        this.cost = 3000;
    }

    public Bronze() {
        super();
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Bronze{" + super.toString() +
                "cost=" + cost +
                '}';
    }
}
