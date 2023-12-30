package com.mycompany.cakebakery.FactoryMethod;


import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Cake;

public class VanillaCrepeCake extends Cake {
    public VanillaCrepeCake() {
        super("Vanilla", 37.00, DirConstant.CREPE_CAKE_PATH + "/vanilla-crepe-cake.png","Crepe Cake");
    }
}
