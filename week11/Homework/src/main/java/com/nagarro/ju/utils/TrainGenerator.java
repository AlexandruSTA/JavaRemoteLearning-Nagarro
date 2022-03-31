package com.nagarro.ju.utils;

import com.nagarro.ju.models.Train;
import com.nagarro.ju.models.TrainType;
import com.nagarro.ju.models.TrainWithDynamicHash;

import java.util.Random;

public class TrainGenerator {

    public static TrainWithDynamicHash generateRandomTrainWithDynamicHash() {
        return new TrainWithDynamicHash(generateRandomNumber(), generateRandomTrainType(), generateRandomNumber());
    }

    public static Train generateRandomTrain() {
        return new Train(generateRandomNumber(), generateRandomTrainType(), generateRandomNumber());
    }

    public static long generateRandomNumber() {
        Random random = new Random();
        return Math.abs(random.nextLong());
    }

    public static TrainType generateRandomTrainType() {
        Random random = new Random();
        int numberOfTypes = TrainType.values().length;
        return TrainType.values()[Math.abs(random.nextInt()) % numberOfTypes];
    }
}
