package com.gfg.problem;

public class LargestSumContiguousSubarray {

	static int maxSubArraySum(int a[], int size) {
		int max_so_far = a[0];
		int curr_max = a[0];

		for (int i = 1; i < size; i++) {
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
			System.out.printf("\n curr_max: %-2d max_so_far %-2d ",curr_max,max_so_far);
		}
		return max_so_far;
	}

	/* Driver program to test maxSubArraySum */
	public static void main(String[] args) {
		int a[] = { -2, -3, -4, -1, -2, -1, -5, -3 };
		int n = a.length;
		int max_sum = maxSubArraySum(a, n);
		System.out.println("Maximum contiguous sum is " + max_sum);
	}
}
