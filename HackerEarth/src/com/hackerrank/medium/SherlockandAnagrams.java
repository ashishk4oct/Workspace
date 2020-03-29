package com.hackerrank.medium;

public class SherlockandAnagrams {
    public static void main(String[] args) {
        System.out.println(anagram("abcda"));
    }
    static int sherlockAndAnagrams(String s) {

        return anagram(s);

    }
    static int anagram(String s){
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                int size = j-i+1;
                int arr1[] = new int[27];
                for (int k = i; k < i+size; k++) {
                    int index = s.charAt(k)-'a';
                    arr1[index]++;
                }
                for(int k = i+1; k <= s.length()-size ; k++){
                    int arr2 [] = new int[27];
                    for(int l = k; l < k+size ; l++){
                        int index = s.charAt(l)-'a';
                        arr2[index]++;
                    }
                    if(equal(arr1, arr2)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static boolean equal(int arr1[], int arr2 []){
        for(int i = 0; i < arr1.length ; i++){
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

}
