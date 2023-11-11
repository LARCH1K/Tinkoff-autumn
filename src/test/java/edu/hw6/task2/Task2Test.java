package edu.hw6.task2;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.hw6.task2.CloneFile.cloneFile;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {

    private final Path path1 = Path.of("src/test/java/edu/hw6/task2/Tinkoff Bank Biggest Secret - копия.txt");
    private final Path path2 = Path.of("src/test/java/edu/hw6/task2/Tinkoff Bank Biggest Secret - копия (2).txt");
    private final Path path3 = Path.of("src/test/java/edu/hw6/task2/Tinkoff Bank Biggest Secret - копия (3).txt");
    private final Path path4 = Path.of("src/test/java/edu/hw6/task2/Tinkoff Bank Biggest Secret - копия (4).txt");
    private final Path path5 = Path.of("src/test/java/edu/hw6/task2/Tinkoff Bank Biggest Secret - копия (5).txt");

    @Test
    void cloneFileTest() throws IOException {
        Files.deleteIfExists(path1);
        Files.deleteIfExists(path2);
        Files.deleteIfExists(path3);
        Files.deleteIfExists(path4);
        Files.deleteIfExists(path5);

        for (int i = 0; i < 5; i++) {
            cloneFile(Path.of("src/test/java/edu/hw6/task2/Tinkoff Bank Biggest Secret.txt"));
        }
        assertTrue(Files.exists(path1));
        assertTrue(Files.exists(path2));
        assertTrue(Files.exists(path3));
        assertTrue(Files.exists(path4));
        assertTrue(Files.exists(path5));
    }
}
