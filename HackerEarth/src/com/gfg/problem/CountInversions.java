package com.gfg.problem;

import com.util.RandomUtil;
import com.util.Printer;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CountInversions {
    // Driver code
    public static void main(String[] args) {

        int arr[] = RandomUtil.generateRandom(8, -10, 10, false);
        Printer.print(arr);
        int n = arr.length;
        System.out.print("Number of inversions are : " + getInvCount(arr, n));

    }


    // Returns sum of arr[0..index].
// This function assumes that the
// array is preprocessed and partial

// sums of array elements are stored
// in BITree[].
    static int getSum(int BITree[],
                      int index) {
// Initialize result
        int sum = 0;

// Traverse ancestors of
// BITree[index]
        while (index > 0) {
            // Add current element of
            // BITree to sum
            sum += BITree[index];

            // Move index to parent node
            // in getSum View
            index -= index & (-index);
        }
        return sum;
    }

    // Updates a node in Binary Index Tree
// (BITree) at given index in BITree.
// The given value 'val' is added to
// BITree[i] and all of its ancestors
// in tree.
    static void updateBIT(int BITree[], int n,
                          int index, int val) {
// Traverse all ancestors
// and add 'val'
        while (index <= n) {
            // Add 'val' to current
            // node of BI Tree
            BITree[index] += val;

            // Update index to that of
            // parent in update View
            index += index & (-index);
        }
    }

    // Converts an array to an array
// with values from 1 to n and
// relative order of smaller and
// greater elements remains same.
// For example, {7, -90, 100, 1}
// is converted to {3, 1, 4 ,2 }
    static void convert(int arr[], int n) {
// Create a copy of arrp[] in temp
// and sort the temp array in
// increasing order
        int[] temp = new int[n];

        for (int i = 0; i < n; i++)
            temp[i] = arr[i];
        Arrays.sort(temp);

// Traverse all array elements
        for (int i = 0; i < n; i++) {
            // lower_bound() Returns pointer
            // to the first element greater
            // than or equal to arr[i]
            int ind = lower_bound(temp, 0, n, arr[i])+1;
            int binaryInd = Arrays.binarySearch(temp,arr[i])+1;
            if(ind != binaryInd)
                System.out.println(binaryInd +" : "+ ind);
            arr[i] = ind;
        }
    }

    static int lower_bound(int[] a, int low,
                           int high, int element) {
        while (low < high) {
            int middle = low +
                    (high - low) / 2;
            if (element > a[middle])
                low = middle + 1;
            else
                high = middle;
        }
        return low;
    }

    // Returns inversion count
// arr[0..n-1]
    static int getInvCount(int arr[],
                           int n) {
// Initialize result
        int invcount = 0;

// Convert arr[] to an array
// with values from 1 to n and
// relative order of smaller
// and greater elements remains
// same. For example, {7, -90,
// 100, 1} is converted to
// {3, 1, 4 ,2 }
        convert(arr, n);

// Create a BIT with size equal
// to maxElement+1 (Extra one is
// used so that elements can be
// directly be used as index)
        int[] BIT = new int[n + 1];

        for (int i = 1; i <= n; i++)
            BIT[i] = 0;

// Traverse all elements
// from right.
        for (int i = n - 1; i >= 0; i--) {
            // Get count of elements
            // smaller than arr[i]
            invcount += getSum(BIT,
                    arr[i] - 1);

            // Add current element to BIT
            updateBIT(BIT, n, arr[i], 1);
        }

        return invcount;
    }


}

// This code is contributed by Amit Katiyar

