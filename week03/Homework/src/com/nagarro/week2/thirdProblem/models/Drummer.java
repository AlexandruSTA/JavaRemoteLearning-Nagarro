package com.nagarro.week2.thirdProblem.models;

public class Drummer {
    private final String name;
    private final Drumset drumset;

    public Drummer() {
        this("", new Drumset());
    }

    public Drummer(String name, Drumset drumset) {
        this.name = name;
        this.drumset = drumset;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Drumset: " + drumset;
    }
}
