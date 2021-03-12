package com.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {
        // your code goes here
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        try{
            String str = reader.readLine().trim();
            String fortyTwo = "42";
            while(!str.equals(fortyTwo)){
                System.out.println(str);
                str = reader.readLine().trim();
            }
        }finally {
            if(null != reader)
                reader.close();
        }

    }
}
