package com.company;

import java.time.LocalDate;

public class Questionary {
    private LocalDate date;
    private String destination;
    private String origin;
    private int companionsNumbers;

    public Questionary(LocalDate date, String destination, String origin, int companionsNumbers) {
        this.date = date;
        this.destination = destination;
        this.origin = origin;
        this.companionsNumbers = companionsNumbers;
    }

    public Questionary() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getCompanionsNumbers() {
        return companionsNumbers;
    }

    public void setCompanionsNumbers(int companionsNumbers) {
        this.companionsNumbers = companionsNumbers;
    }

    @Override
    public String toString() {
        return "Questionary{" +
                "date=" + date +
                ", destination='" + destination + '\'' +
                ", origin='" + origin + '\'' +
                ", companionsNumbers=" + companionsNumbers +
                '}';
    }
}
