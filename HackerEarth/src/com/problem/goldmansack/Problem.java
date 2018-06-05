package com.problem.goldmansack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem {

	public static void main(String[] args) {

		Problem p = new Problem();
		int[][] a = { { 24, 130, 500 }, { 25, 280, 1800 }, { 26, 120, 1500 } };
		
		int[][] b = { { 4, 1, 1 }, { 3, 3, 4 }, { 1, 4, 5 }, { 6, 5, 7 } };
		int[][] c = { { 1, 12, 8 }, { 2, 3, 9 }, { 3, 4, 8 }, { 4, 5, 25 }, { 5, 2, 8 }, { 6, 3, 9 }, { 7, 4, 8 },
				{ 8, 5, 25 }, { 9, 12, 88 }, { 10, 13, 39 }, { 11, 4, 8 }, { 12, 35, 125 }, { 13, 12, 28 },
				{ 14, 63, 229 }, { 15, 4, 8 }, { 21, 22, 28 }, { 22, 3, 9 }, { 23, 14, 8 }, { 24, 5, 25 }, { 25, 2, 8 },
				{ 26, 3, 19 }, { 27, 4, 8 }, { 28, 35, 125 }, { 29, 2, 18 }, { 210, 3, 9 }, { 211, 4, 8 },
				{ 212, 5, 25 }, { 213, 12, 8 }, { 214, 3, 9 }, { 215, 4, 8 }, { 31, 12, 28 }, { 32, 33, 119 },
				{ 33, 34, 118 }, { 34, 25, 125 }, { 35, 22, 88 }, { 36, 13, 29 }, { 37, 14, 28 }, { 38, 5, 25 },
				{ 39, 12, 8 }, { 310, 3, 9 }, { 311, 34, 48 }, { 312, 15, 25 }, { 313, 2, 8 }, { 314, 33, 39 },
				{ 315, 14, 18 }, { 41, 2, 8 }, { 42, 3, 19 }, { 43, 4, 8 }, { 44, 5, 25 }, { 45, 2, 18 },
				{ 46, 13, 29 }, { 47, 14, 58 }, { 48, 5, 125 }, { 49, 12, 8 }, { 410, 13, 19 }, { 411, 4, 8 },
				{ 412, 5, 25 }, { 413, 2, 8 }, { 414, 3, 9 }, { 415, 4, 8 } };

		int[][] d = { { 1, 12, 8 }, { 2, 13, 9 }, { 3, 514, 1008 }, { 4, 915, 10025 }, { 5, 12, 8 }, { 6, 13, 9 }, { 7, 14, 8 },
				{ 8, 15, 25 }, { 9, 12, 88 }, { 10, 13, 39 }, { 11, 14, 8 }, { 12, 35, 125 }, { 13, 12, 28 },
				{ 14, 63, 229 }, { 15, 24, 8 }, { 21, 22, 28 }, { 22, 23, 9 }, { 23, 14, 8 }, { 24, 25, 25 },
				{ 25, 22, 8 }, { 26, 23, 19 }, { 27, 24, 8 }, { 28, 35, 125 }, { 29, 22, 18 }, { 210, 23, 9 },
				{ 211, 24, 8 }, { 212, 35, 125 }, { 213, 12, 8 }, { 214, 13, 9 }, { 215, 14, 8 }, { 31, 12, 28 },
				{ 32, 33, 119 }, { 33, 34, 118 }, { 34, 25, 125 }, { 35, 22, 88 }, { 36, 13, 29 }, { 37, 14, 28 },
				{ 38, 15, 25 }, { 39, 12, 18 }, { 310, 13, 19 }, { 311, 34, 48 }, { 312, 15, 25 }, { 313, 12, 18 },
				{ 314, 33, 39 }, { 315, 14, 18 }, { 41, 12, 18 }, { 42, 13, 19 }, { 43, 14, 18 }, { 44, 15, 25 },
				{ 45, 12, 18 }, { 46, 13, 29 }, { 47, 14, 58 }, { 48, 15, 125 }, { 49, 12, 18 }, { 410, 13, 19 },
				{ 411, 14, 18 }, { 412, 15, 25 }, { 413, 12, 18 }, { 414, 13, 19 }, { 415, 14, 18 }, { 91, 12, 8 },
				{ 92, 13, 9 }, { 92, 14, 8 }, { 94, 15, 25 }, { 95, 12, 8 }, { 96, 13, 9 }, { 97, 14, 8 },
				{ 98, 15, 25 }, { 99, 12, 88 }, { 910, 13, 39 }, { 911, 14, 8 }, { 912, 35, 125 }, { 913, 12, 28 },
				{ 914, 63, 229 }, { 915, 24, 8 }, { 921, 22, 28 }, { 922, 23, 9 }, { 923, 14, 8 }, { 924, 25, 25 },
				{ 925, 22, 8 }, { 926, 23, 19 }, { 927, 24, 8 }, { 928, 35, 125 }, { 929, 22, 18 }, { 9210, 23, 9 },
				{ 9211, 24, 8 }, { 9212, 35, 125 }, { 9213, 12, 8 }, { 9214, 13, 9 }, { 9215, 14, 8 }, { 931, 12, 28 },
				{ 932, 33, 119 }, { 933, 34, 118 }, { 934, 25, 125 }, { 935, 22, 88 }, { 936, 13, 29 }, { 937, 14, 28 },
				{ 938, 15, 25 }, { 939, 12, 18 }, { 9310, 13, 19 }, { 911, 34, 48 }, { 9312, 15, 25 }, { 9313, 12, 18 },
				{ 9314, 33, 39 }, { 9315, 14, 18 }, { 941, 12, 18 }, { 942, 13, 19 }, { 943, 14, 18 }, { 944, 15, 25 },
				{ 945, 12, 18 }, { 946, 13, 29 }, { 974, 14, 58 }, { 948, 15, 125 }, { 949, 12, 18 }, { 9410, 13, 19 },
				{ 9411, 14, 18 }, { 9412, 15, 25 }, { 9413, 12, 18 }, { 9414, 13, 19 }, { 9415, 14, 18 } };
		
		printTimeofExecutionOfMethod(p, 300, a);
//		printTimeofExecutionOfMethod(p,7, b);
//		printTimeofExecutionOfMethod(p,5, b);
//		printTimeofExecutionOfMethod(p,9, b);
//		printTimeofExecutionOfMethod(p,8, b);
//		printTimeofExecutionOfMethod(p, 500, c);
//		printTimeofExecutionOfMethod(p, 2000, d);

	}

	private static void printTimeofExecutionOfMethod(Problem p, int i, int[][] c) {

		long startTime = System.nanoTime();
		
		p.printMaxProfit(i, c);
		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("time taken :" + (double) totalTime / 1000000000.0);
	}

	public void printMaxProfit(int maxCargoWeight, int[][] cargoArr) {

		List<Cargo> cargoList = new ArrayList<Cargo>();

		for (int i = 0; i < cargoArr.length; i++) {
			cargoList.add(new Cargo(cargoArr[i][0], cargoArr[i][1], cargoArr[i][2]));
		}

		// cargoList.stream().map((c)->
		// c.getWeight()).forEach(System.out::println);

		cargoList = cargoList.stream().sorted(Comparator.comparing(Cargo::getWeight)).collect(Collectors.toList());

		int[][] pt = new int[cargoList.size()][maxCargoWeight + 1];

		for (int i = 0; i < pt.length; i++) {
			Cargo c = cargoList.get(i);
			for (int j = 0; j < pt[i].length; j++) {
				if (0 == j)
					pt[i][j] = 0;
				if (0 == i && j >= c.getWeight())
					pt[i][j] = c.getProfit();
				if (0 != i && j < c.getWeight())
					pt[i][j] = pt[i - 1][j];
				if (0 != i && j >= c.getWeight())
					pt[i][j] = max(pt[i - 1][j], pt[i - 1][j - c.getWeight()] + c.getProfit());
			}
		}

		System.out.println(pt[cargoList.size() - 1][maxCargoWeight]);
		
		for(Integer i :printSelectedCargo(pt,cargoList.size()-1,maxCargoWeight, cargoList)) {
			System.out.print(cargoList.get(i).getWeight()+" ");
		}
		System.out.println();
	
	}

	private List<Integer> printSelectedCargo(int[][] pt, int r, int c, List<Cargo> cargoList) {
	
		if(c == 0)
			return new ArrayList<>();
		
		if(0 == r)
			return new ArrayList<>(Arrays.asList(r));
	
		
		while(pt[r][c] == pt[r][c-1]) {
			c--;
		}
		if(pt[r][c] > pt[r-1][c]) {
			int wt = cargoList.get(r).getWeight();
			List<Integer> cl = printSelectedCargo(pt, r-1, c-wt ,cargoList);
			cl.add(r);
			return cl;
		}else {
			return printSelectedCargo(pt, r-1, c ,cargoList);
		}
	}

	private int max(int i, int j) {
		return i > j ? i : j;
	}
}

class Cargo {
	private final int id;
	private final int weight;
	private final int profit;

	public Cargo(int id, int weight, int profit) {
		this.id = id;
		this.weight = weight;
		this.profit = profit;
	}

	public int getId() {
		return id;
	}

	public int getWeight() {
		return weight;
	}

	public int getProfit() {
		return profit;
	}

}