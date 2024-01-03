package com.mycompany.cakebakery.SimpleFactory;

import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Condiment;

public class Macaroon extends Condiment {
    public Macaroon() {
        super("Macaroon",8.00, DirConstant.CONDIMENTS_PATH + "/macron.png");
    }
//    @Override
//    public double getCakeItemPrice(){
//        if(cakeItem == null){
//        return this.cakeItemPrice;
//        }
//        System.out.println(this.getCakeItem().getCakeItemName());
//        return this.cakeItemPrice + this.cakeItem.getCakeItemPrice();
//    }
    public Condiment copy() {
        Condiment newCondiment = new Macaroon();
        return newCondiment;
    }
}
