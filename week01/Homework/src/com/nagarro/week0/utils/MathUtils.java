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

        Stack<Integer> binaryStack = determineBitsStack(number);
        String binaryRepresentation =determineBinaryRepresentationString(binaryStack);

        if (isNegative){
            String complement = complement(binaryRepresentation,32);
            binaryRepresentation = completeTheBinaryRepresentationWithSign(binaryRepresentationWithSign(complement), complement);
        }

        return binaryRepresentation;
    }

    public static Stack<Integer> determineBitsStack(int number){
        // Method stores the binary representation of a number within a stack of bits
        Stack<Integer> binaryStack = new Stack<Integer>();
        while (number != 0){
            // Extracting the remainders and adding them to the stack
            int remainder = number % 2;
            // Updating the number
            number /= 2;
            binaryStack.push(remainder);
        }
        return binaryStack;
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

    public static String binaryRepresentationWithSign(String binaryRepresentation){
        // Method partially determine the signed binary representation of a number
        Stack<Integer> bits = new Stack<Integer>();
        bits.push(1);
        int bitIndex = binaryRepresentation.length()-1;
        while (Integer.parseInt(String.valueOf(binaryRepresentation.charAt(bitIndex))) != 0  && bitIndex >=0 ){
            int bitAtIndex = Integer.parseInt(String.valueOf(binaryRepresentation.charAt(bitIndex)));
            bits = (Stack<Integer>) addOneToBinaryNumber(bits,bitAtIndex).clone();
            bitIndex--;
        }
        return determineBinaryRepresentationString(bits);
    }

    public static Stack<Integer> addOneToBinaryNumber(Stack<Integer> bits, int bit){
        // Method adds one bit to a binary number
        Stack<Integer> modifiedBits = (Stack<Integer>) bits.clone();
        modifiedBits.pop();
        if (bit == 1){
            modifiedBits.push(0);
        }
        modifiedBits.push(1);
        return modifiedBits;
    }

    public static String completeTheBinaryRepresentationWithSign(String binaryRepresentation, String complement){
        // Method returns the signed binary representation of an integer
        return complement.substring(0,complement.length()-binaryRepresentation.length())
                                            + binaryRepresentation;
    }

    public static String determineBinaryRepresentationString(Stack<Integer> bits){
        String binaryRepresentation = "";
        while (!bits.isEmpty()){
            // Using the specific structure of the stack, we can simply pop each element from the formed stack and add to an empty
            // String in order to determine the binary representation of the given number
            binaryRepresentation += Integer.toString(bits.pop());
        }
        return binaryRepresentation;
    }

    public static String determineBinaryRepresentationUsingJavaLibrary(int number){
        // Convert a number into a binary representation using Java library
        return Integer.toBinaryString(number);
    }
}
