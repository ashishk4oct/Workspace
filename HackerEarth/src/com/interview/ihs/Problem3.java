package com.interview.ihs;

public class Problem3 {
    public static void main(String[] args) {
        F f = new F();
        f.process(null);
        f.process("");
        f.process(new Object());
    }
}
class E{
    public void process(Object o){
        System.out.println("Object");
    }
}
class F extends E{
    public void process(String s){
        System.out.println("String");
    }
}
