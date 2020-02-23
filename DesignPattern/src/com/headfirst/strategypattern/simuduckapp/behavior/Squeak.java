package com.headfirst.strategypattern.simuduckapp.behavior;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeak...");
    }
}
