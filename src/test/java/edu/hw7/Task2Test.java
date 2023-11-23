package edu.hw7;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static edu.hw7.Task2.calculateFactorial;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {

    @Test
    public void calculateFactorialTest() {
        assertEquals(BigInteger.ONE, calculateFactorial(0));
        assertEquals(BigInteger.ONE, calculateFactorial(1));
        assertEquals(BigInteger.valueOf(2), calculateFactorial(2));
        assertEquals(BigInteger.valueOf(6), calculateFactorial(3));
        assertEquals(BigInteger.valueOf(24), calculateFactorial(4));
        assertEquals(BigInteger.valueOf(120), calculateFactorial(5));

        assertEquals(new BigInteger("15511210043330985984000000"), calculateFactorial(25));
    }

    @Test()
    public void calculateFactorialNegativeInputTest() {
        assertThrows(IllegalArgumentException.class, () -> calculateFactorial(-1));
        assertThrows(IllegalArgumentException.class, () -> calculateFactorial(-25));
    }

}
