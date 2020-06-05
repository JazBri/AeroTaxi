package com.company;

import com.company.Airplane.Airplane;
import com.company.Flight.Flight;
import com.company.Flight.User;

import java.util.HashSet;

public class Company {
    HashSet <User> userHashSet;
    HashSet <Flight> flightHashSet;
    HashSet <Airplane> airplaneHashSet;

    public Company() {
        this.userHashSet = new HashSet<User>();
        this.flightHashSet = new HashSet<Flight>();
        this.airplaneHashSet = new HashSet<Airplane>();
    }

}
