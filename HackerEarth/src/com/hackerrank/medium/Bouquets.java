package com.hackerrank.medium;

import com.util.RandomUtil;

public class Bouquets {

    public static void main(String[] args) {
        System.out.println(flowerBouquets(2,3, "0001000"));
    }
    public static int flowerBouquets(int p, int q, String s) {

        char arr[] = s.toCharArray();
        int cost[] = new int[arr.length];
        if(arr.length < 2){
            return 0;
        }
        cost[0] = 0;
        if(arr.length == 2){
            if((arr[0] == '1' && arr[1] == '0')){
                cost[1] = q;
            }
        }
        if(arr.length >= 3){
            if(arr[0] == '0' && arr[1] == '0' && arr[2] == '0'){
                cost[2] = max(cost[2], p);
            }
            if((arr[0] == '1' && arr[1] == '0')){
                cost[1] = max(cost[1], q);

            }
            if((arr[1] == '1' && arr[2] == '0')){
                cost[2] = max(cost[2], q);
            }
            cost[1] = max(cost[0], cost[1]);
            cost[2] = max(cost[1],cost[2]);
        }

        for (int i = 3; i < cost.length; i++) {
            cost[i] = cost[i-1];
            if(arr[i-1] == '0' && arr[i-2] == '0' && arr[i] == '0'){
                cost[i] = max(cost[i-3] + p , cost[i]);
            }
            if(arr[i] == '0' && arr[i-1] == '1'){
                cost[i] = max(cost[i-2]+q, cost[i]);
            }
        }
        return cost[cost.length-1];
    }

    private static int max(int i , int j){
        return i>j ? i : j;
    }
}
