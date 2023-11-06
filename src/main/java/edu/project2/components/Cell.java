package edu.project2.components;

public class Cell {

    private Type type;

    private final int row;

    private final int col;

    public Cell(final int row, final int col, final Type type) {
        this.type = type;
        this.row = row;
        this.col = col;
    }

    public enum Type {
        WALL,
        PASSAGE,
        PATH
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
