package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private Task6() {
    }

    final private static int MAX_4_DIGIT_NUMBER = 9999;
    final private static int MIN_4_DIGIT_NUMBER = 1000;
    final private static int NUMBER_WITH_IDENTICAL_DIGITS = 1111;
    final private static int KAPREKARS_NUMBER = 6174;
    final private static int FOUR_DIGITS_IN_NUMBER = 4;
    final private static int DECIMAL_NUMBER_SYSTEM = 10;

    //Такая реализация, потому что в условии было написать рекурсивную функцию (На всякий случай)
    public static int countK(int number) {
        if (number <= MIN_4_DIGIT_NUMBER || number > MAX_4_DIGIT_NUMBER || number % NUMBER_WITH_IDENTICAL_DIGITS == 0) {
            throw new IllegalArgumentException();
        }
        if (number == KAPREKARS_NUMBER) {
            return 0;
        }
        return countKaprekara(number, 1);
    }

    private static int countKaprekara(final int number, final int i) {
        int value = number;
        int[] arrayASC = numberToArray(number);
        Arrays.sort(arrayASC);
        value = reverseArrayToNumber(arrayASC) - arrayToNumber(arrayASC);
        if (value == KAPREKARS_NUMBER) {
            return i;
        }
        return countKaprekara(value, i + 1);
    }

    private static int arrayToNumber(final int[] array) {
        int number = 0;
        for (int i = 0; i < FOUR_DIGITS_IN_NUMBER; i++) {
            number = number * DECIMAL_NUMBER_SYSTEM + array[i];
        }
        return number;
    }

    private static int reverseArrayToNumber(final int[] array) {
        int number = 0;
        for (int i = FOUR_DIGITS_IN_NUMBER - 1; i >= 0; i--) {
            number = number * DECIMAL_NUMBER_SYSTEM + array[i];
        }
        return number;
    }

    private static int[] numberToArray(final int value) {
        int number = value;
        int[] arrayNumbers = new int[FOUR_DIGITS_IN_NUMBER];
        for (int i = FOUR_DIGITS_IN_NUMBER - 1; i >= 0; i--) {
            arrayNumbers[i] = number % DECIMAL_NUMBER_SYSTEM;
            number /= DECIMAL_NUMBER_SYSTEM;
        }
        return arrayNumbers;
    }
}
