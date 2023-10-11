package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    @DisplayName("Test isPalindromeDescendant() with 1-digit number")
    void isPalindromeDescendantIfInputOneDigitNumberTest() {
        assertFalse(Task5.isPalindromeDescendant(0));
        assertFalse(Task5.isPalindromeDescendant(2));
        assertFalse(Task5.isPalindromeDescendant(7));
    }

    @Test
    @DisplayName("Test isPalindromeDescendant() with random values returns true")
    void isPalindromeDescendantWithRandomValuesReturnsTrueTest() {
        assertTrue(Task5.isPalindromeDescendant(11211230));
        assertTrue(Task5.isPalindromeDescendant(13001120));
        assertTrue(Task5.isPalindromeDescendant(23336014));
        assertTrue(Task5.isPalindromeDescendant(545));
        assertTrue(Task5.isPalindromeDescendant(11));
    }

    @Test
    @DisplayName("Test isPalindromeDescendant() with random values returns false")
    void isPalindromeDescendantWithRandomValuesReturnsFalseTest() {
        assertFalse(Task5.isPalindromeDescendant(11717440));
        assertFalse(Task5.isPalindromeDescendant(25783928));
        assertFalse(Task5.isPalindromeDescendant(28742722));
        assertFalse(Task5.isPalindromeDescendant(678));
        assertFalse(Task5.isPalindromeDescendant(41));
    }
}
