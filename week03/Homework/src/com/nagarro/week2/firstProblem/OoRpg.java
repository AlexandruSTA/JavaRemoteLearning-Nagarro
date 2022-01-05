package com.nagarro.week2.firstProblem;

import com.nagarro.week2.firstProblem.models.Character;
import com.nagarro.week2.firstProblem.models.Hero;
import com.nagarro.week2.firstProblem.models.monsters.FireMonster;
import com.nagarro.week2.firstProblem.models.monsters.RockMonster;
import com.nagarro.week2.firstProblem.services.ICharacter;
import com.nagarro.week2.firstProblem.utils.Display;

public class OoRpg {
    public static void main(String[] args) {
        play();
    }

    public static void play() throws RuntimeException {
        try {
            Character hero = new Hero(100, 10, 10, 0, "Chuck");
            Display.creationMessage(hero);
            RockMonster rockMonster = new RockMonster(30, 8, 10);
            Display.creationMessage(rockMonster);
            Character fireMonster = new FireMonster(50, 6, 10);
            Display.creationMessage(fireMonster);

            ICharacter.attack(hero, rockMonster);
            Display.attackMessage(hero, rockMonster);

            rockMonster.magic();
            Display.magicMessage(rockMonster);
            Display.attributesMessage(rockMonster);

            ICharacter.attack(hero, rockMonster);
            Display.attackMessage(hero, rockMonster);

            ICharacter.attack(fireMonster, hero);
            Display.attackMessage(fireMonster, hero);

            ICharacter.attack(hero, fireMonster);
            Display.attackMessage(hero, fireMonster);

            ICharacter.attack(hero, hero);
        } catch (RuntimeException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
