package com.nagarro.week2.extra.driver;

import java.util.List;

public class DispatchOperator implements IEat, IDispatchOperations {

    private final String name;
    private final List<TaxiDriver> drivers;

    public DispatchOperator(String name, List<TaxiDriver> drivers) {
        this.name = name;
        this.drivers = drivers;
    }

    public void eat() {
        System.out.println("Operator " + name + " eats");
    }

    private TaxiDriver getBestAvailableTaxi(String location) {
        return drivers.get(0);
    }

    public void dispatch(String location) {
        getBestAvailableTaxi(location).goToAddress(location);
    }
}
