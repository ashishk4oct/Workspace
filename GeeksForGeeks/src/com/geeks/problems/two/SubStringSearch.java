package com.geeks.problems.two;

public class SubStringSearch {

	public static void main(String[] args) {

		String str = "ggccgccxcnuccgccxjfdccgccx";
		String pattern = "ccgccx";

		findSubString(str, pattern);
		System.out.println();
		KMPSearch(str, pattern);
	}

	private static void findSubString(String str, String pattern) {
		char strArr[] = str.toCharArray();
		char patternArr[] = pattern.toCharArray();

		for (int i = 0; i <= strArr.length - patternArr.length; i++) {
			int j = i;
			while (j - i < patternArr.length && strArr[j] == patternArr[j - i]) {
				j++;
			}
			if (j - i == patternArr.length) {
				System.out.printf("%3d", i);
			}
		}
	}

	private static void KMPSearch(String str, String pat) {
		// create lps[] that will hold the longest prefix suffix values for pattern
		int lps[] = new int[pat.length()];
		int j = 0; // index for pat[]

		computeLPSArray(pat, lps);

		int i = 0;
		while (i < str.length()) {
			if (pat.charAt(j) == str.charAt(i)) {
				j++;
				i++;
			}
			if (j == pat.length()) {
				System.out.println("Found pattern " + "at index " + (i - j));
				j = lps[j - 1];
			}

			// mismatch after j matches
			else if (i < str.length() && pat.charAt(j) != str.charAt(i)) {
				// Do not match lps[0..lps[j-1]] characters,
				// they will match anyway
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
	}

	private static void computeLPSArray(String pat, int lps[]) {
		// length of the previous longest prefix suffix
		int index = 0;
		int i = 1;
		lps[0] = 0; // lps[0] is always 0

		// the loop calculates lps[i] for i = 1 to M-1
		while (i < pat.length()) {
			if (pat.charAt(i) == pat.charAt(index)) {
				index++;
				lps[i] = index;
				i++;
			} else { // (pat[i] != pat[len])
				// This is tricky. Consider the example.
				// AAACAAAA and i = 7. The idea is similar to search step.
				if (index != 0) {
					index = lps[index - 1];
					// Also, note that we do not increment
					// i here
				} else // if (len == 0)
				{
					lps[i] = index;
					i++;
				}
			}
		}
	}
}
