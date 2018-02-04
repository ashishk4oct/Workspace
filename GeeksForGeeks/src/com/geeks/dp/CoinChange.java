package com.geeks.dp;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		int amount = 2048;
		int coins[] = new int[]{2,3,5,6};
		System.out.println("Possible changes: "+findNoOfPossibleChange(0,amount,coins));
//		int n = countWays(coins, coins.length, amount);
//		System.out.println("Possible changes: "+n);
	}

	static int countWays(int S[], int m, int n)
    {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)
 
        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        int[] table = new int[n+1];
 
        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)
 
        // Base case (If given value is 0)
        table[0] = 1;
 
        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];
 
        return table[n];
    }
	private static int findNoOfPossibleChange(int lastCoin,int amount, int[] coins) {
		if(amount == 0) {
			return 1;
		}else if(amount < 0){
			return 0;
		}
		int count = 0;
		for (int i = 0; i < coins.length; i++) {
			int coin = coins[i];
			if(lastCoin <= coin) {
				count += findNoOfPossibleChange(coin, amount-coin, coins);
			}
		}
		return count;
	}

}
