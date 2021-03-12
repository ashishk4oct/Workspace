package com.gfg.problem;

import com.util.Printer;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Tough {

    static int N;
    static int Nhalf;

    public static void main(String[] args) throws Exception {
        InputReader reader = new InputReader(System.in);
        int T = reader.readInt();
        for (int t = 0; t < T; t++) {
            N = reader.readInt();
            Double answer = resultCache.get(N);
            if (answer == null) {
                Nhalf = (N + 1) / 2;
                int[] stats = new int[Nhalf + 1];
                stats[0] = N;
                cache.clear();
                double[] presidents = solve(stats, -1, 0);
                Printer.print(presidents);
                double up = 0;
                double down = 0;
                for (int n = 1; n <= N; n++) {
                    double value = presidents[n];
                    down += value;
                    up += value * n;
                }
                answer = up / (double) down;
                resultCache.put(N, answer);
            }
            System.out.printf("%.6f\n", answer);
        }
    }

    static final Map<Integer, Double> resultCache = new HashMap<Integer, Double>();
    static final Map<Long, double[]> cache = new HashMap<Long, double[]>();

    static final double[] solve(int[] stats, int last, int index) {

        double[] presidents;
        if (index == N) {
            presidents = new double[N + 1];
            int winners = 0;
            for (int i = 1; i <= Nhalf; i++) {
                if (stats[i] > 0) {
                    winners = stats[i];
                }
            }
            presidents[winners]++;
        } else {
            // hash-code
            long code = last;
            for (int value : stats) {
                code *= 36;
                code += value;
            }
            presidents = cache.get(code);
            if (presidents == null) {
                presidents = new double[N + 1];
                for (int i = 0; i <= Nhalf; i++) {
                    int value = stats[i];
                    if (i == last) {
                        value--;
                    }
                    if (value > 0) {
                        int iPlusOne = i + 1;

                        System.out.println("stats: ");
                        Printer.print(stats);
                        stats[i]--;
                        stats[iPlusOne]++;
                        Printer.print(stats);
                        System.out.println("i:"+i+" index:"+ (index));

                        double[] part = solve(stats, iPlusOne, index + 1);
                        for (int n = 1; n <= N; n++) {
                            presidents[n] += value * part[n];
                        }
                        stats[iPlusOne]--;
                        stats[i]++;
                    }
                }
//                Printer.print(stats);
                cache.put(code, presidents);
            }
        }
        return presidents;
    }

    static final class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() throws IOException {
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buf);
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public final int readInt() throws IOException {
            return (int) readLong();
        }

        public final long readLong() throws IOException {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
                if (c == -1) throw new IOException();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return negative ? -res : res;
        }

        public final int[] readIntArray(int size) throws IOException {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = readInt();
            }
            return array;
        }

        public final long[] readLongArray(int size) throws IOException {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) {
                array[i] = readLong();
            }
            return array;
        }

        public final String readString() throws IOException {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.append((char) c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}
