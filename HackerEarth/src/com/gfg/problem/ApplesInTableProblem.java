package com.gfg.problem;

public class ApplesInTableProblem {

	public static void main(String[] args) {
		int [][] mtx = {{1,2,3,4},{8,7,6,5},{9,10,11,12},{16,15,14,13}};
		
		ApplesInTableProblem a = new ApplesInTableProblem();
		a.findPath(mtx);
		
	}
	
	public void findPath(int [][] mtx) {
		int [][] sumMtx = new int [mtx.length] [mtx[0].length];
		
		for (int i = 0; i < sumMtx.length; i++) {
			for (int j = 0; j < sumMtx[i].length; j++) {
				if(j == 0 && i == 0)
					sumMtx[i][j] = mtx[i][j];
				else if(j == 0 && i != 0)
					sumMtx[i][j] = mtx[i][j]+sumMtx[i-1][j];
				else if(j != 0 && i == 0)
					sumMtx[i][j] = mtx[i][j]+sumMtx[i][j-1];
				else
					sumMtx[i][j] = max(mtx[i][j]+sumMtx[i][j-1],mtx[i][j]+sumMtx[i-1][j]);
			}
		}
		for (int i = 0; i < mtx.length; i++) {
			for (int j = 0; j < mtx[i].length; j++) {
				System.out.printf("%-3d",mtx[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		
		for (int i = 0; i < sumMtx.length; i++) {
			for (int j = 0; j < sumMtx[i].length; j++) {
				System.out.printf("%-3d",sumMtx[i][j]);
			}
			System.out.println();
		}
		
	}

	private int max(int i, int j) {
		return i > j ? i : j;
	}

}
