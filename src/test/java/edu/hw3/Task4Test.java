package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task4.convertToRoman;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task4Test {

    @Test
    @DisplayName("Test from task")
    void convertToRomanTaskTest() {
        assertEquals("II", convertToRoman(2));
        assertEquals("XII", convertToRoman(12));
        assertEquals("XVI", convertToRoman(16));
    }

    @Test
    @DisplayName("Test with random values")
    void convertToRomanTest() {
        assertEquals("CCCXXV", convertToRoman(325));
        assertEquals("MCCXXXIV", convertToRoman(1234));
        assertEquals("MMMCMXCIX", convertToRoman(3999));
    }

    @Test
    @DisplayName("Test with throws exception if input wrong values")
    void convertToRomanThrowExceptionIfInputWrongValuesTest() {
        assertThrows(IllegalArgumentException.class, () -> convertToRoman(0));
        assertThrows(IllegalArgumentException.class, () -> convertToRoman(-8));
        assertThrows(IllegalArgumentException.class, () -> convertToRoman(4000));
    }
}
