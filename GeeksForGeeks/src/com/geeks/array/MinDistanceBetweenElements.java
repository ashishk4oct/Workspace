package com.geeks.array;

public class MinDistanceBetweenElements {

    public static void main(String[] args) {

        int[] arr = SampleArray.getArray();

        System.out.println("Min Distance :" + findMinDistanceBetween(701, 840, arr));

    }

    private static int findMinDistanceBetween(int num1, int num2, int[] arr) {

        int index1 = -1, index2 = -1, dist = Integer.MAX_VALUE;

        System.out.println(arr.length);
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == num1)
                index1 = index;
            if (arr[index] == num2)
                index2 = index;

            if (index1 >= 0 && index2 >= 0) {
                int tempDist = diff(index1, index2);
                dist = tempDist < dist ? tempDist : dist;
            }
        }
        System.out.println("index 1 "+index1);
        System.out.println("index 2 "+index2);

        return dist == Integer.MAX_VALUE ? -1 : dist;
    }

    private static int diff(int index1, int index2) {
        return index1 >= index2 ? index1 - index2 : index2 - index1;
    }


}
