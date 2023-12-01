package edu.hw6.task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {

    boolean accept(Path entry);

    default AbstractFilter and(AbstractFilter other) {
        return entry -> this.accept(entry) && other.accept(entry);
    }

    default AbstractFilter or(AbstractFilter other) {
        return entry -> this.accept(entry) || other.accept(entry);
    }

    static AbstractFilter regularFile() {
        return Files::isRegularFile;
    }

    static AbstractFilter readable() {
        return Files::isReadable;
    }

    static AbstractFilter writable() {
        return Files::isWritable;
    }

    static AbstractFilter executable() {
        return Files::isExecutable;
    }

    static AbstractFilter sizeGreaterThan(long size) {
        return entry -> {
            try {
                return Files.size(entry) > size;
            } catch (IOException e) {
                return false;
            }
        };
    }

    static AbstractFilter extensionEquals(String extension) {
        return entry -> {
            String fileExtension = entry.toString();
            int dotIndex = fileExtension.lastIndexOf('.');
            return dotIndex != -1 && fileExtension.substring(dotIndex + 1).equalsIgnoreCase(extension);
        };
    }

    static AbstractFilter regexMatches(String regex) {
        return entry -> entry.getFileName().toString().matches(regex);
    }

    static AbstractFilter magicNumber(byte... magicBytes) {
        return entry -> {
            try {
                byte[] fileBytes = Files.readAllBytes(entry);
                if (fileBytes.length < magicBytes.length) {
                    return false;
                }
                for (int i = 0; i < magicBytes.length; i++) {
                    if (fileBytes[i] != magicBytes[i]) {
                        return false;
                    }
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        };
    }
}
