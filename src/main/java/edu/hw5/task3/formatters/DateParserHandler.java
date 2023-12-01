package edu.hw5.task3.formatters;

import java.time.LocalDate;
import java.util.Optional;

public interface DateParserHandler {
    Optional<LocalDate> parse(String dateString);
}
