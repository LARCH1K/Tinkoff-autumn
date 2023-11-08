package edu.hw5.task3;

import edu.hw5.task3.formatters.DaysAgoHandler;
import edu.hw5.task3.formatters.SpecificDateFormatHandler;
import edu.hw5.task3.formatters.TodayHandler;
import edu.hw5.task3.formatters.TomorrowHandler;
import edu.hw5.task3.formatters.YesterdayHandler;
import java.time.LocalDate;
import java.util.Optional;

public class Task3 {
    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        DateParserHandlerChain handlerChain = new DateParserHandlerChain();

        handlerChain.addHandler(new SpecificDateFormatHandler());
        handlerChain.addHandler(new TomorrowHandler());
        handlerChain.addHandler(new TodayHandler());
        handlerChain.addHandler(new YesterdayHandler());
        handlerChain.addHandler(new DaysAgoHandler());

        return handlerChain.handleRequest(string);
    }
}
