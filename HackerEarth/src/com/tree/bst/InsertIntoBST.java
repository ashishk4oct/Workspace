package com.tree.bst;


public class InsertIntoBST {

	public static void main(String[] args) {
		Node root = insertNode(null, 10);
		
		insertNode(root, 20);
		insertNode(root, 50);
		insertNode(root, 5);
		insertNode(root, 15);
		insertNode(root, 4);
		insertNode(root, 7);
		insertNode(root, 8);
		
		System.out.printf("Pre Order: ");
		preOrderTraversal(root);
		System.out.printf("\nIn Order: ");
		inOrderTraversal(root);
		System.out.printf("\nPost  Order: ");
		postOrderTraversal(root);
		

	}
	

	private static void preOrderTraversal(Node node) {
		if(null == node) 
			return ;
		System.out.print(node.data + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	private static void inOrderTraversal(Node node) {
		if(null == node) 
			return ;
		inOrderTraversal(node.left);
		System.out.print(node.data + " ");
		inOrderTraversal(node.right);
	}

	private static void postOrderTraversal(Node node) {
		if(null == node) 
			return ;
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.data + " ");
	}


	public static Node insertNode(Node node, int data) {
		if(null == node) {
			return new Node(data, null, null);
		}
		if(node.data > data) {
			node.left = insertNode(node.left, data);
		}else {
			node.right = insertNode(node.right, data);
		}
		return node;
	}

}

class Node{
	int data;
    Node left;
    Node right;
    
	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
