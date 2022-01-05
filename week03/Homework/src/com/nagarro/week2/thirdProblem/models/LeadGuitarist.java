package com.nagarro.week2.thirdProblem.models;

public class LeadGuitarist extends Guitarist {
    public LeadGuitarist(String name, int experience, Guitar guitar) {
        super(name, experience, guitar);
    }

    @Override
    public String toString() {
        return super.toString() + ", Lead Guitarist";
    }
}
