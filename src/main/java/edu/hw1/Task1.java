package edu.hw1;

public class Task1 {
    private Task1() {
    }

    final private static int SECONDS_IN_MINUTE = 60;

    public static int minutesToSeconds(String str) {
        int secondes;
        int minutes;
        try {
            String[] strings = str.split(":");
            minutes = Integer.parseInt(strings[0]);
            secondes = Integer.parseInt(strings[1]);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("The input should look like 'minutes:secondes'");
        }
        int result = 0;
        if (secondes >= SECONDS_IN_MINUTE || secondes < 0 || minutes < 0) {
            return -1;
        }
        result = minutes * SECONDS_IN_MINUTE + secondes;
        return result;
    }
}
