package com.hackerrank.medium;

import java.util.LinkedList;
import java.util.Queue;

public class SubstringDiff {
    public static void main(String[] args) {

        int k = 2;
        String s1 = "tabriz", s2 = "torino";
        int i = substringDiff(k, s1, s2);
        System.out.println(i);
    }


    static int substringDiff(int k, String s1, String s2) {
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();

        int LCStuff[][] = new int[s1.length() + 1][s2.length() + 1];
        int result = 0;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    LCStuff[i][j] = 0;
                else if (s1arr[i - 1] == s2arr[j - 1]) {
                    LCStuff[i][j]
                            = LCStuff[i - 1][j - 1] + 1;
                    result = Integer.max(result,
                            LCStuff[i][j]);
                } else
                    LCStuff[i][j] = 0;
            }
        }
        int match[];
        int max = 0;

        for (int i = s1.length(); i > 0; i--) {
            match = new int[s1.length() - i + 1];
            for (int j = 1,t = i; j + i <= s1.length() + 1; j++, t++) {
//                System.out.print(","+t + " " + j);
                match[j - 1] = LCStuff[t][j];
            }
            int localMax = findMax1(match, k);
            max = max > localMax ? max : localMax;
        }
//        System.out.println();
        for (int i = 2; i <= s1.length() ; i++) {
            match = new int[s1.length()-i+1];
            for (int j = i, t = 1; j <= s1.length(); j++, t++) {
//                System.out.print(","+t + " " + j);
                match[j - i] = LCStuff[t][j];
            }
            int localMax = findMax1(match, k);
            max = max > localMax ? max : localMax;
        }

        return max;
    }

    private static int findMax1(int[] match, int k) {
        int max = 0;
        Queue<Integer> q = new LinkedList<>();

        int l = 0;

        for (int i = 0, h = 0; i < match.length; i++) {
            if (match[i] == 0) {
                q.add(i);
                if (l == k) {
                    h = q.poll() + 1;
                } else {
                    l++;
                }
            }
            max = max > i - h + 1 ? max : i - h + 1;
        }
        return max;
    }

}
