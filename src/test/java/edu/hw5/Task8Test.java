package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task8.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {

    @Test
    void firstTaskTest() {
        assertTrue(firstTask("11011"));
        assertTrue(firstTask("011"));

        assertFalse(firstTask("10"));
        assertFalse(firstTask("101010"));
        assertFalse(firstTask("10200"));

        assertThrows(IllegalArgumentException.class, () -> firstTask(null));
    }

    @Test
    void secondTaskTest() {
        assertTrue(secondTask("110110"));
        assertTrue(secondTask("011"));

        assertFalse(secondTask("100"));
        assertFalse(secondTask("1011010"));
        assertFalse(secondTask("10200"));

        assertThrows(IllegalArgumentException.class, () -> secondTask(null));
    }

    @Test
    void thirdTaskTest() {
        assertTrue(thirdTask("1010101"));
        assertTrue(thirdTask("0101010100"));

        assertFalse(thirdTask("10"));
        assertFalse(thirdTask("1010010"));
        assertFalse(thirdTask("10200"));

        assertThrows(IllegalArgumentException.class, () -> thirdTask(null));
    }

    @Test
    void fourthTaskTest() {
        assertTrue(fourthTask("11011"));
        assertTrue(fourthTask("011"));

        assertFalse(fourthTask("11"));
        assertFalse(fourthTask("111"));
        assertFalse(fourthTask("10200"));

        assertThrows(IllegalArgumentException.class, () -> fourthTask(null));
    }

    @Test
    void fifthTaskTest() {
        assertTrue(fifthTask("1010111"));
        assertTrue(fifthTask("10101010"));

        assertFalse(fifthTask("100"));
        assertFalse(fifthTask("001010"));
        assertFalse(fifthTask("10200"));

        assertThrows(IllegalArgumentException.class, () -> fifthTask(null));
    }

    @Test
    void sixthTaskTest() {
        assertTrue(sixthTask("0100"));
        assertTrue(sixthTask("0000"));

        assertFalse(sixthTask("01"));
        assertFalse(sixthTask("011"));
        assertFalse(sixthTask("10200"));

        assertThrows(IllegalArgumentException.class, () -> sixthTask(null));
    }

    @Test
    void seventhTaskTest() {
        assertTrue(seventhTask("1010101"));
        assertTrue(seventhTask("0101"));

        assertFalse(seventhTask("110"));
        assertFalse(seventhTask("101111010"));
        assertFalse(seventhTask("10200"));

        assertThrows(IllegalArgumentException.class, () -> seventhTask(null));
    }
}
