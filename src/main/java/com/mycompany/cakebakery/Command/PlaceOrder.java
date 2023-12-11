package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.CakeOrder;

public class PlaceOrder implements Command{
    
    private CakeOrder order;
    
    public PlaceOrder(CakeOrder order){
        this.order = order;
    }

    @Override
    public void execute() {
        this.order.placeOrder();
    }
    
}
