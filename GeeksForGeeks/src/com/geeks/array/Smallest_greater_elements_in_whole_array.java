package com.geeks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Smallest_greater_elements_in_whole_array {

	public static void main(String[] args) {
		int ar[] = { 6, 3, 9, 8, 10, 2, 1, 15, 7 };
	    smallestGreater(ar, ar.length);
	  }

	private static void smallestGreater(int[] ar, int length) {

		for (int i = 0; i < ar.length; i++) {
			System.out.printf("%-3d",ar[i]);
		}

		System.out.println();
		
		for (int i = 0; i < ar.length; i++) {
			int nextMax = Integer.MAX_VALUE;
			for (int j = 0; j < ar.length; j++) {
				if(nextMax > ar[j] && ar[j] > ar[i])
					nextMax = ar[j];
			}
			if(nextMax == Integer.MAX_VALUE)
				System.out.printf("%-3c",'_');
			else
				System.out.printf("%-3d",nextMax);
		}
	}

}
