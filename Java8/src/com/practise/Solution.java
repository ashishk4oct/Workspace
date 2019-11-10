package com.practise;

import java.time.Instant;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(336465782);
        A.add(-278722862);
        A.add(-2145174067);
        A.add(1101513929);
        A.add(1315634022);
        A.add(-1369133069);
        A.add(1059961393);
        A.add(628175011);
        A.add(-1131176229);
        A.add(-859484421);
        s.maxset(A);
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        long sum = 0;
        int length = 0;
        int start = 0;
        int end = 0;
        long tsum = 0;
        int tlength = 0;
        int tstart = 0;
        int tend = 0;

        for (int i = 0; i < A.size(); i++) {
            Integer a = A.get(i);
            if(a < 0){
                tsum = 0;
                tlength = 0;
                tstart = 0;
                tend = 0;
                continue;
            }

            if(tlength == 0){
                tstart = i;
            }
            tend = i;
            tlength++;
            tsum += a;

            if(tsum > sum){
                sum = tsum;
                length = tlength;
                start = tstart;
                end = tend;
            }else if(tsum == sum){
                if(tlength > length){
                    sum = tsum;
                    length = tlength;
                    start = tstart;
                    end = tend;
                }
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = start; i <= end && i > -1 && length >0; i++){
            al.add(A.get(i));
        }
        return al;
    }

    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A.size() <= 1){
            return 0;
        }
        int steps = 0;
        for(int i = 0; i < A.size()-1 ; i++){
            int x = A.get(i), y = B.get(i);
            int x1 = A.get(i+1), y1 = B.get(i+1);
            int distanceX = x > x1? x-x1 : x1-x;
            int distanceY = y > y1? y-y1 : y1-y;
            steps += distanceX > distanceY ? distanceX : distanceY;
        }
        return steps;
    }
}
