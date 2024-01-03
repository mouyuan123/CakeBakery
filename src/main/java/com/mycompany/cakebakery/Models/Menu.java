package com.mycompany.cakebakery.Models;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.cakebakery.FactoryMethod.*;
import com.mycompany.cakebakery.Decorator.Chocolate;
import com.mycompany.cakebakery.Decorator.Macaroon;
import com.mycompany.cakebakery.Decorator.Strawberry;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class Menu {
    
    private volatile static Menu uniqueMenuInstance;

    private List<Cake> bakedCakes;

    private List<Cake> crepeCakes;

    private List<Condiment> condiments;

    private Menu() {
        this.bakedCakes = new ArrayList<>();
        this.crepeCakes = new ArrayList<>();
        this.condiments = new ArrayList<>();
        // Set up the menu for different base cakes
        this.bakedCakes.add(new MatchaCake());
        this.bakedCakes.add(new ChocolateCake());
        this.bakedCakes.add(new TiramisuCake());
        this.bakedCakes.add(new VanillaCake());
        this.bakedCakes.add(new RedVelvetCake());
        this.crepeCakes.add(new MatchaCrepeCake());
        this.crepeCakes.add(new ChocolateCrepeCake());
        this.crepeCakes.add(new TiramisuCrepeCake());
        this.crepeCakes.add(new VanillaCrepeCake());
        this.crepeCakes.add(new RedVelvetCrepeCake());
        this.condiments.add(new Chocolate());
        this.condiments.add(new Macaroon());
        this.condiments.add(new Strawberry());
    }
    
    public static Menu getMenuInstance(){
        if (uniqueMenuInstance == null) {
            synchronized(Menu.class) {
                if (uniqueMenuInstance == null) {
                    uniqueMenuInstance = new Menu();
                }
            }
        }
        return uniqueMenuInstance;
    }

    public List<Cake> getBakedCakes() {
        return bakedCakes;
    }
    
    public List<Cake> getCrepeCakes() {
        return crepeCakes;
    }


    public List<Condiment> getCondiments() {
        return condiments;
    }
}
