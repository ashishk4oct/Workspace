package com.hackerrank.chalange3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a[] = {"1112",
				"1912",
				"1892",
				"1234"};
		for(String s :cavityMap(a)) {
			System.out.println(s);
		};

	}
	static String[] cavityMap(String[] arr) {

		int res[][] = new int[arr.length][arr[0].length()];
		
		for (int i = 1; i < arr.length-1; i++) {
			String[] a = arr[i-1].split("");
			String[] c = arr[i].split("");
			String[] b = arr[i+1].split("");
			for (int j = 1; j < c.length-1; j++) {
				if(intP(c[j]) > intP(c[j-1]) && intP(c[j]) > intP(c[j+1]) && intP(c[j]) > intP(a[j]) && intP(c[j]) > intP(b[j])) {
					res[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				if(1 == res[i][j]) {
					String s = arr[i];
					arr[i] = s.substring(0,j)+'X'+s.substring(j+1);
				}
			}
		}
		return arr;
    }
	
	private static int intP(String str){
		return Integer.parseInt(str);
		
	}
}
