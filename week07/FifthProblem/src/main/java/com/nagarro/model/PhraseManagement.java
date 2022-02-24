package com.nagarro.model;

import com.nagarro.service.Convertable;

import java.util.StringTokenizer;

public class PhraseManagement implements Convertable {
    private StringTokenizer tokenizer;

    public String pigLatinPhrase(String phrase) {
        if (phrase == null) {
            throw new RuntimeException("Null reference of given phrase!");
        } else if (phrase.equals("")) {
            return "";
        }
        this.tokenizer = new StringTokenizer(phrase);
        StringBuilder sentence = new StringBuilder();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            String pigLatinizedWord = toPigLatin(token);
            sentence.append(pigLatinizedWord).append(" ");
            printPigLatinWord(token);
        }
        return sentence.toString();
    }

    public void printPigLatinWord(String token) {
        System.out.println(toPigLatin(token));
    }

    @Override
    public String toPigLatin(String word) {
        String pigLatinizedWord;
        if (word == null) {
            throw new RuntimeException("Null reference of given word!");
        } else if (word.equals("")) {
            return "";
        }
        pigLatinizedWord = word.substring(1) + word.charAt(0) + "ay";
        return pigLatinizedWord;
    }
}
