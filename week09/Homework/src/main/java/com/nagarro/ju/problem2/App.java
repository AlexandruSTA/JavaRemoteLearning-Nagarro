package com.nagarro.ju.problem2;

import com.nagarro.ju.problem2.utils.Sorter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        Integer[] randomNumbers = generateRandomIntegerNumbers(10, 100);
        displayArray(randomNumbers);
        sorter.bubbleSort(randomNumbers);
        displayArray(randomNumbers);
        String[] randomStrings = generateRandomStrings(10, 10);
        displayArray(randomStrings);
        sorter.bubbleSort(randomStrings);
        displayArray(randomStrings);
    }

    public static Integer[] generateRandomIntegerNumbers(int length, int maximumValue) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            numbers.add(random.nextInt(maximumValue));
        }
        return numbers.toArray(new Integer[0]);
    }

    public static String[] generateRandomStrings(int length, int maximumLengthOfString) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            strings.add(generateRandomAlphanumericString(maximumLengthOfString));
        }
        return strings.toArray(new String[0]);
    }

    public static String generateRandomAlphanumericString(int maximumLengthOfString) {
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = upperAlphabet.toLowerCase();
        String digits = "0123456789";

        String alphanumericString = upperAlphabet + lowerAlphabet + digits;
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < maximumLengthOfString; i++) {
            int index = random.nextInt(alphanumericString.length());
            randomString.append(alphanumericString.charAt(index));
        }
        return randomString.toString();
    }

    public static void displayArray(Object[] array) {
        System.out.println("==================ARRAY CONTENT==================");
        for (Object element : array) {
            System.out.println(element);
        }
        System.out.println("======================================================");
    }
}
