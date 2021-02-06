package com.interview.test1;

public class Test1 {

    public static void main(String[] args) {

        System.out.print(BRule("a+(b - c) - (d - e) - (f+g)+ (h+i)"));
    }


    public static String BRule(String str) {
        // code goes here
        for(int i = 0; i  < str.length(); i++){
            if(str.charAt(i) == ' '){
                str = delete(str, i);
            }
        }

        for(int i = 0; i  < str.length(); i++){
            if(str.charAt(i) == '('){
                str = solve(str, i);
            }
        }

        return str;
    }

    private static String delete(String str , int i ){
        return str.substring(0,i)+str.substring(i+1);
    }
    private static String insert(String str , int i, char c){
        return str.substring(0,i)+c+str.substring(i);
    }

    private static String solve(String str, int index){

        for(int i = index+1; i  < str.length(); i++){
            if(str.charAt(i) == ')'){
                return resolveSign(str, index, i);
            }
            if(str.charAt(i) == '('){
                str = solve(str, i);
            }
        }

        throw new RuntimeException("Closing brases not found");
    }

    private static String resolveSign(String str , int i, int j){
        boolean positive = true;
        if(i != 0){
            if(str.charAt(i-1) == '-'){
                positive = false;
            }
        }

        if(!positive){
            if(str.charAt(i+1) == '-'){
                str = delete(str, i+1);
                str = insert(str, i+1, '+');
            }else if(str.charAt(i+1) == '+'){
                str = delete(str, i+1);
                str = insert(str, i+1, '-');
            }
            for(int index = i+2; index < j ; index++){
                if(str.charAt(index) == '-'){
                    str = delete(str, index);
                    str = insert(str, index, '+');
                }else if(str.charAt(index) == '+'){
                    str = delete(str, index);
                    str = insert(str, index, '-');
                }
            }
        }

        str = delete(str, i);
        str = delete(str, j-1);
        return str;
    }
}
