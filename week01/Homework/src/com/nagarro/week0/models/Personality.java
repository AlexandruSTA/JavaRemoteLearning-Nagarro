package com.nagarro.week0.models;

/**
 * @author: Alexandru-Ioan Stanea
 * @version: 1.0
 * Designed and implemented Java class used to store valuable information regarding a personality
 * The introduced class encapsulates a parametrized constructor, alongside accessories to retrieve or update properties
 * associated with the class.
 * Furthermore, toString() and equals() methods are implemented and used to display personalities in the proper way
 */

public class Personality {
    private String firstName, lastName;
    private int yearOfBirth, yearOfDeath;

    public Personality(String firstName, String lastName, int yearOfBirth, int yearOfDeath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(int yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    @Override
    public String toString() {
        if (yearOfDeath != 0) {
            return firstName + " " + lastName + " (" + yearOfBirth + ", " + yearOfDeath + ")";
        } else {
            return firstName + " " + lastName + " (" + yearOfBirth + ",-)";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personality personality = (Personality) o;
        return yearOfBirth == personality.yearOfBirth
                && yearOfDeath == personality.yearOfDeath
                && firstName.equals(personality.firstName)
                && lastName.equals(personality.lastName);
    }


}
