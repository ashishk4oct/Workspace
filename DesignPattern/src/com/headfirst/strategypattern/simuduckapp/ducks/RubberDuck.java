package com.headfirst.strategypattern.simuduckapp.ducks;

import com.headfirst.strategypattern.simuduckapp.behavior.FlyNoWay;
import com.headfirst.strategypattern.simuduckapp.behavior.Squeak;

public class RubberDuck extends Duck {

    public RubberDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Squeak());
    }

    @Override
    public void display() {
        System.out.println("Ribber Duck");
    }

}
