package com.nagarro.week0;

import com.nagarro.week0.repository.PersonalitiesRepository;
import com.nagarro.week0.utils.MathUtils;
import com.nagarro.week0.utils.ReadFromFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Author: Alexandru-Ioan Stanea
 * @Version: 1.0
 * Main class of the application used to launch a console-based menu and interact with the classes defined earlier
 *
 */

public class App {
    public static void main(String[] args) {
        // Entry point of the application
        System.out.println("Running the application . . .");
        appMenu(args);
    }

    public static void appMenu(String[] args){
        // This method displays the menu of the application and offers the option to interact with it
        // It contains a list of Strings as a parameter, which represents the arguments of the second and third problem
        menuDescription();
        int option = 0;
        boolean runMenu = true;
        // Looping as long the user inserts valid data
        while (runMenu){
            Scanner scanner = new Scanner(System.in);
            try {
                // Reading the option
                option = scanner.nextInt();
            }
            catch (Exception exc){
                // In case of exception, end the application accordingly
                option = 0;
                runMenu = false;
            }
            // Display the solution for each problem, depending on the chosen option
            switch (option){
                case 1:
                    solvingFirstProblem();
                    break;
                case 2:
                    String numberText = args[0];
                    solvingSecondProblem(MathUtils.convertStringToNumber(numberText));
                    break;
                case 3:
                    String decimalNumberText = args[1];
                    solvingThirdProblem(MathUtils.convertStringToNumber(decimalNumberText));
                    break;
                default:
                    runMenu = false;
                    System.out.println("\nExiting the application . . .");
                    break;
            }
            try {
                if (!runMenu){
                    break;
                }
                System.out.println("\nPress ENTER to continue!");
                scanner = new Scanner(System.in);
                scanner.nextLine();
                menuDescription();
            }
            catch (Exception exc){
                runMenu = false;
            }
        }
    }

    public static void menuDescription(){
        // Method used to display the functionalities of the application
        System.out.println("================================JavaRemoteLearning-Nagarro-Week0================================");
        System.out.println("Problems:\n");
        System.out.println("1. Write a small application that reads a list of personalities from a csv file (Firstname, Lastname, dob, dod)\n" +
                "and stores the information in objects. The application should filter out duplicated entries and output the\n" +
                "list of objects to the console in a human readable manner:\n" +
                "\"Firstname Lastname (dob-dod)\".");
        System.out.println("2. Write a program that prints values from 1 to custom n number, provided as an argument to the\n" +
                "application. Print the PRIME keyword near each prime number. (1, 2-PRIME, 3-PRIME, 4, …., 100).");
        System.out.println("3. Create two methods that both takes an int as an argument and returns a String object representing the\n" +
                "binary representation of the integer. Eg. given the argument 42, it should return \"101010\". The first\n" +
                "method should calculate the binary representation manually, and the other should use the functionality\n" +
                "available in the Java class libraries. The number should be supplied as argument to the main method.");
        System.out.println("0. Exit the application.");
        System.out.print("Choose which problem you want to solve: ");
    }

    public static void solvingFirstProblem(){
        // Method used to solve the first problem
        String file = new File("").getAbsolutePath();
        // Setting up the correct path where personalities information can be found
        file +="\\src\\com\\nagarro\\week0\\files\\W1P1input.txt";
        // Initialize a personalities repository
        PersonalitiesRepository personalitiesRepository = new PersonalitiesRepository();
        try {
            // and fill it with parsed objects of type Personality from the file
            personalitiesRepository.parsePersonalitiesInformationsFromString(ReadFromFile.readLinesFromTextFile(file));
            System.out.println(personalitiesRepository.toString());
        }
        catch (IOException exc){
            System.out.println("Error related to Input-Output.\nError information:" + exc.getMessage());
        }
        catch (Exception exc){
            System.out.println("Error while extracting personalities information.\nError information:" + exc.toString());
        }
    }

    public static void solvingSecondProblem(int providedNumber){
        // Method used to solve the second problem
        // If the given input is not valid, the provided number will be 0 and a specific message will be shown
        if (providedNumber == 0){
            System.out.println("\nThe provided input is not of numeric type!");
        }
        // Iterating from 1 to the provided number, and displaying, using isPrime(number) method, each prime number
        for (int i=1 ; i<=providedNumber; i++){
            String displayedInformation = Integer.toString(i);
            if (MathUtils.isPrime(i)){
                displayedInformation +="-PRIME";
            }
            System.out.println(displayedInformation);
        }
    }

    public static void solvingThirdProblem(int providedNumber){
        // Method used to solve the third problem
        // If the given input is not valid, the provided number will be 0 and a specific message will be shown
        if (providedNumber == 0){
            System.out.println("\nThe provided input is not of numeric type!");
        }
        else {
            // Otherwise, determine the binary representation of the provided number using a manually implemented algorithm
            System.out.println("\nBinary representation of " + providedNumber + " determined manually is " + MathUtils.determineBinaryRepresentationManually(providedNumber) + ".");
            // and a java library-based algorithm
            System.out.println("\nBinary representation of " + providedNumber + " determined using java library is " + MathUtils.determineBinaryRepresentationUsingJavaLibrary(providedNumber) + ".");

        }
    }
}
