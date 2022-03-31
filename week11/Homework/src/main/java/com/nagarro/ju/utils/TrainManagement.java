package com.nagarro.ju.utils;

import com.nagarro.ju.models.Train;
import com.nagarro.ju.models.TrainWithDynamicHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainManagement {

    public static void trainManagementWithConstantHash() {
        Map<Train, List<Integer>> trains = new HashMap<>();
        List<List<Integer>> randomSchedules = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            Train train = TrainGenerator.generateRandomTrain();
            List<Integer> workingDays = DaysGenerator.daysOfTheYear();
            if (randomSchedules.size() < 5) {
                randomSchedules.add(workingDays);
            }
            trains.put(train, workingDays);
        }
        DaysDisplayer.displayMultipleDays(randomSchedules);
        double elapsedTime = (double) (System.nanoTime() - startTime) / 1000000000;
        System.out.println("\nPerformance of the HashMap in seconds (with dynamic hash): " + elapsedTime + " seconds");
    }

    public static void trainManagementWithDynamicsHash() {
        Map<TrainWithDynamicHash, List<Integer>> trains = new HashMap<>();
        List<List<Integer>> randomSchedules = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            TrainWithDynamicHash train = TrainGenerator.generateRandomTrainWithDynamicHash();
            List<Integer> workingDays = DaysGenerator.daysOfTheYear();
            if (randomSchedules.size() < 5) {
                randomSchedules.add(workingDays);
            }
            trains.put(train, workingDays);
        }
        DaysDisplayer.displayMultipleDays(randomSchedules);
        double elapsedTime = (double) (System.nanoTime() - startTime) / 1000000000;
        System.out.println("\nPerformance of the HashMap in seconds (with constant hash): " + elapsedTime + " seconds");
    }
}
