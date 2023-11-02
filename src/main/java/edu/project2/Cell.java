package edu.project2;

public class Cell {

    public enum Type {
        WALL,
        PASSAGE,
        PATH
    }

    Type type;

    public Cell(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
