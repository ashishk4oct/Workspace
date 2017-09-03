package com.geeks.graph.test;

import com.geeks.graph.Node;
//
public class CreateGraph {
	
	public static Node initializeGraphWithWeight() {
		Node node0 = new Node(0),node1 = new Node(1), node2 = new Node(2), 
				node3 = new Node(3),node4 = new Node(4), node5 = new Node(5);
			
		node0.addAdjucentNodes(node1,node5);
		node1.addAdjucentNodes(node0,node2,node5);
		node2.addAdjucentNodes(node3,node4,node5,node1);
		node3.addAdjucentNodes(node2,node4);
		node4.addAdjucentNodes(node2,node3,node5);
		node5.addAdjucentNodes(node0,node1,node2,node4);
		
		node0.setWeight(node1,8);
		node0.setWeight(node5,4);
		
		node1.setWeight(node0,8);
		node1.setWeight(node2,3);
		node1.setWeight(node5,4);

		node2.setWeight(node3,5);
		node2.setWeight(node4,7);
		node2.setWeight(node1,3);
		node2.setWeight(node5,3);
		
		node3.setWeight(node2,5);
		node3.setWeight(node4,6);
		
		node4.setWeight(node2,7);
		node4.setWeight(node3,6);
		node4.setWeight(node5,5);
		
		node5.setWeight(node0,4);
		node5.setWeight(node1,4);
		node5.setWeight(node2,3);
		node5.setWeight(node4,5);
		
		return node0;
	}
	
	public static Node initializeGraph() {
		Node node1 = new Node(1), node2 = new Node(2), node3 = new Node(3),
			 node4 = new Node(4), node5 = new Node(5), node6 = new Node(6);
		
		node1.addAdjucentNodes(node2,node3);
		node2.addAdjucentNodes(node1,node4,node5);
		node3.addAdjucentNodes(node1,node5);
		node4.addAdjucentNodes(node2,node5,node6);
		node5.addAdjucentNodes(node2,node3,node4,node6);
		node6.addAdjucentNodes(node4,node5);

		return node1;
	}
	public static Node initializeGraph1() {
		Node node0 = new Node(0), node1 = new Node(1), node2 = new Node(2), node3 = new Node(3);
			
			node0.addAdjucentNodes(node1,node2);
			node1.addAdjucentNodes(node2);
			node2.addAdjucentNodes(node0,node3);
			node3.addAdjucentNodes(node3);

			return node2;		
	}
}
