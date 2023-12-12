package edu.hw8;

import edu.hw8.task2.FixedThreadPool;
import edu.hw8.task2.ThreadPool;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @Test
    void fixedThreadPoolTest() {
        long[] expectedResults = new long[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        long[] actualResults = new long[10];

        try (ThreadPool threadPool = new FixedThreadPool(4)) {
            threadPool.start();

            for (int i = 0; i < 10; i++) {
                int finalI = i;
                threadPool.execute(() -> {
                    long result = calculateFibonacci(finalI);
                    actualResults[finalI] = result;
                });
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertThat(actualResults).containsExactly(expectedResults);
    }

    private static long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            long fib1 = calculateFibonacci(n - 1);
            long fib2 = calculateFibonacci(n - 2);
            return fib1 + fib2;
        }
    }
}
