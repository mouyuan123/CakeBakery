package com.mycompany.cakebakery.Models;

public abstract class Condiment extends CakeItem {
    public CakeItem cakeItem;

    public Condiment(String condimentName, double price, String condimentImg) {
        this.cakeItemName = condimentName;
        this.cakeItemPrice = price;
        this.cakeItemImg = condimentImg;
    }

    public CakeItem getCakeItem() {
        return cakeItem;
    }

    public void setCakeItem(CakeItem cakeItem) {
        this.cakeItem = cakeItem;
    }

    public double getCakeItemPrice() {
        if (cakeItem == null) {
            return this.cakeItemPrice;
        }
        return this.cakeItemPrice + this.cakeItem.getCakeItemPrice();
    }


    public abstract Condiment copy();
}
