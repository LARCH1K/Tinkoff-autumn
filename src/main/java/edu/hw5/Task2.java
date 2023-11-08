package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private static final int MONTHS_IN_YEAR = 12;
    private static final int THIRTEEN = 13;

    private Task2() {
    }

    public static List<String> findFridayThe13ths(int year) {
        if (year < 0) {
            throw new IllegalArgumentException();
        }
        List<String> fridayThe13ths = new ArrayList<>();

        for (int month = 1; month <= MONTHS_IN_YEAR; month++) {
            LocalDate date = LocalDate.of(year, month, THIRTEEN);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridayThe13ths.add(date.toString());
            }
        }

        return fridayThe13ths;
    }

    public static String findNextFridayThe13th(LocalDate currentDate) {
        if (currentDate == null) {
            throw new IllegalArgumentException();
        }
        LocalDate nextFridayThe13th = currentDate;

        while (nextFridayThe13th.getDayOfMonth() != THIRTEEN || nextFridayThe13th.getDayOfWeek() != DayOfWeek.FRIDAY) {
            nextFridayThe13th = nextFridayThe13th.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }

        return nextFridayThe13th.toString();
    }
}
