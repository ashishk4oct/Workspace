package com.gfg.problem;

import java.util.HashMap;
import java.util.Map;

//https://www.hackerrank.com/challenges/tree-top-view/problem

/*

                     150
                      |
            	|----- -----|
               50           150
                |            
                 -----|      
                      75 
                       |            
                        -----| 
                            90
		                     |            
		                      -----|
								   95

top view : 50 100 150 95

*/
public class TopViewOfTree {

	private static Map<Integer, Node> map = new HashMap<Integer, Node>();

	public static void main(String[] args) {
		Node root = new Node(100, new Node(50, null, new Node(75, null, new Node(90, null, new Node(95, null, null)))),
				new Node(150, null, null));
		topView(root);
	}

	static void topView(Node root) {
		if (null == root)
			return;

		traverse(root, 0, 0);
		printTopView();
	}

	private static void printTopView() {
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).map((i) -> i.getValue().data + " ")
				.forEach(System.out::print);
	}

	private static void traverse(Node node, int depth, int width) {
		if (null == node)
			return;
		node.depth = depth;
		node.width = width;

		addToMap(node);

		traverse(node.left, depth + 1, width - 1);
		traverse(node.right, depth + 1, width + 1);
	}

	private static void addToMap(Node node) {
		if (map.containsKey(node.width)) {
			if (map.get(node.width).depth > node.depth) {
				map.put(node.width, node);
			}
		} else {
			map.put(node.width, node);
		}
	}

	static class Node {
		int data;
		Node left;
		Node right;
		int width;
		int depth;

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
