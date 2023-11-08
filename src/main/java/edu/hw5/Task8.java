package edu.hw5;

public class Task8 {

    private Task8() {
    }

    public static boolean firstTask(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return string.matches("^(01|10|11|00)*[01]$");
    }

    public static boolean secondTask(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return string.matches("^(0(01|10|11|00)*|1(01|10|11|00)*[01])$");
    }

    public static boolean thirdTask(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return string.matches("^((1*0){3})+1*$");
    }

    public static boolean fourthTask(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return string.matches("^(?!11$|111$)[01]+$");
    }

    public static boolean fifthTask(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return string.matches("^1(01|11)*[10]?$");
    }

    public static boolean sixthTask(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return string.matches("^(0+1?0+|0{2,}1?0*|0*1?0{2,})$");
    }

    public static boolean seventhTask(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        return string.matches("^(?!.*11)[01]+$");
    }

}
