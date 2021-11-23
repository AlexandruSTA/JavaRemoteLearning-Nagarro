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
 *
 */


public class PersonalitiesRepository {
    private List<Personality> personalities = new ArrayList<Personality>();
    public PersonalitiesRepository(){
        this.personalities = new ArrayList<Personality>();
    }

    public PersonalitiesRepository(List<Personality> personalities){
        this.personalities = personalities;
    }

    public void parsePersonalitiesInformationsFromString(String[] personalitiesInformations){
        // Initialize data related to a Personality object
        String firstName,lastName;
        int yearOfBirth,yearOfDeath;
        // Loop through each String within the list of Strings
        for (String personalityInformation : personalitiesInformations){
            String[] personalityData = personalityInformation.split(",");
            // Trim in case of extra white spaces
            firstName = personalityData[0].trim();
            lastName = personalityData[1].trim();
            // Verifying if both years exits
            if (personalityData.length == 4 ) {
                yearOfBirth = Integer.parseInt(personalityData[2].trim());
                yearOfDeath = Integer.parseInt(personalityData[3].trim());
            }
            // Otherwise set yearOfDeath to 0
            else{
                yearOfBirth = Integer.parseInt(personalityData[2].trim().substring(2,6));
                yearOfDeath = 0;
            }
            Personality personality = new Personality(firstName,lastName,yearOfBirth,yearOfDeath);
            // Add the personality to the list if it does not exist yet
            if (!verifyDuplicate(personality)) {
                this.personalities.add(personality);
            }
        }
    }


    public boolean verifyDuplicate(Personality personality){
        // Verify if a specific personality exists in the current list of personalities using method equals() present
        // in Personality class
        return this.personalities.contains(personality);
    }

    @Override
    public String toString() {
        String personalitiesInformation = "\n================Personalities================\n";
        int indexOfPersonality = 1;
        for (Personality personality : this.personalities){
            personalitiesInformation += indexOfPersonality++ + ". " + personality.toString()+"\n";
        }
        return personalitiesInformation;
    }
}
