package edu.hw6.task1;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    @Test
    void putIntoDiskMapTest() throws IOException {
        Files.deleteIfExists(Path.of("src/test/java/edu/hw6/task1/diskMapTest.txt"));
        DiskMap diskMap = new DiskMap(new File("src/test/java/edu/hw6/task1/diskMapTest.txt"));
        diskMap.put("1111", "123");
        diskMap.put("2222", "456");

        assertThat(diskMap).containsEntry("1111", "123");
        assertThat(diskMap).containsEntry("2222", "456");
    }

    @Test
    void getFromDiskMapTest() throws IOException {
        Files.deleteIfExists(Path.of("src/test/java/edu/hw6/task1/diskMapTest.txt"));
        DiskMap diskMap = new DiskMap(new File("src/test/java/edu/hw6/task1/diskMapTest.txt"));
        diskMap.put("1111", "123");
        diskMap.put("2222", "456");

        assertThat(diskMap).containsEntry("1111", "123");
        assertThat(diskMap).containsEntry("2222", "456");
    }

    @Test
    void deleteFromDiskMapTest() throws IOException {
        Files.deleteIfExists(Path.of("src/test/java/edu/hw6/task1/diskMapTest.txt"));
        DiskMap diskMap = new DiskMap(new File("src/test/java/edu/hw6/task1/diskMapTest.txt"));
        diskMap.put("1111", "123");
        diskMap.put("2222", "456");

        diskMap.remove("1111");

        assertThat(diskMap.size()).isEqualTo(1);
        assertThat(diskMap.get("2222")).isEqualTo("456");
    }

    @Test
    void loadFromFileToDiskMapTest() throws IOException {
        Files.deleteIfExists(Path.of("src/test/java/edu/hw6/task1/diskMapTest.txt"));
        DiskMap diskMap = new DiskMap(new File("src/test/java/edu/hw6/task1/diskMapTest.txt"));
        diskMap.put("1111", "123");
        diskMap.put("2222", "456");

        DiskMap diskMap2 = new DiskMap(new File("src/test/java/edu/hw6/task1/diskMapTest.txt"));
        assertThat(diskMap2).containsEntry("1111", "123");
        assertThat(diskMap2).containsEntry("2222", "456");
    }
}
