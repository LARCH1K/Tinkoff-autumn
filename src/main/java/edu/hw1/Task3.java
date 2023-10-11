package edu.hw1;

import java.util.Arrays;

public class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] array1, int[] array2) {
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            throw new IllegalArgumentException();
        }
        int min1 = Arrays.stream(array1).min().getAsInt();
        int min2 = Arrays.stream(array2).min().getAsInt();
        int max1 = Arrays.stream(array1).max().getAsInt();
        int max2 = Arrays.stream(array2).max().getAsInt();
        return max1 < max2 && min1 > min2;
    }
}
