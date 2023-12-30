package com.mycompany.cakebakery.FactoryMethod;


import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Cake;

public class VanillaCake extends Cake {
    public VanillaCake() {
        super("Vanilla", 27.0, DirConstant.BAKED_CAKE_PATH + "/vanilla-baked-cake.png","Baked Cake");
    }
}
