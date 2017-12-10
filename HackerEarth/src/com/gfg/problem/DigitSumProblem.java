package com.gfg.problem;

import java.util.ArrayList;

/*
	problem link 
	http://www.geeksforgeeks.org/count-different-numbers-can-generated-digits-sum-equal-n/

*/public class DigitSumProblem {

	public static void main(String[] args) {
		System.out.println("Possible no : "+countPossibleNos(4));
	}

	private static int countPossibleNos(int sumNumber) {

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for (int i = 1 ; i <= 3 ; i++) {
			findPossibleNo(sumNumber,i,numbers);
		}
		
		return giveFinalCount(numbers);
	}

	private static int giveFinalCount(ArrayList<Integer> numbers) {
		int finalCount = 0 ;
		for (Integer integer : numbers) {
			finalCount += findOneCount(integer);
		}
		return finalCount;
	}

	private static int findOneCount(Integer num) {
		int count = 0;
		while (num > 0) {
			if(num % 10 == 1) {
				count++;
			}
			num = num/10;
		}
		return (int) Math.pow(2,count);
	}

	private static void findPossibleNo(int sumNumber,int num,ArrayList<Integer> numbers) {
		
		if(sum(num) < sumNumber) {
			for (int i = 1 ; i <= 3 ; i++) {
				findPossibleNo(sumNumber,Integer.parseInt(num+""+i),numbers);
			}
		}else if(sum(num) == sumNumber) {
			System.out.println("numder added : "+num);
			numbers.add(num);	
		}
	}

	private static int sum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num = num/10;
		}
		return sum;
	}
}
