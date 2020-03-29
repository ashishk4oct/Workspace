package com.hackerrank.medium;


import java.util.LinkedList;
import java.util.Queue;

public class CountLuck {

    public static void main(String[] args) {

        System.out.println(countLuck(new String[]{
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                "M.......................................*",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
        }, 20));
    }


    // Complete the countLuck function below.
    static String countLuck(String[] matrix, int k) {
        int xlen = matrix.length;
        int ylen = matrix[0].length();
        int[][] grid = new int[matrix.length][matrix[0].length()];

        int startEnd[] = fillGrid(grid, matrix);

        Queue<String> list = new LinkedList<>();
        int x = startEnd[2], y = startEnd[3];
        list.add(x+","+y);
        print(grid);
        while (!list.isEmpty()) {
            String s[] = list.poll().split(",");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            update(x, y, grid, list, xlen, ylen);
            print(grid);
        }

        int result = grid[startEnd[0]][startEnd[1]];
        int count = countWays(startEnd[0],startEnd[1], xlen, ylen, grid);

        if(count == 2){
            result++;
        }

        if(result == k){
            return "Impressed";
        }
        return "Oops!";
    }

    private static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.printf("%4d", grid[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }

    private static void update(int x, int y, int[][] grid, Queue<String> list, int xlen, int ylen) {
//        if (x < 0 || y < 0 || x >= xlen || y >= ylen) {
//            return;
//        }

        int val = grid[x][y];
        if (val == -1) {
            return;
        }
        if (val >= 0) {
//            int countways = countWays(x,y,xlen, ylen, grid);

//            if(countways > 1)
//                list.add(x+","+y);

            updateCell(x, y, x + 1, y, grid, xlen, ylen, list);
            updateCell(x, y, x -1, y, grid, xlen, ylen, list);
            updateCell(x, y, x, y+1, grid, xlen, ylen, list);
            updateCell(x, y, x, y-1, grid, xlen, ylen, list);

        }
    }

    private static void updateCell(int x, int y, int a, int b, int[][] grid, int xlen, int ylen, Queue<String> list) {
        if (a < 0 || b < 0 || a >= xlen || b >= ylen) {
            return;
        }
        if(grid[a][b] == -1)
            return;
        int countways = countWays(a, b, xlen, ylen, grid);
        int val = 0;
        if (countways > 2) {
            val = grid[x][y] + 1;
        } else {
            val = grid[x][y];
        }
        if(grid[a][b] < 0){
            grid[a][b]  = val;
            list.add(a+","+b);
        }else{
            grid[a][b] = grid[a][b] < val ? grid[a][b] : val;
        }

    }

    private static int countWays(int x, int y, int xlen, int ylen, int[][] grid) {
        int countways = 0;

        if (x + 1 < xlen && grid[x + 1][y] != -1) {
            countways++;
        }
        if (x - 1 >= 0 && grid[x - 1][y] != -1) {
            countways++;
        }
        if (y + 1 < ylen  && grid[x][y + 1] != -1) {
            countways++;
        }
        if (y - 1 >= 0  && grid[x][y - 1] != -1) {
            countways++;
        }

        return countways;
    }

    private static int[] fillGrid(int[][] grid, String[] matrix) {

        int startx = 0, starty = 0, endx = 0, endy = 0;
        for (int i = 0; i < matrix.length; i++) {
            char[] row = matrix[i].toCharArray();
            for (int j = 0; j < row.length; j++) {
                switch (row[j]) {
                    case 'X':
                        grid[i][j] = -1;
                        break;
                    case '.':
                        grid[i][j] = -2;
                        break;
                    case '*':
                        endx = i;
                        endy = j;
                        grid[i][j] = 0;
                        break;
                    case 'M':
                        startx = i;
                        starty = j;
                        grid[i][j] = -3;
                        break;
                }
            }
        }

        return new int[]{startx, starty, endx, endy};
    }
}
