package com.hackerrank.medium;

public class FormingMagicSquare{

    public static void main(String[] args) {

        int v = formingMagicSquare(new int[][]{
                {4, 9, 2},
                {3, 5, 7},
                {8, 1, 5}
        });

        System.out.println(v);
    }


    static int formingMagicSquare(int[][] s) {
        int arr[] = new int[9];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = i+1;
        }
        return findMinCost(arr, s);
    }

    private static int findMinCost(int[] arr, int[][] s) {
        return findMinCost(arr,s,0);
    }


    private static int findMinCost(int[] arr, int[][] s, int index) {
        if(index == 8){
            return validateAndReturnCost(arr,s);
        }else{
            if(!valid(arr, index)){
                return Integer.MAX_VALUE;
            }
        }

        int minCost = Integer.MAX_VALUE;
        int cost ;
        for (int i = index; i < 9; i++) {
            swap(arr,i, index);
            cost = findMinCost(arr,s,index+1);
            minCost = minCost < cost ? minCost : cost;
            swap(arr,i, index);

        }
        return minCost;
    }

    private static boolean valid(int[] arr, int index) {
        for (int i = 0; i < index/3 ; i++) {
            if(arr[(i*3)+0]+arr[(i*3)+1]+arr[(i*3)+2] != 15){
                return false;
            }
        }
        return true;
    }

    private static int validateAndReturnCost(int[] arr, int[][] s) {
        if((arr[0]+arr[1]+arr[2] == 15)
                &(arr[3]+arr[4]+arr[5] == 15)
                &(arr[6]+arr[7]+arr[8] == 15)
                &(arr[0]+arr[3]+arr[6] == 15)
                &(arr[1]+arr[4]+arr[7] == 15)
                &(arr[2]+arr[5]+arr[8] == 15)
                &(arr[0]+arr[4]+arr[8] == 15)
                &(arr[2]+arr[4]+arr[6] == 15)
        ){
            int cost = 0;

            for (int i = 0; i < 9; i++) {
                int a[] = findIndex(i);
                cost += s[a[0]][a[1]] > arr[i] ?  s[a[0]][a[1]] - arr[i] : arr[i] - s[a[0]][a[1]];
            }
            return cost;
        }
        return Integer.MAX_VALUE;
    }

    private static int[] findIndex(int i) {
        return new int[]{i/3,i%3};
    }


    public static void swap(int[] array, int i, int j) {
        int temp;
        temp = array[i] ;
        array[i] = array[j];
        array[j] = temp;
    }
}
