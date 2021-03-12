package com.codechef.medium;

import com.codechef.easy.Reader;
import com.util.RandomUtil;import com.util.Printer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RootOfTheProblem {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int tCount = Reader.readIntArr(reader)[0];
            while (tCount > 0) {
                tCount--;
                int nodes = Reader.readIntArr(reader)[0];
                int count = 0;
                while (nodes > 0) {
                    nodes--;
                    int[] nodeSum = Reader.readIntArr(reader);
                    count = count + nodeSum[0] - nodeSum[1];
                }
                System.out.println(count);
            }
        } finally {
            if (null != reader)
                reader.close();
        }
    }
}
