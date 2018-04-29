package com.hackerrank.chalange1;

public class LargestRectangle {

	public static void main(String[] args) {

//		int h [] = {1,2,3,4,5,6};
//		int h [] = {8,4,6,10,1,3,4,5,6,3,10};
//		int h [] = {4,16,15,10,18,19,5};
		int h [] = {8979, 4570, 6436, 5083, 7780, 3269, 5400, 7579, 2324, 2116};
		System.out.println(MySolution.largestRectangle(h));
		System.out.println(DivideAndConquerSolution.largestRectangle(h));
		System.out.println(StackSolution.largestRectangle(h));
		
		
		
		
	}

    
    
}
