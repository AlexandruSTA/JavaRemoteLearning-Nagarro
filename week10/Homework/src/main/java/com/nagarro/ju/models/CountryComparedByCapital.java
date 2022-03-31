package com.nagarro.ju.models;

public class CountryComparedByCapital extends Country {
    public CountryComparedByCapital(String name, String capital) {
        super(name, capital);
    }

    @Override
    public int compareTo(Country country) {
        return this.capital.compareTo(country.capital);
    }
}
