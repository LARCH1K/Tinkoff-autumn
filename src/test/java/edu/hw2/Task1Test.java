package edu.hw2;

import edu.hw2.task1.Expr.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    @Test
    @DisplayName("Test from task")
    void taskTest() {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        assertEquals(37, res.evaluate());
    }

    @Test
    @DisplayName("Test record Constant")
    void constantTest() {
        var res = new Constant(2);
        Assertions.assertEquals(2, res.evaluate());

        res = new Constant(147);
        Assertions.assertEquals(147, res.evaluate());

        res = new Constant(-9);
        Assertions.assertEquals(-9, res.evaluate());
    }

    @Test
    @DisplayName("Test record Negate")
    void negateTest() {
        var res = new Negate(new Constant(2));
        Assertions.assertEquals(-2, res.evaluate());

        res = new Negate(new Constant(174));
        Assertions.assertEquals(-174, res.evaluate());

        res = new Negate(new Constant(-88));
        Assertions.assertEquals(88, res.evaluate());
    }

    @Test
    @DisplayName("Test record Exponent")
    void exponentTest() {
        var res = new Exponent(new Constant(2), 8);
        Assertions.assertEquals(256, res.evaluate());

        res = new Exponent(new Constant(3), 3);
        Assertions.assertEquals(27, res.evaluate());

        res = new Exponent(new Constant(-4), 5);
        Assertions.assertEquals(-1024, res.evaluate());
    }

    @Test
    @DisplayName("Test record Addition")
    void additionTest() {
        var res = new Addition(new Constant(2), new Constant(2));
        Assertions.assertEquals(4, res.evaluate());

        res = new Addition(new Constant(3), new Constant(-8));
        Assertions.assertEquals(-5, res.evaluate());

        res = new Addition(new Constant(-4), new Constant(256));
        Assertions.assertEquals(252, res.evaluate());
    }

    @Test
    @DisplayName("Test record Multiplication")
    void multiplicationTest() {
        var res = new Multiplication(new Constant(2), new Constant(2));
        Assertions.assertEquals(4, res.evaluate());

        res = new Multiplication(new Constant(3), new Constant(-8));
        Assertions.assertEquals(-24, res.evaluate());

        res = new Multiplication(new Constant(7), new Constant(9));
        Assertions.assertEquals(63, res.evaluate());
    }

}
