package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class QuoteClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) throws InterruptedException {
        try (SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(SERVER_ADDRESS, SERVER_PORT))) {

            // Пример запросов к серверу

            sendRequest(socketChannel, "личности");
            System.out.println("Ответ сервера: " + receiveResponse(socketChannel));

            sendRequest(socketChannel, "оскорбления");
            System.out.println("Ответ сервера: " + receiveResponse(socketChannel));

            sendRequest(socketChannel, "глупый");
            System.out.println("Ответ сервера: " + receiveResponse(socketChannel));

            sendRequest(socketChannel, "интеллект");
            System.out.println("Ответ сервера: " + receiveResponse(socketChannel));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendRequest(SocketChannel socketChannel, String request) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(request.getBytes());
        socketChannel.write(buffer);
        socketChannel.write(ByteBuffer.wrap("\n".getBytes()));
    }

    private static String receiveResponse(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(256);
        int bytesRead = socketChannel.read(buffer);
        if (bytesRead == -1) {
            throw new IOException("Сервер закрыл соединение");
        }
        buffer.flip();
        return new String(buffer.array(), 0, bytesRead).trim();
    }
}
