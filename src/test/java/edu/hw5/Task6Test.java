package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task6.isSubsequence;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {

    @Test
    void isSubsequenceTest() {
        assertTrue(isSubsequence("abc", "achfdbaabgabcaabg"));
        assertTrue(isSubsequence("wer", "qwdeftrtt"));

        assertFalse(isSubsequence("abc ", "achfdbaabgacbaabg"));
        assertFalse(isSubsequence("wer", "qwrdefttt"));

        assertThrows(IllegalArgumentException.class, () -> isSubsequence(null, "sss"));
        assertThrows(IllegalArgumentException.class, () -> isSubsequence("nuddsdll", null));
        assertThrows(IllegalArgumentException.class, () -> isSubsequence(null, null));
    }
}
