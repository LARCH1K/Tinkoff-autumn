package edu.project1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class Session {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int MAX_ATTEMPTS = 5;
    private final String answer;
    private final char[] userAnswer;
    private int attempts;

    public Session(Dictionary dictionary) {
        this.answer = dictionary.getWord();
        this.userAnswer = new char[this.answer.length()];
        Arrays.fill(this.userAnswer, '*');
        this.attempts = 0;
    }

    int getAttempts() {
        return attempts;
    }

    int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    char[] getUserAnswer() {
        return userAnswer;
    }

    void printState() {
        StringBuilder word = new StringBuilder();
        for (final char letter : userAnswer) {
            word.append(letter);
        }
        LOGGER.info("\nThe word: " + word);
    }

    @NotNull GuessResult guess(char guess) {
        boolean successfulAnswer = isSuccessfulAnswer(guess);
        if (Arrays.equals(userAnswer, answer.toCharArray())) {
            return new GuessResult.Win();
        }
        if (!successfulAnswer && attempts >= MAX_ATTEMPTS - 1) {
            return new GuessResult.Defeat();
        }
        if (successfulAnswer) {
            return new GuessResult.SuccessfulGuess();
        } else {
            attempts++;
            return new GuessResult.FailedGuess();
        }
    }

    private boolean isSuccessfulAnswer(final char guess) {
        boolean successfulAnswer = false;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                userAnswer[i] = guess;
                successfulAnswer = true;
            }
        }
        return successfulAnswer;
    }
}
