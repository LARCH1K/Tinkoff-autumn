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
        DirectoryStream.Filter<Path> filter = regularFile()
            .and(readable())
            .and(sizeGreaterThan(1))
            .and(extensionEquals("txt"))
            .and(regexMatches(".*-.*"));

        ArrayList<Path> arrayList = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Path.of("src/test/java/edu/hw6/task3"), filter)) {
            for (Path element : entries) {
                arrayList.add(element);
            }
        }
        assertThat(arrayList).containsExactly(Path.of("src\\test\\java\\edu\\hw6\\task3\\qwe-rty.txt"));
        assertThat(arrayList).doesNotContain(Path.of("src\\test\\java\\edu\\hw6\\task3\\qwerty"));
    }
}
