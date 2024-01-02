package com.mycompany.cakebakery.SimpleFactory;

import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Condiment;

public class Strawberry extends Condiment {
    public Strawberry() {
        super("Strawberry",9.00, DirConstant.CONDIMENTS_PATH + "/strawberries.png");
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
        Condiment newCondiment = new Strawberry();
//        newCondiment.setCakeItem(this.cakeItem);
        return newCondiment;
    }
}
