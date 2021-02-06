package com.hackerrank.medium;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MaximumPalindromes {
    public static void main(String[] args) throws IOException {
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        Result.initialize(s);

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int l = Integer.parseInt(firstMultipleInput[0]);

                int r = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.answerQuery(l, r);

                System.out.println(String.valueOf(result));;
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();*/
        Result.initialize("wldsfubcsxrryqpqyqqxrlffumtuwymbybnpemdiwyqz");
        int v = Result.answerQuery(3, 39);
        System.out.println(v);
    }

}

class Result {

    /*
     * Complete the 'initialize' function below.
     *
     * The function accepts STRING s as parameter.
     */

    private static String s ;
    public static void initialize(String s) {
        // This function is called once before all queries.

        Result.s = s;
    }


    public static int answerQuery(int l, int r) {

        if(l > r){
            throw new IllegalStateException("l grater than r");
        }

        int arr[] = new int[27];
        Arrays.fill(arr,0);

        for (char c: s.substring(l-1,r).toCharArray()){
            int i = c - 'a';
            arr[i] += 1;
        }

        return getMaxCountPalindrome(arr);
    }

    private static int getMaxCountPalindrome(int[] charCount) {
        int uniqueCharCount = 0;
        List<Integer> list = new ArrayList<>();

        for(int i : charCount){
            if(i%2 != 0){
                uniqueCharCount++;
            }
            int v = (i/2)*2;
            if(v != 0){
                list.add(v);
            }
        }
        int result = 1;

        if(list.size() > 0){
            int size = list.stream().reduce((a,b) -> a+b).get()/2;
            int j = 0;
            int factorial = 1;
            for (int i = size; i > 0; i--) {
                factorial *= i;
                if(list.size() > j && factorial%(list.get(j)/2) == 0){
                    factorial = factorial/(list.get(j)/2);
                    j++;
                }
            }
            result *= factorial;
        }

        if(uniqueCharCount != 0)
            result *= uniqueCharCount;

        result %= 1000000007;

        return result;
    }

}