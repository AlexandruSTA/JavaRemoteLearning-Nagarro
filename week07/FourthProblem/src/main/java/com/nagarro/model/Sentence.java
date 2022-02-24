package com.nagarro.model;

public class Sentence {
    private final String firstArticle, firstNoun, verb, preposition, secondArticle, secondNoun;

    public Sentence(String firstArticle, String firstNoun, String verb, String preposition, String secondArticle, String secondNoun) {
        this.firstArticle = firstArticle;
        this.firstNoun = firstNoun;
        this.verb = verb;
        this.preposition = preposition;
        this.secondArticle = secondArticle;
        this.secondNoun = secondNoun;
    }

    private String capitalize(String toCapitalize) {
        String firstLetter = toCapitalize.substring(0, 1).toUpperCase();
        return firstLetter + toCapitalize.substring(1);
    }

    @Override
    public String toString() {
        return capitalize(firstArticle) + " " + firstNoun + " " + verb + " " + preposition + " " + secondArticle + " " + secondNoun + ". ";
    }
}
