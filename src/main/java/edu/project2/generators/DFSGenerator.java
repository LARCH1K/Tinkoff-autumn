package edu.project2.generators;

import edu.project2.Cell;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;


//Алгоритм корректно работает только с нечётными значениями, так как по его условию максимальная ширина стены равна 1
public class DFSGenerator implements Generator {

    private final static Random RANDOM = new Random();

    private Maze maze;

    @Override
    public Maze generate(final int height, final int width) {
        maze = new Maze(height, width);
        initializeMaze(height, width);

        Stack<Cell> stack = new Stack<>();
        maze.getGrid()[0][0] = new Cell(0, 0, Cell.Type.PASSAGE);
        stack.push(maze.getGrid()[0][0]);
        while (!stack.empty()) {
            Cell curr = stack.peek();
            List<Cell> neighbors = getNeighbors(curr, height, width);
            if (!neighbors.isEmpty()) {
                Cell nextCell = neighbors.get(RANDOM.nextInt(neighbors.size()));

                maze.getGrid()[(curr.row() + nextCell.row()) / 2][(curr.col() + nextCell.col()) / 2]
                    = new Cell((curr.row() + nextCell.row()) / 2
                    , (curr.col() + nextCell.col()) / 2, Cell.Type.PASSAGE);

                maze.getGrid()[nextCell.row()][nextCell.col()] = nextCell;
                stack.push(nextCell);
            } else {
                stack.pop();
            }
        }

        return maze;
    }

    private void initializeMaze(final int height, final int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze.getGrid()[i][j] = new Cell(i, j, Cell.Type.WALL);
            }
        }
    }

    private List<Cell> getNeighbors(final Cell cell, final int height, final int width) {
        List<Cell> neighbors = new ArrayList<>();
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] move : moves) {
            int newRow = cell.row() + 2 * move[0];
            int newCol = cell.col() + 2 * move[1];

            if (newRow >= 0 && newRow < height && newCol >= 0 && newCol < width
                && maze.getGrid()[newRow][newCol].type() == Cell.Type.WALL) {
                neighbors.add(new Cell(newRow, newCol, Cell.Type.PASSAGE));
            }
        }

        return neighbors;
    }
}
