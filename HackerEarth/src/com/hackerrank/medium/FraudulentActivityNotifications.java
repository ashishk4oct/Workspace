package com.hackerrank.medium;

public class FraudulentActivityNotifications {

    public static void main(String[] args) {
//        System.out.println(getNthNumber(new int[]{1,0,3,1,5}, 1));
//        System.out.println(getNthNumber(new int[]{1,0,3,1,5}, 2));
//
//        System.out.println(getMedian(new int[]{1,0,3,1,5}, 3));
//        System.out.println(getMedian(new int[]{1,0,3,1,5}, 1,0, 3));

        System.out.println(activityNotifications(new int[]{1, 2, 3, 4, 4}, 4));
    }
    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int [] medianArr = fillMedianArray(expenditure,d);

        double median = getMedian(medianArr, d);
        int exceptionCount = 0;

        for (int i = d; i < expenditure.length ; i++) {
            if(expenditure[i] >= 2*median){
                exceptionCount++;
            }
            median = getMedian(medianArr, expenditure[i], expenditure[i-d],d);
        }

        return exceptionCount;
    }

    private static double getMedian(int[] medianArr, int add, int remove , int d) {
        medianArr[add]++;
        medianArr[remove]--;
        return getMedian(medianArr,d);
    }

    private static double getMedian(int[] medianArr, int d) {
        if(d%2 == 0){
            return (getNthNumber(medianArr,d/2)+getNthNumber(medianArr,(d/2)+1))/2.0;
        }else{
            return getNthNumber(medianArr,(d/2)+1);
        }
    }

    private static int getNthNumber(int[] medianArr, int n) {
        int count = 0;
        int i = 0;
        while(count < n){
            count = medianArr[i++] + count;
        }
        return i-1;
    }

    private static int[] fillMedianArray(int[] expenditure, int d) {
        int medianArr[] = new int[201];
        for (int i = 0; i < d; i++) {
            medianArr[expenditure[i]] += 1;
        }
        return medianArr;
    }


}
