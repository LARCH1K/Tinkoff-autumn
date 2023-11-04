package edu.project2.solvers;

import edu.project2.components.Cell;
import edu.project2.components.Coordinate;
import edu.project2.components.Maze;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Для удобства отсчёт координат идёт с 1, а не с 0
public class DFSSolver implements Solver {
    @Override
    public List<Coordinate> solve(final Maze maze, final Coordinate start, final Coordinate end) {
        if (!isValidValues(maze, start, end)) {
            throw new IllegalArgumentException();
        }
        Coordinate indexStart = new Coordinate(start.row() - 1, start.col() - 1);
        Coordinate indexEnd = new Coordinate(end.row() - 1, end.col() - 1);
        if (maze.getGrid()[indexStart.row()][indexStart.col()].getType() == Cell.Type.WALL
            || maze.getGrid()[indexEnd.row()][indexEnd.col()].getType() == Cell.Type.WALL) {
            return new ArrayList<>();
        }

        Coordinate[][] pathArr = new Coordinate[maze.getHeight()][maze.getWidth()];
        boolean[][] visited = new boolean[maze.getHeight()][maze.getWidth()];
        Deque<Coordinate> deque = new ArrayDeque<>();

        visited[indexStart.row()][indexStart.col()] = true;
        deque.addLast(indexStart);
        while (deque.peek() != null) {
            Coordinate curr = deque.pop();
            List<Coordinate> neighbors = getNeighbors(maze, curr, visited);
            for (Coordinate neighbor : neighbors) {
                pathArr[neighbor.row()][neighbor.col()] = curr;
                visited[neighbor.row()][neighbor.col()] = true;
                deque.addLast(neighbor);
            }
        }
        Coordinate pathCord = indexEnd;
        List<Coordinate> path = new ArrayList<>();
        while (pathCord != null) {
            path.add(pathCord);
            pathCord = pathArr[pathCord.row()][pathCord.col()];
        }
        return path;
    }

    private boolean isValidValues(final Maze maze, final Coordinate start, final Coordinate end) {
        if (maze == null || start == null || end == null) {
            return false;
        }
        if (start.col() < 1 || start.row() < 1 || end.row() < 1 || end.col() < 1
            || start.col() > maze.getWidth() || start.row() > maze.getHeight()
            || end.row() > maze.getHeight() || end.col() > maze.getWidth()) {
            return false;
        }
        return true;
    }

    private List<Coordinate> getNeighbors(final Maze maze, final Coordinate coordinate, final boolean[][] visited) {
        List<Coordinate> neighbors = new ArrayList<>();
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] move : moves) {
            int newRow = coordinate.row() + move[0];
            int newCol = coordinate.col() + move[1];

            if (newRow >= 0 && newRow < maze.getHeight() && newCol >= 0 && newCol < maze.getWidth()
                && maze.getGrid()[newRow][newCol].getType() == Cell.Type.PASSAGE && !visited[newRow][newCol]) {
                neighbors.add(new Coordinate(newRow, newCol));
            }
        }
        return neighbors;
    }
}
