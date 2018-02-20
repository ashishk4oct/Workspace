package com.java.paraller.data.processing.wordcount;

public class IterativeWordCounter {

	final static String SENTENCE =
			"     Nel     mezzo del cammin di nostra vita " +
			"mi ritrovai in una   	 selva oscura" +
			" ché la dritta via era	 smarrita     ";
	
	public static void main(String[] args) {
		System.out.println(countWordsIterative(SENTENCE));
		System.out.println(SENTENCE.trim().split("\\W+").length);
		
	}

	public static int countWordsIterative(String s) {
		int count = 0;
		boolean lastSpace = true;
		
		for(char c : s.toCharArray()) {
			if(Character.isWhitespace(c)) {
				lastSpace = true;
			}else {
				if(lastSpace) count++;
				lastSpace = false;
			}
		}
		
		return count;
	}
}
