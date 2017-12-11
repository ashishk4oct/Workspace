package com.medium.stack;

import java.util.Scanner;
import java.util.Stack;

public class SignalRange {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int noOftestCase = scn.nextInt();
		while (noOftestCase-- > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			System.out.println();
			int[] ans = new int[n];
			Stack<Integer> st = new Stack<Integer>();
			st.push(0);
			ans[0] = 1;
			for (int i = 1; i < n; i++) {
				
				while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
					st.pop();
				}
				ans[i] = st.isEmpty() ? i + 1 : i - st.peek();
				st.push(i);

			}
			for (int val : ans) {
				System.out.print(val + " ");
			}
		}
	}
}