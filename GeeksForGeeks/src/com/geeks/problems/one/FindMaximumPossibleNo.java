package com.geeks.problems.one;

public class FindMaximumPossibleNo {

	public static void main(String[] args) {
		String str = "219814789";
		int k = 4;
		System.out.println(findMaximumNum(str, k));
	}

	private static char[] findMaximumNum(String numStr, int k) {
		char [] numCharArr = numStr.toCharArray();
		return  findMaximumNum(numCharArr, k);
	}

	private static char[] findMaximumNum(char[] numCharArr, int k) {
		boolean maximize = true;
		for (int i = 0; maximize && i < k ; i++) {
			maximize = maximize(numCharArr, i, numCharArr.length-1);
		}
		return numCharArr;
	}

	private static boolean maximize(char[] numCharArr, int start,int end) {
		if(start >= end)
			return false;
		
		int index = findMaxIndex(numCharArr, start, end);
		return  (index == start) ? maximize(numCharArr, start+1, end): swap(numCharArr, start, index);
		
	}

	private static boolean swap(char[] numCharArr, int start,int index) {
		if(start >= index)
			return false;
		
		if(numCharArr[start] >= numCharArr[index])
			return swap(numCharArr, start+1, index);
			
		char temp = numCharArr[start];
		numCharArr[start] = numCharArr[index];
		numCharArr[index] = temp;
		return true;
	}

	private static int findMaxIndex(char[] numCharArr, int start,int end) {
		int index = end;
		for (int i = end; i >= start; i--) {
			if(numCharArr[index] < numCharArr[i])
				index = i;
		}
		return index;
	}
}
