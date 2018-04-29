package com.hackerrank.chalange1;

import java.util.Stack;

//time complexity O(n2)
public class StackSolution {

	protected static int largestRectangle(int[] h) {

		int max = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < h.length; i++) {
			while(!stack.isEmpty() && h[stack.peek()] > h[i]) {
				int top = stack.pop();
				int val;
				if(stack.isEmpty()) {
					val = h[top]*(i);
				}else {
					val = h[top]*(i-stack.peek()-1);
				}
				max = max > val ? max : val;
			}
			stack.push(i);
		}

		int count = 0;
		for (int i = h.length - 1; i >= 0; i--) {
			if (stack.isEmpty())
				break;

			count++;
			if (h[stack.peek()] == h[i]) {
				int val = h[stack.pop()] * count;
				max = max > val ? max : val;
			}
		}
		return max;
	}

}
