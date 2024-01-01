package com.mycompany.cakebakery.Decorator;

import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.CakeItem;
import com.mycompany.cakebakery.Models.Condiment;

public class StrawberryCondiment extends Condiment {

    public StrawberryCondiment(CakeItem cakeItem) {
        super(cakeItem.getCakeItemName() + "Strawberry", cakeItem.getCakeItemPrice() + 9.0, DirConstant.CONDIMENTS_PATH + "/strawberries.jpg");
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
