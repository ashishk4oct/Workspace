package com.interview.ihs;

public class Problem2 {

    public static void main(String[] args) {
        C c = new D();
        System.out.println(c.x);
    }
}
class C{
    int x = 2;
    C(){
        process(3);
    }
    public void process(int i){
        x += i;
    }
}
class D extends C{
    D(){
        process(3);
    }
    public void process(int i){
        x *= i;
    }
}