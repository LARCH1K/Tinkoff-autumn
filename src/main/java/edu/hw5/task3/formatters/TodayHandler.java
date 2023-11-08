package edu.hw5.task3.formatters;

import java.time.LocalDate;
import java.util.Optional;

public class TodayHandler implements DateParserHandler {
    @Override
    public Optional<LocalDate> parse(final String dateString) {
        if (dateString.equalsIgnoreCase("today")) {
            return Optional.of(LocalDate.now());
        }
        return Optional.empty();
    }
}
