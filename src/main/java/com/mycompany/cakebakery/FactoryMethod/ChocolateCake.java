package com.mycompany.cakebakery.FactoryMethod;


import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Cake;

public class ChocolateCake extends Cake {
    public ChocolateCake() {
        super("Chocolate", 20.00, DirConstant.BAKED_CAKE_PATH + "/chocolate-baked-cake.png","Baked Cake");
    }

    public Cake copy() {
        Cake newCake = new ChocolateCake();
        return newCake;
    }
}