package com.gowri.tech.utils;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

/**
 * @author -NaveenWodeyar
 * @date -23-Dec-2024
 * @time - 11:21:00 pm
 * @location -
 */

@Component
public class NumberUtil {

    // Check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Calculate the factorial of a number
    public static long factorial(int number) {
        if (number == 0) return 1;
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    // Convert number to formatted string with commas for thousands
    public static String formatNumberWithCommas(long number) {
        return String.format("%,d", number);
    }

    // Check if a number is positive
    public static boolean isPositive(int number) {
        return number > 0;
    }

    // Check if a number is negative
    public static boolean isNegative(int number) {
        return number < 0;
    }

    // Round a decimal number to 2 decimal places
    public static BigDecimal roundToTwoDecimalPlaces(BigDecimal number) {
        return number.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    // Convert string to number safely (returns null if conversion fails)
    public static Integer safeParseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // Add two numbers
    public static int add(int a, int b) {
        return a + b;
    }

    // Subtract two numbers
    public static int subtract(int a, int b) {
        return a - b;
    }

    // Multiply two numbers
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Divide two numbers and return result as double
    public static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }

    // Check if a number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Check if a number is odd
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
