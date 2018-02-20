package com.java.paraller.data.processing.wordcount;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
	final static String SENTENCE =
			"     Nel     mezzo del cammin di nostra vita " +
			"mi ritrovai in una   	 selva oscura" +
			" ché la dritta via era	 smarrita     ";
	
	public static void main(String[] args) {
		Test t = new Test();
		Stream<Character> stream = IntStream.range(0, SENTENCE.length())
											.mapToObj(SENTENCE::charAt);
		System.out.println("Found " + t.countWords(stream) + " words");
	}

	private int countWords(Stream<Character> stream) {
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
		return wordCounter.getCounter();
	}
}
