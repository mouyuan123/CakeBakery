package com.mycompany.cakebakery.FactoryMethod;

import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Cake;

public class TiramisuCake extends Cake {
    public TiramisuCake() {
        super("Tiramisu", 25.00, DirConstant.BAKED_CAKE_PATH + "/tiramisu-baked-cake.png","Baked Cake");
    }
    public Cake copy() {
        Cake newCake = new TiramisuCake();
        return newCake;
    }
}
