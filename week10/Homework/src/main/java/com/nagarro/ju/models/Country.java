package com.nagarro.ju.models;

import java.util.Objects;

public class Country implements Comparable<Country> {
    protected String name, capital;

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public int compareTo(Country country) {
        return this.name.compareTo(country.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) && Objects.equals(capital, country.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital);
    }

    @Override
    public String toString() {
        return "\n======Country======\nName: " + name + "\nCapital: " + capital + "\n==================";
    }
}
