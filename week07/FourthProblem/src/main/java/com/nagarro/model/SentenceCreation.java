package com.nagarro.model;

import com.nagarro.service.Makeable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SentenceCreation implements Makeable {
    List<String> articles = new ArrayList<>(Arrays.asList("the", "a", "one", "some", "any"));
    List<String> nouns = new ArrayList<>(Arrays.asList("boy", "girl", "dog", "town", "car"));
    List<String> verbs = new ArrayList<>(Arrays.asList("drove", "jumped", "ran", "walked", "skipped"));
    List<String> prepositions = new ArrayList<>(Arrays.asList("to", "from", "over", "under", "on"));


    @Override
    public Sentence createSentence() {
        Random randomIndex = new Random();
        String firstArticle = articles.get(randomIndex.nextInt(articles.size()));
        String firstNoun = nouns.get(randomIndex.nextInt(nouns.size()));
        String verb = verbs.get(randomIndex.nextInt(verbs.size()));
        String preposition = prepositions.get(randomIndex.nextInt(prepositions.size()));
        String secondArticle = articles.get(randomIndex.nextInt(articles.size()));
        String secondNoun = nouns.get(randomIndex.nextInt(nouns.size()));

        return new Sentence(firstArticle, firstNoun, verb, preposition, secondArticle, secondNoun);
    }
}
