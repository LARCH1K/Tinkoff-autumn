package edu.hw3;

public class Task4 {
    final private static int MAX_NUMBER_WITHOUT_SPEC_SYMBOLS = 3999;
    final private static int THOUSANDTH_PLACE = 1000;
    final private static int HUNDREDTH_PLACE = 100;
    final private static int DECIMAL_PLACE = 10;

    private Task4() {
    }

    static String convertToRoman(int number) {
        if (number <= 0 || number > MAX_NUMBER_WITHOUT_SPEC_SYMBOLS) {
            throw new IllegalArgumentException();
        }
        String[] m = {"", "M", "MM", "MMM"};
        String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return m[number / THOUSANDTH_PLACE] + c[(number % THOUSANDTH_PLACE) / HUNDREDTH_PLACE]
            + x[(number % HUNDREDTH_PLACE) / DECIMAL_PLACE] + i[number % DECIMAL_PLACE];
    }
}
