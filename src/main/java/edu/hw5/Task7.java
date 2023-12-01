package edu.hw5;

public class Task7 {
    private Task7() {
    }

    public static boolean firstTask(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return string.matches("^[01]{2}0[01]*$");
    }

    public static boolean secondTask(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return string.matches("^([01])[01]*\\1$");
    }

    public static boolean thirdTask(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return string.matches("^[01]{1,3}$");
    }
}
