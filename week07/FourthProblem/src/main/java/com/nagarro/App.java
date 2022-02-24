package com.nagarro;

import com.nagarro.model.SentenceCreation;

public class App {
    public static void main(String[] args) {
        SentenceCreation sentenceCreation = new SentenceCreation();
        System.out.println(generateSentences(sentenceCreation, 20));
    }

    public static String generateSentences(SentenceCreation sentenceCreation, int numberOfSentences) {
        String createdSentence = "";
        for (int i = 0; i < numberOfSentences; i++) {
            createdSentence += sentenceCreation.createSentence();
        }
        return createdSentence;
    }
}
