package com.gfg.problem;

public class SymmetricTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(3);
		boolean output = tree.isSymmetric(tree.root);
		if (output == true)
			System.out.println("1");
		else
			System.out.println("0");
	}

	static class Node {
		int key;
		Node left, right;

		Node(int item) {
			key = item;
			left = right = null;
		}
	}
	static class BinaryTree{
		Node root;

		public boolean isSymmetric(Node node) {
			return isMirror(node.left,node.right);
		}

		private boolean isMirror(Node left, Node right) {
			if(null == left && null == right)
				return true;
			
			if(left.key == right.key)
				return (isMirror(left.right, right.left) && isMirror(left.left, right.right));
			
			return false;
		}
	}
}
