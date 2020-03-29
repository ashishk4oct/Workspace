package com.hackerrank.medium;

import java.util.Arrays;

public class TheBombermanGame {
    public static void main(String[] args) {

//        String[] arr = new String[]{"O.....", "O.....", ".O....", "...O..", "...O.."};
        String[] arr = new String[]{
                ".......",
                "...O.O.",
                "....O..",
                "..O....",
                "OO...OO",
                "OO.O..."};
        print(arr);
        print(getAllPlantedState(arr));
        print(getNegationInitialState(arr));

    }

    private static void print(String[] grid) {
        int rows = grid.length;
        int columns = grid[0].length();

        System.out.println("--------------------------------");
        for (int i = 0; i < rows; i++) {
            String s = grid[i];
            for (int j = 0; j < columns; j++) {
                char c = s.charAt(j);
                System.out.printf("%3c", c);
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
    }

    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        if(n == 1){
            return grid;
        }
        if (n % 2 == 0) {
            return getAllPlantedState(grid);
        } else if (n % 4 == 1) {
            return getNegationInitialState(getNegationInitialState(grid));
        } else if (n % 4 == 3) {
            return getNegationInitialState(grid);
        }
        return null;
    }

    private static String[] getAllPlantedState(String[] grid) {
        int rows = grid.length;
        int columns = grid[0].length();

        char newGrid[][] = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newGrid[i][j] = 'O';
            }
        }

        String[] resultGrid = new String[rows];
        for (int i = 0; i < rows; i++) {
            resultGrid[i] = new String(newGrid[i]);
        }

        return resultGrid;
    }

    private static String[] getNegationInitialState(String[] grid) {
        int rows = grid.length;
        int columns = grid[0].length();

        char newGrid[][] = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newGrid[i][j] = 'O';
            }
        }

        for (int i = 0; i < rows; i++) {
            String s = grid[i];
            for (int j = 0; j < columns; j++) {
                char c = s.charAt(j);
                if (c == 'O') {
                    newGrid[i][j] = '.';
                    if (i + 1 < rows) newGrid[i + 1][j] = '.';
                    if (i - 1 >= 0) newGrid[i - 1][j] = '.';
                    if (j + 1 < columns) newGrid[i][j + 1] = '.';
                    if (j - 1 >= 0) newGrid[i][j - 1] = '.';
                }
            }
        }

        String[] resultGrid = new String[rows];
        for (int i = 0; i < rows; i++) {
            resultGrid[i] = new String(newGrid[i]);
        }

        return resultGrid;
    }

    private static String updateCharAt(String s, int pos, char c) {
        return s.substring(0, pos) + c + s.substring(pos + 1);
    }
}
