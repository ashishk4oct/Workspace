package com.hackerrank.medium;

import java.util.Arrays;
import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
       int i = longestValidParentheses("(()");
        System.out.println(i);
    }

    public static int longestValidParenthesesOptimal(String s) {

        char arr[] = s.toCharArray();
        int max = 0;
        int left = 0, right = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                left++;
            }else{
                right++;
            }

            if(left == right){
                max = max > (2*left) ? max : (2*left);
            }else if(left < right){
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;

        for(int i = arr.length-1; i >= 0 ; i--){
            if(arr[i] == '('){
                left++;
            }else{
                right++;
            }

            if(left == right){
                max = max > (2*left) ? max : (2*left);
            }else if(left > right){
                left = 0;
                right = 0;
            }
        }

        return max;

       /* Approach in O(1) auxiliary space and O(N) Time complexity:

        1.The idea to solve this problem is to traverse the string on and keep track of the count of open parentheses and close parentheses with the help of two counters left and right respectively.
        2.First, the string is traversed from the left towards the right and for every “(” encountered, the left counter is incremented by 1 and for every “)” the right counter is incremented by 1.
        3.Whenever the left becomes equal to right, the length of the current valid string is calculated and if it greater than the current longest substring, then value of required longest substring is updated with current string length.
        4.If the right counter becomes greater than the left counter, then the set of parentheses has become invalid and hence the left and right counters are set to 0.
        5.After the above process, the string is similarly traversed from right to left and similar procedure is applied.
        */
    }

    public static int longestValidParentheses(String s) {

        char arr[] = s.toCharArray();
        int len[] = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        Arrays.fill(len, 0);

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                stack.push(i);
            }else if(!stack.isEmpty()){
                int index = stack.pop();
                len[index]=1;
                len[i]=1;
            }
        }
        int max = 0;
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            if(len[i] == 1){
                count++;
            }else{
                max = max > count ? max : count;
                count = 0;
            }
        }
        max = max > count ? max : count;
        return max;

        /*
            1. create integer array of string length, filled with all zeros
            2. keep track of open parentheses in stack
            3. when closed parentheses encountered and stack is not empty mark integer array index with 1
            4. count max continuous 1s
        */
    }
}
