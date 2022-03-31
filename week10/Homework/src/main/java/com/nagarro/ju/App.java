package com.nagarro.ju;

import com.nagarro.ju.models.Country;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        List<Country> countries = generateCountries(10);
        countries.add(new Country("France", "Paris"));
        System.out.println("BEFORE");
        System.out.println(countries);
        Collections.sort(countries);
        System.out.println("AFTER");
        System.out.println(countries);
        System.out.println(Collections.binarySearch(countries, new Country("France", "Paris")));
    }

    public static String generateRandomString(int length) {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = lowercase.toUpperCase();
        String alphaString = lowercase + uppercase;

        Random random = new Random();
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            randomString.append(alphaString.charAt(random.nextInt(alphaString.length())));
        }
        return randomString.toString();
    }

    public static List<Country> generateCountries(int size) {
        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            countries.add(new Country(generateRandomString(5), generateRandomString(5)));
        }
        return countries;
    }
}
