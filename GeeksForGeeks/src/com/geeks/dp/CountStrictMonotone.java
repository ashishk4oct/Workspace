package com.geeks.dp;
/*
	https://www.geeksforgeeks.org/number-decimal-numbers-length-k-strict-monotone/
	
	Write a program which takes positive number n on input and returns number of decimal numbers of length n that are strict monotone. Number can’t start with 0.
*/
public class CountStrictMonotone {

	public static void main(String[] args) {
		int count = getCountOfNDigitStrictMonotone(5);
		System.out.println(count);
	}

	private static int getCountOfNDigitStrictMonotone(int n) {
		int countArray[][] = new int[n][9];
		
		for (int i = 0; i < 9 ; i++) {
			countArray[0][i] = 1;
		}
		for (int i = 1 ; i < countArray.length; i++) {
			for (int j = 8-i ; j >= 0 ; j--) {
				countArray[i][j] = countArray[i-1][j+1] + countArray[i][j+1];
			}
		}
		
		/*for (int i = 0; i < countArray.length; i++) {
			for (int j = 0; j < 9 ; j++) {
				System.out.print(String.format("%-5s", countArray[i][j]));
				System.out.print(" ");
			}
			System.out.println();
		}*/

		int sum = 0 ;
		for (int i = 0; i < countArray[n-1].length; i++) {
			sum += countArray[n-1][i];
		}
		return sum;
	}
}
