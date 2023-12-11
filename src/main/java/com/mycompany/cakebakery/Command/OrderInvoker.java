package com.mycompany.cakebakery.Command;

public class OrderInvoker {
    
    private Command orderCommand;
    private Command cancelCommand;
    
    public OrderInvoker(){
        this.orderCommand = new NoCommand();
        this.cancelCommand = new NoCommand();
    }
    
    public void setCommand(Command orderCommand, Command cancelCommand){
        this.orderCommand = orderCommand;
        this.cancelCommand = cancelCommand;
    }
    
    public void onOrderPlaced(){
        this.orderCommand.execute();
    } 
    
    public void onOrderCancel(){
        this.cancelCommand.execute();
    }
}
