package com.headfirst.strategypattern.simuduckapp.behavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Flying With Wings...");
    }
}
