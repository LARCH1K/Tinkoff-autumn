package edu.hw2.task2;

public class Rectangle {
    final private int width;
    final private int height;

    public Rectangle(final int width, final int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
    }

    final public int getWidth() {
        return width;
    }

    final public int getHeight() {
        return height;
    }

    public double area() {
        return width * height;
    }
}



