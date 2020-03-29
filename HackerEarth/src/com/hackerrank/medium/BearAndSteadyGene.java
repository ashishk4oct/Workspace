package com.hackerrank.medium;

public class BearAndSteadyGene {
    public static void main(String[] args) {
        System.out.println(steadyGene("TGATGCCGTCCCCTCAACTTGAGTGCTCCTAATGCGTTGC"));
    }

    // Complete the steadyGene function below.
    static int steadyGene(String gene) {
        int eachLen = gene.length() / 4;
        int eachCount[] = getEachCount(gene);
        final int maxIn[] = getMaxIn(eachCount, eachLen);
        if (evenArray(eachCount, eachLen)) {
            return 0;
        }

        int start = 0, end = 0, extra = 0;
        final int EXT = getExtra(eachCount, eachLen);
        int count[] = new int[4];
        while (true) {
            if(eachCount[getIndex(gene.charAt(start))] > eachLen){
                count[getIndex(gene.charAt(start))] = 1;
                extra = 1;
                end = start;
                break;
            }else{
                start++;
            }
        }
        int wid = gene.length();
        boolean fresh = true;
        while (end < gene.length()-1 && start <= end) {
            if (!fresh) {
                while (true) {
                    int index = getIndex(gene.charAt(start));

                    if (eachCount[index] > eachLen) {
                        count[index]--;
                        if (count[index] == maxIn[index]-1) {
                            extra--;
                            start++;
                            break;
                        }
                    }
                    start++;
                    wid = wid < end-start+1 ? wid :end-start+1;

//                    System.out.println(gene.substring(start,end+1));
//                    System.out.println(start+" "+end+" "+wid);
//                    System.out.print("");

                }
            }
            fresh = false;

            while (end < gene.length()-1) {
                end++;
                int index = getIndex(gene.charAt(end));
                if (eachCount[index] > eachLen) {
                    count[index]++;
                    if (count[index] <= maxIn[index]) {
                        extra++;
                    }
                }
                if (extra == EXT) {
                    break;
                }
            }
            wid = wid < end-start+1 ? wid :end-start+1;

//            System.out.println(start+" "+end+" "+wid);
//            System.out.println(gene.substring(start,end+1));
//            System.out.print("");

        }
        return wid;
    }

    private static int[] getMaxIn(int[] eachCount, int eachLen) {
        int[] maxIn = new int[4];
        for (int i = 0; i < eachCount.length; i++) {
            if (eachCount[i] > eachLen) {
                maxIn[i] = eachCount[i] - eachLen;
            } else {
                maxIn[i] = 0;
            }
        }
        return maxIn;
    }

    private static int getExtra(int[] eachCount, int eachLen) {
        int count = 0;
        for (int i : eachCount) {
            if (i > eachLen) {
                count += (i - eachLen);
            }
        }
        return count;
    }

    private static boolean evenArray(int[] eachCount, int eachLen) {
        for (int i = 0; i < eachCount.length; i++) {
            if (eachCount[i] != eachLen) {
                return false;
            }
        }
        return true;
    }

    private static int[] getEachCount(String gene) {
        int[] eachCount = new int[4];
        for (char c : gene.toCharArray()) {
            eachCount[getIndex(c)]++;
        }
        return eachCount;
    }

    private static int getIndex(char c) {
        switch (c) {
            case 'G':
                return 0;
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'T':
                return 3;
        }
        return -1;
    }

}
