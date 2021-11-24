package com.nagarro.week0.repository;

import com.nagarro.week0.models.Personality;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stanea Alexandru-Ioan
 * @Version: 1.0
 * Repository class used to store multiple objects of type Personality
 * As attributes, the current class contains an ArrayList of Personality which can be initialized with an already existing
 * ArrayList of Personality, or it can be filled using parsePersonalitiesInformationsFromString(String[]) method which parses
 * the list of Strings given as parameter and retrieve valuable data related to personalities
 */


public class PersonalitiesRepository {
    private List<Personality> personalities = new ArrayList<Personality>();

    public PersonalitiesRepository() {
        this.personalities = new ArrayList<Personality>();
    }

    public void parsePersonalitiesInformationsFromString(String[] personalitiesInformations) {
        String firstName, lastName;
        int yearOfBirth, yearOfDeath;
        for (String personalityInformation : personalitiesInformations) {
            String[] personalityData = personalityInformation.split(",");
            firstName = personalityData[0].trim();
            lastName = personalityData[1].trim();
            // Verifying if both years exits
            if (personalityData.length == 4) {
                yearOfBirth = Integer.parseInt(personalityData[2].trim());
                yearOfDeath = Integer.parseInt(personalityData[3].trim());
            }
            // Otherwise set yearOfDeath to 0
            else {
                yearOfBirth = Integer.parseInt(personalityData[2].trim().substring(2, 6));
                yearOfDeath = 0;
            }
            Personality personality = new Personality(firstName, lastName, yearOfBirth, yearOfDeath);
            if (!verifyDuplicate(personality)) {
                this.personalities.add(personality);
            }
        }
    }

    public boolean verifyDuplicate(Personality personality) {
        return this.personalities.contains(personality);
    }

    @Override
    public String toString() {
        StringBuilder personalitiesInformation = new StringBuilder("\n================Personalities================\n");
        int indexOfPersonality = 1;
        for (Personality personality : this.personalities) {
            personalitiesInformation.append(indexOfPersonality++).append(". ").append(personality.toString()).append("\n");
        }
        return personalitiesInformation.toString();
    }
}
