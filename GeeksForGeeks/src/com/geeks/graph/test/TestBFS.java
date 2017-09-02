package com.geeks.graph.test;

import java.util.List;

import com.geeks.graph.Node;
import com.geeks.graph.bfs.BFS;

public class TestBFS {

	public static void main(String args[]) {
		test1(CreateGraph.initializeGraph1());
		test1(CreateGraph.initializeGraph());
	}
	
	private static void test1(Node initializeGraph) {
		BFS bfs = new BFS(initializeGraph);
		List<Node> bfsList = bfs.generateBfsArrayList();
		System.out.println("BFS");
		System.out.println(bfsList.toString());		
	}
}
