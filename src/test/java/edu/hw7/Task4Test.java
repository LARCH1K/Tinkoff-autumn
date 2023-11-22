package edu.hw7;

import org.junit.jupiter.api.Test;
import static edu.hw7.Task4.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {
    @Test
    public void calculatePiTest() {
        int totalSimulations = 1000000;
        double piApproximation = calculatePi(totalSimulations);

        assertTrue(piApproximation >= 3.0 && piApproximation <= 3.5);
    }

    @Test
    public void calculatePiMultiThreadedTest() {
        int totalSimulations = 1000000;
        int numThreads = 4;

        double piApproximationMultiThreaded = calculatePiMultiThreaded(totalSimulations, numThreads);

        assertTrue(piApproximationMultiThreaded >= 3.0 && piApproximationMultiThreaded <= 3.5);
    }

    @Test()
    public void invalidArgumentsSingleThreadedTest() {
        assertThrows(IllegalArgumentException.class, ()->calculatePi(0));
        assertThrows(IllegalArgumentException.class, ()->calculatePi(-5));
    }

    @Test()
    public void invalidArgumentsMultiThreadedTest() {
        assertThrows(IllegalArgumentException.class, ()->calculatePiMultiThreaded(100, 0));
        assertThrows(IllegalArgumentException.class, ()->calculatePiMultiThreaded(0, 24));
        assertThrows(IllegalArgumentException.class, ()->calculatePiMultiThreaded(-100, 3));
        assertThrows(IllegalArgumentException.class, ()->calculatePiMultiThreaded(100, -8));
    }
}
