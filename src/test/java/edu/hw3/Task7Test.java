package edu.hw3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {

    @Test
    void simpleTest() {
        TreeMap<String, String> map = new TreeMap<>(new Task7());
        map.put("aaa", "111");
        map.put(null, "222");
        map.put("ccc", "333");
        assertTrue(map.containsKey(null));
        assertEquals(map.get(null), "222");
        map.remove(null);
        assertFalse(map.containsKey(null));
    }
}
