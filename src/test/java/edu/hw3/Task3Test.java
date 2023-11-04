package edu.hw3;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.Map;
import static edu.hw3.Task3.freqDict;

import org.hamcrest.collection.IsMapContaining;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {

    @org.junit.jupiter.api.Test
    @DisplayName("Test from task")
    void freqDictTaskTest() {
        Map<String, Integer> map = freqDict(new String[] {"a", "bb", "a", "bb"});
        assertThat(map.size(), is(2));
        assertThat(map, IsMapContaining.hasEntry("bb", 2));
        assertThat(map, IsMapContaining.hasEntry("a", 2));

        map = freqDict(new String[] {"this", "and", "that", "and"});
        assertThat(map.size(), is(3));
        assertThat(map, IsMapContaining.hasEntry("that", 1));
        assertThat(map, IsMapContaining.hasEntry("and", 2));
        assertThat(map, IsMapContaining.hasEntry("this", 1));

        map = freqDict(new String[] {"код", "код", "код", "bug"});
        assertThat(map.size(), is(2));
        assertThat(map, IsMapContaining.hasEntry("код", 3));
        assertThat(map, IsMapContaining.hasEntry("bug", 1));

        Map<Integer, Integer> map2 = freqDict(new Integer[] {1, 1, 2, 2});
        assertThat(map2.size(), is(2));
        assertThat(map2, IsMapContaining.hasEntry(1, 2));
        assertThat(map2, IsMapContaining.hasEntry(2, 2));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test with throws exception if input null")
    void freqDictThrowExceptionIfInputNullTest() {
        assertThrows(IllegalArgumentException.class, () -> freqDict(null));
    }

}
