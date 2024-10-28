package com.gowri.tech.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * @author -NaveenWodeyar
 * @date -28-Oct-2024
 * @time - 7:25:36 pm
 * @location -
 */
class StringUtilsTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	

    @Test
    void testIsNullOrEmpty() {
        assertTrue(StringUtils.isNullOrEmpty(null));
        assertTrue(StringUtils.isNullOrEmpty(""));
        assertFalse(StringUtils.isNullOrEmpty("Hello"));
    }

    @Test
    void testCapitalize() {
        assertEquals("Hello", StringUtils.capitalize("hello"));
        assertEquals("A", StringUtils.capitalize("a"));
        assertEquals("", StringUtils.capitalize(""));
        assertNull(StringUtils.capitalize(null));
    }

    @Test
    void testTrim() {
        assertEquals("Hello", StringUtils.trim("  Hello  "));
        assertEquals("", StringUtils.trim("   "));
        assertNull(StringUtils.trim(null));
    }

    @Test
    void testReverse() {
        assertEquals("olleH", StringUtils.reverse("Hello"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null));
    }

    @Test
    void testCountOccurrences() {
        assertEquals(2, StringUtils.countOccurrences("Hello World", "o"));
        assertEquals(0, StringUtils.countOccurrences("Hello World", "x"));
        assertEquals(0, StringUtils.countOccurrences(null, "o"));
        assertEquals(0, StringUtils.countOccurrences("Hello World", null));
    }

    @Test
    void testJoin() {
        assertEquals("Hello, World", StringUtils.join(new String[]{"Hello", "World"}, ", "));
        assertEquals("", StringUtils.join(new String[]{}, ", "));
        assertEquals("Hello", StringUtils.join(new String[]{"Hello"}, ", "));
        assertEquals("", StringUtils.join(null, ", "));
    }

    @Test
    void testGetValue() {
        assertEquals("", StringUtils.getValue(null));
        assertEquals("Hello", StringUtils.getValue("Hello"));
    }

    @Test
    void testStringCompare() {
        assertTrue(StringUtils.stringCompare("Hello", "Hello"));
        assertFalse(StringUtils.stringCompare("Hello", "World"));
        assertTrue(StringUtils.stringCompare(null, null));
        assertFalse(StringUtils.stringCompare(null, "Hello"));
        assertFalse(StringUtils.stringCompare("Hello", null));
    }

}
