package com.test.caffeine;

import java.time.Duration;
import java.time.Instant;

public class TrappingRainWater {
    public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // Process left side
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update left max
                } else {
                    trappedWater += leftMax - height[left]; // Add trapped water
                }
                left++; // Move left pointer
            } else {
                // Process right side
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update right max
                } else {
                    trappedWater += rightMax - height[right]; // Add trapped water
                }
                right--; // Move right pointer
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) throws InterruptedException {

//        System.out.println(String.format("Time taken to build WeightedRoundRobinStrategy: %s", Duration.between(start, end)));


        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped Water: " + trap(height)); // Output: 6

        int[] height1 = {1,2,3,4};
        System.out.println("Trapped Water: " + trap(height1));

        int[] height2 = {6,5,4,3};
        System.out.println("Trapped Water: " + trap(height2));
    }
}

