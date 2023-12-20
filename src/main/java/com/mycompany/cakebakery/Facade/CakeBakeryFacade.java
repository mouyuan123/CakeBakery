package com.mycompany.cakebakery.Facade;

import com.mycompany.cakebakery.Command.CancelOrderCommand;
import com.mycompany.cakebakery.Command.OrderInvoker;
import com.mycompany.cakebakery.Command.PlaceOrderCommand;
import com.mycompany.cakebakery.Models.Budget;
import com.mycompany.cakebakery.Models.Cake;
import com.mycompany.cakebakery.Models.CakeBakery;
import com.mycompany.cakebakery.Models.CakeOrder;

public class CakeBakeryFacade {
    
    private CakeBakery cakeBakery;
    private Budget budget;
    private OrderInvoker waiter;
    private String message;

    public CakeBakeryFacade(CakeBakery cafeBakery, Budget budget, OrderInvoker waiter) {
        this.cakeBakery = cafeBakery;
        this.budget = budget;
        this.waiter = waiter;
    }
    
    public boolean onOpen(){
        this.cakeBakery.getLight().on();
        this.cakeBakery.getMusic().on();
        return true;
    }
    
    public boolean onClose(){
        this.cakeBakery.getLight().off();
        this.cakeBakery.getMusic().off();
        return true;
    }
    
    public boolean placeNewOrder(Cake selected){
        if(budget.spend(selected.getPrice())){
            CakeOrder cake = new CakeOrder(selected);
            PlaceOrderCommand orderCommand = new PlaceOrderCommand(cake);
            CancelOrderCommand cancelCommand = new CancelOrderCommand(cake);
            this.waiter.setCommand(orderCommand, cancelCommand);
            this.waiter.onOrderPlaced();
            return true;
        }
        else{
            this.message = "Not enough budget. Please top up";
            return false;
        }
    }
    
    public boolean cancelCurrentOrder(){
        this.waiter.onOrderCancel();
        return true;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
