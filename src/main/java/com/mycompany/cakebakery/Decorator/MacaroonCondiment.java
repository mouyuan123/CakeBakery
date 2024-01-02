package com.mycompany.cakebakery.Decorator;

import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.CakeItem;
import com.mycompany.cakebakery.Models.Condiment;

public class MacaroonCondiment extends Condiment {

    public MacaroonCondiment(CakeItem cakeItem) {
        super(cakeItem.getCakeItemName() + "Macaroon", cakeItem.getCakeItemPrice() + 8.0, DirConstant.CONDIMENTS_PATH + "/macron.jpg");
    }

    @Override
    public String getCakeItemName() {
        return super.getCakeItemName();
    }

    @Override
    public double getCakeItemPrice() {
        return super.getCakeItemPrice();
    }

    @Override
    public String getCakeItemImg() {
        return super.getCakeItemImg();
    }
}
