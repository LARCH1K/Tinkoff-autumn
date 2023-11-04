package edu.hw3;

public class Task1 {
    private Task1() {
    }

    static String atbash(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        char[] result = string.toCharArray();
        for (int i = 0; i < result.length; i++) {
            if (Character.isLetter(result[i])) {
                if (Character.isUpperCase(result[i])) {
                    result[i] = (char) ('Z' - result[i] + 'A');
                } else {
                    result[i] = (char) ('z' - result[i] + 'a');
                }
            }
        }
        return new String(result);
    }
}
