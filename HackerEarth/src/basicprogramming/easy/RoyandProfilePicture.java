package basicprogramming.easy;

import java.util.Scanner;

public class RoyandProfilePicture {
	 public static void main(String args[] ) throws Exception {
	        /*
	         * Read input from stdin and provide input before running
	         * Use either of these methods for input

	        //BufferedReader
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);

	        //Scanner
	        Scanner s = new Scanner(System.in);
	        int N = s.nextInt();

	        for (int i = 0; i < N; i++) {
	            System.out.println("hello world");
	        }
	        */
		 
        Scanner s = new Scanner(System.in);
        int L = s.nextInt();
        int N = s.nextInt();
        s.nextLine();
        String photoDimension [][] = new String[N][2];
        for (int i = 0; i < N; i++) {
            String photoDimensionStr = s.nextLine();
            photoDimension[i] = photoDimensionStr.split(" ");
        }
        
        for (int i = 0; i < N; i++) {
            int W = Integer.parseInt(photoDimension[i][0]);
            int H = Integer.parseInt(photoDimension[i][1]);
            
            if(W==H && W==L){
                System.out.println("ACCEPTED");
            }else if(W>=L && H>=L){
                System.out.println("CROP IT");
            }else{
                System.out.println("UPLOAD ANOTHER");
            }
            
        }
    }
}
