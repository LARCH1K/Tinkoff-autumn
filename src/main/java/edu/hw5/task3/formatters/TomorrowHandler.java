package edu.hw5.task3.formatters;

import java.time.LocalDate;
import java.util.Optional;

public class TomorrowHandler implements DateParserHandler {

    @Override
    public Optional<LocalDate> parse(String dateString) {
        if (dateString.equalsIgnoreCase("tomorrow")) {
            return Optional.of(LocalDate.now().plusDays(1));
        }
        return Optional.empty();
    }
}
