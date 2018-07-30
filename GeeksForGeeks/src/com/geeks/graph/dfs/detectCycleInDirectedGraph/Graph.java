package com.geeks.graph.dfs.detectCycleInDirectedGraph;

//A Java Program to detect cycle in a graph
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Graph {

	private final int V;
	private final List<List<Integer>> adj;

	public Graph(int V) {
		this.V = V;
		adj = new ArrayList<>(V);

		for (int i = 0; i < V; i++)
			adj.add(new LinkedList<>());
	}

	// This function is a variation of DFSUytil() in
	// https://www.geeksforgeeks.org/archives/18212
	private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {

		// Mark the current node as visited and
		// part of recursion stack
		if (recStack[i])
			return true;

		if (visited[i])
			return false;

		visited[i] = true;

		recStack[i] = true;
		List<Integer> children = adj.get(i);

		for (Integer c : children)
			if (isCyclicUtil(c, visited, recStack))
				return true;

		recStack[i] = false;

		return false;
	}

	private void addEdge(int source, int dest) {
		adj.get(source).add(dest);
	}

	// Returns true if the graph contains a
	// cycle, else false.
	// This function is a variation of DFS() in
	// https://www.geeksforgeeks.org/archives/18212
	private boolean isCyclic() {

		// Mark all the vertices as not visited and
		// not part of recursion stack
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];

		// Call the recursive helper function to
		// detect cycle in different DFS trees
		for (int i = 0; i < V; i++)
			if (isCyclicUtil(i, visited, recStack))
				return true;

		return false;
	}

	// Driver code
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
//		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
//		graph.addEdge(3, 3);

		if (graph.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't " + "contain cycle");

		if (graph.containsCycle())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't " + "contain cycle");
	}

	private boolean containsCycle() {
		
		for (int i = 0; i < V; i++) {
			Set<Integer> set = new HashSet<>();
			if (isCyclicUtil(i, set))
				return true;
			}
		return false;
	}

	private boolean isCyclicUtil(int i, Set<Integer> set) {
		if(set.contains(i))
			return true;
		set.add(i);
		
		for(int index : adj.get(i)) {
			if (isCyclicUtil(index, set))
				return true;
		}
		set.remove(i);
		return false;
	}
}

//This code is contributed by Sagar Shah.