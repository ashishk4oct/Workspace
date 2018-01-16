/*package com.geeks.tree;

public class LowestCommanAncestor {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " + tree.findLCA(4, 5).data);
        System.out.println("LCA(4, 6) = " + tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " + tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " + tree.findLCA(2, 4).data);
	}
}
class BinaryTree{
    Node root;
    Node lca;
	public Node findLCA(int i, int j) {
		return findLCA(root,i,j);
	}

	private void findLCA(Node node, int i, int j) {
		int data = node.data;
		if(data == i) {
			if(!find(node,j))
		}else if(data == j){
			if(find(node,i))
		}else {
			
		}
		return null;
	}
}
class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}
*/