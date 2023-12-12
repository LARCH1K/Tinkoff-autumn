package edu.hw8.task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HackMultiThread {
    private HackMultiThread() {
    }

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static Map<String, String> decryptPasswords(
        Map<String, String> passwordDatabase, int countThreads, int passwordLength
    ) {
        long countVariables = countVariables(passwordLength);
        Map<String, String> passwords = new HashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(countThreads);
        for (int i = 0; i < countThreads; i++) {
            long from = countVariables / countThreads * i;
            long to = countVariables / countThreads * (i + 1);
            executorService.submit(() -> crackPasswords(passwordDatabase, from, to, passwordLength, passwords));
        }
        executorService.close();

        return passwords;
    }

    private static long countVariables(final int passwordLength) {
        long count = 0;
        for (int i = 1; i <= passwordLength; i++) {
            count += (long) Math.pow(CHARACTERS.length(), i);
        }
        return count;
    }

    private static void crackPasswords(
        Map<String, String> passwordDatabase, long from, long to,
        final int passwordLength,
        final Map<String, String> passwords
    ) {
        String password;
        int length = 1;
        while (from > Math.pow(CHARACTERS.length(), length)) {
            length++;
        }
        long currentIndex = from;
        password = generatePasswords(length, to, currentIndex++);
        while (password != null) {
            String hashedPassword = md5Hash(password);
            if (passwordDatabase.containsValue(hashedPassword)) {
                for (Map.Entry<String, String> entry : passwordDatabase.entrySet()) {
                    if (entry.getValue().equals(hashedPassword)) {
                        passwords.put(entry.getKey(), password);
                    }
                }
            }
            password = generatePasswords(length, to, currentIndex++);
            if ((password == null && length < passwordLength) && currentIndex <= to) {
                currentIndex = 0;
                length++;
                password = generatePasswords(length, to, currentIndex);
            }
        }
    }

    private static String generatePasswords(int length, long to, long currentIndex) {
        if (currentIndex >= Math.pow(CHARACTERS.length(), length) || currentIndex >= to) {
            return null;
        }
        StringBuilder variation = new StringBuilder();
        long index = currentIndex;

        for (int i = 0; i < length; i++) {
            int charIndex = (int) (index % CHARACTERS.length());
            variation.append(CHARACTERS.charAt(charIndex));
            index /= CHARACTERS.length();
        }
        return variation.toString();
    }

    private static String md5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();

            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
