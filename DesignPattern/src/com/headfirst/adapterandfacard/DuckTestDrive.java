package com.headfirst.adapterandfacard;


public class DuckTestDrive {

    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();

        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says:");
        turkey.fly();
        turkey.gobble();

        System.out.println("The Duck says:");
        test(mallardDuck);

        System.out.println("The Turkeyadapter says:");
        test(turkeyAdapter);
    }

    private static void test(Duck duck) {
        duck.fly();
        duck.quack();
    }


}
