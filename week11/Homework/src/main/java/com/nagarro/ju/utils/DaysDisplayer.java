package com.nagarro.ju.utils;

import java.util.List;

public class DaysDisplayer {
    public static void displayDays(List<Integer> days) {
        System.out.println("=========WORKING DAYS=========");
        for (Integer day : days) {
            System.out.print(day + ";");
        }
        System.out.println();
    }

    public static void displayMultipleDays(List<List<Integer>> listOfDays) {
        for (List<Integer> days : listOfDays) {
            displayDays(days);
        }
    }
}
