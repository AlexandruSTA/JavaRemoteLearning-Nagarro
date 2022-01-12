package com.iquestgroup.remotelearning.week3.sample1;

import java.util.List;

public class DispatchOperator {

    private String name;
    private List<TaxiDriver> drivers;

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
