package com.mycompany.cakebakery.Models;

public class Condiment extends CakeItem {
    public CakeItem cakeItem;

    public CakeItem getCakeItem() {
        return cakeItem;
    }

    public void setCakeItem(CakeItem cakeItem) {
        this.cakeItem = cakeItem;
    }


    public Condiment(String condimentName, double price, String condimentImg) {
        this.cakeItemName = condimentName;
        this.cakeItemPrice = price;
        this.cakeItemImg = condimentImg;
    }



    public Condiment copy() {
        return null;
    }
}
