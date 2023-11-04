package edu.project1;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsoleCommandTest {

    private static class TestDictionary implements Dictionary {
        @Override
        public @NotNull String getWord() {
            return "qwerty";
        }
    }

    @Test
    void startGameTest() {
        String data = "!start";
        InputStream is = new ByteArrayInputStream(data.getBytes());
        Scanner testScanner = new Scanner(is);

        assertTrue(new Hangman().startGame(testScanner));
    }

    @Test
    void endGameTest() {
        String data = "!exit";
        InputStream is = new ByteArrayInputStream(data.getBytes());
        Scanner testScanner = new Scanner(is);

        assertFalse(new Hangman().startGame(testScanner));
    }

    @Test
    void wrongInputToTryGuessTest() {
        String data = "er\neee\nfsfd";
        InputStream is = new ByteArrayInputStream(data.getBytes());
        Scanner testScanner = new Scanner(is);

        Session session = new Session(new TestDictionary());
        try {
            new Hangman().tryGuess(session, testScanner);
        } catch (NoSuchElementException ignored) {
        }
        assertEquals(0, session.getAttempts());
        assertArrayEquals(new char[] {'*', '*', '*', '*', '*', '*'}, session.getUserAnswer());
    }

    @Test
    void giveUpInputToTryGuessTest() {
        String data = "!giveUp";
        InputStream is = new ByteArrayInputStream(data.getBytes());
        Scanner testScanner = new Scanner(is);

        Session session = new Session(new TestDictionary());
        GuessResult guessResult = new Hangman().tryGuess(session, testScanner);
        assertEquals(GuessResult.GiveUp.class, guessResult.getClass());
    }
}
