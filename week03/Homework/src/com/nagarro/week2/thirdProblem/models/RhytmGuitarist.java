package com.nagarro.week2.thirdProblem.models;

public class RhytmGuitarist extends Guitarist {
    public RhytmGuitarist(String name, int experience, Guitar guitar) {
        super(name, experience, guitar);
    }

    @Override
    public String toString() {
        return super.toString() + ", Rhytm Guitarist";
    }
}
