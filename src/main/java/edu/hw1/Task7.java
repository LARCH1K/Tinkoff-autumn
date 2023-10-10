package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int rotateRight(int n, int shift) {
        if (n <= 0 || shift < 0) {
            throw new IllegalArgumentException();
        }
        String binaryNumber = Integer.toBinaryString(n);
        char[] resultArray = new char[binaryNumber.length()];
        for (int i = 0; i < binaryNumber.length(); i++) {
            resultArray[(i + shift) % binaryNumber.length()] = binaryNumber.charAt(i);
        }
        return Integer.parseInt(new String(resultArray), 2);
    }

    public static int rotateLeft(int n, int shift) {
        if (n <= 0 || shift < 0) {
            throw new IllegalArgumentException();
        }
        int countDigitsInBinaryNumber = Integer.toBinaryString(n).length();
        return rotateRight(n, countDigitsInBinaryNumber - (shift % countDigitsInBinaryNumber));
    }
}
