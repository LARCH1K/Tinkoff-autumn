package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static edu.hw5.task3.Task3.parseDate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {

    @Test
    void parseDateTestFromTask() {
        Optional<LocalDate> actual = parseDate("2020-10-10");
        assertThat(actual.orElse(null)).isEqualTo(LocalDate.of(2020, 10, 10));

        actual = parseDate("2020-12-2");
        assertThat(actual.orElse(null)).isEqualTo(LocalDate.of(2020, 12, 2));

        actual = parseDate("1/3/1976");
        assertThat(actual.orElse(null)).isEqualTo(LocalDate.of(1976, 3, 1));

        actual = parseDate("1/3/20");
        assertThat(actual.orElse(null)).isEqualTo(LocalDate.of(2020, 3, 1));

        actual = parseDate("tomorrow");
        assertThat(actual.orElse(null)).isEqualTo(LocalDate.now().plusDays(1));

        actual = parseDate("today");
        assertThat(actual.orElse(null)).isEqualTo(LocalDate.now());

        actual = parseDate("yesterday");
        assertThat(actual.orElse(null)).isEqualTo(LocalDate.now().minusDays(1));

        actual = parseDate("1 day ago");
        assertThat(actual.orElse(null)).isEqualTo(LocalDate.now().minusDays(1));

        actual = parseDate("2234 days ago");
        assertThat(actual.orElse(null)).isEqualTo(LocalDate.now().minusDays(2234));
    }

    @Test
    void parseDateIfInputWrongValueTest() {
        Optional<LocalDate> actual = parseDate("2");
        assertThat(actual.isPresent()).isEqualTo(false);

        assertThrows(IllegalArgumentException.class, () -> parseDate(null));
    }
}
