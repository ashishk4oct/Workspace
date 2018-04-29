package com.java.pack1;

import java.util.Arrays;
import java.util.Random;

public class RandomNo {

	public static void main(String[] args) {

		RandomNo randomNo = new RandomNo();
		int arr[] = randomNo.genrate(1, 10000, 100000000);

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = max < arr[i] ? arr[i] : max;
			min = min > arr[i] ? arr[i] : min;
			// System.out.println(i+". "+arr[i]);
		}
		System.out.println("min :" + min);
		System.out.println("max :" + max);

		long startTime = System.nanoTime();
//		----------------------------------------------------------------
		while(true)
			Arrays.sort(arr);

//		----------------------------------------------------------------
		/*
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("time : "+(double)totalTime / 1000000000.0);
		*/

		/*int num = -1;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(num != arr[i]) {
				System.out.println(count + ". " + num);
				num = arr[i];
				count = 0;
			}
			count++;
//			System.out.println(i + ". " + arr[i]);
		}*/

	}

	private int[] genrate(int low, int heigh, int len) {
		int[] randomArr = new int[len];
		Random r = new Random();
		for (int i = 0; i < randomArr.length; i++) {
			randomArr[i] = r.nextInt(heigh - low + 1) + low;
		}
		return randomArr;
	}

}
