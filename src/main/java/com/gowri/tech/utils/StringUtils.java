package com.gowri.tech.utils;

import java.util.Optional;
import java.util.function.Function;

/**
 * Utility class for string operations.
 * 
 * @author Naveen Wodeyar
 * @date 28-Oct-2024
 * @time 7:22:56 PM
 */
public class StringUtils {

    /**
     * Checks if a string is null or empty.
     *
     * @param str the string to check
     * @return true if the string is null or empty, false otherwise
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * Capitalizes the first letter of a string.
     *
     * @param str the string to capitalize
     * @return the capitalized string
     */
    public static String capitalize(String str) {
        if (isNullOrEmpty(str)) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * Trims whitespace from both ends of the string.
     *
     * @param str the string to trim
     * @return the trimmed string
     */
    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    /**
     * Reverses a string.
     *
     * @param str the string to reverse
     * @return the reversed string
     */
    public static String reverse(String str) {
        if (isNullOrEmpty(str)) {
            return str;
        }
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Counts the number of occurrences of a substring within a string.
     *
     * @param str the string to search
     * @param substr the substring to count
     * @return the count of occurrences
     */
    public static int countOccurrences(String str, String substr) {
        if (isNullOrEmpty(str) || isNullOrEmpty(substr)) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substr, index)) != -1) {
            count++;
            index += substr.length();
        }
        return count;
    }

    /**
     * Joins an array of strings with a given delimiter.
     *
     * @param strings the array of strings to join
     * @param delimiter the delimiter to use
     * @return the joined string
     */
    public static String join(String[] strings, String delimiter) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        StringBuilder joined = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            joined.append(strings[i]);
            if (i < strings.length - 1) {
                joined.append(delimiter);
            }
        }
        return joined.toString();
    }

    /**
     * Gets the value of a string, returning an empty string if the input is null.
     *
     * @param value the input string
     * @return the input string or an empty string if null
     */
    public static String getValue(String value) {
        return value == null ? "" : value;
    }

    /**
     * Compares two strings for equality.
     *
     * @param s1 the first string
     * @param s2 the second string
     * @return true if both strings are equal, false otherwise
     */
    public static boolean stringCompare(String s1, String s2) {
        return (s1 == null ? s2 == null : s1.equals(s2));
    }
    
    public static String lowecase(String str) {
        if (isNullOrEmpty(str)) {
            return str;
        }
        return str.substring(0, 1).toLowerCase()+ str.substring(1);
    }
    
 // In your StringUtils class
    public static <T> Optional<T> safeTransform(String str, Function<String, T> transformer) {
        return Optional.ofNullable(str).map(transformer);
    }
    
}
