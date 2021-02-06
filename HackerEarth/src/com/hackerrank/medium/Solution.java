package com.hackerrank.medium;

import java.io.*;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(rd.readLine());
        for(int t = 0; t < T; t++) {
            String[] toks = rd.readLine().split(" ");
            int K = Integer.parseInt(toks[0]), L = 0, r, r2;
            char[] P = toks[1].toCharArray(), Q = toks[2].toCharArray();
            for(int l = 0; l < P.length - L; l++) {
                for(int i = 0, j = l; i <= l; i += l, j -= l) {
                    int k = 0;
                    for(r = i; r < P.length - l + i; r++) {
                        if(P[r] != Q[j + r - i])
                            k++;
                    }
                    for(r = i; k > K; r++) {
                        if(P[r] != Q[j + r - i])
                            k--;
                    }
                    r2 = P.length - 1 - j;
                    while(true) {
                        if(r2 - r + 1 > L)
                            L = r2 - r + 1;
                        r--;
                        if(r < i)
                            break;
                        while(r > 0 && j + r - i > 0 && P[r - 1] == Q[j + r - i - 1])
                            r--;
                        while(j + r2 - i >= 0 && P[r2] == Q[j + r2 - i])
                            r2--;
                        r2--;
                    }
                    if(l == 0)
                        break;
                }
            }
            System.out.println(L);
        }
    }
}
