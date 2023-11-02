package edu.project2.renderers;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.List;

public class ConsoleRenderer implements Renderer {
    @Override
    public String render(final Maze maze) {
        StringBuilder mazeStr = new StringBuilder();
        mazeStr.append("⬛".repeat(Math.max(0, maze.getWidth() + 2)));
        mazeStr.append('\n');
        for (Cell[] row : maze.getGrid()) {
            mazeStr.append("⬛");
            for (Cell cell : row) {
                mazeStr.append(cell.getType() == Cell.Type.PASSAGE ? "⬜" : "⬛");
            }
            mazeStr.append("⬛");
            mazeStr.append('\n');
        }
        mazeStr.append("⬛".repeat(Math.max(0, maze.getWidth() + 2)));
        return mazeStr.toString();
    }

    @Override
    public String render(final Maze maze, final List<Coordinate> path) {
        StringBuilder mazeStr = new StringBuilder();
        mazeStr.append("⬛".repeat(Math.max(0, maze.getWidth() + 2)));
        mazeStr.append('\n');
        for (Coordinate coordinate : path) {
            maze.getGrid()[coordinate.row()][coordinate.col()] = new Cell(Cell.Type.PATH);
        }
        for (Cell[] row : maze.getGrid()) {
            mazeStr.append("⬛");
            for (Cell cell : row) {
                if(cell.getType() == Cell.Type.PATH){
                    //mazeStr.append("⚪");
                    mazeStr.append("\uD83D\uDD37");
                }else {
                    mazeStr.append(cell.type() == Cell.Type.PASSAGE ? "⬜" : "⬛");
                }
            }
            mazeStr.append("⬛");
            mazeStr.append('\n');
        }
        mazeStr.append("⬛".repeat(Math.max(0, maze.getWidth() + 2)));
        return mazeStr.toString();
    }
}
