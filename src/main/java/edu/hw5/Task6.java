package edu.hw5;

public class Task6 {
    private Task6() {
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException();
        }
        String regex = ".*" + String.join(".*", s.split("")) + ".*";
        return t.matches(regex);
    }
}
