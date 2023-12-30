package com.mycompany.cakebakery.SimpleFactory;

import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Condiment;

public class Strawberry extends Condiment {
    public Strawberry() {
        super("Strawberry",9.00, DirConstant.CONDIMENTS_PATH + "/strawberries.png");
    }

}
