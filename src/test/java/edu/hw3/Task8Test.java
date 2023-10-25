package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task8Test {

    @Test
    @DisplayName("Test from task")
    void taskTest() {
        List<Integer> values = List.of(1, 2, 3);
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(values);
        for (int value : values.reversed()) {
            assertEquals(backwardIterator.next(), value);
        }
    }

    @Test
    void simpleTest() {
        List<String> values = List.of("aaa", "bbb", "ccc", "ddd", "eee");
        BackwardIterator<String> backwardIterator = new BackwardIterator<>(values);
        for (String value : values.reversed()) {
            assertEquals(backwardIterator.next(), value);
        }
    }
}
