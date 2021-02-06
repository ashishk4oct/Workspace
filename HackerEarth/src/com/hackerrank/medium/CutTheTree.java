package com.hackerrank.medium;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CutTheTree {

    static int n;
    static int a[];
    static ArrayList<Integer> e[];
    static int ans = Integer.MAX_VALUE;
    static int sum = 0;

    static int dfs(int u, int parent) {
        int acc = a[u];

        for (int v : e[u]) {
            if (v == parent) continue;

            int cb = dfs(v, u);
            acc += cb;
            ans = Math.min(ans, Math.abs(cb - (sum - cb)));
        }

        return acc;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        a = new int[n];
        e = new ArrayList[n];
        for (int i=0; i<n; i++) {
            a[i] = cin.nextInt();
            sum += a[i];
            e[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<n-1; i++) {
            int u = cin.nextInt() - 1;
            int v = cin.nextInt() - 1;
            e[u].add(v);
            e[v].add(u);
        }

        dfs(0, -1);
        System.out.println(ans);
    }
}