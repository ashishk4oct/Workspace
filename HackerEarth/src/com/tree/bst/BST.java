package com.tree.bst;


public class BST {

	public static void main(String[] args) {
		Node root = insertNode(null, 10);
		
		insertNode(root, 20);
		insertNode(root, 50);
		insertNode(root, 5);
		insertNode(root, 15);
		insertNode(root, 4);
		insertNode(root, 7);
		insertNode(root, 8);

		traverseTree(root);

		root = deleteNode(root, 10);
		traverseTree(root);
		root = deleteNode(root, 50);
		traverseTree(root);

		root = deleteNode(root, 5);
		traverseTree(root);
		root = deleteNode(root, 7);
		traverseTree(root);
		root = deleteNode(root, 8);
		traverseTree(root);		
		root = deleteNode(root, 4);
		traverseTree(root);
		root = deleteNode(root, 20);
		traverseTree(root);
		root = deleteNode(root, 15);
		traverseTree(root);
	}
	

	private static Node deleteNode(Node node, int data) {
		if(null == node)
			return node;
		if(node.data == data) {
			node = delete(node);
		}else if(node.data < data) {
			node.right = deleteNode(node.right, data);
		}else {
			node.left = deleteNode(node.left, data);
		}
		return node;
	}

	private static Node delete(Node node) {

		if(null == node.left)
			return node.right;
		if(null == node.right)
			return node.left;
		
		int data = findSmallestNode(node.right).data;
		deleteNode(node , data);
		
		Node newNode = new Node(data,node.left, node.right);
		return newNode;
	}


	private static Node findSmallestNode(Node node) {
		if(null != node.left)
			return findSmallestNode(node.left);
		return node;
	}


	private static void traverseTree(Node root) {
		System.out.printf("\nPre Order: ");
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
