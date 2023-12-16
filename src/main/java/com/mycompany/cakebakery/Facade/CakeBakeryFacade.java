package com.mycompany.cakebakery.Facade;

import com.mycompany.cakebakery.Models.Budget;
import com.mycompany.cakebakery.Models.CakeBakery;

public class CakeBakeryFacade {
    
    private CakeBakery cakeBakery;
    private Budget budget;

    public CakeBakeryFacade(CakeBakery cafeBakery, Budget budget) {
        this.cakeBakery = cafeBakery;
        this.budget = budget;
    }
    
    public boolean onOpen(){
        this.cakeBakery.getLight().on();
        this.cakeBakery.getMusic().on();
        budget.setBudget(0);
        return true;
    }
    
    public boolean onClose(){
        this.cakeBakery.getLight().off();
        this.cakeBakery.getMusic().off();
        return true;
    }
    
}
