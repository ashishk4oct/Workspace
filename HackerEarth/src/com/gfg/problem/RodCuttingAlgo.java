package com.gfg.problem;

public class RodCuttingAlgo {

	static int count = 0;
	static int c = 0;
	public static void main(String[] args) {

		int[] p =  {1,5,8,9,10,17,17,20,30,12,14,1,5,8,9,10,17,17,20,30,12,14};
		int[] op = new int[p.length];
		for (int i = 0; i < op.length; i++) {
			op[i] = -1;
		}
		System.out.println(maxPriceRodCuttingRecursive(p,p.length));
		System.out.println(c);
		System.out.println(maxPriceRodCuttingDP(p,p.length,op));
		System.out.println(count);
	}

	private static int maxPriceRodCuttingDP(int[] priceArr, int len, int [] op) {
		count++;
		if(op[len-1] != -1)
			return op[len-1];
		
		int val = priceArr[len-1];
		for (int i = 1; i <= len/2 ; i++) {
			val = max(val,maxPriceRodCuttingDP(priceArr, len-i, op)+maxPriceRodCuttingDP(priceArr, i , op));
		}
		op[len-1] = val;
		return val ;
	}

	private static int maxPriceRodCuttingRecursive(int[] priceArr, int len) {
		c++;
		int val = priceArr[len-1];
		for (int i = 1; i <= len/2 ; i++) {
			val = max(val,maxPriceRodCuttingRecursive(priceArr, len-i)+maxPriceRodCuttingRecursive(priceArr, i));
		}
		return val ;
		
	}

	private static int max(int i, int j) {
		return j > i ? j : i;
	}

}
