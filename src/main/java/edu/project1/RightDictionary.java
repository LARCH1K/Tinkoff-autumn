package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

class RightDictionary implements Dictionary {
    private static final String[] WORDS = {"hello", "array", "string", "random", "class"};

    private static final Random RANDOM = new Random();

    RightDictionary() {
    }

    public @NotNull String getWord() {
        return WORDS[RANDOM.nextInt(WORDS.length)].toLowerCase();
    }
}
