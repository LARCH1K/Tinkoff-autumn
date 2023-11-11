package edu.hw6.task3;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import static edu.hw6.task3.AbstractFilter.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    void abstractFilterTest() throws IOException {
        final Path path1 = Path.of("src/test/java/edu/hw6/task3/qwe-rty.txt");
        final Path path2 = Path.of("src/test/java/edu/hw6/task3/qwerty");
        Files.deleteIfExists(path1);
        Files.deleteIfExists(path2);
        Files.createFile(path1);
        Files.createFile(path2);

        DirectoryStream.Filter<Path> filter = regularFile()
            .and(readable())
            .and(extensionEquals("txt"))
            .and(regexMatches(".*-.*"));

        ArrayList<Path> arrayList = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of("src/test/java/edu/hw6/task3"), filter)) {
            for (Path element : entries) {
                arrayList.add(element);
            }
        }
        assertThat(arrayList).containsExactly(path1);
        assertThat(arrayList).doesNotContain(path2);
    }
}
