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
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    // Format a Date into a String (using DateTimeFormatter for thread-safety)
    public static String formatDate(Date date, String format) {
        if (date == null) {
            return ""; 
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    // Parse a String into a Date
    public static Date parseDate(String dateStr, String format) throws ParseException {
        if (dateStr == null || format == null) {
            throw new IllegalArgumentException("Date string or format cannot be null");
        }
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
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    // Add days to a date
    public static Date addDays(Date date, int days) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        long timeInMillis = date.getTime() + TimeUnit.DAYS.toMillis(days);
        return new Date(timeInMillis);
    }

    // Subtract days from a date
    public static Date subtractDays(Date date, int days) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        long timeInMillis = date.getTime() - TimeUnit.DAYS.toMillis(days);
        return new Date(timeInMillis);
    }

    // Convert Date to LocalDate (useful for Spring Data JPA, etc.)
    public static LocalDate toLocalDate(Date date) {
        if (date == null) {
            return null; 
        }
        return LocalDate.ofInstant(date.toInstant(), java.time.ZoneId.systemDefault());
    }

    // Convert LocalDate to Date (useful for Spring Data JPA, etc.)
    public static Date fromLocalDate(LocalDate localDate) {
        if (localDate == null) {
            return null; 
        }
        return java.util.Date.from(localDate.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
    }

    // Optional: Utility to handle LocalDateTime (Java 17+)
    public static LocalDateTime parseLocalDateTime(String dateStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateStr, formatter);
    }

    public static String formatLocalDateTime(LocalDateTime dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }

    // Convert LocalDateTime to Date (for legacy use with APIs that require java.util.Date)
    public static Date fromLocalDateTime(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;  
        }
        return java.util.Date.from(localDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant());
    }

    // Convert Date to LocalDateTime (for legacy use with APIs that require java.util.Date)
    public static LocalDateTime toLocalDateTime(Date date) {
        if (date == null) {
            return null;  
        }
        return LocalDateTime.ofInstant(date.toInstant(), java.time.ZoneId.systemDefault());
    }
}
