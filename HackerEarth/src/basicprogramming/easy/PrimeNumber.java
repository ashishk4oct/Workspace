package basicprogramming.easy;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        boolean prime ;
        
        for (int i = 2; i <= N ; i++) {
        	prime = true;
            for (int j = 2; j <= i/2 ; j++) {
    			if(i%j == 0) {
    				prime = false;
    				break;
    			}
            }
            if(prime)
            	System.out.print(i+" ");
		}

	}

}
