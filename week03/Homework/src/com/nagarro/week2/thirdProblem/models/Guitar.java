package com.nagarro.week2.thirdProblem.models;

public class Guitar {
    private final Manufacturer manufacturer;

    public Guitar(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Manufacturer: " + manufacturer;
    }
}
