package edu.hw2.task2;

public class Square extends Rectangle {

    public Square(final int side) {
        super(side, side);
    }

    public Square setSide(final int side) {
        return new Square(side);
    }
}




