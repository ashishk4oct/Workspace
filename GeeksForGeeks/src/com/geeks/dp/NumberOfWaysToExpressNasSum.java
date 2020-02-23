package com.geeks.dp;

//https://www.geeksforgeeks.org/count-ofdifferent-ways-express-n-sum-1-3-4/
public class NumberOfWaysToExpressNasSum {
    static int countWays(int n)
    {
        int DP[] = new int[n + 1];

        // base cases
        DP[0] = DP[1] = DP[2] = 1;
        DP[3] = 2;

        // iterate for all values from 4 to n
        for (int i = 4; i <= n; i++)
            DP[i] = DP[i - 1] + DP[i - 3]
                    + DP[i - 4];

        return DP[n];
    }

    // driver code
    public static void main(String[] args)
    {
        int n = 6;
        System.out.println(countWays(n));
    }
}
