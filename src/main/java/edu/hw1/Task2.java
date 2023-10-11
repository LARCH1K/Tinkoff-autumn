package edu.hw1;

public class Task2 {
    private Task2() {
    }

    final private static int DECIMAL_NUMBER_SYSTEM = 10;

    public static int countDigits(int number) {
        int value = number;
        int count = 0;
        do {
            value /= DECIMAL_NUMBER_SYSTEM;
            count++;
        } while (value != 0);
        return count;
    }
}
