package com.hackerrank.medium;

import java.util.HashMap;
import java.util.Map;

public class ZeroOneKnapsack {

    public static void main(String args[]) {
//        int val[] = new int[]{60, 100, 120};
//        int wt[] = new int[]{10, 20, 30};
        int val[] = new int[]{1, 2, 5, 6};
        int wt[] = new int[]{2, 3, 4, 5};
        int W = 10;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
        System.out.println(knapSackSetsMethod(W, wt, val));
    }

    private static int knapSack(int W, int[] wt, int[] val, int n) {

        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                knapSack(W, wt, val, n - 1)
        );
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }


    private static int knapSackSetsMethod(int W, int[] wt, int[] val) {
        Knapsack knapsack = new Knapsack(W);
        for (int i = 0; i < wt.length; i++) {
            knapsack.add(val[i], wt[i]);
        }
        return knapsack.maxValue();
    }
}

class Knapsack {

    private final Integer weight;
    private Map<Integer, Integer> priceWeightMap = new HashMap<>();

    Knapsack(Integer weight) {
        this.weight = weight;
        priceWeightMap.put(0, 0);
    }

    public void add(Integer p, Integer w) {
        Map<Integer, Integer> newPriceWeightMap = new HashMap<>();
        for (Integer price : priceWeightMap.keySet()) {
            Integer weight = priceWeightMap.get(price);
            if (weight + w <= this.weight) {
                newPriceWeightMap.put(price + p, weight + w);
            }
        }


        for (Integer newPrice : newPriceWeightMap.keySet()) {
            Integer newWeight = newPriceWeightMap.get(newPrice);
            if (priceWeightMap.containsKey(newPrice)) {
                Integer weight = priceWeightMap.get(newPrice);
                priceWeightMap.put(newPrice, min(weight, newWeight));
            } else {
                priceWeightMap.put(newPrice, newWeight);
            }
        }
    }

    private static int min(Integer a, Integer b) {
        return (a < b) ? a : b;
    }

    public int maxValue() {
        return this.priceWeightMap.keySet().stream().max(Integer::compareTo).get();
    }
}



