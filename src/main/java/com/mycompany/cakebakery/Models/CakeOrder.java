package com.mycompany.cakebakery.Models;


public class CakeOrder {
    
    private String name;
    
    public CakeOrder(String name){
        this.name = name;
    }
    
    public void placeOrder(){
        System.out.println("Your order: " + name);
    }
    
    public void cancelOrder(){
        System.out.println("Your order: " + name + " is cancelled");
        this.name = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  
}
