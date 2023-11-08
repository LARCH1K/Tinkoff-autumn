package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static edu.hw5.Task2.findFridayThe13ths;
import static edu.hw5.Task2.findNextFridayThe13th;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {

    @Test
    void findFridayThe13thsTestFromTask() {
        List<String> actual = findFridayThe13ths(1925);
        assertThat(actual).containsExactly("1925-02-13", "1925-03-13", "1925-11-13");
        actual = findFridayThe13ths(2024);
        assertThat(actual).containsExactly("2024-09-13", "2024-12-13");
    }

    @Test
    void findNextFridayThe13thTest() {
        String actual = findNextFridayThe13th(LocalDate.parse("2024-05-18"));
        assertThat(actual).isEqualTo("2024-09-13");
        actual = findNextFridayThe13th(LocalDate.parse("1925-02-17"));
        assertThat(actual).isEqualTo("1925-03-13");
    }

    @Test
    void findFridayThe13thsIfInputValueLowThanZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> findFridayThe13ths(-5));
        assertThrows(IllegalArgumentException.class, () -> findFridayThe13ths(-1980));
    }

    @Test
    void findNextFridayThe13thIfInputNullTest() {
        assertThrows(IllegalArgumentException.class, () -> findNextFridayThe13th(null));
    }
}
