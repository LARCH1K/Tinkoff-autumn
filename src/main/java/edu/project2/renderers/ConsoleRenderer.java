package edu.project2.renderers;

import edu.project2.components.Cell;
import edu.project2.components.Coordinate;
import edu.project2.components.Maze;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ConsoleRenderer implements Renderer {
    @Override
    public String render(final Maze maze) {
        if (maze == null) {
            throw new IllegalArgumentException();
        }
        return getStringMaze(maze.getGrid());
    }

    @Override
    public String render(final Maze maze, final List<Coordinate> path) {
        if (maze == null || path == null) {
            throw new IllegalArgumentException();
        }
        Cell[][] mazeWithPath = new Cell[maze.getHeight()][maze.getWidth()];
        for (int i = 0; i < mazeWithPath.length; i++) {
            for (int j = 0; j < mazeWithPath[i].length; j++) {
                mazeWithPath[i][j] = new Cell(i, j, maze.getGrid()[i][j].getType());
            }
        }
        for (Coordinate coordinate : path) {
            mazeWithPath[coordinate.row()][coordinate.col()] =
                new Cell(coordinate.row(), coordinate.col(), Cell.Type.PATH);
        }
        return getStringMaze(mazeWithPath);
    }

    @NotNull private static String getStringMaze(final Cell[][] mazeWithPath) {
        StringBuilder mazeStr = new StringBuilder();
        mazeStr.append("⬛".repeat(Math.max(0, mazeWithPath[0].length + 2)));
        mazeStr.append('\n');
        for (Cell[] row : mazeWithPath) {
            mazeStr.append("⬛");
            for (Cell cell : row) {
                if (cell.getType() == Cell.Type.WALL) {
                    mazeStr.append("⬛");
                } else {
                    mazeStr.append(cell.getType() == Cell.Type.PASSAGE ? "⬜" : "\uD83D\uDD37");
                }
            }
            mazeStr.append("⬛");
            mazeStr.append('\n');
        }
        mazeStr.append("⬛".repeat(Math.max(0, mazeWithPath[0].length + 2)));
        return mazeStr.toString();
    }
}
