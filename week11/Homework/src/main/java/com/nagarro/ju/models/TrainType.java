package com.nagarro.ju.models;

public enum TrainType {
    Regional(0), Passenger(1), HighSpeed(2);

    private final int value;

    TrainType(int value) {
        this.value = value;
    }
}
