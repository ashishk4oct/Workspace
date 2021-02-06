package com.hackerrank.medium;

public class OptimalStrategy {

    public static void main(String[] args) {
        System.out.println(pickOptimal(new int[]{ 8, 15, 3, 7 }));
    }

    private static int pickOptimal(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        return pickOptimal(arr, 0, arr.length - 1);
    }

    private static int pickOptimal(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        if(i+1 == j){
            return arr[i] > arr[j] ? arr[i] : arr[j];
        }
        if (i > j) {
            throw new IllegalStateException("end {} less than start index");
        }

        int res1, res2;
        int ind = pickOptimalIndex(arr, i + 1, j);
        if(ind == i+1){
            res1 = pickOptimal(arr, i + 2, j) + arr[i];
        }else{
            res1 = pickOptimal(arr, i + 1, j-1) + arr[i];
        }

        ind = pickOptimalIndex(arr, i , j-1);
        if(ind == i){
            res2 = pickOptimal(arr, i + 1, j-1) + arr[i];
        }else{
            res2 = pickOptimal(arr, i, j-2) + arr[i];
        }
        return res1 > res2 ? res1 : res2;
    }

    private static int pickOptimalIndex(int[] arr, int i, int j) {
        if (i == j) {
            return i;
        }
        if(i+1 == j){
            return arr[i] > arr[j] ? i : j;
        }
        if (i > j) {
            throw new IllegalStateException("end {} less than start index");
        }

        int res1 = pickOptimal(arr, i + 1, j) + arr[i];
        int res2 = pickOptimal(arr, i, j - 1) + arr[j];
        if(res1 > res2)
            return i;
        else
            return j;
    }
}
