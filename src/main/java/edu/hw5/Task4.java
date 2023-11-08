package edu.hw5;

public class Task4 {
    private Task4() {
    }

    public static boolean isValidPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException();
        }
        String passwordRegex = ".*[~!@#$%^&*|].*";
        return password.matches(passwordRegex);
    }
}
