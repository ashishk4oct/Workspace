package com.tree.problem1;


public class DistanceBetweenTwoKey {

	private static int distance(Node n1, int i, int j) {

		int [] path1 = getPath(n1,i,0);
		int [] path2 = getPath(n1,j,0);
		
		if(path1 == null || path2 == null) {
			return -1;
		}
		
		int longer = path1.length > path2.length ? path1.length : path2.length;
		int smaller = path1.length < path2.length ? path1.length : path2.length;
		int k = 0;
		while(k < smaller) {
			if(path1[k] != path2[k])
				break;
			k++;
		}
		System.out.println("Lowest Common Ansister :"+path1[k-1]);
		return (smaller + longer - 2*k);
	}

	private static int[] getPath(Node n, int i,int size) {
		if(null == n)
			return null;
		
		if(n.data == i) {
			int arr [] = new int[size+1];
			arr[size] = i;
			return arr;
		}else {
			int left [] = getPath(n.left, i, size+1);
			if(left != null) {
				left[size] = n.data;
				return left;
			}
			int right [] = getPath(n.right, i, size+1);
			if(right != null) {
				right[size] = n.data;
				return right ;
			}
		}
		return null;
	}

	public static void main(String[] args) {

		Node n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11;

		n11 = new Node(10);
		n10 = new Node(15);
		n9 = new Node(16);
		n8 = new Node(17, n10, n11);
		n7 = new Node(21);
		n6 = new Node(51);
		n5 = new Node(31, n8, n9);
		n4 = new Node(61);
		n3 = new Node(11, n6, n7);
		n2 = new Node(22, n4, n5);
		n1 = new Node(18, n2, n3);
	
		int i, j;
		i = n6.data;
		j = n7.data;
		System.out.printf("\nDistance between %2d, %2d = %2d ", i, j, distance(n1,i,j));
	}
	
	private static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public Node(int data) {
			this.data = data;
		}
	}
}
