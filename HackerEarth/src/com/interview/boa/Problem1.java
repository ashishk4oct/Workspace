package com.interview.boa;

import com.util.RandomUtil;
import com.util.Printer;

public class Problem1 {

    public static void main(String[] args) {
        int arr[] = RandomUtil.generateRandom(20,1,20);
        Printer.print(arr);
        int sum = 50;

        int m [][] = new int[arr.length+1][sum+1];

        for(int i = 0 ; i <= arr.length; i++){
            m[i][0] = 0;
        }
        for(int i = 0 ; i <= sum; i++){
            m[0][i] = 0;
        }

        for(int i = 1 ; i <= arr.length; i++){
            for(int j = 1 ; j <= sum; j++){
                if(j-arr[i-1] > 0){
                    m[i][j] = max(m[i-1][j], m[i-1][j-arr[i-1]]+arr[i-1]);
                }else if(j >= arr[i-1]){
                    m[i][j] = max(m[i-1][j], arr[i-1]);
                }else{
                    m[i][j] = 0;
                }
            }
        }

        int i = arr.length;
        int j = sum;
        while(i > 0 & j > 0){
            if(m[i][j] > m[i-1][j]){
                System.out.println(arr[i-1]+" "+(i-1));
                j = j-arr[i-1];
            }
            i--;
        }
    }

    private static int max(int a, int b){
        return a > b ? a : b;
    }
}
