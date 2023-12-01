package edu.hw5;

public class Task5 {
    private Task5() {
    }

    public static boolean isLicensePlate(String licensePlate) {
        if (licensePlate == null) {
            throw new IllegalArgumentException();
        }
        String passwordRegex = "^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$";
        return licensePlate.matches(passwordRegex);
    }
}
