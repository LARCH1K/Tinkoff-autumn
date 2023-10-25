package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task1.atbash;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {

    @Test
    @DisplayName("Test from task")
    void taskTest() {
        assertEquals("Svool dliow!", atbash("Hello world!"));
        assertEquals(
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg"
                + " sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi",
            atbash("Any fool can write code that a computer can understand. Good programmers write code that"
                + " humans can understand. ― Martin Fowler")
        );
    }

    @Test
    @DisplayName("Test with throws exception")
    void throwExceptionIfInputNullTest() {
        assertThrows(IllegalArgumentException.class, () -> atbash(null));
    }
}
