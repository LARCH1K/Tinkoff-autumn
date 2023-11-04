package edu.project2.generators;

import edu.project2.components.Cell;
import edu.project2.components.Coordinate;
import edu.project2.components.Maze;
import java.util.ArrayList;
import java.util.Random;

//Алгоритм корректно работает только с нечётными значениями, так как по его условию шаг равен 2
public class AldousBroderGenerator implements Generator {

    private final static Random RANDOM = new Random();

    private final static int STEP = 2;

    private Maze maze;

    @Override
    public Maze generate(final int height, final int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        maze = new Maze(height, width);
        initializeMaze(height, width);
        Coordinate curr = new Coordinate(0, 0);
        maze.getGrid()[0][0].setType(Cell.Type.PASSAGE);
        while (!isValidMaze()) {
            ArrayList<Coordinate> directions = new ArrayList<>();
            if (curr.col() > 0) {
                directions.add(new Coordinate(0, -STEP));
            }
            if (curr.col() < width - 1) {
                directions.add(new Coordinate(0, STEP));
            }
            if (curr.row() > 0) {
                directions.add(new Coordinate(-STEP, 0));
            }
            if (curr.row() < height - 1) {
                directions.add(new Coordinate(STEP, 0));
            }
            Coordinate move = directions.get(RANDOM.nextInt(directions.size()));
            if (curr.row() + move.row() >= height || curr.col() + move.col() >= width) {
                continue;
            }
            curr = new Coordinate(curr.row() + move.row(), curr.col() + move.col());
            if (maze.getGrid()[curr.row()][curr.col()].getType() == Cell.Type.WALL) {
                maze.getGrid()[curr.row()][curr.col()].setType(Cell.Type.PASSAGE);
                maze.getGrid()[curr.row() - move.row() / 2][curr.col() - move.col() / 2].setType(Cell.Type.PASSAGE);
            }
        }
        return maze;
    }

    private boolean isValidMaze() {
        for (int i = 0; i < maze.getHeight(); i += 2) {
            for (int j = 0; j < maze.getWidth(); j += 2) {
                if (maze.getGrid()[i][j].getType() == Cell.Type.WALL) {
                    return false;
                }
            }
        }
        return true;
    }

    private void initializeMaze(final int height, final int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze.getGrid()[i][j] = new Cell(i, j, Cell.Type.WALL);
            }
        }
    }
}
