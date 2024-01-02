package com.mycompany.cakebakery.FactoryMethod;


import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Cake;

public class RedVelvetCrepeCake extends Cake {
    public RedVelvetCrepeCake() {
        super("Red Velvet", 37.00, DirConstant.CREPE_CAKE_PATH + "/red-velvet-crepe-cake.png","Crepe Cake");
    }

    public Cake copy() {
        Cake newCake = new RedVelvetCrepeCake();
        return newCake;
    }
}