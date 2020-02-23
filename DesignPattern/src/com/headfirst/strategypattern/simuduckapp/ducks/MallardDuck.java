package com.headfirst.strategypattern.simuduckapp.ducks;

import com.headfirst.strategypattern.simuduckapp.behavior.FlyWithWings;
import com.headfirst.strategypattern.simuduckapp.behavior.Quack;

public class MallardDuck extends Duck {

    public MallardDuck(){
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }
    @Override
    public void display() {
        System.out.println("Mallard Duck");
    }

}
