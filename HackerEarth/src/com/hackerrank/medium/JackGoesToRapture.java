package com.hackerrank.medium;

import java.util.*;

public class JackGoesToRapture {
    public static void main(String[] args) {

        ArrayList<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        gFrom.add(1);
        gTo.add(2);
        gWeight.add(30);
        gFrom.add(2);
        gTo.add(3);
        gWeight.add(50);
        gFrom.add(3);
        gTo.add(4);
        gWeight.add(70);
        gFrom.add(4);
        gTo.add(5);
        gWeight.add(90);
        gFrom.add(1);
        gTo.add(3);
        gWeight.add(70);
        gFrom.add(3);
        gTo.add(5);
        gWeight.add(85);
        getCost(5, gFrom, gTo, gWeight);

        int[][] edges = new int[][]{
                {1, 2, 30},
                {2, 3, 50},
                {3, 4, 70},
                {4, 5, 90},
                {1, 3, 70},
                {3, 5, 85}
        };
        int cost = getCost(5, edges);
        System.out.println(cost);
    }


    public static int getCost(int gNodes, int[][] edges) {

        System.out.println("done");
        return 0;
    }

    public static void getCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        // Print your answer within the function and return nothing
        int node = gNodes;
        int nodesW[] = new int[gNodes + 1];
        Arrays.fill(nodesW, Integer.MAX_VALUE);
        nodesW[gNodes] = 0;
        PriorityQueue<PQElement> pq = new PriorityQueue<>(gFrom.size(), new PQComparator());
        fillMinNodes(node, 0, gFrom, gTo, gWeight, pq, nodesW);
        while (!pq.isEmpty() && pq.peek().node != 1) {
            PQElement element = pq.poll();
            fillMinNodes(element.node, element.weight, gFrom, gTo, gWeight, pq, nodesW);
        }

        if (pq.isEmpty())
            System.out.println("NO PATH EXISTS");
        else
            System.out.println(pq.peek().weight);

    }

    private static void fillMinNodes(int node, int weight, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight, PriorityQueue<PQElement> pq, int[] nodesW) {

        if (weight > nodesW[node]) return;

        for (int i = 0; i < gFrom.size(); i++) {
            if (gFrom.get(i).equals(node)) {
                PQElement element = new PQElement(gTo.get(i), max(weight, gWeight.get(i)));
                if (nodesW[element.node] > element.weight) {
                    pq.add(element);
                    nodesW[element.node] = element.weight;
                }

            }
            if (gTo.get(i).equals(node)) {
                PQElement element = new PQElement(gFrom.get(i), max(weight, gWeight.get(i)));
                if (nodesW[element.node] > element.weight) {
                    pq.add(element);
                    nodesW[element.node] = element.weight;
                }
            }
        }

    }

    private static int max(int i, Integer j) {
        return i > j ? i : j;
    }

}

class PQComparator implements Comparator<PQElement> {

    @Override
    public int compare(PQElement p, PQElement q) {
        int weight = p.weight - q.weight;
        if (weight == 0) {
            return p.node - q.node;
        }
        return weight;
    }
}

class PQElement {
    int node;
    int weight;

    PQElement(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PQElement pqElement = (PQElement) o;
        return node == pqElement.node;
    }

}
