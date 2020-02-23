package com.headfirst.strategypattern.simuduckapp.ducks;

import com.headfirst.strategypattern.simuduckapp.behavior.FlyWithWings;
import com.headfirst.strategypattern.simuduckapp.behavior.Quack;

public class RedHeadDuck extends Duck {

    public RedHeadDuck(){
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.println("Red Head Duck");
    }

}
