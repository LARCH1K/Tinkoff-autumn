package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task7.firstTask;
import static edu.hw5.Task7.secondTask;
import static edu.hw5.Task7.thirdTask;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {

    @Test
    void firstTaskTest() {
        assertTrue(firstTask("11011"));
        assertTrue(firstTask("01001"));

        assertFalse(firstTask("10"));
        assertFalse(firstTask("10100"));
        assertFalse(firstTask("10200"));

        assertThrows(IllegalArgumentException.class, () -> firstTask(null));
    }

    @Test
    void secondTaskTest() {
        assertTrue(secondTask("11011"));
        assertTrue(secondTask("01000"));

        assertFalse(secondTask("10"));
        assertFalse(secondTask("10100"));
        assertFalse(secondTask("10200"));

        assertThrows(IllegalArgumentException.class, () -> secondTask(null));
    }

    @Test
    void thirdTaskTest() {
        assertTrue(thirdTask("110"));
        assertTrue(thirdTask("1"));

        assertFalse(thirdTask("1011"));
        assertFalse(thirdTask("10100"));
        assertFalse(thirdTask("10200"));

        assertThrows(IllegalArgumentException.class, () -> thirdTask(null));
    }
}
