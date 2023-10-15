package edu.hw2.task1;

import static java.lang.Math.pow;

public sealed interface Expr {
    double evaluate();

    public record Constant(double constant) implements Expr {
        @Override
        public double evaluate() {
            return constant;
        }
    }

    public record Negate(Expr value) implements Expr {
        @Override
        public double evaluate() {
            return -value.evaluate();
        }
    }

    public record Exponent(Expr value, double exp) implements Expr {
        @Override
        public double evaluate() {
            return pow(value.evaluate(), exp);
        }
    }

    public record Addition(Expr value1, Expr value2) implements Expr {
        @Override
        public double evaluate() {
            return value1.evaluate() + value2.evaluate();
        }
    }

    public record Multiplication(Expr value1, Expr value2) implements Expr {
        @Override
        public double evaluate() {
            return value1.evaluate() * value2.evaluate();
        }
    }
}
