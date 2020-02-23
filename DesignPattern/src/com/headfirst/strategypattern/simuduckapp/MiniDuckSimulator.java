package com.headfirst.strategypattern.simuduckapp;

import com.headfirst.strategypattern.simuduckapp.behavior.Squeak;
import com.headfirst.strategypattern.simuduckapp.ducks.Duck;
import com.headfirst.strategypattern.simuduckapp.ducks.MallardDuck;

public class MiniDuckSimulator {
    public static void main(String[] args) {

        Duck mallardDuck = new MallardDuck();

        mallardDuck.performFly();
        mallardDuck.performQuack();

        mallardDuck.setQuackBehavior(new Squeak());

        mallardDuck.performQuack();
    }
}
