package edu.hw6.task4;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.hw6.task4.OutputStreamChainExample.task4;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    @Test
    void outputStreamChainExampleTest() throws IOException {
        Path path = Path.of("src/test/java/edu/hw6/task4/output.txt");
        task4(path);
        assertThat(Files.readAllLines(path).get(0)).isEqualTo(
            "Programming is learned by writing programs. ― Brian Kernighan");
    }
}
