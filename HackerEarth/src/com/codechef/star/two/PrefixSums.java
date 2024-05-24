package com.codechef.star.two;

import com.codechef.easy.Reader;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
*Problem Link: https://www.codechef.com/practice/course/2-star-difficulty-problems/DIFF1500/problems/UNQEQ
*
* Input Format
*   First line of input will contain T, the number of test cases. Then the test cases follow.
*   Each test case contains a single line of input, the integer 𝑁. (For a positive, even integer N)
*/
public class PrefixSums {
    public static void main(String[] args) throws java.lang.Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Reader.readIntArr(reader)[0];
            for (int i = 0; i < t; i++) {
                int n = Reader.readIntArr(reader)[0];
                prefixSums(n);
            }
        }
    }

    private static void prefixSums(int n) {
        if (oddSum(n)) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");

        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();

        for (int i = (n / 4), k = (n / 4) + 1; i > 0; i--, k++) {
            sbA.append(" ");
            sbA.append((n + 1) - i);
            sbA.insert(0, i + " ");
            sbB.append(" ");
            sbB.append((n + 1) - k);
            sbB.insert(0, k + " ");
        }

        int index = sbA.indexOf("  ");
        sbA.replace(index, index+2, " ");
        index = sbB.indexOf("  ");
        sbB.replace(index, index+2, " ");
        System.out.println(sbA.toString());
        System.out.println(sbB.toString());
    }

    private static boolean oddSum(int n) {
        return n % 4 != 0;
    }
}