package com.hackerrank.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueensAttackII {

    public static void main(String[] args) {
        queensAttack(5, 3, 4, 3, new int[][]{
                {5, 5},
                {4, 2},
                {2, 3}
        });
    }


    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int count = find(n, r_q, c_q, obstacles);
        System.out.println(count);
        return count;
    }


    static int find(int n, int x, int y, int[][] o) {
        int directions[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        int count = 0;
        for (int d : directions) {
            int tempx = x, tempy = y;
            while (tempx > 0 && tempy > 0 && tempx <= n && tempy <= n) {

                boolean brk = false;
                if (o != null) {
                    for (int[] arr : o) {
                        if(arr[0] == tempx && arr[1] == tempy){
                            brk = true;
                            break;
                        }
                    }
                }
                if(brk){
                    break;
                }
                if (d == 1 || d == 2 || d == 8) {
                    tempx += 1;
                }
                if (d == 2 || d == 3 || d == 4) {
                    tempy += 1;
                }
                if (d == 4 || d == 5 || d == 6) {
                    tempx -= 1;
                }
                if (d == 6 || d == 7 || d == 8) {
                    tempy -= 1;
                }
                count++;
            }
            count--;
        }
        return count;
    }

}
