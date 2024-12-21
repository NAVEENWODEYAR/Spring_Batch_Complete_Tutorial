package com.gowri.tech.utils;
/**
 * @author -NaveenWodeyar
 * @date -21-Dec-2024
 * @time - 5:54:37 pm
 * @location -
 */
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DateUtilsTest {

    @Test
    public void testFormatDate() {
        Date date = new Date();
        String formattedDate = DateUtils.formatDate(date, "yyyy-MM-dd");
        assertNotNull(formattedDate);
        assertTrue(formattedDate.matches("\\d{4}-\\d{2}-\\d{2}"));
    }

    @Test
    public void testParseDate() throws ParseException {
        String dateStr = "2024-12-21";
        Date parsedDate = DateUtils.parseDate(dateStr, "yyyy-MM-dd");
        assertNotNull(parsedDate);
        assertEquals("2024-12-21", DateUtils.formatDate(parsedDate, "yyyy-MM-dd")); // Ensure parsing is correct
    }

    @Test
    public void testDaysBetween() throws ParseException {
        Date startDate = DateUtils.parseDate("2024-12-20", "yyyy-MM-dd");
        Date endDate = DateUtils.parseDate("2024-12-21", "yyyy-MM-dd");
        long days = DateUtils.daysBetween(startDate, endDate);
        assertEquals(1, days); // 2024-12-21 - 2024-12-20 = 1 day
    }

    @Test
    public void testAddDays() {
        Date currentDate = new Date();
        Date futureDate = DateUtils.addDays(currentDate, 5);
        assertNotNull(futureDate);
        assertTrue(futureDate.after(currentDate)); // The future date should be after the current date
    }

    @Test
    public void testSubtractDays() {
        Date currentDate = new Date();
        Date pastDate = DateUtils.subtractDays(currentDate, 5);
        assertNotNull(pastDate);
        assertTrue(pastDate.before(currentDate)); // The past date should be before the current date
    }

    @Test
    public void testToLocalDateAndFromLocalDate() {
        Date currentDate = new Date();
        java.time.LocalDate localDate = DateUtils.toLocalDate(currentDate);
        assertNotNull(localDate);

        Date convertedDate = DateUtils.fromLocalDate(localDate);
        assertNotNull(convertedDate);
        assertEquals(DateUtils.formatDate(currentDate, "yyyy-MM-dd"), DateUtils.formatDate(convertedDate, "yyyy-MM-dd"));
    }

    @Test
    public void testGetCurrentDateString() {
        String currentDateString = DateUtils.getCurrentDateString("yyyy-MM-dd HH:mm:ss");
        assertNotNull(currentDateString);
        assertTrue(currentDateString.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")); // Ensure the format is correct
    }

    @Test
    public void testGetCurrentDate() {
        Date currentDate = DateUtils.getCurrentDate();
        assertNotNull(currentDate);
    }
}
