package com.gowri.tech.utils;
/**
 * @author -NaveenWodeyar
 * @date -21-Dec-2024
 * @time - 5:47:13 pm
 * @location -
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    // Format a Date into a String
    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    // Parse a String into a Date
    public static Date parseDate(String dateStr, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateStr);
    }

    // Get the current date
    public static Date getCurrentDate() {
        return new Date();
    }

    // Get the current date as a String in a specific format
    public static String getCurrentDateString(String format) {
        return formatDate(getCurrentDate(), format);
    }

    // Calculate the difference between two dates in days
    public static long daysBetween(Date startDate, Date endDate) {
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    // Add days to a date
    public static Date addDays(Date date, int days) {
        long timeInMillis = date.getTime() + TimeUnit.DAYS.toMillis(days);
        return new Date(timeInMillis);
    }

    // Subtract days from a date
    public static Date subtractDays(Date date, int days) {
        long timeInMillis = date.getTime() - TimeUnit.DAYS.toMillis(days);
        return new Date(timeInMillis);
    }

    // Convert Date to LocalDate (useful for Spring Data JPA, etc.)
    public static java.time.LocalDate toLocalDate(Date date) {
        return java.time.LocalDate.ofInstant(date.toInstant(), java.time.ZoneId.systemDefault());
    }

    // Convert LocalDate to Date (useful for Spring Data JPA, etc.)
    public static Date fromLocalDate(java.time.LocalDate localDate) {
        return java.util.Date.from(localDate.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
    }
}
