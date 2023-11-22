package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    private Task1() {
    }

    public static int threadSafeCounter(int incrementAmount, int threadCount) {
        if (incrementAmount <= 0 || threadCount <= 0) {
            throw new IllegalArgumentException();
        }
        AtomicInteger counter = new AtomicInteger(0);
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementAmount; j++) {
                    counter.incrementAndGet();
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return counter.get();
    }

//    public static void main(String[] args) {
//        System.out.println(threadSafeCounter(100000, 5));
//    }
}
