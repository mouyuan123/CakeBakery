package com.mycompany.cakebakery.Facade;

import com.mycompany.cakebakery.FactoryMethod.BakedCakeFactory;
import com.mycompany.cakebakery.FactoryMethod.CakeFactory;
import com.mycompany.cakebakery.FactoryMethod.CrepeCakeFactory;
import com.mycompany.cakebakery.Models.Budget;
import com.mycompany.cakebakery.Models.Cake;
import com.mycompany.cakebakery.Models.CakeBakery;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class CakeBakeryFacade {
    
    private CakeBakery cakeBakery;
    private CakeFactory cakeFactory;
    private Budget budget;
    private String title;
    private String message;

    public CakeBakeryFacade(CakeBakery cafeBakery, Budget budget) {
        this.cakeBakery = cafeBakery;
        this.budget = budget;
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
    
    public boolean processTopUp(String topUpAmount){
        try{
            double amount = Double.parseDouble(topUpAmount);
            if (amount <= 0) {
                this.setTitle("Invalid Amount");
                this.setMessage("Please enter a valid number.");
                return false;
            }
            this.budget.topUp(amount);
            return true;
        }catch(NumberFormatException e){
            this.setTitle("Invalid Input");
            this.setMessage("Please enter a valid number.");
            return false;
        }
    }
    
    public boolean processPayment(double totalCost){
        if(this.budget.getBudget() < totalCost){
            this.setTitle("Insufficient Budget");
            this.setMessage("Your current budget is insufficient. Please Top Up.");
            return false;
        }
        else{
            this.budget.spend(totalCost);
            return true;
        }
    }
    
    public boolean processCake(Cake choosedCake, ImageView imgFactoryProcess, Label labelFactoryProcess, ArrayList<String> choosedCondimentNameList, ArrayList<ImageView> choosedCondimentImageViewList, ImageView imgFinalCake, AnchorPane apFinalCakeItem, GridPane gpFactoryProcess, StackPane spMain){
       if (choosedCake.getCakeType().equals("Crepe Cake")) {
           this.cakeFactory = new CrepeCakeFactory();
           this.cakeFactory.orderCake(choosedCake.getCakeItemName().toLowerCase(), imgFactoryProcess, labelFactoryProcess, choosedCondimentNameList, choosedCondimentImageViewList, imgFinalCake, apFinalCakeItem, gpFactoryProcess, spMain);
        } else if (choosedCake.getCakeType().equals("Baked Cake")) {
            this.cakeFactory = new BakedCakeFactory();
            this.cakeFactory.orderCake(choosedCake.getCakeItemName().toLowerCase(), imgFactoryProcess, labelFactoryProcess, choosedCondimentNameList, choosedCondimentImageViewList, imgFinalCake, apFinalCakeItem, gpFactoryProcess, spMain);
        }
       return true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
