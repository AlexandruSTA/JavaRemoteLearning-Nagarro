package com.nagarro;

import com.nagarro.model.PhraseManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<String> pigLatinPhrases = new ArrayList<>();
    private static PhraseManagement phraseManagement = new PhraseManagement();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int option = 1;
        while (option > 0) {
            printMenu();
            System.out.println("Enter your option:");
            option = Integer.parseInt(readInput());
            switch (option) {
                case 1 -> pigLatinizePhrase();
                case 2 -> showAllPigLatinizedPhrases();
            }
        }
    }

    public static void createPigLatinPhrase(String phrase) {
        pigLatinPhrases.add(phraseManagement.pigLatinPhrase(phrase));
    }

    public static void pigLatinizePhrase() {
        System.out.println("Please type in a phrase without punctuation:");
        createPigLatinPhrase(readInput());
        System.out.println("Pig latinized phrase ===> " + pigLatinPhrases.get(pigLatinPhrases.size() - 1) + "\n");
    }

    public static void showAllPigLatinizedPhrases() {
        System.out.println("###########PIG LATINIZED PHRASES###########");
        for (int i = 0; i < pigLatinPhrases.size(); i++) {
            System.out.println((i + 1) + ". " + pigLatinPhrases.get(i));
        }
        System.out.println("###########################################\n\n");
    }

    public static void printMenu() {
        System.out.println("================PIG LATINIZER================\n1. Insert a phrase\n2. Show pig latinized phrases\n0. Exit");
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
