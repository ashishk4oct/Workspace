package com.ola;

import java.math.BigInteger;

public class CountNumberOfWays {

	public static void main(String[] args) {

		int n = 73;
		System.out.println(countWays(n));
		System.out.println(countWaysBigInt(n).toString());

	}

	public static long countWays(int n) {
		long[] res = new long[n + 1];
		res[0] = 1;
		res[1] = 1;
		res[2] = 2;

		for (int i = 3; i <= n; i++)
			res[i] = res[i - 1] + res[i - 2] + res[i - 3];

		return res[n];
	}
	public static BigInteger countWaysBigInt(int n) {
		BigInteger[] res = new BigInteger[n + 1];
		res[0] = new BigInteger("1");
		res[1] = new BigInteger("1");
		res[2] = new BigInteger("2");

		for (int i = 3; i <= n; i++)
			res[i] = res[i - 1].add(res[i - 2]).add(res[i - 3]);

		return res[n];
	}

}
