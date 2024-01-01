package com.mycompany.cakebakery.Decorator;

import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.CakeItem;
import com.mycompany.cakebakery.Models.Condiment;

public class ChocolateCondiment extends Condiment {

    public ChocolateCondiment(CakeItem cakeItem) {
        super(cakeItem.getCakeItemName() + "Chocolate", cakeItem.getCakeItemPrice() + 5.0, DirConstant.CONDIMENTS_PATH + "/chocolates.jpg");
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
