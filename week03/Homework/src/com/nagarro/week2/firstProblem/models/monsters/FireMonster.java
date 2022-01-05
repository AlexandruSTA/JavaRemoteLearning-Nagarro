package com.nagarro.week2.firstProblem.models.monsters;

import com.nagarro.week2.firstProblem.models.MagicalSkill;
import com.nagarro.week2.firstProblem.models.Monster;
import com.nagarro.week2.firstProblem.models.Race;

public class FireMonster extends Monster {

    public FireMonster(int healthPoints, int attackStrength, int defense) {
        super(healthPoints, attackStrength, defense, Race.FireDragons, MagicalSkill.Defensive);
    }

    @Override
    public void magic() {
        this.setDefense(this.getDefense() * 3);
    }
}
