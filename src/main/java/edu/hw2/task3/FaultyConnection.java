package edu.hw2.task3;

import java.util.Random;

public class FaultyConnection implements Connection {
    @Override
    public void execute(final String command) {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new ConnectionException();
        }

    }

    @Override
    public void close() throws Exception {

    }
}
