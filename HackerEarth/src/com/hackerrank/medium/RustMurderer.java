package com.hackerrank.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RustMurderer {

    public static void main(String[] args) {
        Arrays.stream(rustMurderer(5, new int[][]{
                {1, 3},
                {1, 4},
                {1, 5},
                {2, 4},
                {2, 5},
                {3, 5},
        }, 1)).forEach(value -> System.out.println(value));
    }


    static int[] rustMurderer(int n, int[][] roads, int s) {

        RMNode[] nodeArr = new RMNode[n + 1];
        fillNodes(roads, nodeArr);
        Map<String, Integer> map = new HashMap<>();

        int result[] = new int[n - 1];
        int sub = 1;
        for (int i = 1; i <= n; i++) {
            if (i == s) {
                sub = 2;
                continue;
            }
            result[i - sub] = findDistance(roads, nodeArr, s, i, n, "."+s+"."+i+".");
        }

        return result;
    }

    private static int findDistance(int[][] roads, RMNode[] nodeArr, int i, int j, int n, String parent) {
        if(i == j){
            return n;
        }
        if (!isConnected(nodeArr, i, j)) {
            return 1;
        }

        for (int k = 1; k <= n; k++) {
            if (k != i && k != j) {
                if (!isConnected(nodeArr, i, k) && !isConnected(nodeArr, j, k)) {
                    return 2;
                }
            }
        }
        RMNode nodeI = nodeArr[i];
        int min = n;
        while (nodeI != null) {
            RMNode nodeJ = nodeArr[j];
            while (nodeJ != null) {
                if(parent.indexOf("."+nodeI.value+".") == -1 && parent.indexOf("."+nodeJ.value+".") == -1 && !isConnected(nodeArr, nodeI.value, j) && !isConnected(nodeArr, nodeJ.value, i)  ){
                    int dis = findDistance(roads, nodeArr, nodeI.value, nodeJ.value, n , parent+"."+nodeI.value+"."+nodeJ.value+".") + 2;
                    min = min > dis ? dis : min;
                }
                nodeJ= nodeJ.next;
            }
            nodeI = nodeI.next;
        }
        return min;
    }

    private static boolean isConnected(RMNode[] nodeArr, int i, int j) {
        if (nodeArr[i] == null) {
            return false;
        }
        RMNode node = nodeArr[i];
        while (true) {
            if (node.value == j) {
                return true;
            }
            if (node.next == null) {
                return false;
            }
            node = node.next;
        }
    }


    static void fillNodes(int[][] roads, RMNode[] nodeArr) {
        for (int[] path : roads) {
            fill(path[0], path[1], nodeArr);
            fill(path[1], path[0], nodeArr);
        }

    }

    private static void fill(int i, int j, RMNode[] nodeArr) {
        RMNode node = new RMNode(j);
        if (nodeArr[i] == null) {
            nodeArr[i] = new RMNode(j);
            return;
        }
        node.next = nodeArr[i];
        nodeArr[i] = node;
    }
}

class RMNode {
    int value;
    RMNode next;

    public RMNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value+"";
    }
}