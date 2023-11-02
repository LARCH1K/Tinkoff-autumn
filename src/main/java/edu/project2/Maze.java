package edu.project2;

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

    public boolean isIn(Coordinate coordinate) {
        return coordinate.col() >= 0 && coordinate.row() >= 0 && coordinate.col() < width && coordinate.row() < height;
    }

    public Cell.Type getCellType(Coordinate coordinate) {
        return grid[coordinate.row()][coordinate.col()].type();
    }
    public boolean isIn(int col, int row) {
        return col >= 0 && row >= 0 && col < width && row < height;
    }
}






