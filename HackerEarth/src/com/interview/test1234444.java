package com.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test1234444 {
    public static void main(String[] args) {
        int arr[] = new int[]{5,3,2,6};
        System.out.println(getWays(10,arr));
    }


    public static long getWays(int n, int[] c) {
        Arrays.sort(c);
        long[] arr = new long[n+1];
        arr[0] = 1;
        for (int l: c){
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] > 0 && i+l< arr.length){
                    arr[i+l] = arr[i]+arr[i+l];
                }
            }
        }
        return arr[n];
    }

}
