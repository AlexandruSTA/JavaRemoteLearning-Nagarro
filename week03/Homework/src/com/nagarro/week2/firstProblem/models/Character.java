package com.nagarro.week2.firstProblem.models;

import com.nagarro.week2.firstProblem.services.ICharacter;

import java.util.Objects;

public abstract class Character implements ICharacter {
    protected int healthPoints, attackStrength, defense;

    public Character(int healthPoints, int attackStrength, int defense) {
        this.healthPoints = healthPoints;
        this.attackStrength = attackStrength;
        this.defense = defense;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public abstract String getCharacterNameInfo();

    @Override
    public String toString() {
        return "HP = " + this.getHealthPoints() + ", ATK = " + this.getAttackStrength() + ", DEF = " + this.getDefense();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return healthPoints == character.healthPoints && attackStrength == character.attackStrength && defense == character.defense;
    }

    @Override
    public int hashCode() {
        return Objects.hash(healthPoints, attackStrength, defense);
    }
}
