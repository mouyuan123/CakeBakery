package com.mycompany.cakebakery.SimpleFactory;

import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Condiment;

public class Macaroon extends Condiment {
    public Macaroon() {
        super("Macaroon",8.00, DirConstant.CONDIMENTS_PATH + "/macron.png");
    }

}
