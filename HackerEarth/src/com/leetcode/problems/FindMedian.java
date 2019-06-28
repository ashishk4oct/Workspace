package com.leetcode.problems;

public class FindMedian {
    public static void main(String[] args) {

        FindMedian findMedian = new FindMedian();
        int [] num1 = {1,2,5,7,8};
        int [] num2 = {3,9,10};

        System.out.println(findMedian.findMedianSortedArrays(num1, num2));
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;

        int elementIndex = len/2 + 1 ;
        double median = findElementAtIndex(elementIndex, nums1, nums2);


        if(len%2 == 0){
            elementIndex--;
            median +=  findElementAtIndex(elementIndex, nums1, nums2);
            median = median/2.0;

        }

        return median;
    }

    private double findElementAtIndex(int elementIndex, int[] nums1, int[] nums2) {
        int i = 0 , j = 0, index = 1;

        while(i < nums1.length && j < nums2.length){
            if(index == elementIndex){
                return nums1[i] < nums2[j] ? nums1[i] : nums2[j];
            }

            if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
            index++;
        }

        while(i < nums1.length) {
            if(index == elementIndex){
                return nums1[i];
            }
            i++;
            index++;
        }

        while(j < nums2.length) {
            if(index == elementIndex){
                return nums2[j];
            }
            j++;
            index++;
        }
        return 0.0;
    }

}