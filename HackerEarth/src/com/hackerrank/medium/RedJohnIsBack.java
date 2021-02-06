package com.hackerrank.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RedJohnIsBack {

    public static void main(String[] args) {
        Task t = new Task();
        int k = 11;
        t.solve(1,k);
        int i = redJohn(k);
        System.out.println(i);
    }


    // initializing the max value
    static int MAX_SIZE = 120000000;

    // To store all prime numbers
    static int arr[];

    // Function to generate N prime numbers
    // using Sieve of Eratosthenes
    static
    {
        // Create a boolean array "IsPrime[0..MAX_SIZE]"
        // and initialize all entries it as true.
        // A value in IsPrime[i] will finally be false
        // if i is Not a IsPrime, else true.
        boolean [] IsPrime = new boolean[MAX_SIZE];

        for(int i = 0; i < MAX_SIZE; i++)
            IsPrime[i] = true;

        for (int p = 2; p * p < MAX_SIZE; p++)
        {
            // If IsPrime[p] is not changed,
            // then it is a prime
            if (IsPrime[p] == true)
            {
                // Update all multiples of p greater than or
                // equal to the square of it
                // numbers which are multiple of p and are
                // less than p^2 are already been marked.
                for (int i = p * p; i < MAX_SIZE; i += p){
                    IsPrime[i] = false;
                }
            }
        }

        int count = 0;
        // Store all prime numbers
        for (int p = 2; p < MAX_SIZE; p++) {
            if (IsPrime[p] == true)
                count++;
        }
        arr = new int[count];
        count=0;
        for (int p = 2; p < MAX_SIZE; p++) {
            if (IsPrime[p] == true)
                arr[count++] = p;
        }
    }

    // Complete the redJohn function below.
    static int redJohn(int n) {

        int num = numberOfWays(n);
        System.out.println(num);
        int pnum = findPrimeNumberCount(num);

        return pnum;

    }

    static int findPrimeNumberCount(int num){
        int count = 0;

        for(int n : arr){
            if(n > num) {
                break;
            }
            count++;
        }


        return count;

    }

    static int numberOfWays(int n){
        int i = 0;
        int result = 0;
        while(n >= (4*i)){
            int k = n-(4*i);
            // (k+i)!/k!i!
            result += factorial(k+i, k, i);
            i++;
        }
        return result;
    }

    static int factorial(int ki, int k , int i){
        int result = 1;
        int larger = k > i ? k : i;
        int smaller = k < i ? k : i;
        int temp = 2;
        for(int l = ki; l > larger; l--){
            result *= l;
        }
        while(smaller > 0){
            result = result/smaller;
            smaller--;
        }
        return result;
    }


}


class Task {
    final int MAXN = 41;

    int[] numberOfWays;
    boolean[] isPrime;
    ArrayList<Integer> primeList;

    public Task() {
        numberOfWays = new int[MAXN];
        numberOfWays[0] = numberOfWays[1] = numberOfWays[2] = numberOfWays[3] = 1;
        for (int i = 4; i < numberOfWays.length; ++i) {
            numberOfWays[i] = numberOfWays[i - 1] + numberOfWays[i - 4];
        }


        isPrime = new boolean[numberOfWays[numberOfWays.length - 1]];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < isPrime.length; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        primeList = new ArrayList<Integer>();
        for (int i = 2; i < isPrime.length; ++i) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }
    }

    public void solve(int testNumber, int n) {
        int m = numberOfWays[n];
        System.out.println(m);
        int res = Collections.binarySearch(primeList, m);
        if (res >= 0) {
            ++res;
        }
        else {
            res = -(res + 1);
        }
        System.out.println(res);
    }
}