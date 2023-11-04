package edu.project1;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Project1Test {
    private static class TestDictionary implements Dictionary {
        @Override
        public @NotNull String getWord() {
            return "qwerty";
        }
    }

    private Session session;

    @BeforeEach
    void prepare() {
        session = new Session(new TestDictionary());
    }

    @Test
    @DisplayName("After exceeding a number of attempts, the game always returns defeat")
    void defeatTest() {
        GuessResult guessResult = null;
        for (int i = 0; i < session.getMaxAttempts(); i++) {
            guessResult = session.guess('f');
        }
        assertEquals(GuessResult.Defeat.class, guessResult.getClass());
    }

    @Test
    @DisplayName("Win at game Test")
    void winAtGameTest() {
        session.guess('q');
        session.guess('w');
        session.guess('r');
        session.guess('g');
        session.guess('e');
        session.guess('y');
        GuessResult guessResult = session.guess('t');
        assertEquals(GuessResult.Win.class, guessResult.getClass());
    }

    @Test
    @DisplayName("SuccessfulGuess Test")
    void successfulGuessTest() {
        assertEquals(GuessResult.SuccessfulGuess.class, session.guess('w').getClass());
        assertEquals(GuessResult.SuccessfulGuess.class, session.guess('r').getClass());
        assertEquals(GuessResult.SuccessfulGuess.class, session.guess('y').getClass());
        assertArrayEquals(new char[] {'*', 'w', '*', 'r', '*', 'y'}, session.getUserAnswer());
        assertEquals(0, session.getAttempts());
    }

    @Test
    @DisplayName("FailedGuess Test")
    void failedGuessTest() {
        assertEquals(GuessResult.FailedGuess.class, session.guess('s').getClass());
        assertEquals(GuessResult.FailedGuess.class, session.guess('g').getClass());
        assertEquals(GuessResult.FailedGuess.class, session.guess('j').getClass());
        assertArrayEquals(new char[] {'*', '*', '*', '*', '*', '*'}, session.getUserAnswer());
        assertEquals(3, session.getAttempts());

    }

    @Test
    @DisplayName("Checking that the game state changes correctly (if guessing/not guessing)")
    void correctlyChangesGameStateTest() {
        session.guess('f');
        assertEquals(1, session.getAttempts());
        assertArrayEquals(new char[] {'*', '*', '*', '*', '*', '*'}, session.getUserAnswer());
        session.guess('w');
        assertEquals(1, session.getAttempts());
        assertArrayEquals(new char[] {'*', 'w', '*', '*', '*', '*'}, session.getUserAnswer());
        session.guess('g');
        assertEquals(2, session.getAttempts());
        assertArrayEquals(new char[] {'*', 'w', '*', '*', '*', '*'}, session.getUserAnswer());

    }
}
