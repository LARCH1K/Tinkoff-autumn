package edu.hw8;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static edu.hw8.task3.HackMultiThread.decryptPasswords;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    void hackMultiThreadTest() {
        Map<String, String> passwordDatabase = new HashMap<>();
        passwordDatabase.put("a.v.petrov", "e2fc714c4727ee9395f324cd2e7f331f");
        passwordDatabase.put("v.v.belov", "81dc9bdb52d04dc20036dbd8313ed055");
        passwordDatabase.put("a.s.ivanov", "4d1ea1367acf0560c6716dd076a84d7f");
        passwordDatabase.put("k.p.maslov", "962012d09b8170d912f0669f6d7d9d07");
        passwordDatabase.put("s.y.sidorov", "0cc175b9c0f1b6a831c399e269772661");
        passwordDatabase.put("k.r.klimov", "fa246d0262c3925617b0c72bb20eeb1d");

        Map<String, String> actual = decryptPasswords(passwordDatabase, 4, 4);

        assertThat(actual.size()).isEqualTo(6);
        assertThat(actual).containsEntry("a.v.petrov", "abcd");
        assertThat(actual).containsEntry("v.v.belov", "1234");
        assertThat(actual).containsEntry("a.s.ivanov", "ewq");
        assertThat(actual).containsEntry("k.p.maslov", "qwer");
        assertThat(actual).containsEntry("s.y.sidorov", "a");
        assertThat(actual).containsEntry("k.r.klimov", "9999");
    }

    @Test
    void statsHackMultiThreadTest() {
        Map<String, String> passwordDatabase = new HashMap<>();
        passwordDatabase.put("a.v.petrov", "e2fc714c4727ee9395f324cd2e7f331f");
        passwordDatabase.put("v.v.belov", "81dc9bdb52d04dc20036dbd8313ed055");
        passwordDatabase.put("a.s.ivanov", "4d1ea1367acf0560c6716dd076a84d7f");
        passwordDatabase.put("k.p.maslov", "962012d09b8170d912f0669f6d7d9d07");

        for (int i = 1; i <= 8; i++) {
            long startTime = System.currentTimeMillis();
            decryptPasswords(passwordDatabase, i, 4);
            long endTime = System.currentTimeMillis();
            System.out.println("Число потоков = " + i + ". Выполнено за " + (endTime - startTime) + " миллисекунд");
        }
    }
}
