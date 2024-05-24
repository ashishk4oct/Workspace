package com.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;

public class Reader {

    public static String[] readStringArr(BufferedReader reader) throws IOException {
        if(null == reader)
            throw new RuntimeException("null reader");

        return reader.readLine().trim().split(" ");
    }

    public static int[] readIntArr(BufferedReader reader) throws IOException {
        String line [] = readStringArr(reader);

        int arr [] = new int[line.length];

        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        return arr;
    }
}
