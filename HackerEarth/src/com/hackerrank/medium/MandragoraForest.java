package com.hackerrank.medium;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class MandragoraForest {

    public static void main(String[] args) {
        System.out.println(mandragora(new int[]{5, 2, 6, 11, 29, 12, 7}));
    }

    static long mandragora(int[] H) {
        if (H.length == 1) {
            return H[0];
        }
        Arrays.sort(H);
        long num = 0;
        long max = num;
        long sum = num;
        long val ;
        for (int i = H.length-1 ; i >= 0 ; i--) {
            sum += H[i];
            val = sum*(i+1);
            max = val > max ? val : max;
        }
        return max;
    }

}
