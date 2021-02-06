package com.hackerrank.medium;

public class WetSharkandTwoSubsequences {

    public static void main(String[] args) {

//        for (int sum = 0; sum <= 2000 ; sum++) {
//            for (int diff = 0; diff <= 2000 ; diff++) {
//                printPossibleNumbers(sum, diff);
//            }
//        }

        int x[] = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,185,320,482,325,134,212,305,407,159,457,158,385,146,129,317,190,283,230,485,493,1159,1092,1194,1113,1028,1073,1028,1007,1060,1034,1189,1043,1187,1005,1150,1105,1162,1114,1085,1185,1058,1176,1004,1160,1037,1183,1097,1045,1016,1094,1934,1875,1902,1902,1861,1985,1863,1968,1921,1969};
        int result = twoSubsequences(x, 500,0);
        System.out.println(result);
    }

    static final long mod = 1000000007;
    static int twoSubsequences(int[] x, int sum, int diff) {

        int arr[] = new int[2001];
        for (int i = 0; i < x.length; i++) {
            arr[x[i]]++;
        }
        int nums [] = possibleNumbers(sum, diff, x, arr);

        if(null == nums){
            return 0;
        }

        return count(arr[nums[0]], arr[nums[1]]);
    }

    private static int count(int i, int j) {
        long count = 0 ;
        int min = i < j ? i : j;
        for (int k = 1; k <= min; k++) {
            long c = combination(i,k);
            c = (combination(j,k)%mod * c%mod)%mod;
            count = ((count%mod)+(c%mod))%mod;
        }
        return (int)count;
    }

    private static long combination(int n, int r) {
        int max, min;
        if(n-r > r){
            max = n-r;
            min = r;
        }else{
            max = r;
            min = n-r;
        }

        long result = 1;
        for (int i = n; i > max; i--) {
            result = ((i%mod) * (result%mod))%mod;
        }
        for (int i = min; i > 1 ; i--) {
            result = ((result%mod)/(i%mod))%mod;
        }
        return result;
    }

    private static int[] possibleNumbers(int sum, int diff, int [] x, int [] arr) {
        for (int i = 0; i < x.length ; i++) {
            int j = sum - x[i] ;
            if(j <= 0 || arr[j] == 0)
                continue;
            if(x[i] - j == diff){
                return new int[]{x[i], j};
            }
        }
        return null;
    }

    private static void printPossibleNumbers(int sum, int diff) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 2000 && i < sum ; i++) {
            int j = sum - i ;
            if(j < 0)
                continue;
            if(i-j == diff){
                if(count == 0){
                    count++;
                    System.out.println();
                    System.out.println("sum : "+i+", diff: "+j+"");
                }
                sb.append("["+i+","+j+"],");
            }
        }
        if(count > 0){
            System.out.println(sb);
        }

    }
}
