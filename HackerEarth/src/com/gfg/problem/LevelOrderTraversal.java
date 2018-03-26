package com.gfg.problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {

	//1 2 5 3 6 4
	
	Queue<Node> q = new LinkedList<Node>();
	
	public static void main(String[] args) {
		
	}
	
	void levelOrderTree(Node root) {
		if(root == null)
			return ;
		q.add(root);
		levelOrderTraverse(q.poll());
    }
	private void levelOrderTraverse(Node node) {
		if(node == null)
			return ;
		System.out.print(node.data +" ");
		q.add(node.left);
		q.add(node.right);
		
		levelOrderTraverse(q.poll());
	
	}
}

class Node {
	int data;
	Node left;
	Node right;
}
