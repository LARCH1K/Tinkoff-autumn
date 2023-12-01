package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task4.isValidPassword;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {

    @Test
    void isValidPasswordTest() {
        assertTrue(isValidPassword("qwer!ty"));
        assertTrue(isValidPassword("qw@erty"));
        assertTrue(isValidPassword("qw#er$ty"));

        assertFalse(isValidPassword("qwerty"));
        assertFalse(isValidPassword("asdfg"));

        assertThrows(IllegalArgumentException.class, () -> isValidPassword(null));
    }
}
