package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int rotateRight(int n, int shift) {
        if (n <= 0 || shift < 0) {
            throw new IllegalArgumentException();
        }
        String binaryNumber = Integer.toBinaryString(n);
        char[] arrayOfNumbers = binaryNumber.toCharArray();
        char[] resultArray = new char[arrayOfNumbers.length];
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            resultArray[(i + shift) % arrayOfNumbers.length] = arrayOfNumbers[i];
        }
        return Integer.parseInt(new String(resultArray), 2);
    }

    public static int rotateLeft(int n, int shift) {
        if (n <= 0 || shift < 0) {
            throw new IllegalArgumentException();
        }
        String binaryNumber = Integer.toBinaryString(n);
        char[] arrayOfNumbers = binaryNumber.toCharArray();
        char[] resultArray = new char[arrayOfNumbers.length];
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            resultArray[(i + arrayOfNumbers.length - shift % arrayOfNumbers.length) % arrayOfNumbers.length] =
                arrayOfNumbers[i];
        }
        return Integer.parseInt(new String(resultArray), 2);
    }
}
