package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.CakeOrder;

public class CancelOrderCommand implements Command{
    
    private CakeOrder order;
    
    public CancelOrderCommand(CakeOrder order){
        this.order = order;
    }

    @Override
    public void execute() {
        this.order.cancelOrder();
        this.order = null;
    }
    
}
