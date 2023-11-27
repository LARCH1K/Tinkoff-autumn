package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuoteServer {
    private static final int PORT = 8080;
    private static final int MAX_CONNECTIONS = 5;
    private static final String[] QUOTES = {
        "Не переходи на личности там, где их нет",
        "Если твои противники перешли на личные оскорбления, будь уверен — твоя победа не за горами",
        "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
        "Чем ниже интеллект, тем громче оскорбления"
    };
    private static final Logger LOGGER = LogManager.getLogger();

    public void run() {
        try (ExecutorService executorService = Executors.newFixedThreadPool(MAX_CONNECTIONS);
             ServerSocket serverSocket = new ServerSocket(PORT
             )) {
            LOGGER.info("Сервер запущен. Ожидание подключений...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                LOGGER.info("Новое соединение установлено.");

                executorService.submit(() -> handleClient(clientSocket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                LOGGER.info("Получено сообщение от клиента: " + clientMessage);
                String response = findQuoteByKeyword(clientMessage);
                writer.println(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static String findQuoteByKeyword(String keyword) {
        for (String quote : QUOTES) {
            if (quote.contains(keyword)) {
                return "Сервер: " + quote;
            }
        }
        return "Сервер: К сожалению, цитата по данному ключевому слову не найдена.";
    }
}
