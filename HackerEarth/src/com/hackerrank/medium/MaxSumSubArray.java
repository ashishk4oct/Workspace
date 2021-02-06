package com.hackerrank.medium;

import com.util.RandomUtil;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSumSubArray {

    public static void main(String[] args) {

        IntStream.rangeClosed(1,10).forEach(i ->{
            int [] arr = RandomUtil.generateRandom(20,-10,10);
            RandomUtil.print(arr);
            subArrayNew(arr);
            System.out.println();
        });
    }

    public static void subArrayNew(int arr[]) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0 , j = 0;
        int x = 0,y = 0;
        while (j < arr.length){
            sum += arr[j];
            if(sum>max){
                x = i;
                y = j;
                max = sum;
            }
            j++;
            if(sum <= 0){
                i = j;
                sum = 0;
            }
        }
        printArray(arr, x, y);
    }
    private static void printArray(int[] arr, int x, int y ) {
        for (int k = x; k <= y ; k++) {
            System.out.printf("%d, ",arr[k]);
        }
        System.out.println();
    }

}