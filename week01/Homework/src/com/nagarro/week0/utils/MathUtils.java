package com.nagarro.week0.utils;

import java.util.Stack;

/**
 * @Author: Stanea Alexandru-Ioan
 * @Version: 1.0
 * Class which contains static methods used for mathematical and conversion purposes only
 */

public class MathUtils {

    public static int convertStringToNumber(String numberText) {
        try {
            return Integer.parseInt(numberText);
        } catch (Exception exception) {
            return 0;
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        int iterator = 2;
        while (iterator * iterator <= number) {
            if (number % iterator == 0) {
                return false;
            }
            iterator++;
        }
        return true;
    }

    public static String determineBinaryRepresentationManually(int number) {
        // Convert the number given as a parameter into binary representation using stack
        boolean isNegative = false;
        if (number < 0) {
            number = -number;
            isNegative = true;
        }

        Stack<Integer> binaryStack = determineBitsStack(number);
        String binaryRepresentation = determineBinaryRepresentationString(binaryStack);

        if (isNegative) {
            String complement = complement(binaryRepresentation, 32);
            binaryRepresentation = completeTheBinaryRepresentationWithSign(binaryRepresentationWithSign(complement), complement);
        }

        return binaryRepresentation;
    }

    public static Stack<Integer> determineBitsStack(int number) {
        Stack<Integer> binaryStack = new Stack<Integer>();
        while (number != 0) {
            int remainder = number % 2;
            number /= 2;
            binaryStack.push(remainder);
        }
        return binaryStack;
    }

    public static String complement(String binaryRepresentation, int numberOfBits) {
        // Method used for negative numbers only
        StringBuilder complementOfNumber = new StringBuilder();
        for (int i = 0; i < numberOfBits - binaryRepresentation.length(); i++) {
            complementOfNumber.append("1");
        }
        for (int i = 0; i < binaryRepresentation.length(); i++) {
            if (binaryRepresentation.charAt(i) == '0') {
                complementOfNumber.append("1");
            } else if (binaryRepresentation.charAt(i) == '1') {
                complementOfNumber.append("0");
            }
        }
        return complementOfNumber.toString();
    }

    public static String binaryRepresentationWithSign(String binaryRepresentation) {
        // Method partially determine the signed binary representation of a number
        Stack<Integer> bits = new Stack<Integer>();
        bits.push(1);
        int bitIndex = binaryRepresentation.length() - 1;
        while (Integer.parseInt(String.valueOf(binaryRepresentation.charAt(bitIndex))) != 0 && bitIndex >= 0) {
            int bitAtIndex = Integer.parseInt(String.valueOf(binaryRepresentation.charAt(bitIndex)));
            bits = (Stack<Integer>) addOneToBinaryNumber(bits, bitAtIndex).clone();
            bitIndex--;
        }
        return determineBinaryRepresentationString(bits);
    }

    public static Stack<Integer> addOneToBinaryNumber(Stack<Integer> bits, int bit) {
        // Method adds one bit to a binary number
        Stack<Integer> modifiedBits = (Stack<Integer>) bits.clone();
        modifiedBits.pop();
        if (bit == 1) {
            modifiedBits.push(0);
        }
        modifiedBits.push(1);
        return modifiedBits;
    }

    public static String completeTheBinaryRepresentationWithSign(String binaryRepresentation, String complement) {
        // Method returns the signed binary representation of an integer
        return complement.substring(0, complement.length() - binaryRepresentation.length())
                + binaryRepresentation;
    }

    public static String determineBinaryRepresentationString(Stack<Integer> bits) {
        StringBuilder binaryRepresentation = new StringBuilder();
        while (!bits.isEmpty()) {
            binaryRepresentation.append(bits.pop());
        }
        return binaryRepresentation.toString();
    }

    public static String determineBinaryRepresentationUsingJavaLibrary(int number) {
        return Integer.toBinaryString(number);
    }
}
