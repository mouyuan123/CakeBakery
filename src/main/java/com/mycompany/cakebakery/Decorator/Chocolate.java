package com.mycompany.cakebakery.Decorator;

import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Condiment;

public class Chocolate extends Condiment {
    public Chocolate() {
        super("Chocolate",5.00, DirConstant.CONDIMENTS_PATH + "/chocolates.png");
    }
    public Condiment copy() {
        Condiment newCondiment = new Chocolate();
        return newCondiment;
    }
}
