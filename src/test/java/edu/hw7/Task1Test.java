package edu.hw7;

import org.junit.jupiter.api.Test;
import static edu.hw7.Task1.threadSafeCounter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    @Test
    public void threadSafeCounterTest() {
        assertEquals(10, threadSafeCounter(10, 1));
        assertEquals(100, threadSafeCounter(10, 10));
        assertEquals(10000, threadSafeCounter(1000, 10));
        assertEquals(1000000, threadSafeCounter(100000, 10));
    }

    @Test()
    public void threadSafeCounterInvalidArgumentsTest() {
        assertThrows(IllegalArgumentException.class, () -> threadSafeCounter(-1, 1));
        assertThrows(IllegalArgumentException.class, () -> threadSafeCounter(2, -4));
        assertThrows(IllegalArgumentException.class, () -> threadSafeCounter(0, 1));
        assertThrows(IllegalArgumentException.class, () -> threadSafeCounter(2, 0));
        assertThrows(IllegalArgumentException.class, () -> threadSafeCounter(-4, -8));
    }
}
