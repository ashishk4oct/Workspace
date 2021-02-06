package com.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomUtil {

    final static int MIN = 1;
    final static int MAX = 20;
    final static int LEN = 20;

    public static void print(int [] arr){
        String r = Arrays.stream(arr).mapToObj(i -> ((Integer) i).toString()) //i is an int, not an Integer
                .collect(Collectors.joining(", "));
        System.out.println(r);
    }
    public static int[] generateRandom(int length){
        return generateRandom(length,MIN, MAX,true);
    }
    public static int[] generateRandomUnique(int length){
        return generateRandom(length,MIN, MAX,false);
    }
    public static int[] generateRandom(int length, int from, int to ){
        return generateRandom(length,from,to,true);
    }
    public static int[] generateRandomUnique(int length,int from, int to){
        return generateRandom(length,from,to,false);
    }
    public static int[] generateRandom(){
        return generateRandom(LEN,MIN, MAX,true);
    }
    public static int[] generateRandomUnique(){
        return generateRandom(LEN,MIN, MAX,false);
    }
    public static int[] generateRandom(int from, int to ){
        return generateRandom(LEN,from,to,true);
    }
    public static int[] generateRandomUnique(int from, int to){
        return generateRandom(LEN,from,to,false);
    }
    public static int[] generateRandom(int length, int from, int to, boolean duplicateAllowed){
        Set<Integer> generated = new HashSet<>();
        Random rand = new Random();

        int i = 0;
        int diff = to-from;
        if(!duplicateAllowed && diff < length){
            length = diff;
        }
        int [] arr = new int[length];
        while(i < length){
            int v = rand.nextInt(diff);
            v += from;
            if(!duplicateAllowed){
                if(!generated.contains(v)){
                    generated.add(v);
                    arr[i++] = v;
                }else{
                    continue;
                }
            }else{
                arr[i++] = v;
            }
        }

        return arr;
    }
}

/*
        RandomUtil.print(RandomUtil.generateRandom());
        RandomUtil.print(RandomUtil.generateRandomUnique());
        RandomUtil.print(RandomUtil.generateRandom(10,30));
        RandomUtil.print(RandomUtil.generateRandomUnique(10,20));
        RandomUtil.print(RandomUtil.generateRandom(5));
        RandomUtil.print(RandomUtil.generateRandomUnique(5));
        RandomUtil.print(RandomUtil.generateRandom(5,10,30));
        RandomUtil.print(RandomUtil.generateRandomUnique(50,10,30));
*/
