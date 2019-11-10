package com.java.streams.questions;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Test {

	public static void main(String[] args) {

		List<Transaction> transactions = TransactionsDataGenerator.getTransactions();

		findAllTransactionIn2011Sorted(transactions);
		System.out.println();
		findUniqueCities(transactions);
		System.out.println();
		allTransactionFormCambridgeAndSortByName(transactions);
		System.out.println();
		allTradersNameSortedAlphabatically(transactions);
		System.out.println();
		isTradersBasedInMilan(transactions);
		System.out.println();
		allTransactionsValueOfTradersLiveInCambridge(transactions);
		System.out.println();
		highestValueOfAllTransactions(transactions);
		System.out.println();
		smallesValueOfAllTransactions(transactions);
		
	}

	private static void smallesValueOfAllTransactions(List<Transaction> transactions) {

		Optional<Transaction> t = transactions.stream()
	   			    				.reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
		System.out.println(t.isPresent());
		System.out.println(t.get());
		
		Optional<Transaction> smallestTransaction =	transactions.stream()
													.min(comparing(Transaction::getValue));
		System.out.println(smallestTransaction.get());
					
	}

	private static void highestValueOfAllTransactions(List<Transaction> transactions) {
		Integer max = transactions.stream()
					.map(Transaction::getValue)
					.max(Comparator.comparing(Integer::intValue)).get();
		System.out.println(max);
		
		max = transactions.stream()
				.map(Transaction::getValue)
				.reduce(Integer.MIN_VALUE,Integer::max);
		System.out.println(max);
	}

	private static void allTransactionsValueOfTradersLiveInCambridge(List<Transaction> transactions) {
		transactions.stream()
					.filter((t) -> t.getTrader().getCity().equals("Cambridge"))
					.map(Transaction::getValue)
					.forEach(System.out::println);
	}

	private static void isTradersBasedInMilan(List<Transaction> transactions) {
		boolean isAnyTradeBasedOnMilan =  transactions.stream()
					.anyMatch((t) -> t.getTrader().getCity().equals("Milan"));
		System.out.println("isAnyTradeBasedOnMilan = "+isAnyTradeBasedOnMilan);
	}

	private static void allTradersNameSortedAlphabatically(List<Transaction> transactions) {
		String names  = transactions.stream()
									.map((t) -> t.getTrader().getName())
									.distinct()
									.sorted()
									.reduce("", (n1, n2) -> n1 +" "+n2);
		
		System.out.println(names);
	}

	private static void allTransactionFormCambridgeAndSortByName(List<Transaction> transactions) {
		transactions.stream()
			.map(Transaction::getTrader)
			.filter((t) -> t.getCity().equals("Cambridge"))
			.distinct()
			.sorted(comparing(Trader::getName))
			.forEach((t) -> {
				System.out.println(t);
			});
	}

	private static void findUniqueCities(List<Transaction> transactions) {
		transactions.stream()
					.map((t) -> t.getTrader().getCity())
					.distinct()
					.forEach((c) -> {
						System.out.println(c);
					});
	}

	private static void findAllTransactionIn2011Sorted(List<Transaction> transactions) {

		transactions.stream()
					.filter((t) -> t.getYear() == 2011 )
					.sorted(comparing(Transaction::getValue))
					.forEach((t) -> {
						System.out.println(t);
					});
	}

}
