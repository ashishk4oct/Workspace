package com.hackerrank.medium;

import java.util.*;

public class LilysHomework {

    public static void main(String[] args) {

        System.out.println(lilysHomework(new int[]{
                2,3,4,1,6,5
        }));
    }
    static int lilysHomework(int[] arr) {

        Set<Integer> indexSet = getIndexSet(arr.length);
        Integer [] sortedArr = getSortedArr(arr);
        Map<Integer, Integer> valueIndexMap = getValueIndexMap(sortedArr);

        int loopCount = getLoopCount(arr,indexSet,sortedArr,valueIndexMap);

        indexSet = getIndexSet(arr.length);
        Arrays.sort(sortedArr, Collections.reverseOrder());
        valueIndexMap = getValueIndexMap(sortedArr);

        int loopCount1 = getLoopCount(arr,indexSet,sortedArr,valueIndexMap);


        return arr.length - (loopCount > loopCount1 ? loopCount : loopCount1);
    }

    private static int getLoopCount(int[] arr, Set<Integer> indexSet, Integer[] sortedArr, Map<Integer, Integer> valueIndexMap) {
        int lookCount = 0;
        while(!indexSet.isEmpty()){
            Integer index = indexSet.stream().findAny().get();
            loopSetUpdate(index,arr,indexSet,sortedArr,valueIndexMap);
            lookCount++;
        }
        return lookCount;
    }

    private static void loopSetUpdate(Integer initalIndex, int[] arr, Set<Integer> indexSet, Integer[] sortedArr, Map<Integer, Integer> valueIndexMap) {
        Integer index = initalIndex;
        while(true){
            indexSet.remove(index);
            Integer next = valueIndexMap.get(arr[index]);

            if(initalIndex == next){
                break;
            }
            index = next;
        }
    }

    private static Integer[] getSortedArr(int[] arr) {
        Integer[] sortedArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sortedArr[i] = arr[i];
        }
        Arrays.sort(sortedArr);
        return sortedArr;
    }

    private static Map<Integer, Integer> getValueIndexMap(Integer[] arr) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            valueIndexMap.put(arr[i],i);
        }
        return valueIndexMap;
    }

    private static Set<Integer> getIndexSet(int length) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(i);
        }
        return set;
    }

}
