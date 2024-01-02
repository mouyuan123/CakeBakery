package com.mycompany.cakebakery.SimpleFactory;

import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Condiment;

public class Chocolate extends Condiment {
    public Chocolate() {
        super("Chocolate",5.00, DirConstant.CONDIMENTS_PATH + "/chocolates.png");
    }
    @Override
    public double getCakeItemPrice(){
        if(cakeItem == null){
            return this.cakeItemPrice;
        }
        System.out.println(this.getCakeItem().getCakeItemName());
        return this.cakeItemPrice + this.cakeItem.getCakeItemPrice();
    }

    public Condiment copy() {
        Condiment newCondiment = new Chocolate();
//        newCondiment.setCakeItem(this.cakeItem);
        return newCondiment;
    }
}
