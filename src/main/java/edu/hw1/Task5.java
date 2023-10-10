package edu.hw1;

import java.util.Arrays;

public class Task5 {
    private Task5() {
    }

    final private static int DECIMAL_NUMBER_SYSTEM = 10;

    public static boolean isPalindromeDescendant(final int number) {
        int value = Math.abs(number);
        int[] arrayNumbers = numberToArray(value);
        while (true) {
            if (arrayNumbers.length <= 1) {
                return false;
            }
            if (isAPalindrome(arrayNumbers)) {
                return true;
            }
            arrayNumbers = arrayOfAdditionNumbers(arrayNumbers);
        }
    }

    private static int[] arrayOfAdditionNumbers(final int[] arrayNumbers) {
        int number = 0;
        int index = 0;
        int[] result = new int[arrayNumbers.length];
        for (int i = 0; i < arrayNumbers.length - 1; i += 2) {
            number = arrayNumbers[i] + arrayNumbers[i + 1];
            if (number > DECIMAL_NUMBER_SYSTEM) {
                result[index++] = number / DECIMAL_NUMBER_SYSTEM;
                result[index++] = number % DECIMAL_NUMBER_SYSTEM;
            } else {
                result[index++] = number;
            }
        }
        if (arrayNumbers.length % 2 == 1) {
            result[index++] = arrayNumbers[arrayNumbers.length - 1];
        }
        return Arrays.copyOf(result, index);
    }

    private static int[] numberToArray(final int value) {
        int number = value;
        int count = Task2.countDigits(number);
        int[] arrayNumbers = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            arrayNumbers[i] = number % DECIMAL_NUMBER_SYSTEM;
            number /= DECIMAL_NUMBER_SYSTEM;
        }
        return arrayNumbers;
    }

    private static boolean isAPalindrome(final int[] arrayNumbers) {
        for (int i = 0; i < arrayNumbers.length / 2; i++) {
            if (arrayNumbers[i] != arrayNumbers[arrayNumbers.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
