package com.geeks.dp.palindrome;

public class PalindromeMinInsertion {

	public static void main(String[] args) {

		String str = "geeksashishkumarsinghashutoshkumarlapx";
		
		long start = System.currentTimeMillis();
	      
        // start of function
 
		System.out.println(findMinInsertions(str.toCharArray(), 0, str.length() - 1));
		
        // end of function
 
        // ending time
        long end = System.currentTimeMillis();
        System.out.println("Counting to 10000000 takes " +
                                    (end - start) + "ms");
		
        
        start = System.currentTimeMillis();
	      
        // start of function

		System.out.println(findMinInsertionsDP(str.toCharArray(), 0, str.length() - 1));
		
        // end of function
 
        // ending time
        end = System.currentTimeMillis();
        System.out.println("Counting to 10000000 takes " +
                                    (end - start) + "ms");
        
	}

	static int findMinInsertions(char str[], int l, int h) {
		// Base Cases
		if (l > h)
			return Integer.MAX_VALUE;
		if (l == h)
			return 0;
		if (l == h - 1)
			return (str[l] == str[h]) ? 0 : 1;

		// Check if the first and last characters
		// are same. On the basis of the comparison
		// result, decide which subrpoblem(s) to call
		return (str[l] == str[h]) ? findMinInsertions(str, l + 1, h - 1)
				: (Integer.min(findMinInsertions(str, l, h - 1), findMinInsertions(str, l + 1, h)) + 1);
	}

	static int findMinInsertionsDP(char str[], int l, int h) {
		int[][] metrix = new int[str.length][str.length];

		for (int i = 0; i < metrix.length; i++) {
			for (int j = 0; j < metrix.length; j++) {
				metrix[i][j] = -1;
			}
		}
		return findMinInsertionsDP(str, l, h, metrix);

	}

	static int findMinInsertionsDP(char str[], int l, int h, int[][] metrix) {
		// Base Cases
		if (l > h)
			return Integer.MAX_VALUE;
		if (l == h)
			return 0;
		if (l == h - 1)
			return (str[l] == str[h]) ? 0 : 1;

		// Check if the first and last characters
		// are same. On the basis of the comparison
		// result, decide which subrpoblem(s) to call
		int minInsertion;
		if(-1 != metrix[l][h]) {
			return metrix[l][h];
		} else if (str[l] == str[h]) {
			minInsertion = findMinInsertions(str, l + 1, h - 1);
		} else {
			minInsertion = (Integer.min(findMinInsertions(str, l, h - 1), findMinInsertions(str, l + 1, h)) + 1);
		}
		metrix[l][h] = minInsertion;
		return minInsertion;
	}
}
