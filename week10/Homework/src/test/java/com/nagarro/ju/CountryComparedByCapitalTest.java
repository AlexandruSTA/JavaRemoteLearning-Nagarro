package com.nagarro.ju;

import com.nagarro.ju.models.CountryComparedByCapital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountryComparedByCapitalTest {
    List<CountryComparedByCapital> countries;

    @BeforeEach
    public void initialize() {
        countries = new ArrayList<>();
        countries.add(new CountryComparedByCapital("France", "Paris"));
        countries.add(new CountryComparedByCapital("England", "London"));
        countries.add(new CountryComparedByCapital("Romania", "Bucharest"));
    }

    @Test
    public void testCountries() {
        Assertions.assertArrayEquals(
                List.of(new CountryComparedByCapital("France", "Paris"),
                        new CountryComparedByCapital("England", "London"),
                        new CountryComparedByCapital("Romania", "Bucharest")).toArray(), countries.toArray());
    }

    @Test
    public void testCountriesSortedByCapital() {
        Collections.sort(countries);
        Assertions.assertArrayEquals(
                List.of(new CountryComparedByCapital("Romania", "Bucharest"),
                        new CountryComparedByCapital("England", "London"),
                        new CountryComparedByCapital("France", "Paris")).toArray(), countries.toArray());
    }

    @Test
    public void testCountriesBinarySearchKeyFound() {
        Collections.sort(countries);
        Assertions.assertEquals(2,
                Collections.binarySearch(countries, new CountryComparedByCapital("France", "Paris")));
    }

    @Test
    public void testCountriesBinarySearchKeyNotFound() {
        Collections.sort(countries);
        countries.remove(2);
        Assertions.assertTrue(Collections.binarySearch(countries, new CountryComparedByCapital("France", "Paris")) < 0);
    }


}
