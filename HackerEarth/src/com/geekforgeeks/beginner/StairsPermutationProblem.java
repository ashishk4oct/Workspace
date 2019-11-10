package com.geekforgeeks.beginner;

import java.sql.Timestamp;
import java.util.TimeZone;

//Count ways to reach the n’th stair
//https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
public class StairsPermutationProblem {
    // A recursive function used by countWays
    static int countWaysUtil(int n, int m)
    {
        int res[] = new int[n];
        res[0] = 1; res[1] = 1;
        for (int i=2; i<n; i++)
        {
            res[i] = 0;
            for (int j=1; j<=m && j<=i; j++)
                res[i] += res[i-j];
        }
        return res[n-1];
    }

    // Returns number of ways to reach s'th stair
    static int countWays(int s, int m)
    {
        return countWaysUtil(s+1, m);
    }

    // Driver method
    public static void main(String[] args)
    {
        int s = (int)Math.pow(10,5), m = 2;
        long start = System.nanoTime();

        System.out.println("Nuber of ways = " + countWays(s, m));
        long end = System.nanoTime();
        System.out.println("time in secs: "+(end-start)/100000000.0);
    }
}
