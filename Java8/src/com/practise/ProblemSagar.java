package com.practise;

public class ProblemSagar {

    public static void main(String args[]){

        ProblemSagar problemSagar = new ProblemSagar();
        for (int i : problemSagar.createArray(4, 2)) {
            System.out.println(i);
        }

        int arr[] = problemSagar.createArray(4, 2);
    }

    public int[] createArray(int size, int a0) {//size = N,a0 array 0 index value
        int arr[] = new int[size];
        arr[0] = a0;
        for (int i = 1; i < size; i++) {
            int val;
            if(i%2 == 0){//i is odd
                val = (2*arr[i-1])+(3*arr[i-2]);
            }else{//i is even
                val = 3*arr[i-1];
                if(val%2 == 0){// if value odd then add 1
                    val++;
                }
            }
            arr[i] = val;
        }
        return arr;
    }
}
