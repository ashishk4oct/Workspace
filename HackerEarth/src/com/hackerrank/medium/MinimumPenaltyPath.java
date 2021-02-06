package com.hackerrank.medium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MinimumPenaltyPath {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] edgesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int edgesItem = Integer.parseInt(edgesRowItems[j]);
                edges[i][j] = edgesItem;
            }
        }

        String[] AB = scanner.nextLine().split(" ");

        int A = Integer.parseInt(AB[0]);

        int B = Integer.parseInt(AB[1]);

        int result = beautifulPath(edges, A, B, n);

        System.out.println(String.valueOf(result));

        scanner.close();
    }


    // Complete the beautifulPath function below.
    static int beautifulPath(int[][] edges, int A, int B, int N) {

        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < edges.length ; i++) {
            List<Edge> list = map.get(edges[i][1]);
            if(list == null){
                list = new ArrayList<>();
                map.put(edges[i][1],list);
            }
            list.add(new Edge(edges[i][0],edges[i][1],edges[i][2]));
        }


        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> qCost = new LinkedList<>();
        queue.add(B);
        qCost.add(0);
        int minCost[] = new int[N+1];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            Integer cost = qCost.poll();

            List<Edge> edgeList = map.get(node);
            if(edgeList == null)
                continue;
            for(Edge e : edgeList){
                int c = e.cost|cost;
                if(node == 31 && (e.cost == 8 || e.cost == 4)){
                    System.out.println(e.u+" "+e.cost+" "+node+" "+c);
                }

                if(minCost[e.u] > c){
                    minCost[e.u] = c;
                    queue.add(e.u);
                    qCost.add(c);
                }else{
                    continue;
                }

            }
        }

        return minCost[A] == Integer.MAX_VALUE ? -1 : minCost[A];

    }

}
class Edge{
    int u,v,cost;

    Edge(int u, int v, int cost){
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
}