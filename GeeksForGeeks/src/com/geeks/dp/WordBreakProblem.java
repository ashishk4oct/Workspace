package com.geeks.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreakProblem {

	static final ArrayList<String> dict = new ArrayList<String>(Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice", 
			"cream", "icecream", "man", "go", "mango"));
	
	public static void main(String[] args) {
		StringBuilder seprtatedString = getSepratedString("igoiicreammangoice");
		System.out.println(seprtatedString);
	}

	private static StringBuilder getSepratedString(String input) {

		StringBuilder output = new StringBuilder();
		for (int endIndex = 1; endIndex <= input.length() ; endIndex++) {
			if(matchSubString(input,0,endIndex,output)) {
				output.insert(0, " "+ input.substring(0, endIndex));
				return output;
			}
		}
		return null;
	}

	private static boolean matchSubString(String input, int beginIndex , int lastIndex, StringBuilder output) {
		if(!dict.contains(input.substring(beginIndex,lastIndex))) {
//			output = input.substring(beginIndex, lastIndex) + " " +output;
			return false;
		}
		
		if(input.length() == lastIndex) {
			return true;
		}
		
		for (int endIndex = lastIndex+1 ; endIndex <= input.length() ; endIndex++) {
			if(matchSubString(input,lastIndex,endIndex,output)) {
				output.insert(0, " "+ input.substring(lastIndex, endIndex));
				return true;
			}
		}
		
		return false;
	}
}
