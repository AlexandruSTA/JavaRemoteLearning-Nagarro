package com.nagarro.week1;

import com.nagarro.week1.utils.Utils;

import java.util.Scanner;

/**
 * @author: Alexandru-Ioan Stanea
 * @version: 1.0
 * Main class of the application used to launch a console-based menu
 */

public class App {
    public static void main(String[] args) {
        System.out.println("Running the application . . .");
        appMenu(args);
    }

    public static void appMenu(String[] args) {
        menuDescription();
        int option;
        boolean runMenu = true;
        while (runMenu) {
            Scanner scanner = new Scanner(System.in);
            try {
                option = scanner.nextInt();
            } catch (Exception exc) {
                option = 0;
                runMenu = false;
            }
            switch (option) {
                case 1 -> solveFirstProblem();
                case 2 -> solveSecondProblem();
                case 3 -> solveThirdProblem();
                default -> {
                    runMenu = false;
                    System.out.println("\nExiting the application . . .");
                }
            }
            try {
                if (!runMenu) {
                    break;
                }
                System.out.println("\nPress ENTER to continue!");
                scanner = new Scanner(System.in);
                scanner.nextLine();
                menuDescription();
            } catch (Exception exc) {
                runMenu = false;
            }
        }
    }

    public static void menuDescription() {
        // Method used to display the functionalities of the application
        System.out.println("================================JavaRemoteLearning-Nagarro-Week1================================");
        System.out.println("Problems:\n");
        System.out.println("""
                1. Create a class that holds the firstname and the surname of a person. Make it have two constructors,
                one with both firstname and surname, and one with full name (we assume each individual has only one surname
                and at least one firstname separated by spaces). Test in main class.""");
        System.out.println("""
                2. Create a class called Tank that can be filled and emptied (let’s say it has acts like a stack), and has a
                termination condition that it must be empty when the object is cleaned up. Write a finalize() that verifies
                this termination condition. In main(), test the possible scenarios that can occur when your Tank is used.""");
        System.out.println("""
                3. Create a small application that demonstrates (with sysouts) the order in which constructors, local
                variables, fields, static blocks are initialized / called - consider using superclasses as well.
                """);
        System.out.println("0. Exit the application.");
        System.out.print("Choose which problem you want to solve: ");
    }

    public static void solveFirstProblem() {
        Utils.testPersonClass();
    }

    public static void solveSecondProblem() {
        Utils.testTankClass();
    }

    public static void solveThirdProblem() {
        Utils.testOrderOfCalls();
    }

}
