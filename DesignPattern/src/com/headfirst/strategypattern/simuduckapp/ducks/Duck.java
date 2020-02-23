package com.headfirst.strategypattern.simuduckapp.ducks;

import com.headfirst.strategypattern.simuduckapp.behavior.FlyBehavior;
import com.headfirst.strategypattern.simuduckapp.behavior.QuackBehavior;

public abstract class Duck {

    private QuackBehavior quackBehavior;
    private FlyBehavior flyBehavior;

    public void swim(){
        System.out.println("Swiming...");
    }

    public abstract void display();

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performQuack(){
        this.quackBehavior.quack();
    }

    public void performFly(){
        this.flyBehavior.fly();
    }
}
