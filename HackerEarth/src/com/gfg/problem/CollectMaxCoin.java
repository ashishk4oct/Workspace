package com.gfg.problem;

public class CollectMaxCoin {
	public static void main(String [] args) {
		
		char arr[][] = { {'E', 'C', 'C', 'C', 'C'},
						{'C', '#', 'C', '#', 'E'},
						{'#', 'C', 'C', '#', 'C'},
						{'C', 'E', 'E', 'C', 'E'},
						{'C', 'E', '#', 'C', 'E'}
              		  };
		printMaxCoinsCollected(arr);
	}

	private static void printMaxCoinsCollected(char[][] mtx) {
		
		int [][][] sumMtx = new int [mtx.length] [mtx[0].length][2];
		for (int i = 0; i < sumMtx.length; i++) {
			for (int j = 0; j < sumMtx[i].length; j++) {
				for (int j2 = 0; j2 < sumMtx[i][j].length; j2++) {
					sumMtx[i][j][j2] = -1;
				}
			}
		}
		
		System.out.println(maxCoinsUtil(mtx, 0, 0, 1, sumMtx)); ;
	}

	// dir = 0 for left, dir = 1 for right.  This function returns
	// number of maximum coins that can be collected starting from
	// (i, j).
	private static int maxCoinsUtil(char[][] arr, int i, int j, int dir, int[][][] dp) {
		// If this is a invalid cell or if cell is a blocking cell
	    if (!isValid(i,j) || arr[i][j] == '#')
	        return 0;
	 
	    // If this subproblem is already solved than return the
	    // already evaluated answer.
	    if (dp[i][j][dir] != -1)
	       return dp[i][j][dir];
		
	    // Check if this cell contains the coin 'C' or if its 'E'.
	    dp[i][j][dir] = (arr[i][j] == 'C')? 1: 0;
	    
	    // Get the maximum of two cases when you are facing right
	    // in this cell
	    if (dir == 1) // Direction is right
	       dp[i][j][dir] += max(maxCoinsUtil(arr, i+1, j, 0, dp), // Down
	                            maxCoinsUtil(arr, i, j+1, 1, dp)); // Ahead in right
	 
	    // Get the maximum of two cases when you are facing left
	    // in this cell
	    if (dir == 0) // Direction is left
	       dp[i][j][dir] += max(maxCoinsUtil(arr, i+1, j, 1, dp),  // Down
	                            maxCoinsUtil(arr, i, j-1, 0, dp)); // Ahead in left
	 
	    // return the answer
	    return dp[i][j][dir];
	}

	private static boolean isValid(int i, int j) {
		return (i >=0 && i < 5 && j >=0 && j < 5);
	}

	private static int max(int i, int j) {
		return i > j ? i : j;
	}
}
