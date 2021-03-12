package com.codechef.medium;

import com.codechef.easy.Reader;
import com.util.RandomUtil;import com.util.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.*;

public class SUBLCM {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        for (int i = 0; i < 50; i++) {
            int arr[] = RandomUtil.generateRandom(100000, 1, 1000000);
//            Printer.print(arr);
            System.out.println(solution(arr));
        }

        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
    }

    public static void main1(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Reader.readIntArr(reader)[0];
            for (int i = 0; i < t; i++) {
                int len = Reader.readIntArr(reader)[0];
                int arr[] = Reader.readIntArr(reader);
                System.out.println(solution(arr));
            }

        } finally {
            if (null != reader)
                reader.close();
        }
    }

    public static int solution(int arr[]) {
        Map<Integer, Set<Integer>> numFactors = new HashMap<>();

        for (int num : arr) {
            Set<Integer> factors = numFactors.get(num);
            if (null == factors) {
                numFactors.put(num, factors(num));
            }
        }
        int len = 0;
        int i = 0;
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < arr.length; j++) {
            Set<Integer> factors = numFactors.get(arr[j]);
            for (Integer v : factors) {
                while (set.contains(v)) {
                    set.removeAll(numFactors.get(arr[i]));
                    i++;
                }
                set.add(v);
            }
            len = j - i > len ? j - i : len;
        }
        return len + 1;
    }

    private static Set<Integer> factors(int num) {
        Set<Integer> set = new HashSet<>();
        if (num == 1) {
            return set;
        }

        int count = 0;
        for (int i = 0; i < primeNumbers.length && num >= primeNumbers[i]; i++) {
            if (0 == num % primeNumbers[i]) {
                count++;
                set.add(primeNumbers[i]);
            }
        }
        if (count == 0) {
            set.add(num);
        }

        return set;
    }


    static int primeNumbers[] = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1009};
}


class Main {
    private static final int N = (int) 1e6 + 6;
    private static int[] p = new int[N];

    public static void main(String args[]) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        pre();
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc, out);
        }
        out.close();
    }

    private static void pre() {
        for (int i = 2; i < N; i++) {
            if (p[i] == 0) {
                p[i] = i;
                for (int j = 2 * i; j < N; j += i) {
                    p[j] = i;
                }
            }
        }
    }

    private static void solve(FastReader sc, PrintWriter out) {
        int n = sc.nextInt();
        int[] a = new int[N];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
//        int[] dp = new int[N];
        int[] last = new int[N];
//        Arrays.fill(dp, 0);
        Arrays.fill(last, 0);
        int dp = 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int x = a[i], fac = 0;
            while (x > 1) {
                int j = p[x];
                fac = Math.max(fac, last[j]);
                last[j] = i;
                while (x % j == 0) {
                    x /= j;
                }
            }
            if (i > 1) {
                dp = Math.min(dp + 1, i - fac);
            }
            ans = Math.max(ans, dp);
        }
        out.println(ans > 1 ? ans : "-1");
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
