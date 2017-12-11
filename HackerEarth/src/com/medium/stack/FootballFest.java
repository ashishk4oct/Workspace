package com.medium.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FootballFest {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		
        int testCases = Integer.parseInt(readline()); 
        while(testCases-- > 0) {
        	String arr[] = readline().split(" ");
        	int N = Integer.parseInt(arr[0]);
        	Stack.empty();
        	int baseId = Integer.parseInt(arr[1]);
        	
        	while(N-- > 0) {
        		arr = readline().split(" ");
        		String operation = arr[0];
        		if(operation.equalsIgnoreCase("P")) {
        			int id = Integer.parseInt(arr[1]);
        			Stack.push(id);
        		}else {
        			Stack.reverse();
        		}
        	}
        	System.out.println("Player "+Stack.peek());
        }
	}

	private static String readline() throws Exception {
		return br.readLine().trim();
	}
	
	static class Stack{
		static int stackArray [] = new int[2];
		static int top = -1;
		
		public static int peek() {
			return stackArray[top];
		}

		public static void reverse() {
			int temp = stackArray[0];
			stackArray[0] = stackArray[1];
			stackArray[1] = temp;
		}

		public static void empty() {
			top = -1;
			stackArray[0] = 0;
			stackArray[1] = 0;
		}

		public static void push(int id) {
			if(top == 1) {
				stackArray[0] = stackArray[1];
				stackArray[1] = id;
			}else {
				stackArray[++top] = id;
			}
			
		}
	}
}
