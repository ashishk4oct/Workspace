package com.hackerrank.hard;

import javax.smartcardio.Card;

public class CardsPermutation {


    public static void main(String[] args) {
       long r = solve(new int[]{ 0, 0, 1, 3});
        System.out.println(r);

    }

    static long factorial [] = new long[300000];
    static int fMax ;
    static{
        factorial[0] = 1;
        factorial[1] = 1;
        fMax = 1;
    }

    static long factorialN(int n){
        if(n > fMax){
            for (int i = fMax+1; i <= n  ; i++) {
                factorial[i] = (factorial[i-1]*i)%1000000007;
            }
        }
        return factorial[n];

    }
    static long solve(int[] x) {

        int count = 0;
        int arr[] = new int[x.length+1];
        for(int v : x){
            if(v == 0){
                count++;
            }else{
                arr[v] = 1;
            }
        }

        if(count == 0){
            return findPosition(new int[]{} , x);
        }
        int[] missing = new int[count];
        int c = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != 1){
                missing[c++] = i;
            }
        }
        long result = 0;
        return permute(missing, 0, missing.length-1, result, x);
    }
    private static long permute(int arr[], int l, int r, long result, int[] x) {
        if (l == r) {
            long position = findPosition(arr,x);
            result += position;
            result = result%1000000007;
        } else {
            for (int i = l; i <= r; i++)
            {
                swap(arr,l,i);
                result = permute(arr, l+1, r, result, x);
                swap(arr,l,i);
            }
        }
        return result;
    }

    private static long findPosition(int[] arr, int[] x) {
        int ar[] = new int[x.length];
        int c = 0;
        for (int i = 0; i < x.length; i++) {
            ar[i] = x[i] == 0 ? arr[c++] : x[i];
        }
        int len = ar.length;
        long position = 1;
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = i-1; j >= 0 ; j--) {
                count = ar[j] < ar[i] ? count+1 : count;
            }
            position += (factorialN(len-1-i)*(ar[i]-1-count))%1000000007;
            position = position%1000000007;
        }

        return position;
    }


    public static void swap(int[] array, int i, int j) {
        int temp;
        temp = array[i] ;
        array[i] = array[j];
        array[j] = temp;
    }

}
