package com.interview.test1;

import java.math.BigInteger;

public class DealerSocket {

    public static void main(String[] args) {

        DealerSocket ds = new DealerSocket();
        System.out.println(ds.solution1("bbbbc"));

        int count = ds.solution(new int[]{4,-1,0,3}, new int[]{-2,5,0,3});
        System.out.println(count);
    }

    public int solution(int[] A, int[] B) {

        BigInteger suma1 = new BigInteger("0");
        BigInteger sumb1 = new BigInteger("0");
        for (int i = 0; i < A.length ; i++) {
            suma1 = suma1.add(new BigInteger(A[i]+""));
            sumb1 = sumb1.add(new BigInteger(B[i]+""));
        }

        if(suma1.compareTo(sumb1) != 0){
            return 0;
        }

        BigInteger suma0 = new BigInteger("0");
        BigInteger sumb0 = new BigInteger("0");
        int count = 0;
        for (int i = 0; i < A.length-1 ; i++) {
            suma0 = suma0.add(new BigInteger(A[i]+""));
            sumb0 = sumb0.add(new BigInteger(B[i]+""));

            suma1 = suma1.subtract(new BigInteger(A[i]+""));
            sumb1 = sumb1.subtract(new BigInteger(B[i]+""));

            if(suma0.compareTo(suma1) == 0 && suma0.compareTo(sumb0) == 0 &&  suma0.compareTo(sumb1) == 0){
                count++;
            }
        }
        return count;
    }

    public String solution1(String S) {
        // write your code in Java SE 8

        for (int i = 1; i < S.length(); i++) {
            char a = S.charAt(i-1);
            char b = S.charAt(i);

            if(a > b){
                return S.substring(0,i-1)+S.substring(i);
            }
        }
        return S.substring(0, S.length()-1);
    }
}
