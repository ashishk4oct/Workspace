package com.hackerrank.medium;

import java.util.Arrays;

public class TravelAroundTheWorld {

    public static void main(String[] args) {
        int [] a = new int[]{3, 1, 2};
        int [] b = new int[]{2, 2, 2};
        long c = 2;

        System.out.println(travelAroundTheWorld(a,b,c));
    }

    /*
     * Complete the travelAroundTheWorld function below.
     */
    static int travelAroundTheWorld(int[] a, int[] b, long c) {

        long req [] = new long[a.length];
        Arrays.fill(req,0);
        for (int i = a.length-1 ; i >= 0; i--) {
            if(b[i] > a[i]){
                req[i] = b[i]-a[i];
            }
        }
        for (int i = a.length-2 ; i >= 0; i--) {
            if(b[i]+req[i+1]-a[i] > 0){
                req[i] = b[i]+req[i+1]-a[i];
            }
        }

        if(b[a.length-1]+req[0]-a[a.length-1] > 0){
            req[a.length-1] = b[a.length-1]+req[0]-a[a.length-1];
        }


        for (int i = a.length-2 ; i >= 0; i--) {
            if(b[i]+req[i+1]-a[i] > 0){
                req[i] = b[i]+req[i+1]-a[i];
            }else{
                break;
            }
        }

        int count = 0;
        for (int i = 0; i < a.length ; i++) {
            if(req[i] == 0)
                count++;
            if(req[i]+a[i] > c){
                return 0;
            }
        }
        return count;
    }
}
