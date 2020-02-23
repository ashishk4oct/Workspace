package com.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConservativeGraphOptimalSolution {

    static int mat[][];

    public static void main(String Args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder str = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Graph g = new Graph(n);
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                g.add(u, v, w);
            }
            if (g.conservative())
                str.append("YES\n");
            else
                str.append("NO\n");
        }
        System.out.println(str.toString());
    }
}

class Pair {
    int node;
    int weight;

    Pair(int f, int s) {
        this.node = f;
        this.weight = s;
    }
}

class Graph {
    int n;
    LinkedList<Pair>[] adj;

    Graph(int n) {
        this.n = n;
        adj = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new LinkedList<Pair>();
        }
    }

    void add(int u, int v, int w) {
        adj[u].add(new Pair(v, w));
        adj[v].add(new Pair(u, -w));
    }

    boolean conservative() {
        boolean vis[] = new boolean[n + 1];
        int dis[] = new int[n + 1];
        Arrays.fill(dis, -1);
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                if (!check(i, vis, dis)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(int i, boolean[] vis, int[] dis) {
        vis[i] = true;
        dis[i] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        while (!que.isEmpty()) {
            int u = que.remove();
            Iterator<Pair> itr = adj[u].iterator();
            while (itr.hasNext()) {
                Pair p = itr.next();
                if (dis[p.node] == -1) {
                    dis[p.node] = dis[u] + p.weight;
                    vis[p.node] = true;
                    que.add(p.node);
                } else {
                    if (dis[p.node] != dis[u] + p.weight)
                        return false;
                }
            }
        }
        return true;
    }
}