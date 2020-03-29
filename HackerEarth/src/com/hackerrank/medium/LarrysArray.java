package com.hackerrank.medium;

public class LarrysArray {

    public static void main(String[] args) {
        larrysArray(new int[]{1, 6, 5, 2, 3, 4});
    }
    // Complete the larrysArray function below.
    static String larrysArray(int[] A) {


        for(int i = 0 ; i < A.length-2 ; i++ ){
            position(i+1,A);
        }

        return checkSorted(A);
    }
    static String checkSorted(int[] A){

        for(int i = 0 ; i < A.length-1 ; i++ ){
            if(A[i]>A[i+1]){
                return "NO";
            }
        }
        return "YES";
    }
    static void position(int num, int[] A){
        int i = 0;
        for(; i < A.length ; i++ ){
            if(A[i] == num){
                break;
            }
        }
        while(i+1 != num){
            if(i >= A.length-2){
                rotate(A.length-3, A);
            }else{
                rotate(i-1, A);
            }
            i--;
        }
    }
    static void rotate(int j, int[] A){
        if(j+2 < A.length){
            int temp = A[j];
            A[j] = A[j+1];
            A[j+1] = A[j+2];
            A[j+2] = temp;
        }
    }

}
