package com.geeks.array;

import java.util.Arrays;

public class Sort_an_array_in_wave_form {

	public static void main(String[] args) {

		int [] arr = {10,1,2,8,4,5,0};
		sortArrayInWaveForm(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		int arr1[] = {10,1,2,8,4,5,0};
		sortArrayInWaveFormGFG(arr1);
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i]+" ");
		}
		
	}

	
	private static void sortArrayInWaveFormGFG(int[] arr) {
		
		for (int i = 0; i < arr.length; i = i+2) {
			if( i > 0 && arr[i-1]>arr[i]) 
				swap(arr,i,i-1);
			if(i<arr.length-1 && arr[i]<arr[i+1])
				swap(arr,i,i+1);
				
		}
	}


	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}


	private static int [] sortArrayInWaveForm(int[] arr){
		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i = i+2) {
			int temp = arr[i-1];
			arr[i-1] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
}
