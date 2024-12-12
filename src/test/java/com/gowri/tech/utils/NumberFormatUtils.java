package com.gowri.tech.utils;
/**
 * @author -NaveenWodeyar
 * @date -12-Dec-2024
 * @time - 7:52:23 pm
 * @location -
 */
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatUtils {

    // Format number as a currency (default to USD)
    public static String formatCurrency(double amount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyFormat.format(amount);
    }

    // Format number as a percentage
    public static String formatPercentage(double amount) {
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2); // Set to 2 decimal places
        return percentFormat.format(amount);
    }

    // Format number with a specific number of decimal places
    public static String formatWithDecimalPlaces(double amount, int decimalPlaces) {
        String pattern = "###,###." + "0".repeat(decimalPlaces);
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(amount);
    }

    // Format number with a default number of decimal places (2 decimal places)
    public static String formatWithDefaultDecimals(double amount) {
        return formatWithDecimalPlaces(amount, 2);
    }

    // Format number as a plain number (no grouping, no decimals)
    public static String formatPlain(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(amount);
    }

    // Format a number with custom grouping separator and decimal places
    public static String formatCustom(double amount, String pattern) {
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(amount);
    }
}

