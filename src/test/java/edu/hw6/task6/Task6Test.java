package edu.hw6.task6;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static edu.hw6.task6.PortScanner.scanOccupiedPort;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {

    @Test
    void scanOccupiedPortTest() {
        Map<String, String> map = scanOccupiedPort();
        assertThat(map).isNotEmpty();
    }
}
