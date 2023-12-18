package com.mycompany.cakebakery.Models;

public class CakeOrder {
    
    private Cake cake;

    public CakeOrder(Cake cake) {
        this.cake = cake;
    }
    
    public void placeOrder(){
        System.out.println("Your order: " + this.cake.getFlavour());
    }
    
    public void cancelOrder(){
        System.out.println("Your order: " + this.cake.getFlavour() + " is cancelled");
        this.cake = null;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }
}
