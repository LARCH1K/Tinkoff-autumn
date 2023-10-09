package edu.hw1;

public class Task4 {
    private Task4() {
    }

    public static String fixString(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        char[] string = str.toCharArray();
        char buf;
        for (int i = 0; i < string.length - 1; i += 2) {
            buf = string[i];
            string[i] = string[i + 1];
            string[i + 1] = buf;
        }
        return new String(string);
    }
}
