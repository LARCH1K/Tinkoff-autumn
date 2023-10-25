package edu.hw2.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(final ConnectionManager manager, final int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    public void tryExecute(String command) throws Exception {
        int countAttempts = 0;
        while (true) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                break;
            } catch (ConnectionException connectionException) {
                if (++countAttempts > maxAttempts) {
                    throw new ConnectionException(connectionException);
                }
            }
        }
    }
}

