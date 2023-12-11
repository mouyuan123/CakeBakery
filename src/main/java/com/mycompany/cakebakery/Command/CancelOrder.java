package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.CakeOrder;

public class CancelOrder implements Command{
    
    private CakeOrder order;
    
    public CancelOrder(CakeOrder order){
        this.order = order;
    }

    @Override
    public void execute() {
        this.order.cancelOrder();
        this.order = null;
    }
    
}
