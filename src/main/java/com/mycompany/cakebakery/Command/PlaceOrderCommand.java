package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.CakeOrder;

public class PlaceOrderCommand implements Command{
    
    private CakeOrder order;
    
    public PlaceOrderCommand(CakeOrder order){
        this.order = order;
    }

    @Override
    public void execute() {
        this.order.placeOrder();
    }
    
}
