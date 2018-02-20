package com.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

	public static void main(String [] args) {
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );

	
		List<String> hightCaloriesFood = menu.stream()
		.filter((d) -> d.getCalories() > 300)
		.sorted(Comparator.comparing(Dish::getCalories).reversed())
//		.sorted((d1, d2) -> new Integer(d2.getCalories()).compareTo(d1.getCalories()))
		.map(Dish::getName)
		.limit(2)
		.collect(Collectors.toList());
		
		for (String string : hightCaloriesFood) {
			System.out.println(string);
		}
		
		int sum = menu.stream()
					  .collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
		
		System.out.println(sum);
		
		
	}
	public Map<Boolean, List<Integer>> partitionPrimes(int n) {
		return IntStream.rangeClosed(2, n).boxed()
						.collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
	}
	public boolean isPrime(int candidate) {
		int candidateRoot = (int) Math.sqrt((double) candidate);
		return IntStream.rangeClosed(2, candidateRoot)
		.noneMatch(i -> candidate % i == 0);
	}
	
}
