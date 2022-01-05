package com.nagarro.week2.firstProblem.models.monsters;

import com.nagarro.week2.firstProblem.models.MagicalSkill;
import com.nagarro.week2.firstProblem.models.Monster;
import com.nagarro.week2.firstProblem.models.Race;

public class RockMonster extends Monster {

    public RockMonster(int healthPoints, int attackStrength, int defense) {
        super(healthPoints, attackStrength, defense, Race.RockCyclops, MagicalSkill.Physical);
    }

    @Override
    public void magic() {
        this.setAttackStrength(this.getAttackStrength() * 2);
        this.setHealthPoints(this.getHealthPoints() + 5);
    }

}
