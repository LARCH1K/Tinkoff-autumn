package edu.hw6.task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CloneFile {
    private CloneFile() {
    }

    public static void cloneFile(Path path) {
        String filename = path.getFileName().toString();
        String extension = "";
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex != -1) {
            extension = filename.substring(dotIndex);
            filename = filename.substring(0, dotIndex);
        }

        String newFilename = filename + " - копия" + extension;
        String newPath = path.getParent().toString() + "/" + newFilename;
        if (new File(newPath).exists()) {
            int count = 2;
            while (new File(newPath).exists()) {
                newFilename = filename + " - копия (" + count++ + ")" + extension;
                newPath = path.getParent().toString() + "/" + newFilename;
            }
        }

        try {
            Files.copy(path, path.resolveSibling(newFilename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
