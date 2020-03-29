package com.hackerrank.medium;

import java.util.*;

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

    // Complete the prims function below.
    static int prims(int n, int[][] edges, int start) {
        Node[] nodesArr = getNodesArr(n, edges);
        Node node = nodesArr[start];

        Integer[] weights = getWeights(node, n);

        return getWeightsSum(weights);
    }

    private static int getWeightsSum(Integer[] weights) {
        Integer sum = new Integer(0);
        for (Integer weight : weights) {
            if(weight != null){
                sum += weight;
            }
        }
        return sum;
    }

    private static Integer[] getWeights(Node node, int n) {
        return null;
    }

    private static void updateWeight(Integer[] weights, Integer weight, int number) {
        Integer w = weights[number];
        if(w == null || w > weight){
            weights[number] = weight;
        }
    }

    private static Node[] getNodesArr(int n, int[][] edges) {
        Node nodes[] = new Node[n + 1];
        for (int i = 0; i < edges.length; i++) {
            Node nodeFrom = getNode(edges[i][0], nodes);
            Node nodeTo = getNode(edges[i][1], nodes);
            linkNodes(nodeFrom, nodeTo, edges[i][2]);
        }
        return nodes;
    }

    private static void linkNodes(Node node1, Node node2, int weight) {
        linkNode(node1, node2, weight);
        linkNode(node2, node1, weight);
    }


    private static void linkNode(Node node1, Node node2, int weight) {
        if (node1.map.containsKey(node2)) {
            int value = node1.map.get(node2);
            if (value > weight) {
                node1.map.put(node2, weight);
            }
        } else {
            node1.map.put(node2, weight);
        }

    }

    private static Node getNode(int i, Node[] nodes) {
        Node node = nodes[i];
        if (node == null) {
            nodes[i] = new Node(i);
            node = nodes[i];
        }
        return node;
    }


}

class Node {
    int number;
    Map<Node, Integer> map;

    Node(int number) {
        this.number = number;
        map = new HashMap<>();
    }

    @Override
    public String toString() {
        return ""+number;
    }
}
