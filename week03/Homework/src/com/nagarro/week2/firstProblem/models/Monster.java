package com.nagarro.week2.firstProblem.models;

import com.nagarro.week2.firstProblem.services.ICharacter;
import com.nagarro.week2.firstProblem.services.IMagic;

import java.util.Objects;

public abstract class Monster extends Character implements ICharacter, IMagic {
    protected Race race;
    protected MagicalSkill magicalSkill;

    public Monster(int healthPoints, int attackStrength, int defense, Race race, MagicalSkill magicalSkill) {
        super(healthPoints, attackStrength, defense);
        this.race = race;
        this.magicalSkill = magicalSkill;
    }

    public Race getRace() {
        return race;
    }

    @Override
    public String getCharacterNameInfo() {
        return this.getRace().toString();
    }

    @Override
    public String toString() {
        return "Monster => RACE = " + this.getRace() + ", " + super.toString() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monster monster = (Monster) o;
        return race == monster.race;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), race);
    }
}
