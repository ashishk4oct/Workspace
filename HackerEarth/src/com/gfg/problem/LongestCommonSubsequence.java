package com.gfg.problem;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// String s1 = "ABCDGH" , s2 = "AEDFHR";
		// String s1 = "AGGTABX" , s2 = "GXTXAYB";
		String s1 = "abcdefghi" , s2 = "aeghibdf";
		
		LCS lcs = new LCS();
		System.out.println(lcs.findLCS(s1, s2));
		System.out.println(lcs.findLCSDP(s1, s2));

	}
}

class LCS {

	public int findLCSDP(String s1, String s2) {
		return findLCSDP(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
	}

	public int findLCSDP(char[] X, char[] Y, int m, int n) {
		int L[][] = new int[m + 1][n + 1];

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that
		 * L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];
	}

	public int findLCS(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0)
			return 0;

		return findLCS(s1, 0, s2, 0);
	}

	// Time complexity of the above naive recursive approach is O(2^n) in worst
	// case and
	// worst case happens when all characters of X and Y mismatch i.e., length
	// of LCS is 0
	public int findLCS(String s1, int l1, String s2, int l2) {
		if (s1.length() == l1 || s2.length() == l2)
			return 0;
		if (s1.charAt(l1) == s2.charAt(l2))
			return 1 + findLCS(s1, l1 + 1, s2, l2 + 1);

		return Math.max(findLCS(s1, l1 + 1, s2, l2), findLCS(s1, l1, s2, l2 + 1));
	}

}
