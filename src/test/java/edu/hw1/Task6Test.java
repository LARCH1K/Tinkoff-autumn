package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task6Test {

    @Test
    @DisplayName("Test countK() if input number <= 1000")
    void countKIfInputNumberLowThen1001Test() {
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(0));
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(215));
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(1000));
    }

    @Test
    @DisplayName("Test countK() if input number > 9999")
    void countKIfInputNumberMoreThen9999Test() {
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(10000));
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(157572));
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(27527));
    }

    @Test
    @DisplayName("Test countK() if input number with identical digits")
    void countKIfInputNumberWithIdenticalDigitsTest() {
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(1111));
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(3333));
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(5555));
    }

    @Test
    @DisplayName("Test countK() with random numbers")
    void countKWithRandomNumbersTest() {
        assertEquals(3, Task6.countK(3524));
        assertEquals(5, Task6.countK(6621));
        assertEquals(4, Task6.countK(6554));
        assertEquals(3, Task6.countK(1234));
    }

    @Test
    @DisplayName("Test countK() with Kaprekars number")
    void countKIfInputKaprekarsNumberTest() {
        assertEquals(0, Task6.countK(6174));
    }
}
