package com.mycompany.cakebakery.Facade;

import com.mycompany.cakebakery.FactoryMethod.BakedCakeFactory;
import com.mycompany.cakebakery.FactoryMethod.CrepeCakeFactory;
import com.mycompany.cakebakery.Models.Budget;
import com.mycompany.cakebakery.Models.CakeBakery;

public class CakeBakeryFacade {
    
    private CakeBakery cakeBakery;
    private CrepeCakeFactory crepeCakeFactory;
    private BakedCakeFactory bakedCakeFactory;
    private Budget budget;
    private String message;

    public CakeBakeryFacade(CakeBakery cafeBakery, Budget budget, CrepeCakeFactory crepeCakeFactory, BakedCakeFactory bakedCakeFactory) {
        this.cakeBakery = cafeBakery;
        this.budget = budget;
        this.crepeCakeFactory = crepeCakeFactory;
        this.bakedCakeFactory = bakedCakeFactory;
    }
    
    public boolean onOpen(){
        this.cakeBakery.getLight().on();
        this.cakeBakery.getMusic().on();
        return true;
    }
    
    public boolean onClose(){
        this.cakeBakery.getLight().off();
        this.cakeBakery.getMusic().off();
        return true;
    }
    
    public boolean orderCake(){
        return true;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
