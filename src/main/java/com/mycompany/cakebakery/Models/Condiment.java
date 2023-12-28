package com.mycompany.cakebakery.Models;

public class Condiment {

    private String condimentName;
    private double price;
    private String condimentImg;

    public Condiment(String condimentName, double price, String condimentImg) {
        this.condimentName = condimentName;
        this.price = price;
        this.condimentImg = condimentImg;
    }


    public String getCondimentName() {
        return condimentName;
    }

    public void setCondimentName(String condimentName) {
        this.condimentName = condimentName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCondimentImg() {
        return condimentImg;
    }

    public void setCondimentImg(String condimentImg) {
        this.condimentImg = condimentImg;
    }
}
