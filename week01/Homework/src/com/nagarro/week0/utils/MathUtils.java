package com.nagarro.week0.utils;

import java.util.Stack;

/**
 * @Author: Stanea Alexandru-Ioan
 * @Version: 1.0
 * Class which contains static methods used for mathematical and conversion purposes only
 *
 */

public class MathUtils {

    public static int convertStringToNumber(String numberText){
        try {
            // If the string offered as a parameter can be parsed, return the number associated with it
            return Integer.parseInt(numberText);
        }
        catch (Exception exception){
            // Otherwise return 0
            return 0;
        }
    }

    public static boolean isPrime(int number){
        // Verify if number is a prime number
        // If the number is less than or equal with 1, then it is definitely not prime
        if (number <= 1){
            return false;
        }
        // Else, verify if the number has proper divisors
        int iterator = 2;
        while (iterator * iterator <= number){
            if (number % iterator == 0){
                return false;
            }
            iterator++;
        }
        // If not, the number is prime
        return true;
    }

    public static String determineBinaryRepresentationManually(int number){
        // Convert the number given as a parameter into binary representation using stack
        // Initializing the stack
        boolean isNegative = false;
        if (number < 0){
            number = -number;
            isNegative = true;
        }
        Stack<Integer> binaryStack = new Stack<Integer>();
        while (number != 0){
            // Extracting the remainders and adding them to the stack
            int remainder = number % 2;
            // Updating the number
            number /= 2;
            binaryStack.push(remainder);
        }

        String binaryRepresentation ="";
        while (!binaryStack.isEmpty()){
            // Using the specific structure of the stack, we can simply pop each element from the formed stack and add to an empty
            // String in order to determine the binary representation of the given number
            binaryRepresentation += Integer.toString(binaryStack.pop());
        }
        if (isNegative){
            binaryRepresentation = addOneToBinaryNumber(complement(binaryRepresentation,32));
        }

        return binaryRepresentation;
    }

    public static String complement(String binaryRepresentation, int numberOfBits) {
        // Method used for negative numbers only
        // It returns the complement of a binary number ( ex. complement(101) == 010)
        String complementOfNumber = "";
        for (int i=0; i< numberOfBits-binaryRepresentation.length(); i++){
            complementOfNumber +="1";
        }
        for (int i=0; i< binaryRepresentation.length(); i++) {
           if (binaryRepresentation.charAt(i) == '0'){
               complementOfNumber += "1";
           }
           else if (binaryRepresentation.charAt(i) == '1'){
               complementOfNumber += "0";
           }
        }
        return complementOfNumber;
    }

    public static String addOneToBinaryNumber(String binaryRepresentation){
        // Method adds one to a binary number
        // ex. addOneToBinaryNumber(100) == 101
        // Method is implemented just for binary numbers that have the right most bit equal to 0
        String updatedBinaryRepresentation = binaryRepresentation;
        updatedBinaryRepresentation = updatedBinaryRepresentation.substring(0,binaryRepresentation.length()-1) + "1";
        if (binaryRepresentation.charAt(binaryRepresentation.length()-1) == '0'){
            updatedBinaryRepresentation = updatedBinaryRepresentation.substring(0,binaryRepresentation.length()-1) + "1";
        }
        return updatedBinaryRepresentation;
    }

    public static String determineBinaryRepresentationUsingJavaLibrary(int number){
        // Convert a number into a binary representation using Java library
        return Integer.toBinaryString(number);
    }
}
