package edu.hw5.task3.formatters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class SpecificDateFormatHandler implements DateParserHandler {

    private static final DateTimeFormatter[] FORMATTERS = {
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        DateTimeFormatter.ofPattern("yyyy-M-d"),
        DateTimeFormatter.ofPattern("d/M/yyyy"),
        DateTimeFormatter.ofPattern("d/M/yy")
    };

    @Override
    public Optional<LocalDate> parse(String dateString) {
        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                LocalDate date = LocalDate.parse(dateString, formatter);
                return Optional.of(date);
            } catch (Exception ignored) {
            }
        }
        return Optional.empty();
    }
}
