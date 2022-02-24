package com.nagarro.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Titlelization implements Titlelizer {

    private List<String> ignoredWords = new ArrayList<String>(Arrays.asList("the", "a", "to", "in", "of", "is"));

    public String titlelize(String toTitlelize) {
        String titlelizedString = "";
        if (toTitlelize == null) {
            throw new IllegalArgumentException();
        } else if (toTitlelize.equals("")) {
            return "";
        }
        List<String> splittedString = Arrays.asList(toTitlelize.split(" "));
        for (String word : splittedString) {
            if (!ignoredWords.contains(word)) {
                titlelizedString += capitalize(word) + " ";
            } else {
                titlelizedString += word + " ";
            }
        }

        return titlelizedString.substring(0, titlelizedString.length() - 1);
    }

    public String capitalize(String toCapitalize) {
        String firstLetter = toCapitalize.substring(0, 1).toUpperCase();
        return firstLetter + toCapitalize.substring(1);
    }
}
