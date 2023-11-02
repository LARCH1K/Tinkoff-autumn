package edu.project2.solvers;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FirstSolver implements Solver {
    @Override
    public List<Coordinate> solve(final Maze maze, final Coordinate start, final Coordinate end) {
        int[][] d = new int[maze.getHeight()][maze.getWidth()];
        Coordinate[][] p = new Coordinate[maze.getHeight()][maze.getWidth()];
        boolean[][] used = new boolean[maze.getHeight()][maze.getWidth()];
        Deque<Coordinate> stack = new ArrayDeque<>();

        d[start.row()][start.col()] = 1;
        used[start.row()][start.col()] = true;
        stack.addLast(start);
        while (stack.peek()!=null) {
            Coordinate xy = stack.pop();
            List<Coordinate> neighbors = getNeighbors(maze, xy, used);
            for (Coordinate neighbor : neighbors) {
                d[neighbor.row()][neighbor.col()] = d[xy.row()][xy.col()]+1;
                p[neighbor.row()][neighbor.col()] = xy;
                used[neighbor.row()][neighbor.col()] = true;
                stack.addLast(neighbor);
            }

        }
        Coordinate cur = end;
        List<Coordinate> path = new ArrayList<>();
        while (cur != null){
            path.add(cur);
            cur = p[cur.row()][cur.col()];
        }
        return path;
    }

    private List<Coordinate> getNeighbors(final Maze maze, final Coordinate coordinate, final boolean[][] used) {
        List<Coordinate> neighbors = new ArrayList<>();
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] move : moves) {
            int newRow = coordinate.row() + move[0];
            int newCol = coordinate.col() + move[1];

            if (newRow >= 0 && newRow < maze.getHeight() && newCol >= 0 && newCol < maze.getWidth()
                && maze.getGrid()[newRow][newCol].type() == Cell.Type.PASSAGE && !used[newRow][newCol]) {
                neighbors.add(new Coordinate(newRow, newCol));
            }
        }

        return neighbors;
    }

}
