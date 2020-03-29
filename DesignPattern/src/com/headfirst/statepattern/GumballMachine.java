package com.headfirst.statepattern;

public class GumballMachine implements State {

    private final State soldOutState = new SoldOutState(this);
    private final State soldState = new SoldState(this);
    private final State hasQuarterState = new HasQuarterState(this);
    private final State noQuarterState = new NoQuarterState(this);
    private final State winnerState = new WinnerState(this);

    State state = this.getSoldOutState();

    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = getNoQuarterState();
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    @Override
    public void insertQuarter() {
        getState().insertQuarter();
    }

    @Override
    public void ejectQuarter() {
        getState().ejectQuarter();
    }

    @Override
    public void turnCrank() {
        getState().turnCrank();
    }

    @Override
    public void dispense() {
        getState().dispense();
    }
}
