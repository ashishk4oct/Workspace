package com.geeks.graph.dfs;

import java.util.List;

import com.geeks.graph.Node;

public class DFS {
	private Node root;

	public DFS(Node node) {
		setRoot(node);
	}
	
	public void generateDfsArrayList(List<Node> list, Node node){
		
		if(node.isVisited()) return;
		
		list.add(node.markVisited());
		for (Node n : node.getAdjucentNodes()) {
			generateDfsArrayList(list, n);
		}
	}
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
}
