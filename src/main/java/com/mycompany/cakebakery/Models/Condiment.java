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

    @Override
    public double getCakeItemPrice(){
        if(cakeItem != null)    {
            setCakeItemPrice(cakeItemPrice + cakeItem.cakeItemPrice);
            return cakeItemPrice;}
        return cakeItemPrice;
    }

    public Condiment copy() {
        Condiment newCondiment = new Condiment(this.getCakeItemName(),this.getCakeItemPrice(),this.getCakeItemImg());
        if(this.cakeItem != null){
            newCondiment.setCakeItem(this.cakeItem);
        }
        return newCondiment;
    }
}
