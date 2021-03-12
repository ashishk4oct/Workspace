package com.interview.informatica;

import com.util.Printer;
import com.util.RandomUtil;

import java.util.Arrays;

public class Problem1 {

    public static void main(String[] args) {

        int arr[] = RandomUtil.generateRandom(10000,0,65536,true);
        Printer.print(arr);
        String str = "";

        for (int i = 0; i < arr.length ; i++) {
            str += (char)arr[i];
        }
        System.out.println(findKthMax(str,1));
    }

    public static char findKthMax(String arr  , int k){

        System.out.println(arr);
        char charArr[] = arr.toCharArray();

        int countArr [] = new int [65536];
        int sortCountArr [] = new int [65536];

        for(char c : charArr){
            countArr[(int)c]++;
            sortCountArr[(int)c]++;
        }

        Arrays.sort(sortCountArr);

        int count = sortCountArr[sortCountArr.length-k];

        for(int i = 0; i < countArr.length; i++ ){
            if(countArr[i] == count){
                return (char)i;
            }
        }

        return ' ';
    }


    public static int waysCount(int n) {
        int arr[] = new int[n + 1];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i >= 1) {
                arr[i] += arr[i - 1];
            }
            if (i >= 2) {
                arr[i] += arr[i - 2];
            }
            if (i >= 3) {
                arr[i] += arr[i - 3];
            }
        }
        return arr[n];
    }


}
