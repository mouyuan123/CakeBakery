package com.mycompany.cakebakery.FactoryMethod;

import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Cake;

public class TiramisuCrepeCake extends Cake {
    public TiramisuCrepeCake() {
        super("Tiramisu", 35.00, DirConstant.CREPE_CAKE_PATH + "/tiramisu-crepe-cake.png","Crepe Cake");
    }
    public Cake copy() {
        Cake newCake = new TiramisuCrepeCake();
        return newCake;
    }
}
