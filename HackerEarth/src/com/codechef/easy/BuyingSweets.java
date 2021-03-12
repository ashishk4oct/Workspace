package com.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BuyingSweets {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tCount = Integer.parseInt(reader.readLine().trim());

        while(tCount > 0){
            tCount--;
            String NX[] = reader.readLine().trim().split(" ");
            int notesCount = Integer.parseInt(NX[0]);
            int sweetPrice = Integer.parseInt(NX[1]);
            String notesArrayStr[] = new String[notesCount];
            int notesArray[] = new int[notesCount];
            notesArrayStr = reader.readLine().trim().split(" ");
            for (int j = 0; j < notesArray.length; j++) {
                notesArray[j] = Integer.valueOf(notesArrayStr[j]);
            }

            int n = solution(notesArray, notesCount, sweetPrice);
            System.out.println(n);
        }
    }

    private static int solution(int[] notesArray, int notesCount, int sweetPrice) {
        int sum = 0;

        for (int i = 0; i < notesCount ; i++) {
            sum += notesArray[i];
        }

        if(sum%sweetPrice == 0){
            return sum/sweetPrice;
        }
        Arrays.sort(notesArray);
        return notesArray[0] <= sum%sweetPrice ? -1 : sum/sweetPrice;
    }
}
