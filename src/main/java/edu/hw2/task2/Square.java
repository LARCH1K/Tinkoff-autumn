package edu.hw2.task2;

public class Square extends Rectangle {

    public Square(final int width, final int height) {
        super(width, height);
        if (width != height) {
            throw new IllegalArgumentException();
        }
    }

    public Square() {

    }
}




