package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientHandler implements Runnable {
    private final SocketChannel clientChannel;

    public ClientHandler(SocketChannel clientChannel) {
        this.clientChannel = clientChannel;
    }

    @Override
    public void run() {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(256);
            int bytesRead = clientChannel.read(buffer);
            buffer.flip();
            String request = new String(buffer.array(), 0, bytesRead).trim();
            System.out.println("Получен запрос от клиента: " + request);

            String response = processRequest(request);
            sendResponse(response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendResponse(String response) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(response.getBytes());
        while (buffer.hasRemaining()) {
            clientChannel.write(buffer);
        }
        clientChannel.write(ByteBuffer.wrap("\n".getBytes()));
    }

    private String processRequest(String request) {
        // Реализуйте здесь свою логику обработки запроса и формирования ответа
        switch (request.toLowerCase()) {
            case "личности":
                return "Не переходи на личности там, где их нет";
            case "оскорбления":
                return "Если твои противники перешли на личные оскорбления, будь уверен, твоя победа не за горами";
            case "глупый":
                return "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.";
            case "интеллект":
                return "Чем ниже интеллект, тем громче оскорбления";
            default:
                return "Неизвестный запрос";
        }
    }
}
