package com.headfirst.strategypattern.simuduckapp.behavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack...");
    }
}
