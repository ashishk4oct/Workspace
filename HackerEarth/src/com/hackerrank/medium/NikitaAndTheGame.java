package com.hackerrank.medium;

public class NikitaAndTheGame {


    public static void main(String[] args) {
        arraySplitting(new int[]{2, 3, 2, 3});
    }

    static int arraySplitting(int[] arr) {
        return arraySplitting(arr, 0, arr.length-1);
    }



    static int arraySplitting(int[] arr,final int startIndex,final int endIndex) {
        int i = startIndex, j = endIndex;

        if(i==j || i>j){
            return 0;
        }

        int diff = arr[i]-arr[j];
        while(i != j-1){
            if(diff >= 0){
                diff -= arr[--j];
            }else{
                diff += arr[++i];
            }
        }
        if(diff != 0){
            return 0;
        }
        int left = arraySplitting(arr, startIndex, i);
        int right = arraySplitting(arr, j, endIndex);
        int max = left > right ? left: right;
        return max+1;
    }
}
