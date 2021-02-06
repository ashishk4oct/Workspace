package com.hackerrank.medium;

import com.util.RandomUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BeautifulQuadruples {

    public static void main(String[] args) {
//        int arr [] = RandomUtil.generateRandom(4,1,3000,false);
        int arr[] = new int[]{1,2,3,4};//6297
        RandomUtil.print(arr);

        int count = beautifulQuadruples(arr[0],arr[1],arr[2],arr[3]);

        System.out.println(count);
    }

    static int beautifulQuadruples(int a, int b, int c, int d) {
        /*
         * Write your code here.
         */
        int arr[] = new int[]{a,b,c,d};
        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(0,1);
        fillMap(map,arr,0,1);
        fillMap(map2,arr,2,3);

        int count = 0;

        for(Integer k :  map.keySet()) {
            Integer v1 = map.get(k);
            Integer v2 = map2.get(k);
            if(v2 == null)
                continue;

            count += v1*v2;
        }
        int all = a*b*c*d;
        return all-count;
    }


    private static void fillMap(Map<Integer, Integer> map, int[] arr, int s, int t ){
        for (int i = 1; i < 12; i++) {
            int start = (int)Math.pow(2,i);
            int end = (int)Math.pow(2,i+1);
            for (int j = start; j < end && j <= arr[s] ; j++) {
                for (int k = j; k < end && k <= arr[t]; k++) {
                    int num = j^k;
                    System.out.println(j+ " "+k);
                    if(map.containsKey(num)){
                        Integer val = map.get(num);
                        map.put(num, val+1);
                    }else{
                        map.put(num,1);
                    }
                }
            }
        }
    }

}

