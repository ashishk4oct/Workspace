package com.headfirst.commandpattern;

public class NoCommand implements Command {

    @Override
    public void execute() {
        System.out.println("NoCommand");
    }
}
