package edu.project1;

import org.jetbrains.annotations.NotNull;

sealed interface GuessResult {
    @NotNull String message(Session session);

    record Defeat() implements GuessResult {

        @Override
        public @NotNull String message(final Session session) {
            return "\nMissed, mistake 5 out of 5.\nYou lost";
        }
    }

    record Win() implements GuessResult {
        @Override
        public @NotNull String message(final Session session) {
            return "\nYou win";
        }
    }

    record SuccessfulGuess() implements GuessResult {
        @Override
        public @NotNull String message(final Session session) {
            return "\nHit";
        }
    }

    record FailedGuess() implements GuessResult {
        @Override
        public @NotNull String message(final Session session) {
            return "\nMissed, mistake " + session.getAttempts() + " out of " + session.getMaxAttempts() + ".";
        }
    }

    record GiveUp() implements GuessResult {
        @Override
        public @NotNull String message(final Session session) {
            return "\nYou giveUp!";
        }
    }
}
