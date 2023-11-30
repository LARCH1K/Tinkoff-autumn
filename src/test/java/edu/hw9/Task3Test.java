package edu.hw9;

import edu.hw9.task3.ParallelDFSSolver;
import edu.project2.components.Cell;
import edu.project2.components.Coordinate;
import edu.project2.components.Maze;
import edu.project2.generators.DFSGenerator;
import edu.project2.solvers.DFSSolver;
import edu.project2.solvers.Solver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    Maze maze;

    @BeforeEach
    void beforeEach() {
        maze = new Maze(3, 3);
        initializeMaze(maze, 3, 3);
        maze.getGrid()[0][0].setType(Cell.Type.PASSAGE);
        maze.getGrid()[0][1].setType(Cell.Type.PASSAGE);
        maze.getGrid()[1][1].setType(Cell.Type.PASSAGE);
        maze.getGrid()[2][1].setType(Cell.Type.PASSAGE);
        maze.getGrid()[2][2].setType(Cell.Type.PASSAGE);
        maze.getGrid()[0][2].setType(Cell.Type.PASSAGE);
        maze.getGrid()[2][0].setType(Cell.Type.PASSAGE);
    }

    @Test
    void solverDFSTest() {
        Solver solver = new ParallelDFSSolver(4);
        List<Coordinate> path = solver.solve(maze, new Coordinate(1, 1), new Coordinate(3, 3));
        assertThat(path).hasSize(5)
            .contains(new Coordinate(0, 0))
            .contains(new Coordinate(0, 1))
            .contains(new Coordinate(1, 1))
            .contains(new Coordinate(2, 1))
            .contains(new Coordinate(2, 2));
    }

    @Test
    void solverDSTest() {
        Solver solver = new ParallelDFSSolver(4);
        Solver solver2 = new DFSSolver();
        maze = new DFSGenerator().generate(1001, 1001);
        long startTime1 = System.currentTimeMillis();
        List<Coordinate> path = solver.solve(maze, new Coordinate(1, 1), new Coordinate(3, 3));
        long endTime1 = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        List<Coordinate> path2 = solver2.solve(maze, new Coordinate(1, 1), new Coordinate(3, 3));
        long endTime2 = System.currentTimeMillis();

        System.out.println(endTime1 - startTime1);
        System.out.println(endTime2 - startTime2);

        assertThat(path).isNotEmpty();
    }

    @Test
    void solverDFSWithInputWallCellTest() {
        Solver solver = new ParallelDFSSolver(4);
        List<Coordinate> path = solver.solve(maze, new Coordinate(2, 1), new Coordinate(3, 3));
        assertThat(path).isEmpty();
        path = solver.solve(maze, new Coordinate(1, 1), new Coordinate(2, 3));
        assertThat(path).isEmpty();
    }

    private void initializeMaze(final Maze maze, final int height, final int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze.getGrid()[i][j] = new Cell(i, j, Cell.Type.WALL);
            }
        }
    }
}

