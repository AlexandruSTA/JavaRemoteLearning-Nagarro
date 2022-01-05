package com.nagarro.week2.firstProblem.utils;

import com.nagarro.week2.firstProblem.models.Character;

public class Display {

    public static void creationMessage(Character character) {
        System.out.println("Created character: " + character.toString());
    }


    public static void attackMessage(Character attacker, Character target) {
        System.out.println("================================ATTACK================================");
        System.out.println(attacker.getCharacterNameInfo() + " attacks " + target.getCharacterNameInfo());
        attributesMessage(attacker);
        attributesMessage(target);
        System.out.println("======================================================================");
    }


    public static void magicMessage(Character monster) {
        System.out.println("================================MAGIC================================");
        System.out.println(monster.getCharacterNameInfo() + " starts using magic!");
        System.out.println("======================================================================");
    }


    public static void attributesMessage(Character character) {
        System.out.println(character.getCharacterNameInfo() + "'s attributes: " + character);
    }
}
