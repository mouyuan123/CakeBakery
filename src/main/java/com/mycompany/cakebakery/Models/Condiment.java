package com.mycompany.cakebakery.Models;

import javafx.scene.control.Label;

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

    public void add(Label label) {
        System.out.println(this.cakeItemName);
        label.setText("Adding " + this.cakeItemName + "...");
    }

    public abstract Condiment copy();
}
