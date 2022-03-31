package com.nagarro.ju;

import com.nagarro.ju.models.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountryTest {
    List<Country> countries;

    @BeforeEach
    public void initialize() {
        countries = new ArrayList<>();
        countries.add(new Country("France", "Paris"));
        countries.add(new Country("England", "London"));
        countries.add(new Country("Romania", "Bucharest"));
    }

    @Test
    public void testCountries() {
        Assertions.assertArrayEquals(
                List.of(new Country("France", "Paris"),
                        new Country("England", "London"),
                        new Country("Romania", "Bucharest")).toArray(), countries.toArray());
    }

    @Test
    public void testCountriesSortedByName() {
        Collections.sort(countries);
        Assertions.assertArrayEquals(
                List.of(new Country("England", "London"),
                        new Country("France", "Paris"),
                        new Country("Romania", "Bucharest")).toArray(), countries.toArray());
    }


}
