package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuoteClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final Logger LOGGER = LogManager.getLogger();

    public void run() {
        try (
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        ) {
            writer.println("личности");
            String response = reader.readLine();
            LOGGER.info(response);

            writer.println("оскорбления");
            response = reader.readLine();
            LOGGER.info(response);

            writer.println("глупый");
            response = reader.readLine();
            LOGGER.info(response);

            writer.println("интеллект");
            response = reader.readLine();
            LOGGER.info(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
