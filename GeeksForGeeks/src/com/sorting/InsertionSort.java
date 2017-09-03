package com.sorting;

public class InsertionSort {

	private static int[] sort(int[] arr) {
		for (int j = 1; j < arr.length; j++) {
			int i = j - 1;
			int key = arr[j];
			while (i >= 0 && arr[i] > key) {
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = key;
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 2, 4, 6, 1, 3 };
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");	
		}
		System.out.println();
		arr = sort(arr);
	
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");	
		}
		
	}

}
