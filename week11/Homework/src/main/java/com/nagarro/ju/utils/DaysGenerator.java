package com.nagarro.ju.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DaysGenerator {

    public static List<Integer> generateDaysAsNumbers(int numberOfDays) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= numberOfDays; i++) {
            if (random.nextBoolean()) {
                numbers.add(i);
            }
        }
        return numbers;
    }

    public static List<Integer> daysOfTheYear() {
        return generateDaysAsNumbers(365);
    }
}
