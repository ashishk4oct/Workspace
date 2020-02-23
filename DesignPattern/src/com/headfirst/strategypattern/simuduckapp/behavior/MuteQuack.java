package com.headfirst.strategypattern.simuduckapp.behavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Mute Quack...");
    }
}
