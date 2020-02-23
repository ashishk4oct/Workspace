package com.headfirst.strategypattern.simuduckapp.ducks;

import com.headfirst.strategypattern.simuduckapp.behavior.FlyNoWay;
import com.headfirst.strategypattern.simuduckapp.behavior.MuteQuack;

public class DecoyDuck extends Duck {

    public DecoyDuck(){
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("Decoy Duck");
    }


}
