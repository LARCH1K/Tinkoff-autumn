package edu.project2.components;

public final class Maze {
    private final int height;
    private final int width;
    private final Cell[][] grid;

    public Maze(final int height, final int width) {
        this.height = height;
        this.width = width;
        this.grid = new Cell[height][width];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell[][] getGrid() {
        return grid;
    }

}






