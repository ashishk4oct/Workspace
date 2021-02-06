package com.hackerrank.medium;

import java.util.Arrays;

public class PrimsMSTSpecialSubtree {

    public static void main(String[] args) {
        int i = prims(5, new int[][]{
                {1, 2, 3},
                {1, 3, 4},
                {4, 2, 6},
                {5, 2, 2},
                {2, 3, 5},
                {3, 5, 7},

        }, 1);
        System.out.println(i);
    }


    static int prims(int n, int[][] edges, int start) {

        int arr[] = new int[n + 1];

        WeightedNode edgesArr [] = new WeightedNode[edges.length];
        int set [] = new int[n+1];

        for (int i = 0; i < edges.length ; i++) {
            edgesArr[i] = new WeightedNode(edges[i][2], edges[i][0], edges[i][1]);
        }
        for (int i = 1; i <= n ; i++) {
            set[i] = i;
        }

        Arrays.sort(edgesArr,(a,b)-> a.weight -b.weight);
        int count = 0;
        for(WeightedNode node  : edgesArr) {
            if(set[node.u] == set[node.v]){
                continue;
            }
            count += node.weight;
            int max = set[node.u] > set[node.v] ?  set[node.u] : set[node.v];
            int min = set[node.u] < set[node.v] ?  set[node.u] : set[node.v];
            for (int i = 1; i <= n ; i++) {
                if(set[i] == max){
                    set[i] = min;
                }
            }

        }

        return count;

    }

}
class WeightedNode{
    int weight;
    int u;
    int v;

    public WeightedNode(int weight, int u, int v) {
        this.weight = weight;
        this.u = u;
        this.v = v;
    }
}




