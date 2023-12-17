package com.mycompany.cakebakery.Models;

public class Cake {
    
    private String flavour;
    private double price;
    private String cakeImg;

    public Cake(String flavour, double price, String cakeImg) {
        this.flavour = flavour;
        this.price = price;
        this.cakeImg = cakeImg;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCakeImg() {
        return cakeImg;
    }

    public void setCakeImg(String cakeImg) {
        this.cakeImg = cakeImg;
    }
    
    
}
