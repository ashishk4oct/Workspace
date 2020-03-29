package com.hackerrank.medium;

import java.util.Stack;


public class ConnectedCellsGrid {
    public static void main(String[] args) {

        int i = connectedCell(new int[][]{
                {1, 1, 1, 0, 1},
                {0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0}
        });

        System.out.println(i);
    }

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int count = maxConnected(matrix, i, j);
                max = count > max ? count : max;
            }
        }

        return max;
    }

    private static int maxConnected(int[][] matrix, int i, int j) {
        if (matrix[i][j] <= 0) {
            return 0;
        }
        int connected = 0;
        Stack<String> stack = new Stack<>();
        stack.push(i + "," + j);
        matrix[i][j] = -1;
        while (!stack.isEmpty()) {
            String[] s = stack.pop().split(",");
            int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]);

            push(stack, x-1, y-1, matrix);
            push(stack, x-1, y, matrix);
            push(stack, x-1, y+1, matrix);
            push(stack, x+1, y-1, matrix);
            push(stack, x+1, y, matrix);
            push(stack, x+1, y+1, matrix);
            push(stack, x, y+1, matrix);
            push(stack, x, y-1, matrix);

            connected++;
        }
        return connected;
    }

    private static void push(Stack<String> stack, int x, int y, int[][] matrix) {
        if (matrix.length > x && x >= 0 && matrix[0].length > y && y >= 0) {
            if (matrix[x][y] == 1) {
                stack.push((x) + "," + (y));
                matrix[x][y] = -1;
            }
        }
    }

}
