package com.problem.lithium;

import java.util.Stack;

public class LongestBalancedParentheses {
// Length of longest balanced parentheses prefix

	public static void main(String[] args) {
		String bracketString = "]()((()))))))){{{{{{{{{{{{{{()()[][][([[]])]}}}()()(";
		
		
		System.out.println(calculate(bracketString));
	}

	public static int calculate(String bracketString) {

		char[] bracketArr  = bracketString.toCharArray();
		int [] bracketArrStatus = new int[bracketArr.length];
		Stack<Integer> lastOpenBracketPosition = new Stack<>();
		Stack<Integer> lastNonBalancedBracket = new Stack<>();
		
		for (int i = 0; i < bracketArrStatus.length; i++) {
			bracketArrStatus[i] = 0;
		}
		for (int i = 0; i < bracketArr.length; i++) {
			if(isOpenBracket(bracketArr[i])) {
				lastOpenBracketPosition.push(i);
				lastNonBalancedBracket.push(i);	
			}else if(!lastOpenBracketPosition.isEmpty() && !lastNonBalancedBracket.isEmpty() && lastNonBalancedBracket.peek() == lastOpenBracketPosition.peek() && isCompatible(bracketArr[i], bracketArr[lastOpenBracketPosition.peek()]) ) {
				bracketArrStatus[i] = 1;
				bracketArrStatus[lastOpenBracketPosition.peek()] = 1;

				lastOpenBracketPosition.pop();
				lastNonBalancedBracket.pop();
			}else {
				lastNonBalancedBracket.push(i);	
			}
		}

		int tempMax = 0, max = 0;
		
		for (int i = 0; i < bracketArrStatus.length; i++) {
			System.out.printf("%5s:%d",bracketArr[i],bracketArrStatus[i]);
			System.out.println();
			if(bracketArrStatus[i] == 1) {
				tempMax++;
			}else {
				max = tempMax > max ? tempMax : max;
				tempMax = 0;
			}
		}
		max = tempMax > max ? tempMax : max;
		return max;
	}

	private static boolean isCompatible(char c, char d) {
		// TODO Auto-generated method stub
		switch (d) {
		case '(':
			return c == ')';
		case '[':
			return c == ']';
		case '{':
			return c == '}';
		}
		return false;
	}

	private static boolean isOpenBracket(char c) {
		return (c == '(' || c == '{' || c == '[') ? true : false;
	}

}
