package com.codechef.easy;

import java.nio.file.Path;
import java.util.*;

public class ConservativeGraph {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(!in.hasNextInt()){
            return ;
        }
        int testcases =  in.nextInt();

        for (int i = 0; i < testcases; i++) {
            if(!in.hasNextInt()){
                return ;
            }
            int nodesCount = in.nextInt();
            if(!in.hasNextInt()){
                return ;
            }
            int edgeCount = in.nextInt();

            String [][] edgeMap = new String[edgeCount+1][2];
            for (int j = 0; j < edgeCount ; j++) {
                if(!in.hasNextInt()){
                    return ;
                }
                int start = in.nextInt();
                if(!in.hasNextInt()){
                    return ;
                }
                int end = in.nextInt();
                if(!in.hasNextInt()){
                    return ;
                }
                int cost = in.nextInt();
                populateEdgeMapBoth(start, end, cost ,edgeMap);
            }
            System.out.println(checkConservativeGraph(nodesCount, edgeCount, edgeMap));
        }
    }


    private static void populateEdgeMapBoth(int node1, int node2,int cost ,String[][] edgeMap) {
        populateEdgeMap(node1, node2, cost ,edgeMap);
        populateEdgeMap(node2, node1, cost*-1 ,edgeMap);
    }

    private static void populateEdgeMap(int node1, int node2, int cost, String[][] edgeMap) {
        String map = edgeMap[node1][0];
        if(null == map){
            map = "";
        }else{
            map += ",";
        }
        map += node2;

        String mapCost = edgeMap[node1][1];
        if(null == mapCost){
            mapCost = "";
        }else{
            mapCost += ",";
        }
        mapCost += cost;

        edgeMap[node1][0] = map;
        edgeMap[node1][1] = mapCost;
    }

    private static String checkConservativeGraph(int nodesCount, int edgeCount, String [][] edgeMap) {
        for (int i = 1; i <= nodesCount ; i++) {
            for (int j = i+1; j <= nodesCount ; j++) {
                if(i != j){
                    if(!checkAllPathCostSame(i, j, edgeMap)){
                        return "NO";
                    }
                }
            }
        }
        return "YES";
    }

    private static boolean checkAllPathCostSame(int src, int dest, String[][] edgeMap) {
        return findPathCost(""+src,src,dest,edgeMap,0).isConservative;
    }

    private static PathCost findPathCost(String pathTraversed, int currentNode,  int dest, String[][] edgeMap, int previousCost){
        if(currentNode == dest){
            PathCost pathCost = new PathCost(true);
            pathCost.cost = previousCost;
            pathCost.foundPath = true;
            return pathCost;
        }
        String connections = edgeMap[currentNode][0];
        if(null == connections){
            return new PathCost(false);
        }

        String pathTraversedArr[] = pathTraversed.split(",");
        PathCost pathCost = new PathCost(false);
        int index = 0;
        for (String n : connections.split(",")){
            if(checkTraversedNode(pathTraversedArr,n)){
                index++;
                continue;
            }
            int next = Integer.parseInt(n);

            PathCost pathCostTemp = findPathCost(pathTraversed+","+next, next,  dest, edgeMap, previousCost+getCost(currentNode, index, edgeMap));
            if(!pathCostTemp.isConservative){
                return pathCostTemp;
            }
            if(pathCostTemp.foundPath){
                if(pathCost.foundPath){
                    if(pathCost.cost != pathCostTemp.cost){
                        return new PathCost(false);
                    }
                }else{
                    pathCost = pathCostTemp;
                }
            }
            index++;
        }
        return pathCost;
    }

    private static boolean checkTraversedNode(String[] pathTraversedArr, String n) {
        for (String node : pathTraversedArr) {
            if(node.equalsIgnoreCase(n)){
                return true;
            }
        }
        return false;
    }

    private static int getCost(int currentNode, int index, String edges[][]) {
        return Integer.parseInt(edges[currentNode][1].split(",")[index]);
    }

}

class PathCost{
    PathCost(boolean isConservative){
        this.isConservative = isConservative;
    }
    int cost;
    boolean foundPath = false;
    boolean isConservative = false;
}