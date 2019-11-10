package com.java.streams.questions;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class CollectingDataWithScreams {

    private static List<Transaction> transactions = TransactionsDataGenerator.getTransactions();
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        System.out.println("----------------------------------------------------------------------------");
        Map<Boolean, List<Integer>> map = IntStream.rangeClosed(2, 10).boxed()
                .collect(partitioningBy(candidate -> IntStream.rangeClosed(2, (int)Math.sqrt(candidate)).noneMatch(i -> candidate/i == 0)));
        System.out.println("----------------------------------------------------------------------------");
    }



    public static void test5() {
        System.out.println("----------------------------------------------------------------------------");
        Map<Integer, Transaction> t = transactions.stream().collect(groupingBy(Transaction::getYear, collectingAndThen(maxBy(Comparator.comparing(Transaction::getValue)),Optional::get)));
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void test4() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println(transactions.stream().collect(reducing(
                0, Transaction::getValue, (i, j) -> i + j)));
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void test3() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println(transactions.stream().map(Transaction::getTrader).map(Trader::getName).collect(joining(", ")));
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void test2() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println(transactions.stream().collect(summingInt(Transaction::getValue)));
        System.out.println(transactions.stream().collect(maxBy(Comparator.comparing(Transaction::getValue))));
        System.out.println(transactions.stream().collect(summarizingInt(Transaction::getValue)));
//        System.out.println(transactions.stream().collect(Collectors.summingInt(Transaction::getValue)));
//        System.out.println(transactions.stream().collect(Collectors.summingInt(Transaction::getValue)));
//        System.out.println(transactions.stream().collect(Collectors.summingInt(Transaction::getValue)));
        System.out.println("----------------------------------------------------------------------------");
    }

    public static void test1() {
        System.out.println("----------------------------------------------------------------------------");
        Map<Integer, List<Transaction>> transactionsByCurrencies =
                transactions.stream().collect(groupingBy(Transaction::getYear));
        System.out.println("----------------------------------------------------------------------------");
    }
}
