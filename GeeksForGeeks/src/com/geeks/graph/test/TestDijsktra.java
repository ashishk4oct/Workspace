package com.geeks.graph.test;

import java.util.HashMap;

import com.geeks.graph.Node;
import com.geeks.graph.shortestpathalgo.DijsktraAlgo;

public class TestDijsktra {

	public static void main(String[] args) {

		DijsktraAlgo dijsktraAlgo = new DijsktraAlgo(CreateGraph.initializeGraphWithWeight());
		HashMap<Node, Integer> distanceFromRoot = dijsktraAlgo.findShortestPathToAllNodes();
		
	}

}
