package com.headfirst.statepattern;

public class SoldOutState implements State {

    GumballMachine gumballMachine;
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry you eject, yo haven't inserted a quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there is no gumball!");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
