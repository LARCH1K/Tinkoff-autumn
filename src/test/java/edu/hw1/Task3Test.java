package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {

    @Test
    @DisplayName("Test isNestable() if input null")
    void countDigitsIfInputZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> Task3.isNestable(null, null));
        assertThrows(IllegalArgumentException.class, () -> Task3.isNestable(new int[] {1, 2}, null));
        assertThrows(IllegalArgumentException.class, () -> Task3.isNestable(null, new int[] {1, 2}));
    }

    @Test
    @DisplayName("Test isNestable() if input empty array")
    void countDigitsIfInputEmptyArrayTest() {
        assertThrows(IllegalArgumentException.class, () -> Task3.isNestable(new int[] {}, new int[] {}));
        assertThrows(IllegalArgumentException.class, () -> Task3.isNestable(new int[] {}, new int[] {1, 2}));
        assertThrows(IllegalArgumentException.class, () -> Task3.isNestable(new int[] {1, 2}, new int[] {}));
    }

    @Test
    @DisplayName("Test isNestable() with random values returns true")
    void countDigitsWithRandomValuesReturnsTrueTest() {
        assertTrue(Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6}));
        assertTrue(Task3.isNestable(new int[] {3, 1}, new int[] {4, 0}));
    }

    @Test
    @DisplayName("Test isNestable() with random values returns false")
    void countDigitsWithRandomValuesReturnsFalseTest() {
        assertFalse(Task3.isNestable(new int[] {9, 9, 8}, new int[] {8, 9}));
        assertFalse(Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {2, 3}));
    }
}
