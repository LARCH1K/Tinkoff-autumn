package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task2.clusterize;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {

    @Test
    @DisplayName("Test from task")
    void clusterizeTaskTest() {
        assertArrayEquals(new String[] {"()", "()", "()"}, clusterize("()()()").toArray());
        assertArrayEquals(new String[] {"((()))"}, clusterize("((()))").toArray());
        assertArrayEquals(
            new String[] {"((()))", "(())", "()", "()", "(()())"},
            clusterize("((()))(())()()(()())").toArray()
        );
        assertArrayEquals(new String[] {"((())())", "(()(()()))"}, clusterize("((())())(()(()()))").toArray());
    }

    @Test
    @DisplayName("Test with throws exception if input null")
    void clusterizeThrowExceptionIfInputNullTest() {
        assertThrows(IllegalArgumentException.class, () -> clusterize(null));
    }

    @Test
    @DisplayName("Test with throws exception if input wrong values")
    void clusterizeThrowExceptionIfInputWrongValuesTest() {
        assertThrows(IllegalArgumentException.class, () -> clusterize("()(()()"));
        assertThrows(IllegalArgumentException.class, () -> clusterize("((())))"));
        assertThrows(IllegalArgumentException.class, () -> clusterize("((()))((d))()()(()())"));
    }
}
