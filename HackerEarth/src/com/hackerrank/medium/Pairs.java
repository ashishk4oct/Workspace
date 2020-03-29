package com.hackerrank.medium;

import java.util.Arrays;

public class Pairs {

    public static void main(String[] args) {
//        Instant x = Instant.now();
//        int arr [] = new int[Integer.MAX_VALUE];
//        Arrays.fill(arr,0);
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i-(int)(100*Math.random());
//        }
//        Arrays.parallelSort(arr);
//        Instant y = Instant.now();
//
//        System.out.println(Duration.between(x,y).getSeconds());

        System.out.println(pairs( 2 ,new int[]{1, 3, 5, 8, 6, 4, 2}));
    }

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int count = 0;
        for (int i = 1; i < len; i++) {

            if(diffExist(arr, k, len, i-1, i)){
                count++;
            }
        }
        return count;
    }

    static boolean diffExist(int [] arr, int k, int len, int i, int j){
        if(j >= len){
            for (int l = len-1 ; l > j/2 ; l--) {
                if(arr[l]-arr[i] == k){
                    return true;
                }
            }
            return false;
        }
        if(arr[j]-arr[i] == k){
            return true;
        }
        if(arr[j]-arr[i] < k){
            return diffExist(arr, k, len, i, 2*j);
        }
        if(arr[j]-arr[i] > k){
            for (int l = j-1; l > j/2; l--) {
                if(arr[l]-arr[i] == k){
                    return true;
                }
            }
        }
        return false;

    }
}
