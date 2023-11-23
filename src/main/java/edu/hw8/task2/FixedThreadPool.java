package edu.hw8.task2;

import java.util.concurrent.*;

public class FixedThreadPool implements ThreadPool {
    private final int numThreads;
    private final Thread[] threads;
    private final BlockingQueue<Runnable> taskQueue;

    public FixedThreadPool(int numThreads) {
        this.numThreads = numThreads;
        this.threads = new Thread[numThreads];
        this.taskQueue = new LinkedBlockingQueue<>();
    }

    @Override
    public void start() {
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new Worker());
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            synchronized (taskQueue) {
                taskQueue.put(runnable);
                taskQueue.notify();  // Уведомляем один из потоков о наличии новой задачи
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void close() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    private class Worker implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                Runnable task;
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();  // Ожидаем появления новой задачи
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    task = taskQueue.poll();
                }

                task.run();
            }
        }
    }

    public static void main(String[] args) {
        try (FixedThreadPool threadPool = createThreadPool(4)) {
            threadPool.start();

            for (int i = 0; i < 10; i++) {
                final int n = i;
                threadPool.execute(() -> {
                    long fib = fibonacci(n);
                    System.out.println("Fibonacci(" + n + ") = " + fib);
                });
            }
        }
    }

    private static FixedThreadPool createThreadPool(int numThreads) {
        return new FixedThreadPool(numThreads);
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            long fib1 = 0;
            long fib2 = 1;
            long result = 0;

            for (int i = 2; i <= n; i++) {
                result = fib1 + fib2;
                fib1 = fib2;
                fib2 = result;
            }

            return result;
        }
    }
}
