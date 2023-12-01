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

    @Test
    public void invalidArgumentsSingleThreadedTest() {
        assertThrows(IllegalArgumentException.class, () -> calculatePi(0));
        assertThrows(IllegalArgumentException.class, () -> calculatePi(-5));
    }

    @Test
    public void invalidArgumentsMultiThreadedTest() {
        assertThrows(IllegalArgumentException.class, () -> calculatePiMultiThreaded(100, 0));
        assertThrows(IllegalArgumentException.class, () -> calculatePiMultiThreaded(0, 24));
        assertThrows(IllegalArgumentException.class, () -> calculatePiMultiThreaded(-100, 3));
        assertThrows(IllegalArgumentException.class, () -> calculatePiMultiThreaded(100, -8));
    }

    @Test
    void calculateStatistics() {
        for (int i = 10; i <= 1_000_000_000; i *= 10) {
            statOfCalculatePi(i);
        }
    }

    @Test
    void calculateStatisticWithSomeThreads() {
        for (int i = 1; i <= 10; i++) {
            long startTime2 = System.currentTimeMillis();
            double piApproximationMultiThreaded = calculatePiMultiThreaded(1000000, i);
            long endTime2 = System.currentTimeMillis();

            System.out.println("Approximated Pi (multi-threaded): " + piApproximationMultiThreaded);
            System.out.println(
                "Time taken (multi-threaded, " + i + " threads): " + (endTime2 - startTime2) + " milliseconds");
        }
    }

    private void statOfCalculatePi(int totalSimulations) {
        long startTime1 = System.currentTimeMillis();
        double piApproximation = calculatePi(totalSimulations);
        long endTime1 = System.currentTimeMillis();

        System.out.println("TotalSimulations = " + totalSimulations);
        System.out.println("Approximated Pi: " + piApproximation);
        System.out.println("Time taken (single-threaded): " + (endTime1 - startTime1) + " milliseconds");

        int numThreads = 4;
        long startTime2 = System.currentTimeMillis();
        double piApproximationMultiThreaded = calculatePiMultiThreaded(totalSimulations, numThreads);
        long endTime2 = System.currentTimeMillis();

        System.out.println("Approximated Pi (multi-threaded): " + piApproximationMultiThreaded);
        System.out.println(
            "Time taken (multi-threaded, " + numThreads + " threads): " + (endTime2 - startTime2) + " milliseconds");

        double speedup = (double) (endTime1 - startTime1) / (double) (endTime2 - startTime2);
        System.out.println("Speedup: " + speedup + "\n");
    }

}
