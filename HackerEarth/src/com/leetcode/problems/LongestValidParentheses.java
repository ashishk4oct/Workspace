package com.leetcode.problems;

import java.util.Arrays;
import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {

        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses("(()()(())())()(()(("));
        System.out.println(longestValidParentheses.longestValidParentheses("(()(((()"));
    }

    public int longestValidParentheses(String s) {

        int dp[] = new int[s.length()];

        for (int i = 1; i < s.length() ; i++) {
            if(s.charAt(i) == ')' && s.charAt(i-1) == '('){
                dp[i] = 2 + ( i-2 > 0 ? dp[i-2] : 0);
            }else if(s.charAt(i) == ')' && s.charAt(i-1) == ')'){
                if(dp[i-1] > 0 && i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = 2+dp[i-1]+(i-dp[i-1] > 1 ? dp[i-dp[i-1]-2] : 0 );
                }
            }
        }
        int max = 0;
        for (int i : dp){
            max = i > max ? i : max;
        }
        return max;
    }
}
