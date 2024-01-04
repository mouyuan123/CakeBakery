package com.mycompany.cakebakery.Decorator;

import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Condiment;

public class Strawberry extends Condiment {
    public Strawberry() {
        super("Strawberry",9.00, DirConstant.CONDIMENTS_PATH + "/strawberries.png");
    }

    public Condiment copy() {
        Condiment newCondiment = new Strawberry();
        return newCondiment;
    }
}
