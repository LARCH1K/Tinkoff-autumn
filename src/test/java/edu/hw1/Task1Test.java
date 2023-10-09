package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {

    @Test
    @DisplayName("Test minutesToSeconds() with wrong input")
    void minutesToSecondsIfInputWrongValuesTest() {
        assertThrows(IllegalArgumentException.class, () -> Task1.minutesToSeconds("adfaw"));
        assertThrows(IllegalArgumentException.class, () -> Task1.minutesToSeconds("ff:aaa"));
        assertThrows(IllegalArgumentException.class, () -> Task1.minutesToSeconds("23:ff"));
        assertThrows(IllegalArgumentException.class, () -> Task1.minutesToSeconds("ee:44"));
        assertThrows(IllegalArgumentException.class, () -> Task1.minutesToSeconds("2f3:f4"));
    }

    @Test
    @DisplayName("Test minutesToSeconds() with incorrect input")
    void minutesToSecondsIfInputIncorrectValuesTest() {
        assertEquals(-1, Task1.minutesToSeconds("00:84"));
        assertEquals(-1, Task1.minutesToSeconds("00:60"));
        assertEquals(-1, Task1.minutesToSeconds("00:-5"));
        assertEquals(-1, Task1.minutesToSeconds("-7:24"));
    }

    @Test
    @DisplayName("Test minutesToSeconds() with random input")
    void minutesToSecondsWithRandomValuesTest() {
        assertEquals(60, Task1.minutesToSeconds("01:00"));
        assertEquals(836, Task1.minutesToSeconds("13:56"));
        assertEquals(659, Task1.minutesToSeconds("10:59"));
        assertEquals(59999, Task1.minutesToSeconds("999:59"));
    }
}
