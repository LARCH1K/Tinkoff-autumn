package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task3 {

    private Task3() {
    }

    static <T> Map<T, Integer> freqDict(T[] arr) {
        Map<T, Integer> resultMap = new HashMap<>();
        for (T element : arr) {
            resultMap.put(element, resultMap.getOrDefault(element, 0) + 1);
        }
        return resultMap;
    }
}
