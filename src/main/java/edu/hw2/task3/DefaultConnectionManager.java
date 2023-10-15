package edu.hw2.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    final private static int CHANCE_ONE_IN_THREE = 3;

    @Override
    public Connection getConnection() {
        Random random = new Random();
        if (random.nextInt(CHANCE_ONE_IN_THREE) == 0) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
