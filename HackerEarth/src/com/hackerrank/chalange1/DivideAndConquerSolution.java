package com.hackerrank.chalange1;

// time complexity O(n log(n)) average case
//				   O(n2) worst case if already sorted array
public class DivideAndConquerSolution {

	protected static long largestRectangle(int[] h) {
		return largestRectangle(h, 0, h.length - 1);
	}

	private static int find(int[] h, int i, int length) {
		int min = i;
		while (i++ < length) {
			min = h[min] > h[i] ? i : min;
		}
		return min;
	}

	private static int largestRectangle(int[] h, int l, int r) {
		if (l > r)
			return Integer.MIN_VALUE;
		if (l == r)
			return h[l];

		int mid = find(h, l, r);
		return max(largestRectangle(h, l, mid - 1), largestRectangle(h, mid + 1, r), h[mid] * (r - l + 1));
	}

	private static int max(int i, int j, int k) {
		int temp = (i > j ? i : j);
		return k > temp ? k : temp;
	}
}
