package com.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Elevator {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            // Reading data using readLine
            int tCount = Integer.parseInt(reader.readLine().trim());
            String[] result = new String[tCount];
            for (int i = 0; i < tCount; i++) {
                String NM[] = reader.readLine().trim().split(" ");
                int N = Integer.parseInt(NM[0]);
                int M = Integer.parseInt(NM[1]);
                String sequenceString[] = new String[N];
                int sequence[] = new int[N];
                sequenceString = reader.readLine().trim().split(" ");
                for (int j = 0; j < sequence.length; j++) {
                    sequence[j] = Integer.valueOf(sequenceString[j]);
                }

                result[i] = solve(N, M, sequence);

            }

            for (int i = 0; i < tCount; i++) {
                System.out.println(result[i]);
            }
        } finally {
            if (null != reader)
                reader.close();
        }
    }

    private static String solve(int n, int floorCount, int[] sequence) {

        Integer[] upChangeCount = new Integer[n];
        Integer[] downChangeCount = new Integer[n];

        int i = 0, j = 0;
        while (j < n) {
            i = j;
            while(sequence[j] == -1){
                j++;
            }
            if (i != j) {
                fill(i, j, n, sequence, upChangeCount, downChangeCount);
            }
            j++;
        }

        return (upChangeCount[n-1] < downChangeCount[n-1] ? upChangeCount[n-1] : downChangeCount[n-1]).toString();
    }


    private static void fill(int i, int j, int n, int[] sequence, Integer[] upChangeCount, Integer[] downChangeCount) {

        if(i == 0){
            fillBegining(i, j, n, sequence, upChangeCount, downChangeCount);
            return;
        }
        boolean directionUP = true;
        if(i > 2 && sequence[i-2] != -1 && sequence[i-1] != -1){
            directionUP = sequence[i-2] < sequence[i-1]? true : false;
        }




    }

    private static void fillBegining(int i, int j, int n, int[] sequence, Integer[] upChangeCount, Integer[] downChangeCount) {

    }

}

class State {

    int changeCount = 0;


}

enum Direction {
    UP, DOWN, NA;


}
