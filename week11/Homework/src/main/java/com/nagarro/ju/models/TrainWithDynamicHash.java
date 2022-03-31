package com.nagarro.ju.models;

import java.util.Objects;

public class TrainWithDynamicHash extends Train {
    public TrainWithDynamicHash(long trainNumber, TrainType type, long numberOfWagons) {
        super(trainNumber, type, numberOfWagons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type, numberOfWagons);
    }
}
