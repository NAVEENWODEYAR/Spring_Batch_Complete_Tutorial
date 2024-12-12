package com.gowri.tech.utils;
/**
 * @author -NaveenWodeyar
 * @date -12-Dec-2024
 * @time - 7:54:07 pm
 * @location -
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberFormatUtilsTest {

    @Test
    public void testFormatCurrency() {
        double amount = 12345.6789;
        String result = NumberFormatUtils.formatCurrency(amount);
        // This will depend on the locale used in the NumberFormat.getCurrencyInstance()
        // In the case of Locale.US, the result will be "$12,345.68"
        assertEquals("$12,345.68", result);
    }

    @Test
    public void testFormatPercentage() {
        double percentage = 0.2534;
        String result = NumberFormatUtils.formatPercentage(percentage);
        assertEquals("25.34%", result);
    }

    @Test
    public void testFormatWithDecimalPlaces() {
        double amount = 12345.6789;
        String result = NumberFormatUtils.formatWithDecimalPlaces(amount, 3);
        assertEquals("12,345.679", result);
    }

    @Test
    public void testFormatWithDefaultDecimals() {
        double amount = 12345.6789;
        String result = NumberFormatUtils.formatWithDefaultDecimals(amount);
        assertEquals("12,345.68", result);  // Default decimal places are 2
    }

    @Test
    public void testFormatPlain() {
        double amount = 12345.6789;
        String result = NumberFormatUtils.formatPlain(amount);
        assertEquals("12345.68", result);  // No grouping and up to 2 decimals
    }

    @Test
    public void testFormatCustom() {
        double amount = 12345.6789;
        String result = NumberFormatUtils.formatCustom(amount, "###,###.###");
        assertEquals("12,345.679", result);
    }

    @Test
    public void testFormatCurrencyWithNegativeAmount() {
        double amount = -12345.6789;
        String result = NumberFormatUtils.formatCurrency(amount);
        // This will depend on the locale used, but the expected format should handle negative amounts
        assertEquals("-$12,345.68", result); // The negative sign is correctly applied
    }

    @Test
    public void testFormatPercentageWithZero() {
        double percentage = 0.0;
        String result = NumberFormatUtils.formatPercentage(percentage);
        assertEquals("0%", result); // Expect 0% for zero value
    }

    @Test
    public void testFormatWithDecimalPlacesNoDecimal() {
        double amount = 1000.0;
        String result = NumberFormatUtils.formatWithDecimalPlaces(amount, 3);
        assertEquals("1,000.000", result);  // It should show three decimals even if the number is a whole number
    }

    @Test
    public void testFormatWithCustomPattern() {
        double amount = 1234567.89123;
        String result = NumberFormatUtils.formatCustom(amount, "#,###.##");
        assertEquals("1,234,567.89", result); // Custom pattern with 2 decimals
    }
}
