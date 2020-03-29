package com.hackerrank.medium;

import java.util.*;

public class SnakesAndLadders {

    public static void main(String[] args) {
        int v = quickestWayUp(new int[][]{{3, 90}}, new int[][]{{99, 1},{98, 1},{97, 1},{96, 1},{95, 1},{94, 1}});
        System.out.println(v);
    }


    // Complete the quickestWayUp function below.
    static int quickestWayUp(int[][] ladders, int[][] snakes) {

        int[] board = new int[101];

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < ladders.length; i++) {
            map.put(ladders[i][0], ladders[i][1]);
        }

        int [] check = new int[snakes.length];
        for (int i = 0; i < snakes.length; i++) {
            map.put(snakes[i][0], snakes[i][1]);
            check[i] = snakes[i][0];
        }

        Arrays.sort(check);

        int count = 0;

        for (int i = 0; i < check.length-1; i++) {
            if(check[i] == check[i+1]-1){
                count++;
                if(count == 5){
                    return -1;
                }
            }else{
                count = 0;
            }
        }

        Arrays.fill(board, -1);
        board[0] = 0;
        board[1] = 0;
        fill(1, board, map);

        return board[100];
    }

    static void fill(int index, int[] board, Map<Integer, Integer> map) {

        while (index < 100) {
            index++;

            int v = getValue(index, board);
            if (v != -1) {
                v++;
                if (board[index] == -1 || board[index] > v) {
                    board[index] = v;
                    if (map.containsKey(index)) {

                        int i = map.get(index);

                        if (board[i] == -1 || board[index] < board[i]) {
                            board[i] = board[index];
                            fill(i, board, map);
                        }
                    }
                } else {
                    break;
                }
            }else{
                break;
            }
        }
    }

    private static int getValue(int index, int[] board) {
        int min = board[index - 1];
        for (int i = 2; i <= 6 && index - i >= 0; i++) {
            if (board[index - i] != -1) {
                min = min(min, board[index - i]);
            }
        }

        return min;
    }


    private static int min(int c1, int c2) {
        return c1 < c2 ? c1 : c2;
    }

}
