package com.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Printer {

    public static <T extends Object> void print(Collection<T> collection){
        StringBuilder sb = new StringBuilder();
        collection.forEach(i -> sb.append(i+", "));
        System.out.println(sb.subSequence(0, sb.length()-2));
    }

    public static void print(int [] arr){
        String r = Arrays.stream(arr).mapToObj(i -> ((Integer) i).toString()) //i is an int, not an Integer
                .collect(Collectors.joining(", "));
        System.out.println(r);
    }

    public static void print(double[] arr) {
        String r = Arrays.stream(arr).mapToObj(i -> ((Double) i).toString())
                .collect(Collectors.joining(", "));
        System.out.println(r);
    }
}
