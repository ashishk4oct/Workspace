package com.headfirst.commandpattern;

public class RemoteControl {

    Command [] onCommand;
    Command [] offCommand;

    public RemoteControl(){
        this.onCommand = new Command[7];
        this.offCommand = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            this.onCommand[i] = noCommand;
            this.offCommand[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand,Command offCommand){
        this.onCommand[slot] = onCommand;
        this.offCommand[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot){
        onCommand[slot].execute();
    }
    public void offButtonWasPressed(int slot){
        offCommand[slot].execute();
    }

}
