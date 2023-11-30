package edu.hw9.task2;

import java.io.File;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class FileSystemSearch {
    private FileSystemSearch() {
    }

//    public static void main(String[] args) {
//        List<File> foundFile = searchDirectoriesWithMoreThan1000Files("D:\\", 1000);
//
//        System.out.println("Found directories matching the criteria:");
//        for (File file : foundFile) {
//            System.out.println(file.getAbsolutePath());
//        }
//
//        System.out.println();
//        System.out.println("------------------------------------");
//        System.out.println();
//
//        List<File> foundFiles = searchFilesWithASpecificExtensionAndSize("D:\\", ".txt", 1024000);
//        System.out.println("Found files matching the criteria:");
//        for (File file : foundFiles) {
//            System.out.println(file.getAbsolutePath());
//        }
//    }

    public static List<File> searchDirectoriesWithMoreThanCountFiles(String path, int countFiles) {
        try (ForkJoinPool pool = new ForkJoinPool();) {
            File rootDirectory = new File(path);
            return pool.invoke(new FileCountTask(rootDirectory, countFiles));
        }
    }

    public static List<File> searchFilesWithASpecificExtensionAndSize(
        String path,
        String extension,
        long sizeThreshold
    ) {
        try (ForkJoinPool pool = new ForkJoinPool();) {
            File rootDirectory = new File(path);
            return pool.invoke(new FileSearchTask(rootDirectory, extension, sizeThreshold));
        }
    }
}
