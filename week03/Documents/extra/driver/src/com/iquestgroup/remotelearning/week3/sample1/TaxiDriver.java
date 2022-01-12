package com.iquestgroup.remotelearning.week3.sample1;

public class TaxiDriver {

    private String name;

    public TaxiDriver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void eat() {
        System.out.println("Driver " + name + " eats");
    }

    public void sleep() {
        System.out.println("Driver " + name + " sleeps");
    }

    public String getCurrentLocation() {
        return "mock location";
    }

    /**
     * Triggers depart to address
     *
     * @return estimated time of arrival (minutes)
     */
    public int goToAddress(String address) {
        System.out.println("Driver " + name + " goes to " + address);
        return 2; // mock value
    }
}
