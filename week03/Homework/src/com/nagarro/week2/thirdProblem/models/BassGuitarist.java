package com.nagarro.week2.thirdProblem.models;

public class BassGuitarist extends Guitarist {
    public BassGuitarist(String name, int experience, Guitar guitar) {
        super(name, experience, guitar);
    }

    @Override
    public String toString() {
        return super.toString() + ", Bass Guitarist";
    }
}
