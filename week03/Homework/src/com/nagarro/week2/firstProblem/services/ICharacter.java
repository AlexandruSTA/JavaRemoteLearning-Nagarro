package com.nagarro.week2.firstProblem.services;

import com.nagarro.week2.firstProblem.models.Character;
import com.nagarro.week2.firstProblem.models.Hero;


public interface ICharacter {
    static void attack(Character attacker, Character target) {
        if (attacker.getClass().getName().equals(target.getClass().getName())) {
            throw new RuntimeException("Attacker must be of different type than target!");
        }
        
        int attackerAttackStrength = attacker.getAttackStrength();

        if (target.getDefense() > attackerAttackStrength) {
            target.setDefense(target.getDefense() - attackerAttackStrength);
        } else {
            attackerAttackStrength -= target.getDefense();
            target.setDefense(0);
        }

        if (target.getHealthPoints() > 0 && attackerAttackStrength > 0 && target.getDefense() == 0) {
            target.setHealthPoints(target.getHealthPoints() - attackerAttackStrength);
            try {
                Hero hero = (Hero) attacker;
                hero.setExperiencePoints(hero.getExperiencePoints() + hero.getAttackStrength());
            } catch (Exception exc) {
                System.out.println("Attacker is not a hero!");
            }
        }
    }
}
