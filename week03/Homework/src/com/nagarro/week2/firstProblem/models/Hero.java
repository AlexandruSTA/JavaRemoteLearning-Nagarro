package com.nagarro.week2.firstProblem.models;

import java.util.Objects;

public class Hero extends Character {
    private final String name;
    private int experiencePoints;

    public Hero(int healthPoints, int attackStrength, int defense, int experiencePoints, String name) {
        super(healthPoints, attackStrength, defense);
        this.experiencePoints = experiencePoints;
        this.name = name;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getCharacterNameInfo() {
        return this.getName();
    }

    @Override
    public String toString() {
        return "Hero => NAME: " + this.getName() + ", XP = " + this.getExperiencePoints() + ", " + super.toString() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hero hero = (Hero) o;
        return experiencePoints == hero.experiencePoints && Objects.equals(name, hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experiencePoints, name);
    }

}
