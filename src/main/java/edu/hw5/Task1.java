package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task1 {

    private final static String PATTERN = "yyyy-MM-dd, HH:mm";

    private final static int SECONDS_IN_MINUTE = 60;

    private final static int SECONDS_IN_HOUR = 3600;

    private Task1() {
    }

    public static String calculateAverageDuration(String[] input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        long totalSeconds = 0;

        for (String inputStr : input) {
            if (inputStr == null) {
                throw new IllegalArgumentException();
            }
            String[] parts = inputStr.split(" - ");
            LocalDateTime start = LocalDateTime.parse(parts[0], DateTimeFormatter.ofPattern(PATTERN));
            LocalDateTime end = LocalDateTime.parse(parts[1], DateTimeFormatter.ofPattern(PATTERN));

            Duration duration = Duration.between(start, end);
            totalSeconds += duration.getSeconds();
        }

        long averageSeconds = totalSeconds / input.length;

        long hours = averageSeconds / SECONDS_IN_HOUR;
        long minutes = (averageSeconds % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;

        return hours + "ч " + minutes + "м";
    }
}
