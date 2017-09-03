package com.geeks.graph.test;

import java.util.ArrayList;
import java.util.List;

import com.geeks.graph.Node;
import com.geeks.graph.dfs.DFS;

public class TestDFS {

	public static void main(String[] args) {
		test1(CreateGraph.initializeGraph1());
		test1(CreateGraph.initializeGraph());
	}
	
	private static void test1(Node initializeGraph) {
		DFS dfs = new DFS(initializeGraph);
		List<Node> dfsList = new ArrayList<Node>();
		dfs.generateDfsArrayList(dfsList, dfs.getRoot());
		System.out.println("DFS");
		System.out.println(dfsList.toString());		
	}

}
