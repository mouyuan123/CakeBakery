package com.mycompany.cakebakery.FactoryMethod;


import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Cake;

public class MatchaCrepeCake extends Cake {
    public MatchaCrepeCake() {
        super("Matcha", 40.00, DirConstant.CREPE_CAKE_PATH+ "/matcha-crepe-cake.png","Crepe Cake");
    }

    public Cake copy() {
        Cake newCake = new MatchaCrepeCake();
        return newCake;
    }
}
