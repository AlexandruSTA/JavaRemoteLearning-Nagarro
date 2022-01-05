package com.nagarro.week2.thirdProblem.models;

public class Drumset {
    private final String description;

    public Drumset() {
        this("");
    }

    public Drumset(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Description: " + description;
    }
}
