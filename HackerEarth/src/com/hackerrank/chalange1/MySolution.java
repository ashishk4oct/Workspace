package com.hackerrank.chalange1;

//time complexity O(n2)
public class MySolution {
	
	protected static long largestRectangle(int[] h) {
        int max = Integer.MIN_VALUE;
    	for (int i = 0; i < h.length; i++) {
    		int index = i;
    		int count = 1;
			while(index  > 0 && h[i] <= h[--index]) {
				count++;
			}
			index = i;
			while(index  < h.length-1 && h[i] <= h[++index]) {
				count++;
			}
			int max_temp = h[i]*count;
			max = (max > max_temp) ? max : max_temp;
		}
    	return max;
    }
	
}
