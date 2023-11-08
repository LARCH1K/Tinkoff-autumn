package edu.hw5.task3.formatters;

import java.time.LocalDate;
import java.util.Optional;

public class DaysAgoHandler implements DateParserHandler {
    @Override
    public Optional<LocalDate> parse(final String dateString) {
        if (dateString.matches("^\\d+\\s+day(s)?\\s+ago")) {
            return Optional.of(LocalDate.now().minusDays(Integer.parseInt(dateString.split(" ")[0])));
        }
        return Optional.empty();
    }
}
