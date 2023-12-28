package com.mycompany.cakebakery.FactoryMethod;

import com.mycompany.cakebakery.Models.Condiment;

import java.util.ArrayList;

public abstract class Cake {
    
    private String flavour;
    private double price;
    private String cakeImg;
    ArrayList<Condiment> condiments = new ArrayList<Condiment>();


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

    void prepare(){
        System.out.println("Prepare " + flavour);
        System.out.println("Prepare Batter...");

    };

    void bake(){
        System.out.println("Baking the cake...");
    };
    void prepareCakeComponents(){
        System.out.println("Prepare cake components...");
    };
    void assemble(){
        System.out.println("Assembling the cake...");
    };
    void decorate(){
        System.out.println("Adding condiments: ");
        for (Condiment condiment : condiments) {
            System.out.println("   " + condiment.getCondimentName());
        }
    };
    void chill(){
        System.out.println("Chilling the cake...");
    };
    void box(){
        System.out.println("Box the cake...");
    };

    
    
}
