package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    @DisplayName("Test countDigits() with zero")
    void countDigitsIfInputZeroTest() {
        int result = Task2.countDigits(0);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Test countDigits() with MAX_INT and MIN_INT")
    void countDigitsIfInputMaxIntOrMinIntTest() {
        int result = Task2.countDigits(Integer.MAX_VALUE);
        assertEquals(10, result);

        result = Task2.countDigits(Integer.MIN_VALUE);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("Test countDigits() with random numbers")
    void countDigitsIfInputWithRandomNumbersTest() {
        int[][] tests = {{231598496, 439719042, 53898354, 86137073, 3677433, 392864, 888, 64, 7},
            {9, 9, 8, 8, 7, 6, 3, 2, 1}};
        for (int i = 0; i < 8; i++) {
            assertEquals(tests[1][i], Task2.countDigits(tests[0][i]));
        }
    }
}
