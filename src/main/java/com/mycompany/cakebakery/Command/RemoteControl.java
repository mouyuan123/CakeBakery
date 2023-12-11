package com.mycompany.cakebakery.Command;

public class RemoteControl {
    
    // -> On Light, On Music, Swap Previous Music 
    private Command[] leftCommand;
    // -> Off Light, Off Music, Swap Next Music
    private Command[] rightCommand;
    
    public RemoteControl(){
        // Total 6 commands (2 receivers: Light, Music)
        this.leftCommand = new Command[3];
        this.rightCommand = new Command[3];
        
        Command noCommand = new NoCommand();
        for(int i = 0; i < leftCommand.length; i++){
            this.leftCommand[i] = noCommand;
            this.rightCommand[i] = noCommand;
        }
    }
    
    public void setCommand(int slot, Command leftCommand, Command rightCommand){
        this.leftCommand[slot] = leftCommand;
        this.rightCommand[slot] = rightCommand;
    }
    
    public void leftButtonPressed(int slot){
        this.leftCommand[slot].execute();
    }
    
    public void rightButtonPressed(int slot){
        this.rightCommand[slot].execute();
    }
}
