package com.mycompany.cakebakery.FactoryMethod;


import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Cake;

public class MatchaCake extends Cake {
    public MatchaCake() {
        super("Matcha", 30.00, DirConstant.BAKED_CAKE_PATH+ "/matcha-baked-cake.png", "Baked Cake");
    }
}
