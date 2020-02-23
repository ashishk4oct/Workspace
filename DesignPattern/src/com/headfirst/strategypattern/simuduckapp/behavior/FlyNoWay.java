package com.headfirst.strategypattern.simuduckapp.behavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Fly No Way...!");
    }
}
