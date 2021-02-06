package com.hackerrank.medium;

import com.util.RandomUtil;

public class StockMaximize {

    public static void main(String[] args) {
        int arr[] = RandomUtil.generateRandom(10, -10, 10);
        RandomUtil.print(arr);
        System.out.println(stockmax(arr));
    }

    public static long stockmax(int[] prices) {

        if (prices.length == 1) {
            return 0;
        }
        int maxPointer = prices.length - 1;
        long result = 0;
        for (int pointer = prices.length - 2; pointer >= 0; pointer--) {
            if (prices[maxPointer] > prices[pointer]) {
                result += prices[maxPointer] - prices[pointer];
            } else {
                maxPointer = pointer;
            }
        }
        return result;
    }
}