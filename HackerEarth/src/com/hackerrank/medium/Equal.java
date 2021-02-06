package com.hackerrank.medium;

import java.util.*;

import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
public class Equal {


    public static void main(String[] args) {

        int arr[] = new int[]{0,1,4,6};
        int arr1[] = new int[]{10, 7, 12};

        System.out.println(equal(arr1));
    }
    // Complete the equal function below.
    static int equal(int[] arr) {
        Map<Array, Array[]> map = new HashMap<>();
        Queue<Array> queue = new LinkedList<>();

        queue.add(new Array(arr, 0));
        while(!queue.isEmpty()){
            Array a = queue.poll();
            if(map.containsKey(a)){
                continue;
            }
            Array b[] = findAllPermutation(a);

            if(b == null){
                return a.level + 1;
            }

            map.put(a, b);
            queue.addAll(Arrays.asList(b));
        }
        return 0;

    }

    private static Array[] findAllPermutation(Array array) {

        Array[] result = new Array[array.arr.length*3];
        int index = 0;
        for (int i = 0; i < array.arr.length ; i++) {
            int arr1[] = new int[array.arr.length];
            int arr2[] = new int[array.arr.length];
            int arr5[] = new int[array.arr.length];
            for (int j = 0; j < array.arr.length ; j++) {
                if(j != i){
                    arr1[j] = array.arr[j]+1;
                    arr2[j] = array.arr[j]+2;
                    arr5[j] = array.arr[j]+5;
                }else{
                    arr1[j] = array.arr[j];
                    arr2[j] = array.arr[j];
                    arr5[j] = array.arr[j];
                }
            }

            if(isEqual(arr1) || isEqual(arr2) || isEqual(arr5)){
                return null;
            }
            result[index++] = new Array(arr1, array.level+1);
            result[index++] = new Array(arr2, array.level+1);
            result[index++] = new Array(arr5, array.level+1);

        }
        return result;
    }

    private static boolean isEqual(int[] arr) {
        int v = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != v){
                return false;
            }
        }
        return true;
    }


}

class Array{

    public final int arr[];
    public final int level;
    public Array(int arr[],int level){
        this.arr = arr;
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array = (Array) o;
        return Arrays.equals(arr, array.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }
}




class Solution1 implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(null, new Solution1(), "", 256 * (1L << 20)).start();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            out = new PrintWriter(System.out);

            in = new BufferedReader(new InputStreamReader(System.in));
            //in = new BufferedReader(new FileReader("src/input.txt"));
            //   out = new PrintWriter("output.txt");

            Locale.setDefault(Locale.US);
            solve();
            in.close();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    // solution
    void solve() throws IOException {
        int testcases = readInt();
        while (testcases-- > 0) {
            int n = readInt();
            int min = Integer.MAX_VALUE;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = readInt();
                min = Math.min(min, a[i]);
            }
            int bestResult = Integer.MAX_VALUE / 2;
            for (int borderline = min; borderline >= 0 && borderline >= min - 20; borderline--) {
                int result = 0;
                for (int i = 0; i < n; i++) {
                    result += (a[i] - borderline) / 5;
                    result += (a[i] - borderline) % 5 / 2;
                    result += (a[i] - borderline) % 5 % 2 / 1;
                }
                bestResult = Math.min(bestResult, result);
            }
            out.println(bestResult);
        }
    }
}
