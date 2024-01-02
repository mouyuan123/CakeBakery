package com.mycompany.cakebakery.FactoryMethod;


import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Cake;

public class ChocolateCrepeCake extends Cake {
    public ChocolateCrepeCake() {
        super("Chocolate", 30.00, DirConstant.CREPE_CAKE_PATH + "/chocolate-crepe-cake.png","Crepe Cake");
    }

    public Cake copy() {
        Cake newCake = new ChocolateCrepeCake();
        return newCake;
    }
}