package com.hackerrank.medium;

import java.util.Arrays;

public class AlmostSorted {

    public static void main(String[] args) {
        almostSorted(new int[]{1, 2, 4, 3, 5, 6});
    }
    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        if(arr.length == 1){
            System.out.println("yes");
            return;
        }
        if(sorted(arr)){
            System.out.println("yes");
            return;
        }else if(arr.length == 2){
            System.out.println("yes");
            System.out.println("swap "+1+" "+2);
            return;
        }

        int startIndex = -1, endIndex = -1;
        int i = 0;
        while(i < arr.length-1){
            if(arr[i] > arr[i+1]){
                startIndex = i;
                break;
            }
            i++;
        }

        boolean swap = false;
        i++;
        if(arr[i] < arr[i+1])
            swap = true;
        else{
            endIndex = i+1;
        }
        while(swap && i < arr.length-1){
            if(arr[i] > arr[i+1]){
                endIndex = i+1;
                break;
            }
            i++;
        }
        while(!swap && i < arr.length-1){
            if(arr[i] < arr[i+1]){
                endIndex = i;
                break;
            }
            i++;
        }


        if(swap && endIndex < 0 && startIndex-1 >= 0){
            endIndex = startIndex+1;
        }
        if(swap && endIndex > 0){
            swap(arr, startIndex, endIndex);
        }else if(endIndex > 0){
            reverse(arr, startIndex, endIndex);
        }
        if(!sorted(arr)){
            System.out.println("no");
        }else{
            System.out.println("yes");
            if(swap)
                System.out.println("swap "+(startIndex+1)+" "+(endIndex+1));
            else
                System.out.println("reverse "+(startIndex+1)+" "+(endIndex+1));

        }
    }

    private static void swap(int [] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


    private static void reverse(int [] arr, int start, int end){
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }

    }
    private static boolean sorted(int [] arr){
        for(int i = 0; i< arr.length-1 ; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
