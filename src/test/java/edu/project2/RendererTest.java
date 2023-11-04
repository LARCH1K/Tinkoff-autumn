package edu.project2;

import edu.project2.components.Cell;
import edu.project2.components.Coordinate;
import edu.project2.components.Maze;
import edu.project2.renderers.ConsoleRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RendererTest {

    @Test
    void renderMazeWithoutPathTest(){
        Maze maze = new Maze(3,3);
        initializeMaze(maze, 3, 3);
        maze.getGrid()[0][0].setType(Cell.Type.PASSAGE);
        maze.getGrid()[0][1].setType(Cell.Type.PASSAGE);
        maze.getGrid()[1][1].setType(Cell.Type.PASSAGE);
        maze.getGrid()[2][1].setType(Cell.Type.PASSAGE);
        maze.getGrid()[2][2].setType(Cell.Type.PASSAGE);

        ConsoleRenderer consoleRenderer = new ConsoleRenderer();
        String expected = "⬛⬛⬛⬛⬛\n⬛⬜⬜⬛⬛\n⬛⬛⬜⬛⬛\n⬛⬛⬜⬜⬛\n⬛⬛⬛⬛⬛";
        assertEquals(expected, consoleRenderer.render(maze));
    }

    @Test
    void renderMazeWithPathTest(){
        Maze maze = new Maze(3,3);
        initializeMaze(maze, 3, 3);
        maze.getGrid()[0][0].setType(Cell.Type.PASSAGE);
        maze.getGrid()[0][1].setType(Cell.Type.PASSAGE);
        maze.getGrid()[1][1].setType(Cell.Type.PASSAGE);
        maze.getGrid()[2][1].setType(Cell.Type.PASSAGE);
        maze.getGrid()[2][2].setType(Cell.Type.PASSAGE);

        List<Coordinate> coordinates = new ArrayList<>(List.of(new Coordinate(0, 0), new Coordinate(0, 1), new Coordinate(1, 1)));
        ConsoleRenderer consoleRenderer = new ConsoleRenderer();
        String expected = "⬛⬛⬛⬛⬛\n⬛\uD83D\uDD37\uD83D\uDD37⬛⬛\n⬛⬛\uD83D\uDD37⬛⬛\n⬛⬛⬜⬜⬛\n⬛⬛⬛⬛⬛";
        assertEquals(expected, consoleRenderer.render(maze, coordinates));
    }

    private void initializeMaze(final Maze maze, final int height, final int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze.getGrid()[i][j] = new Cell(i, j, Cell.Type.WALL);
            }
        }
    }
}
