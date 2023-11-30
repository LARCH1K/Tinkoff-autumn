package edu.hw8;

import edu.hw8.task1.QuoteClient;
import edu.hw8.task1.QuoteServer;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    public void quoteServerTest() throws InterruptedException {
        final QuoteServer server = new QuoteServer();
        Thread serverThread = new Thread(server::run);
        Set<String> answers = new ConcurrentSkipListSet<>();
        Thread clientThread1 = new Thread(() -> {
            QuoteClient client = new QuoteClient();
            client.sendRequest("интеллект");
            answers.add(client.getAnswer());
            client.sendRequest("оскорбления");
            answers.add(client.getAnswer());
        });
        Thread clientThread2 = new Thread(() -> {
            QuoteClient client = new QuoteClient();
            client.sendRequest("личности");
            answers.add(client.getAnswer());
            client.sendRequest("глупый");
            answers.add(client.getAnswer());
        });

        serverThread.start();
        Thread.sleep(50);
        clientThread1.start();
        clientThread2.start();
        clientThread1.join();
        clientThread2.join();
        serverThread.join(1000);

        assertThat(answers.contains("Чем ниже интеллект, тем громче оскорбления")).isTrue();
        assertThat(answers.contains("Не переходи на личности там, где их нет")).isTrue();
        assertThat(answers.contains(
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.")).isTrue();
        assertThat(answers.contains(
            "Если твои противники перешли на личные оскорбления, будь уверен — твоя победа не за горами")).isTrue();
    }
}
