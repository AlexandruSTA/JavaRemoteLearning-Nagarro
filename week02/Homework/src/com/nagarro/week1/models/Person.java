package com.nagarro.week1.models;

import java.util.Objects;

/**
 * @author: Alexandru-Ioan Stanea
 * @version: 1.0
 * Designed and implemented Java class used to store valuable information regarding a person
 */

public class Person {
    private String firstName, surName;

    public Person() {
        this("","");
    }

    public Person(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    public Person(String fullName) {
        extractFirstNameAndSurnameFromFullName(fullName);
    }

    private void extractFirstNameAndSurnameFromFullName(String fullName) {
        this.firstName = "";
        String[] nameParts = fullName.split(" ");
        for (int nameIndex = 0; nameIndex < nameParts.length - 1; nameIndex++) {
            this.firstName += nameParts[nameIndex] + " ";
        }
        this.surName = nameParts[nameParts.length - 1];
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surName;
    }

    public void setSurname(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        if (this.firstName == null || this.surName == null) return "Person details are missing!\n";
        return !this.firstName.equals("") || !this.surName.equals("")
                ? "\nFirst name: " + this.firstName + "\nSurname: " + this.surName + "\nHash Code: " + this.hashCode() + "\n"
                : "Person details are missing!\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(surName, person.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surName);
    }
}
