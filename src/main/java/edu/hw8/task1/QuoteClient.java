package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class QuoteClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8080;

    private final Socket socket;
    private final BufferedReader reader;
    private final PrintWriter writer;

    public QuoteClient() {
        try {
            this.socket = new Socket(SERVER_IP, SERVER_PORT);
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendRequest(String send) {
        writer.println(send);
    }

    public String getAnswer() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
