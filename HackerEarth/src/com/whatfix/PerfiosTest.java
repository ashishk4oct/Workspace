package com.whatfix;

import java.util.*;

public class PerfiosTest {

    public static void main(String[] args) {

        String s = answer1(new int[]{2,5,5,2},4);
        System.out.println(s);
        s = answer1(new int[]{2,5,5,1,1,2},6);
        System.out.println(s);


        System.out.println(CountOccurrences("occurrences"));

        System.out.println(mostFrequentStrength(20, new int[]{2,5,1,8,4,2,2,7,9,8}, 1, 10));
        System.out.println(mostFrequentStrength(20, new int[]{2,5,1,8,4,2,2,7,9,8}, 4, 10));
        System.out.println(mostFrequentStrength(20, new int[]{2,5,1,8,4,2,2,7,9,8}, 2, 2));
        System.out.println(mostFrequentStrength(20, new int[]{2,5,1,8,4,2,2,7,9,8}, 1, 3));
        System.out.println(mostFrequentStrength(20, new int[]{2,5,1,8,4,2,2,7,9,8}, 25, 69));
    }
    static int mostFrequentStrength(int K, int[] troops, long L, long R){
        int arrLen = troops.length*K;
        int l = (int)L;
        int r = (int)R;
        int start = (l-1)%troops.length;
        int times = (r-l+1)/troops.length;

        int diff = (r-l+1)%troops.length - (troops.length*times) ;
        int i = start;
        int len = troops.length;


        Map<Integer,Integer> map = new HashMap<>();
        for (int troop : troops) {
            Integer count = map.get(troop);
            if(count != null){
                map.put(troop, count+times);
            }else{
                map.put(troop, times);
            }
        }
        while(diff > 0) {
            int index = i%len;
            Integer count = map.get(troops[index]);
            if(count != null){
                count++;
                map.put(troops[index], count);
            }else{
                map.put(troops[index], 1);
            }
            diff--;
            i++;
        }

        return maxOcc(map);
    }

    private static int maxOcc(Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<>();
        Integer maxFrequency = 0;
        for (Integer key : map.keySet()) {
            Integer frequency = map.get(key);
            if(frequency > maxFrequency){
                maxFrequency = frequency;
                list = new ArrayList<>();
                list.add(key);
            }else if(frequency == maxFrequency){
                list.add(key);
            }
        }

        Integer max = list.get(0);

        for (Integer k : list) {
            max = max > k ? max : k;
        }
        return max;
    }

    static String CountOccurrences(String S){

        int arr [] = new int[27];
        String s = "";
        for (char c : S.toCharArray()) {
            int i = c - 'a';
            if(arr[i] == 0){
                s += c;
            }
            arr[i]++;
        }

        String result = "";

        for (char c : s.toCharArray()) {
            int i = c - 'a';
            result += c+""+arr[i];
        }
        return result;
    }

    static String answer1(int[] arr, int N){
        // Write your code here

        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i< arr.length ; i++){
            Integer elem = arr[i];

            if(set.contains(elem)){
                set.remove(elem);
            }else{
                set.add(elem);
            }
        }

        if(set.isEmpty()){
            return "Yes";
        }else{
            return "No";
        }

    }

}
