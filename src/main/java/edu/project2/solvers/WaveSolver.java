package edu.project2.solvers;

import edu.project2.components.Cell;
import edu.project2.components.Coordinate;
import edu.project2.components.Maze;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

//Для удобства отсчёт координат идёт с 1, а не с 0
public class WaveSolver implements Solver {

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

        Integer[][] potentialMatrix = getPotentialMatrix(maze, indexStart, indexEnd);
        int potential = potentialMatrix[indexStart.row()][indexStart.col()];
        return getPath(indexStart, potential, potentialMatrix);
    }

    @NotNull private static List<Coordinate> getPath(
        final Coordinate indexStart,
        int potentialVal,
        final Integer[][] potentialMatrix
    ) {
        List<Coordinate> path = new ArrayList<>();
        int potential = potentialVal;
        path.add(new Coordinate(indexStart.row(), indexStart.col()));
        Coordinate curr = new Coordinate(indexStart.row(), indexStart.col());
        while (potential != 0) {
            potential--;
            if (curr.row() > 0 && potentialMatrix[curr.row() - 1][curr.col()] != null
                && potentialMatrix[curr.row() - 1][curr.col()] == potential) {
                path.add(new Coordinate(curr.row() - 1, curr.col()));
                curr = new Coordinate(curr.row() - 1, curr.col());
                continue;
            }
            if (curr.row() < potentialMatrix.length - 1 && potentialMatrix[curr.row() + 1][curr.col()] != null
                && potentialMatrix[curr.row() + 1][curr.col()] == potential) {
                path.add(new Coordinate(curr.row() + 1, curr.col()));
                curr = new Coordinate(curr.row() + 1, curr.col());
                continue;
            }
            if (curr.col() > 0 && potentialMatrix[curr.row()][curr.col() - 1] != null
                && potentialMatrix[curr.row()][curr.col() - 1] == potential) {
                path.add(new Coordinate(curr.row(), curr.col() - 1));
                curr = new Coordinate(curr.row(), curr.col() - 1);
                continue;
            }
            if (curr.col() < potentialMatrix[0].length - 1 && potentialMatrix[curr.row()][curr.col() + 1] != null
                && potentialMatrix[curr.row()][curr.col() + 1] == potential) {
                path.add(new Coordinate(curr.row(), curr.col() + 1));
                curr = new Coordinate(curr.row(), curr.col() + 1);
            }
        }
        return path;
    }

    private Integer[][] getPotentialMatrix(final Maze maze, final Coordinate start, final Coordinate end) {
        Integer[][] potentialMatrix = new Integer[maze.getHeight()][maze.getWidth()];
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getGrid()[i][j].getType() == Cell.Type.WALL) {
                    potentialMatrix[i][j] = -1;
                }
            }
        }
        potentialMatrix[end.row()][end.col()] = 0;
        while (potentialMatrix[start.row()][start.col()] == null) {
            for (int i = 0; i < potentialMatrix.length; i++) {
                for (int j = 0; j < potentialMatrix[i].length; j++) {
                    moveWave(potentialMatrix, i, j);
                }
            }
        }
        return potentialMatrix;
    }

    private static void moveWave(final Integer[][] potentialMatrix, final int i, final int j) {
        if (potentialMatrix[i][j] == null || potentialMatrix[i][j] == -1) {
            return;
        }
        int number = potentialMatrix[i][j] + 1;
        if (i > 0) {
            if (potentialMatrix[i - 1][j] == null) {
                potentialMatrix[i - 1][j] = number;
            } else if (potentialMatrix[i - 1][j] != -1) {
                potentialMatrix[i - 1][j] = Math.min(potentialMatrix[i - 1][j], number);
            }
        }
        if (j > 0) {
            if (potentialMatrix[i][j - 1] == null) {
                potentialMatrix[i][j - 1] = number;
            } else if (potentialMatrix[i][j - 1] != -1) {
                potentialMatrix[i][j - 1] = Math.min(potentialMatrix[i][j - 1], number);
            }
        }
        if (i < potentialMatrix.length - 1) {
            if (potentialMatrix[i + 1][j] == null) {
                potentialMatrix[i + 1][j] = number;
            } else if (potentialMatrix[i + 1][j] != -1) {
                potentialMatrix[i + 1][j] = Math.min(potentialMatrix[i + 1][j], number);
            }
        }
        if (j < potentialMatrix[0].length - 1) {
            if (potentialMatrix[i][j + 1] == null) {
                potentialMatrix[i][j + 1] = number;
            } else if (potentialMatrix[i][j + 1] != -1) {
                potentialMatrix[i][j + 1] = Math.min(potentialMatrix[i][j + 1], number);
            }
        }
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
}
