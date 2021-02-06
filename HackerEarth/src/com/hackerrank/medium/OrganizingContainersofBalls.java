package com.hackerrank.medium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OrganizingContainersofBalls {


    public static void main(String[] args) {
        organizingContainers(new int[][]{
                {0, 2, 1},
                {1, 1, 1},
                {2, 0, 0},
        });
    }

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {

        long vSum[] = new long[container.length];
        long hSum[] = new long[container.length];

        boolean possible[][] = new boolean[container.length][container.length];

        for (int i = 0; i < possible.length; i++) {
            for (int j = 0; j < possible.length; j++) {
                possible[i][j] = false;
            }
        }

        Arrays.fill(vSum, 0);
        Arrays.fill(hSum, 0);

        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container.length; j++) {
                vSum[i] += container[i][j];
                hSum[j] += container[i][j];
            }
        }


        for (int i = 0; i < possible.length; i++) {
            for (int j = 0; j < possible.length; j++) {
                if (hSum[i] == vSum[j]) {
                    possible[i][j] = true;
                }
            }
        }
        if (!isPossible(possible, 0, new HashSet<>())) {
            System.out.println("Impossible");

            return "Impossible";
        }

        System.out.println("Possible");
        return "Possible";
    }

    static boolean isPossible(boolean[][] possible, int index, Set<Integer> set) {
        if (index == possible.length)
            return true;

        for (int i = 0; i < possible.length; i++) {
            if (possible[i][index]) {
                if (!set.contains(i)) {
                    set.add(i);
                    if (isPossible(possible, index + 1, set)) {
                        return true;
                    }
                    set.remove(i);
                }
            }
        }

        return false;
    }
}