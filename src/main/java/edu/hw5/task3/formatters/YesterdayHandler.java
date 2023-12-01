package edu.hw5.task3.formatters;

import java.time.LocalDate;
import java.util.Optional;

public class YesterdayHandler implements DateParserHandler {
    @Override
    public Optional<LocalDate> parse(final String dateString) {
        if (dateString.equalsIgnoreCase("yesterday")) {
            return Optional.of(LocalDate.now().minusDays(1));
        }
        return Optional.empty();
    }
}
