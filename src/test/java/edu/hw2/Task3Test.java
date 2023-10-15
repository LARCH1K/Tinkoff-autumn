package edu.hw2;

import edu.hw2.task3.ConnectionException;
import edu.hw2.task3.DefaultConnectionManager;
import edu.hw2.task3.FaultyConnection;
import edu.hw2.task3.FaultyConnectionManager;
import edu.hw2.task3.PopularCommandExecutor;
import edu.hw2.task3.StableConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {

    @Test
    @DisplayName("Test FaultyConnection throws exception")
    void faultyConnectionThrowsExceptionTest() {
        assertThrows(ConnectionException.class, () -> {
            while (true) {
                new FaultyConnection().execute("");
            }
        });
    }

    @Test
    @DisplayName("Test execute in FaultyConnection done")
    void executeInFaultyConnectionDoneTest() {
        while (true) {
            try {
                new FaultyConnection().execute("");
                break;
            } catch (ConnectionException ignored) {
            }
        }
    }

    @Test
    @DisplayName("Test FaultyConnectionManager returns FaultyConnection")
    void FaultyConnectionManagerReturnsFaultyConnectionTest() {
        assertEquals(FaultyConnection.class, new FaultyConnectionManager().getConnection().getClass());
    }

    @Test
    @DisplayName("Test DefaultConnectionManager returns FaultyConnection")
    void DefaultConnectionManagerReturnsFaultyConnectionTest() {
        while (true) {
            if (FaultyConnection.class.equals(new DefaultConnectionManager().getConnection().getClass())) {
                break;
            }
        }
    }

    @Test
    @DisplayName("Test DefaultConnectionManager returns StableConnection")
    void DefaultConnectionManagerReturnsStableConnectionTest() {
        while (true) {
            if (StableConnection.class.equals(new DefaultConnectionManager().getConnection().getClass())) {
                break;
            }
        }
    }

    @Test
    @DisplayName("Test PopularCommandExecutor executed")
    void PopularCommandExecutorExecutedTest() throws Exception {
        while (true) {
            try {
                PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(), 10);
                executor.updatePackages();
                break;
            } catch (ConnectionException ignored) {
            }
        }
    }

    @Test
    @DisplayName("Test PopularCommandExecutor throws Exception")
    void PopularCommandExecutorThrowsExceptionTest() throws Exception {
        assertThrows(ConnectionException.class, () -> {
            while (true) {
                PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(), 3);
                executor.updatePackages();
            }
        });
    }
}

