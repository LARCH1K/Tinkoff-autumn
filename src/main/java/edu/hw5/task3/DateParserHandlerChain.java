package edu.hw5.task3;

import edu.hw5.task3.formatters.DateParserHandler;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DateParserHandlerChain {

    private final List<DateParserHandler> handlers = new ArrayList<>();

    public Optional<LocalDate> handleRequest(String dateString) {
        for (DateParserHandler handler : handlers) {
            Optional<LocalDate> result = handler.parse(dateString);
            if (result.isPresent()) {
                return result;
            }
        }
        return Optional.empty();
    }

    public void addHandler(DateParserHandler handler) {
        handlers.add(handler);
    }
}
