package edu.hw7;

import java.util.Random;

public class Task4 {

    private final static double RADIUS = 0.5;

    private final static double NUMBER_FOUR_FROM_FORMULA = 4.0;

    private Task4() {
    }

//    public static void main(String[] args) {
//        int totalSimulations = 1000; // Количество симуляций
//
//        long startTime1 = System.currentTimeMillis();
//        double piApproximation = calculatePi(totalSimulations);
//        long endTime1 = System.currentTimeMillis();
//
//        System.out.println("Approximated Pi: " + piApproximation);
//        System.out.println("Time taken (single-threaded): " + (endTime1 - startTime1) + " milliseconds");
//
//        // Многопоточная версия (пример)
//        int numThreads = 4; // Количество потоков
//        long startTime2 = System.currentTimeMillis();
//        double piApproximationMultiThreaded = calculatePiMultiThreaded(totalSimulations, numThreads);
//        long endTime2 = System.currentTimeMillis();
//
//        System.out.println("Approximated Pi (multi-threaded): " + piApproximationMultiThreaded);
//        System.out.println(
//            "Time taken (multi-threaded, " + numThreads + " threads): " + (endTime2 - startTime2) + " milliseconds");
//
//        // Рассчет ускорения
//        double speedup = (double) (endTime1 - startTime1) / (double) (endTime2 - startTime2);
//        System.out.println("Speedup: " + speedup);
//    }

    public static double calculatePi(int totalSimulations) {
        if (totalSimulations <= 0) {
            throw new IllegalArgumentException();
        }
        int circleCount = 0;
        Random random = new Random();

        for (int i = 0; i < totalSimulations; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();

            double distance = Math.sqrt((x - RADIUS) * (x - RADIUS) + (y - RADIUS) * (y - RADIUS));

            if (distance <= RADIUS) {
                circleCount++;
            }
        }

        return NUMBER_FOUR_FROM_FORMULA * circleCount / totalSimulations;
    }

    public static double calculatePiMultiThreaded(int totalSimulations, int numThreads) {
        if (totalSimulations <= 0 || numThreads <= 0) {
            throw new IllegalArgumentException();
        }
        int simulationsPerThread = totalSimulations / numThreads;
        Thread[] threads = new Thread[numThreads];
        PiThread[] piThreads = new PiThread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            piThreads[i] = new PiThread(simulationsPerThread);
            threads[i] = new Thread(piThreads[i]);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int totalCircleCount = 0;
        for (PiThread piThread : piThreads) {
            totalCircleCount += piThread.getCircleCount();
        }

        return NUMBER_FOUR_FROM_FORMULA * totalCircleCount / totalSimulations;
    }

    private static class PiThread implements Runnable {
        private final int simulations;
        private int circleCount;
        private final Random random;

        PiThread(int simulations) {
            this.simulations = simulations;
            this.circleCount = 0;
            this.random = new Random();
        }

        @Override
        public void run() {
            for (int i = 0; i < simulations; i++) {
                double x = random.nextDouble();
                double y = random.nextDouble();

                double distance = Math.sqrt((x - RADIUS) * (x - RADIUS) + (y - RADIUS) * (y - RADIUS));

                if (distance <= RADIUS) {
                    circleCount++;
                }
            }
        }

        public int getCircleCount() {
            return circleCount;
        }
    }
}
