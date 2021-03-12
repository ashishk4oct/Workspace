package com.codechef.medium;

import com.codechef.easy.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CountingStrings {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String str = in.readLine().trim();

        int mod, i, len = str.length(), extra;
        long ans, sum;

        mod = 1000000007;

        long[] values = new long[len];
        long[] greater = new long[len];
        long[] pow_of_26 = new long[len];


        pow_of_26[len - 1] = 1L;

        for (i = len - 2; i >= 0; i--) {
            pow_of_26[i] = pow_of_26[i + 1] * 26;
            pow_of_26[i] %= mod;
        }
        ans = 0L;
        for (i = 0; i < len; i++) {
            extra = 25 - (str.charAt(i) - 65);
            greater[i] = (long) extra;
            values[i] = greater[i];
            ans += greater[i];
            ans %= mod;

            greater[i] *= pow_of_26[i];
            greater[i] %= mod;
//out.print(greater[i]+" ");
        }
//out.println();
        for (i = len - 2; i >= 0; i--) {
            greater[i] += greater[i + 1];
            greater[i] %= mod;
        }
        for (i = 1; i < len; i++) {
            sum = (greater[0] - greater[i]);

            if (sum < mod)
                sum += mod;

            sum *= power(pow_of_26[i - 1], mod - 2, mod);
            sum %= mod;
            sum *= (values[i]);
            sum %= mod;

            ans += sum;
            ans %= mod;
        }
        out.println(ans);
        out.close();
        out.flush();
    }

    public static long power(long x, long y, int p) {
        long res = 1L;      // Initialize result

        x = x % p;  // Update x if it is more than or
        // equal to p

        while (y > 0) {
            // If y is odd, multiply x with result
            if (y % 2 == 1)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }

}
