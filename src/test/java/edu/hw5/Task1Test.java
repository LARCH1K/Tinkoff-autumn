package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task1.calculateAverageDuration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {

    @Test
    void calculateAverageDurationTestFromTask() {
        String expected = "3ч 40м";
        String actual = calculateAverageDuration(new String[] {
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        });
        assertEquals(expected, actual);
    }

    @Test
    void calculateAverageDurationWithRandomValuesTest() {
        String expected = "19ч 36м";
        String actual = calculateAverageDuration(new String[] {
            "2023-05-22, 20:20 - 2023-05-23, 13:50",
            "2023-05-25, 20:20 - 2023-05-25, 23:50",
            "2023-06-01, 11:30 - 2023-06-03, 01:20"
        });
        assertEquals(expected, actual);
    }

    @Test
    void calculateAverageDurationIfInputNullTest() {
        assertThrows(IllegalArgumentException.class, () -> calculateAverageDuration(new String[] {
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            null
        }));
        assertThrows(IllegalArgumentException.class, () -> calculateAverageDuration(null));
    }
}
