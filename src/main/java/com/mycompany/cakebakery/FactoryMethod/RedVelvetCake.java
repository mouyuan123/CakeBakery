package com.mycompany.cakebakery.FactoryMethod;


import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Cake;

public class RedVelvetCake extends Cake {
    public RedVelvetCake() {
        super("Red Velvet", 27.0, DirConstant.BAKED_CAKE_PATH + "/red-velvet-baked-cake.png", "Baked Cake");
    }
}