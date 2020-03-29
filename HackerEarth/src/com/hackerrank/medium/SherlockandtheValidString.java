package com.hackerrank.medium;

import java.util.Arrays;

public class SherlockandtheValidString {

    public static void main(String[] args) {
        String s = isValid("aabbcd");
        System.out.println(s);
    }
    // Complete the isValid function below.
    static String isValid(String s) {
        int arr[] = new int[27];

        Arrays.fill(arr, 0);
        for (int i = 0; i < s.length(); i++) {
            int index = getIndex(s, i);
            arr[index]++;
        }
        if(valid(arr)){
            return "YES";
        }

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] > 0){
                arr[i]--;
                if(valid(arr)){
                    return "YES";
                }
                arr[i]++;
            }
        }

        return "NO";
    }
    static boolean valid(int [] arr){

        int count = 0;
        boolean valid = true;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] > 0){
                if(count != 0){
                    if(arr[i] != count){
                        valid = false;
                        break;
                    }
                }

                count = arr[i];
            }
        }
        return valid;


    }
    static int getIndex(String s,int index){
        return ((int)s.charAt(index))-'a';
    }
}
