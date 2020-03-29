package com.hackerrank.medium;

public class PalindromeIndex {

    public static void main(String[] args) {
        System.out.println(palindromeIndex("acbbc"));

    }

    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
        if (checkPalindrome(s)) {
            return -1;
        }

        int len = s.length();

        int i = 0, j = len - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (checkPalindrome(s.substring(0, i)+ s.substring(i + 1))) {
                    return i;
                }

                if (checkPalindrome(s.substring(0, j)+ s.substring(j + 1))) {
                    return j;
                }
            }
            i++;
            j--;
        }
        return -1;

    }

    static boolean checkPalindrome(String s) {

        int len = s.length();

        int i = 0, j = len - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
