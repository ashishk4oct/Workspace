package com.problem.amazon;

import java.util.*;

public class Question1 {

    public static void main(String[] args) {



        List<String> stringList = new ArrayList<String>();

        Collections.sort(stringList, (o1, o2) -> {

            o1.substring(o1.indexOf(" "));
            String str = o1, s = " ";
            int index = str.indexOf(s);
            int len = s.length();
            str = str.substring(0,index) + str.substring(index+len);
            o1 = str;

            o2.substring(o2.indexOf(" "));
            str = o2;
            s = " ";
            index = str.indexOf(s);
            len = s.length();
            str = str.substring(0,index) + str.substring(index+len);
            o2 = str;

            return o1.compareTo(o2);
        });

        List<String> numList = new ArrayList<String>();
        List<String> list = new ArrayList<String>();


        list.addAll(stringList);
        System.out.println(isNumber(""));
        System.out.println(isNumber("1"));
        System.out.println(isNumber(".1"));
        System.out.println(isNumber("1.1"));

        System.out.println("ash..sh".indexOf(".."));
        System.out.println("ash..sh".substring(0, 3)+"ash..sh".substring(5));

        Integer arr[] = new Integer[]{10,20,30, 1};
        Arrays.sort(arr);
    int x = arr.length;
        for (int i : arr){
            System.out.println(i);
        }
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> popularNToys(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes)
    {
        // WRITE YOUR CODE HERE

        Map<String, Integer> toySet = new HashMap<String, Integer>();
        for(String toy : toys){
            toySet.put(toy.toLowerCase(), 0);
        }

        for(String quote: quotes){
            quote = quote.toLowerCase();
            quote = remove(quote, ".");
            quote = remove(quote, "!");
            quote = remove(quote, "'s");

            for(String word: quote.split(" ")){
                Integer count = toySet.get(word);
                if(count != null){
                    toySet.put(word, count+1);
                }
            }
        }

        Integer arr[] = new Integer[toySet.size()];
        int v = 0;
        for(String key : toySet.keySet()){
            arr[v] = toySet.get(key);
            v++;
        }

        Arrays.sort(arr);
        int len = arr.length-1;

        ArrayList<String> list = new ArrayList<>();
        while(topToys > 0){

            Integer count = arr[len];
            len--;
            String k = "";
            for(String key : toySet.keySet()){
                Integer c = toySet.get(key);
                if(count == c){
                    k = key;
                    break;
                }
            }
            toySet.remove(k);
            list.add(k);
            topToys--;

        }


        return list;

    }
    // METHOD SIGNATURE ENDS

    private String remove(String str, String s){
        int index = str.indexOf(s);
        int len = s.length();
        str = str.substring(0,index) + str.substring(index+len);
        return str;
    }

    private static boolean isNumber(String s){

        try{
            Double.parseDouble(s);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}
