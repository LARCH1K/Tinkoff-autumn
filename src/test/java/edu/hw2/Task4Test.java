package edu.hw2;

import edu.hw2.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw2.task4.Task4.callingInfo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    @DisplayName("Test ")
    void callingInfoTest() {
        assertEquals("edu.hw2.CallingInfoTest", CallingInfoTest.test().className());
        assertEquals("test.txt", CallingInfoTest.test().methodName());
    }
}

class CallingInfoTest {
    public static Task4.CallingInfo test() {
        return callingInfo();
    }
}
