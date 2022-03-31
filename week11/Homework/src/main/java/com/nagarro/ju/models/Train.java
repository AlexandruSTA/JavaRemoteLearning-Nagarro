package com.nagarro.ju.models;

public class Train {
    protected final long number;
    protected final TrainType type;
    protected final long numberOfWagons;

    public Train(long number, TrainType type, long numberOfWagons) {
        this.number = number;
        this.type = type;
        this.numberOfWagons = numberOfWagons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return number == train.number && numberOfWagons == train.numberOfWagons && type == train.type;
    }

    @Override
    public int hashCode() {
        return 10;
    }
}
