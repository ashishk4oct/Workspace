package com.hackerrank.medium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BreadthFirstSearchShortestReach {
/*
    public static void main(String[] args) {

        for(int v : bfs(4, 2, new int[][]{{1,2},{1,3}}, 1)){
            System.out.print(v+", ");
        }
    }*/


    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);
            for(int v : result){
                System.out.print(v+", ");
            }
            System.out.println();
        }
        scanner.close();
    }
    // Complete the bfs function below.
    static int[] bfs(int numberOfNodes, int numberOfEdges, int[][] edges, int srcNode) {
        Node graph [] = new Node[numberOfNodes+1];
        for(int[] edge: edges){
            Node dest = (graph[edge[1]] == null) ? new Node(edge[1]) : graph[edge[1]];
            Node src = (graph[edge[0]] == null) ? new Node(edge[0]) : graph[edge[0]];
            src.add(dest);
            graph[edge[1]] = dest;
            graph[edge[0]] = src;
        }

        Node src = graph[srcNode];
        int distanceArray[] = new int[numberOfNodes+1];
        Arrays.fill(distanceArray, -1);

        if(src == null){
            int dist[] = new int[numberOfNodes-1];
            Arrays.fill(dist, -1);
            return dist;
        }

        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        queue.add(src);
        depth.add(0);
        while(!queue.isEmpty()){
            int d = depth.poll();
            Node node = queue.poll();

            for(Node n : node.nexts){
                queue.add(n);
                depth.add(d+1);
            }

            if(distanceArray[node.data] < d){
                distanceArray[node.data] = d*6;
            }
        }

        int dist[] = new int[numberOfNodes-1];
        int c = 0;
        for(int i = 1; i < distanceArray.length; i++){
            if(i == src.data){
                continue;
            }
            dist[c++] = distanceArray[i];
        }

        return dist;
    }

}

class Node{
    int data;
    List<Node> nexts = new ArrayList<>();

    Node(int data, Node next){
        this.data = data;
        this.nexts.add(next);
    }
    Node(int data){
        this.data = data;
    }
    public void add(Node node){
        this.nexts.add(node);
    }
}