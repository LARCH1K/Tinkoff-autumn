package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task7Test {

    @Test
    @DisplayName("Test rotateRight() if input number low then 1 or shift low then 0")
    void rotateRightIfInputWrongNumberOrShiftTest() {
        assertThrows(IllegalArgumentException.class, () -> Task7.rotateRight(0, 3));
        assertThrows(IllegalArgumentException.class, () -> Task7.rotateRight(7, -4));
        assertThrows(IllegalArgumentException.class, () -> Task7.rotateRight(0, -2));
    }

    @Test
    @DisplayName("Test rotateLeft() if input number low then 1 or shift low then 0")
    void rotateLeftIfInputWrongNumberOrShiftTest() {
        assertThrows(IllegalArgumentException.class, () -> Task7.rotateLeft(0, 3));
        assertThrows(IllegalArgumentException.class, () -> Task7.rotateLeft(7, -4));
        assertThrows(IllegalArgumentException.class, () -> Task7.rotateLeft(0, -2));
    }

    @Test
    @DisplayName("Test rotateRight() with random numbers")
    void rotateRightWithRandomNumbersTest() {
        assertEquals(4, Task7.rotateRight(8, 1));
        assertEquals(28, Task7.rotateRight(19, 7));
        assertEquals(5, Task7.rotateRight(6, 92));
    }

    @Test
    @DisplayName("Test rotateLeft() with random numbers")
    void rotateLeftWithRandomNumbersTest() {
        assertEquals(1, Task7.rotateLeft(16, 1));
        assertEquals(6, Task7.rotateLeft(17, 2));
        assertEquals(3, Task7.rotateLeft(6, 44));
    }
}
