package edu.project2.solvers;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class SecondSolver implements Solver {
    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        List<Coordinate> way = new ArrayList<>();
        int[][] intMaze = new int[maze.getHeight()][maze.getWidth()];
        for (int i = 0; i < intMaze.length; ++i) {
            for (int j = 0; j < intMaze[0].length; ++j) {
                intMaze[i][j] = -1;
            }
        }

        goAroundTheMaze(maze, start, intMaze);

        if (intMaze[end.row()][end.col()] != -1) {
            Coordinate cell = new Coordinate(end.col(), end.row());

            while (!cell.equals(start)) {
                boolean find = false;
                way.add(0, cell);

                for (int i = -1; i < 2 && !find; ++i) {
                    for (int j = -1; j < 2 && !find; ++j) {
                        if (Math.abs(i) == Math.abs(j)) {
                            continue;
                        }

                        int x = cell.col() + i;
                        int y = cell.row() + j;

                        if (maze.isIn(x, y) && intMaze[y][x] == intMaze[cell.row()][cell.col()] - 1) {
                            cell = new Coordinate(x, y);
                            find = true;
                        }
                    }
                }
            }

            way.add(0, cell);
        }

        return way;
    }

    private void goAroundTheMaze(Maze maze, Coordinate start, int[][] intMaze) {
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(start);
        intMaze[start.row()][start.col()] = 0;

        while (!queue.isEmpty()) {
            Coordinate cell = queue.peek();
            queue.remove();

            for (int i = -1; i < 2; ++i) {
                for (int j = -1; j < 2; ++j) {
                    if (Math.abs(i) == Math.abs(j)) {
                        continue;
                    }

                    int x = cell.col() + i;
                    int y = cell.row() + j;

                    if (maze.isIn(x, y) && maze.getGrid()[x][y].type() == Cell.Type.PASSAGE && intMaze[y][x] == -1) {
                        intMaze[y][x] = intMaze[cell.row()][cell.col()] + 1;
                        queue.add(new Coordinate(x, y));
                    }
                }
            }
        }
    }
}
