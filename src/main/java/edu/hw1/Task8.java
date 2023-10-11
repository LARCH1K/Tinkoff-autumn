package edu.hw1;

import java.util.ArrayList;

public class Task8 {
    private Task8() {
    }

    final private static int MATRIX_SIZE = 8;

    public static boolean knightBoardCapture(int[][] board) {
        checkBoard(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    if (checkItem(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void checkBoard(final int[][] board) {
        if (board == null || board.length != MATRIX_SIZE) {
            throw new IllegalArgumentException();
        }
        for (final int[] ints : board) {
            if (ints.length != MATRIX_SIZE) {
                throw new IllegalArgumentException();
            }
            for (final int item : ints) {
                if (item != 1 && item != 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private static boolean checkItem(final int[][] board, final int i, final int j) {
        ArrayList<Coordinates> coordinates = getCoordinates(i, j);
        for (Coordinates coordinate : coordinates) {
            if (coordinate.x >= 0 && coordinate.x < MATRIX_SIZE
                && coordinate.y >= 0 && coordinate.y < MATRIX_SIZE) {
                if (board[coordinate.x][coordinate.y] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static ArrayList<Coordinates> getCoordinates(final int i, final int j) {
        ArrayList<Coordinates> result = new ArrayList<>();
        result.add(new Coordinates(i + 2, j + 1));
        result.add(new Coordinates(i + 2, j - 1));
        result.add(new Coordinates(i + 1, j + 2));
        result.add(new Coordinates(i + 1, j - 2));
        result.add(new Coordinates(i - 2, j + 1));
        result.add(new Coordinates(i - 2, j - 1));
        result.add(new Coordinates(i - 1, j + 2));
        result.add(new Coordinates(i - 1, j - 2));
        return result;
    }

    private static class Coordinates {
        int x;
        int y;

        private Coordinates(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
