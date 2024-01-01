package com.mycompany.cakebakery.Models;

public class Condiment extends CakeItem {
    CakeItem cakeItem;
    public Condiment(String condimentName, double price, String condimentImg) {
        this.cakeItemName = condimentName;
        this.cakeItemPrice = price;
        this.cakeItemImg = condimentImg;
    }

}
