package com.hackerrank.medium;

import java.util.Arrays;

public class AbsolutePermutation {


    private static void verify(int[] absolutePermutation, int diff) {
        for (int i = 0; i < absolutePermutation.length; i++) {
            if(Math.abs(absolutePermutation[i]-(i+1)) != diff){
                System.out.println(i+" "+absolutePermutation[i]+ " "+ diff);
            }
        }
    }

    public static void main(String[] args) {

//        printArray(absolutePermutation(69187 ,0));
        verify(absolutePermutation(10  ,4), 4);
    }

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int size, int diff) {

        int [] arr = getArray(size);

        int [] first = getArray(size, -1);

        int [] second = getArray(size, -1);

        if(diff*2 > size){
            return new int[]{-1};
        }
        if(diff == 0){
            int temp [] = new int[size];
            for (int i = 1; i < arr.length; i++) {
                temp[i-1] = i;
            }
            return temp;
        }


        int index = 1;
        while (arr[index]+diff <= size){
            first[index] = arr[index]+diff;
            index++;
        }

        index = size;
        while (arr[index]-diff > 0){
            second[index] = arr[index]-diff;
            index--;
        }

//        printArray(arr);
//        printArray(first);
//        printArray(second);

        index = size;
        while (arr[index]+diff > size){
            markAsUsed(index, second, first, diff, size);
            index--;
        }

        index = 1;
        while(arr[index]-diff <= 0){
            markAsUsed(index, first, second, diff, size);
            index++;
        }

        int result [] = new int[size];
        for (int i = 1; i <= size ; i++) {
            if(first[i] > 0){
                result[i-1]=first[i];
            }else if(second[i] > 0){
                result[i-1]=second[i];
            }else{
                return new int[]{-1};
            }


        }
        return result;

    }

    private static void markAsUsed(int index, int[] arr1, int[] arr2, int diff, int size) {

        if(arr1[index] < 0){
            return;
        }

        int i = (arr1[index] < index) ? arr1[index]-diff : arr1[index]+diff;
//        if(i > 0  && i <= size){
//            markAsUsed(i,arr1, arr2, diff, size);
//            arr2[i] = -1;
//        }

        while(arr1[index] > 0 && i > 0 && i <= size){
            arr2[i] = -1;
            index = i;
            i = (arr1[index] < index) ? arr1[index]-diff : arr1[index]+diff;
        }
    }

    private static void printArray(int[] first) {
        System.out.println();
        Arrays.stream(first).forEach(element -> System.out.printf("%4s ",element+", "));
    }


    private static int[] getArray(int size, int defaultValue) {
        int [] arr = getArray(size);
        Arrays.fill(arr, defaultValue);
        return  arr;
    }
    private static int[] getArray(int size) {
        int [] arr = new int[size+1];
        for (int i = 1; i <= size; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
