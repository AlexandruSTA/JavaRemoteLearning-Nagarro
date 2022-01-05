package com.nagarro.week2.thirdProblem.services;

import com.nagarro.week2.thirdProblem.models.Guitarist;

public interface IBand {
    void addGuitarist(Guitarist guitarist);

    void removeGuitarist(Guitarist guitarist);
}
