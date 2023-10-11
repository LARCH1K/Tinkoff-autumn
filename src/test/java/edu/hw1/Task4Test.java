package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task4Test {

    @Test
    @DisplayName("Test fixString() with NULL")
    void fixStringIfInputNullTest() {
        assertThrows(IllegalArgumentException.class, () -> Task4.fixString(null));
    }

    @Test
    @DisplayName("Test fixString() with empty String")
    void fixStringIfInputEmptyStringTest() {
        assertEquals("", Task4.fixString(""));
    }

    @Test
    @DisplayName("Test fixString() with one symbol")
    void fixStringIfInputOneSymbolTest() {
        assertEquals(" ", Task4.fixString(" "));
        assertEquals("f", Task4.fixString("f"));
        assertEquals("3", Task4.fixString("3"));
    }

    @Test
    @DisplayName("Test fixString() with random Strings")
    void fixStringWithRandomStringsTest() {
        assertEquals("214365", Task4.fixString("123456"));
        assertEquals("This is a mixed up string.", Task4.fixString("hTsii  s aimex dpus rtni.g"));
        assertEquals("abcde", Task4.fixString("badce"));
    }
}
