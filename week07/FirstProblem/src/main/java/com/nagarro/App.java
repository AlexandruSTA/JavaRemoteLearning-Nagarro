package com.nagarro;

import com.nagarro.model.EmailAddressField;
import com.nagarro.model.Field;
import com.nagarro.model.PasswordField;
import com.nagarro.model.PhoneNumberField;
import com.nagarro.service.EmailAddressValidator;
import com.nagarro.service.PasswordValidator;
import com.nagarro.service.PhoneNumberValidator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int option = 1;
        while (option > 0) {
            printMenu();
            System.out.println("Enter your option:");
            option = Integer.parseInt(readInput());
            switch (option) {
                case 1 -> emailAddressValidation();
                case 2 -> passwordValidation();
                case 3 -> phoneNumberValidation();
            }
        }
    }

    public static void emailAddressValidation() {
        System.out.println("Please enter a string: ");
        String possibleEmailAddress = readInput();

        EmailAddressField emailAddressField = new EmailAddressField(possibleEmailAddress);
        EmailAddressValidator emailAddressValidator = new EmailAddressValidator();
        boolean isEmailAddress = emailAddressValidator.isEmailAddress(emailAddressField);

        printValidation(emailAddressField, isEmailAddress);
    }

    public static void passwordValidation() {
        System.out.println("Please enter a string: ");
        String possiblePassword = readInput();

        PasswordField passwordField = new PasswordField(possiblePassword);
        PasswordValidator passwordValidator = new PasswordValidator();
        boolean isPassword = passwordValidator.isPassword(passwordField);

        printValidation(passwordField, isPassword);
    }

    public static void phoneNumberValidation() {
        System.out.println("Please enter a string: ");
        String possiblePhoneNumber = readInput();

        PhoneNumberField phoneNumberField = new PhoneNumberField(possiblePhoneNumber);
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
        boolean isPhoneNumber = phoneNumberValidator.isPhoneNumber(phoneNumberField);

        printValidation(phoneNumberField, isPhoneNumber);
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void printValidation(Field field, boolean isSpecificField) {
        if (isSpecificField) {
            System.out.println(field.getValue() + " is a valid " + field.getType() + ".\n");
        } else {
            System.out.println(field.getValue() + " is an invalid " + field.getType() + ".\n");
        }
    }

    public static void printMenu() {
        System.out.println("================Field Validator================\n1. Validate an email address\n2. Validate a password\n3. Validate a phone number\n0. Exit");
    }
}
