package com.leetcode.problems;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        t.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        int s = 0, e = height.length - 1, p;
        int sum = 0;
        while (s < e && s != e) {
            if (height[s] <= height[e]) {
                p = s + 1;
                while (p < e && (height[s] >= height[p])) {
                    sum += height[s] - height[p];
                    p++;
                }
                s = p;

            } else {
                p = e - 1;
                while (p > s && (height[e] >= height[p])) {
                    sum += height[e] - height[p];
                    p--;
                }
                e = p;
            }
        }
        return sum;
    }
}
