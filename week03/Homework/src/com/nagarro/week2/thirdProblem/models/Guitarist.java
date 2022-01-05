package com.nagarro.week2.thirdProblem.models;

public class Guitarist {
    protected String name;
    protected int experience;
    protected Guitar guitar;

    public Guitarist(String name, int experience, Guitar guitar) {
        this.name = name;
        this.experience = experience;
        this.guitar = guitar;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Experience: " + experience + ", Guitar: " + guitar;
    }
}
