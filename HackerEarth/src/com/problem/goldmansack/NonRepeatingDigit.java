package com.problem.goldmansack;

public class NonRepeatingDigit {

	public static void main(String[] args) {
		System.out.println(nonRepeatingDigitProductCount(2, 0, 15));
	}
	
	static int nonRepeatingDigitProductCount(int x, int y, int z) {
		int count = 0;
		for(int i = y; i <= z ; i++) {
			int num = x*i;
			if(!contains(i,num)) {
				count++;
			}
		}
		return count;
    }

	private static boolean contains(int i, int num) {
		String str = num+"";
		do {
			if(str.contains(i%10+"")) {
				return true;
			}
			i = i / 10;
		}while(i > 0);
		return false;
	}

}
