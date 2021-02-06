package com.hackerrank.medium;

public class EmasSupercomputer {

    public static void main(String[] args) {

        String[] grid = new String[]{
                "BGBBBBBGB",
                "BGBBBBBGB",
                "GGGGGGGGG",
                "BGBBBBBGB",
                "GGGGGGGGG",
                "BGBBBBBGB",
                "GGGGGGGGG",
                "GGGGGGGGG",
                "BGBBBBBGB"
        };
        System.out.println(twoPluses(grid));
    }










     
    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {
        int[][] intGrid = fillGrid(grid);

        int product = initProduct(intGrid);

        if (product == 0) {
            return product;
        }

        return getProduct(intGrid, product, 1, 1, 0);

    }

    static int initProduct(int[][] intGrid) {
        for (int i = 0; i < intGrid.length; i++) {
            for (int j = 0; j < intGrid.length; j++) {
                if (intGrid[i][j] > 0) {
                    return 1;
                }
            }
        }
        return 0;
    }

    static int getProduct(int[][] intGrid, int product, int x, int y, int count) {
        if(count == 2){
            return product;
        }
        int temp = product;
        for (int i = x; i < intGrid.length - 1; i++) {
            int j = i == x ? y : 1;
            for (; j < intGrid[i].length - 1; j++) {
                int len = length(intGrid, i, j);
                for (int a = 1; a <= len; a++) {
                    if (check(intGrid, i, j, a)) {
                        int num = (4 * a) + 1;
                        if (i == intGrid.length - 2 && j == intGrid[i].length - 2)
                            return (product*num)>temp? product * num : temp;

                        int p, q;
                        if (j == intGrid[i].length - 2) {
                            p = i + 1;
                            q = 1;
                        } else {
                            p = i;
                            q = j + 1;
                        }
                        update(intGrid, i, j, a);
                        int t1 = getProduct(intGrid, product * num, p, q, count+1);
                        reset(intGrid, i, j, a);
                        int t2 = getProduct(intGrid, product, p, q, count);
                        int max = t1 > t2 ? t1 : t2;
                        temp = max > temp ? max : temp;

                    }else{
                        break;
                    }
                }
            }
        }
        return temp;
    }

    private static void printGrid(int[][] intGrid) {
//        for (int i = 0; i < intGrid.length; i++) {
//            for (int j = 0; j < intGrid[i].length; j++) {
//                System.out.printf("%3d", intGrid[i][j]);
//            }
//            System.out.println();
//        }
    }

    static void update(int[][] grid, int i1, int i2, int len) {
        printGrid(grid);

        grid[i1][i2] = -1;
        for (int i = 1; i <= len; i++) {
            grid[i1][i2 + i] = -1;
            grid[i1][i2 - i] = -1;
        }
        for (int i = 1; i <= len; i++) {
            grid[i1 + i][i2] = -1;
            grid[i1 - i][i2] = -1;
        }
        printGrid(grid);

    }

    static void reset(int[][] grid, int i1, int i2, int len) {
        printGrid(grid);

        grid[i1][i2] = 1;
        for (int i = 1; i <= len; i++) {
            grid[i1][i2 + i] = 1;
            grid[i1][i2 - i] = 1;
        }
        for (int i = 1; i <= len; i++) {
            grid[i1 + i][i2] = 1;
            grid[i1 - i][i2] = 1;
        }
        printGrid(grid);

    }

    static boolean check(int[][] grid, int i1, int i2, int len) {
//        int num = (len * 2) + 1;
        if (grid[i1][i2] < 0) {
            return false;
        }
        for (int i = 1; i <= len; i++) {
            if (grid[i1][i2 + i] < 0) {
                return false;
            }
            if (grid[i1][i2 - i] < 0) {
                return false;
            }
        }

        for (int i = 1; i <= len; i++) {
            if (grid[i1 + i][i2] < 0) {
                return false;
            }
            if (grid[i1 - i][i2] < 0) {
                return false;
            }
        }
        return true;

    }

    static int length(int[][] grid, int i1, int i2) {
        return min(min(i1, grid.length - (i1 + 1)), min(i2, grid[0].length - (i2 + 1)));

    }

    static int min(int i1, int i2) {
        return i1 < i2 ? i1 : i2;
    }

    static int[][] fillGrid(String[] grid) {
        int[][] intGrid = new int[grid.length][grid[0].length()];

        for (int i = 0; i < grid.length; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < row.length; j++) {
                intGrid[i][j] = row[j] == 'G' ? 1 : -1;
            }
        }
        return intGrid;
    }
}
