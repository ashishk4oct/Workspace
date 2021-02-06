package com.hackerrank.medium;

public class SherlockAndCost {

    public static void main(String[] args) {
        int [] arr = new int[]{4,7,9};
        System.out.println(cost(arr));


        int i = 1, j = -1;
        System.out.println(i<<1);
        System.out.println(j<<1);
    }


    static int cost(int[] B) {
        int max = 0;
        int min = 0;
        int m, n, tmax, tmin;
        for(int i = 1; i < B.length ; i++){
            m = max + Math.abs(B[i-1]-B[i]);
            n = min + Math.abs(1-B[i]);
            tmax = m > n ? m : n;
            m = max + Math.abs(B[i-1]-1);
            n = min;
            min = m > n ? m : n;
            max = tmax;
        }

        return max > min ? max: min;
    }

}
