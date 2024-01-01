package com.mycompany.cakebakery.Models;

public abstract class CakeItem {
    protected String cakeItemName;
    protected double cakeItemPrice;
    protected String cakeItemImg;

    public String getCakeItemName() {
        return cakeItemName;
    }

    public void setCakeItemName(String cakeItemName) {
        this.cakeItemName = cakeItemName;
    }

    public double getCakeItemPrice() {
        return cakeItemPrice;
    }

    public void setCakeItemPrice(double cakeItemPrice) {
        this.cakeItemPrice = cakeItemPrice;
    }

    public String getCakeItemImg() {
        return cakeItemImg;
    }

    public void setCakeItemImg(String cakeItemImg) {
        this.cakeItemImg = cakeItemImg;
    }
}
