package com.interview.ihs;

public class Problem1 {

    public static void main(String[] args) {
        A a = new B();
        a.process(null);
        a.process("");
        a.process(new Object());
    }
}
class A{
    public void process(Object o){
        System.out.println("Object");
    }
}
class B extends A{
    public void process(String s){
        System.out.println("String");
    }
}
