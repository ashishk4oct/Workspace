package com.ola;

public class Test1 {

	public static void main(String[] args) {

		int i = 35;

		System.out.println(countWays(i));

		System.out.println(findCombination(i));

		System.out.println(findCombination1(i));

	}

	public static int countWays(int n) {
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		res[2] = 2;

		for (int i = 3; i <= n; i++)
			res[i] = res[i - 1] + res[i - 2] + res[i - 3];

		return res[n];
	}

	static int count = 0;

	private static int findCombination1(int n) {
		if (n == 1 || n == 0)
			return 1;
		if (n == 2)
			return 2;

		return findCombination1(n - 1) + findCombination1(n - 2) + findCombination1(n - 3);
	}

	private static int findCombination(int n) {
		findCombination(n, 0);
		return count;
	}

	private static void findCombination(int n, int sum) {
		if (sum == n) {
			count++;
			return;
		}

		if (sum > n)
			return;

		for (int i = 1; i <= 3; i++) {
			findCombination(n, sum + i);
		}
	}

}
