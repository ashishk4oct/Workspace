package com.gfg.problem;

public class Fibonacci {

	public static void main(String[] args) {
		int n = 9, i = 1 ;
		long j = 1 , k = 1;
		
		
		while(i <= n) {
			if(i == 2 || i == 1) {
				System.out.printf(" 1");
			}else {
				long l = j+k;
				j = k;
				k = l;
				System.out.printf(" "+k);
			}
			i++;
		}
	}

}
