package com.geeks.graph.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.geeks.graph.Node;

public class BFS {
	private Queue<Node> queue;
	
	public BFS(Node root) {
		setQueue(new LinkedList<Node>());
		getQueue().add(root.markVisited());
	}

	protected Queue<Node> getQueue() {
		return queue;
	}

	protected void setQueue(Queue<Node> queue) {
		this.queue = queue;
	}

	public List<Node> generateBfsArrayList() {
		ArrayList<Node> bfsList = new ArrayList<Node>();
		while (!getQueue().isEmpty()) {
			Node node = getQueue().poll();
			bfsList.add(node);
			getQueue().addAll(getNonVisitedSiblings(node));
		}
		return bfsList;
	}

	protected Set<Node> getNonVisitedSiblings(Node node) {
		Set<Node> set = new HashSet<Node>();
		for (Node n : node.getAdjucentNodes()) {
			if(!n.isVisited()) {
				set.add(n.markVisited());
			}
		}
		return set;
	}
}
