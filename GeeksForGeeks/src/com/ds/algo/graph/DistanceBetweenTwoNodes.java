package com.ds.algo.graph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public class DistanceBetweenTwoNodes {

	// Java program to find minimum edge
	// between given two vertex of Graph
	 

	 // method for addition of edge
    static void addEdge(ArrayList<Integer> edges[], int u, int v)
    {
       edges[u].add(v);
       edges[v].add(u);
    }
 
	
	 // Driver method
    public static void main(String args[])
    {
        // To store adjacency list of graph
        int n = 9;
        ArrayList<Integer> edges[] = new ArrayList[9];
         
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<Integer>();
        }
         
        addEdge(edges, 0, 1);
        addEdge(edges, 0, 7);
        addEdge(edges, 1, 7);
        addEdge(edges, 1, 2);
        addEdge(edges, 2, 3);
        addEdge(edges, 2, 5);
        addEdge(edges, 2, 8);
        addEdge(edges, 3, 4);
        addEdge(edges, 3, 5);
        addEdge(edges, 4, 5);
        addEdge(edges, 5, 6);
        addEdge(edges, 6, 7);
        addEdge(edges, 7, 8);
        int u = 0;
        int v = 4;
        System.out.println(myMinEdgeBFS(edges, u, v));
        System.out.println(minEdgeBFS(edges, u, v, n));
    }




	private static int myMinEdgeBFS(ArrayList<Integer>[] edges, int u, int v) {
		
		return 0;
	}


	// Method for finding minimum no. of edge
    // using BFS
    static int minEdgeBFS(ArrayList<Integer> edges[], int u,
                                  int v, int n)
    {
        // visited[n] for keeping track of visited
        // node in BFS
        Vector<Boolean> visited = new Vector<Boolean>(n);
         
        for (int i = 0; i < n; i++) {
            visited.addElement(false);
        }
      
        // Initialize distances as 0
        Vector<Integer> distance = new Vector<Integer>(n);
         
        for (int i = 0; i < n; i++) {
            distance.addElement(0);
        }
      
        // queue to do BFS.
        Queue<Integer> Q = new LinkedList<>();
        distance.setElementAt(0, u);
      
        Q.add(u);
        visited.setElementAt(true, u);
        while (!Q.isEmpty())
        {
            int x = Q.peek();
            Q.poll();
      
            for (int i=0; i<edges[x].size(); i++)
            {
                if (visited.elementAt(edges[x].get(i)))
                    continue;
      
                // update distance for i
                distance.setElementAt(distance.get(x) + 1,edges[x].get(i));
                Q.add(edges[x].get(i));
                visited.setElementAt(true,edges[x].get(i));
            }
        }
        return distance.get(v);
    }
}
