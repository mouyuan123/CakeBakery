package com.mycompany.cakebakery.Models;

public class Budget {
    
    private volatile static Budget uniqueBudgetInstance;
    
    private double budget;
    
    private Budget(){
        this.budget = 0.0;
    }
    
    public static Budget getBudgetInstance(){
        if (uniqueBudgetInstance == null) {
            synchronized(Budget.class) {
                if (uniqueBudgetInstance == null) {
                    uniqueBudgetInstance = new Budget();
                }
            }
        }
        return uniqueBudgetInstance;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
    
    public void topUp(double amount){
        this.budget = budget + amount;
    }
    
    public boolean spend(double amount){
        if(this.isBudgetEnough(amount)){
            this.budget -= amount;
            return true;
        }
        else return false;
    }
    
    private boolean isBudgetEnough(double amountToPay){
        return amountToPay <= this.budget;
    }
}
