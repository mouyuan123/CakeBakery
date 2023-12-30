package com.mycompany.cakebakery.Models;

import com.mycompany.cakebakery.Constants.DirConstant;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.cakebakery.FactoryMethod.*;
import com.mycompany.cakebakery.SimpleFactory.Chocolate;
import com.mycompany.cakebakery.SimpleFactory.Macaroon;
import com.mycompany.cakebakery.SimpleFactory.Strawberry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class Menu {
    
    private volatile static Menu uniqueMenuInstance;

    private List<Cake> bakedCakes;

    private List<Cake> crepeCakes;

    private List<Condiment> condiments;
    private static TableView table;

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

    public void getBakedCakes(List<Cake> cakes) {
        this.bakedCakes = bakedCakes;
    }

    public List<Cake> getCrepeCakes() {
        return crepeCakes;
    }

    public void getCrepeCakes(List<Cake> cakes) {
        this.crepeCakes = crepeCakes;
    }

    public List<Condiment> getCondiments() {
        return condiments;
    }

    public void getCondiments(List<Condiment> condiments) {
        this.condiments = condiments;
    }

    public TableView<Cake> getTable() {
        return table;
    }

    public void setTable(TableView table) {
        Menu.table = table;
    }
    
//    public ObservableList<Cake> getObservableListMenu(){
//        return FXCollections.observableList(getCakes());
//    }
    
    
    public void generateTableView(){
        TableView tableView = new TableView();
        TableColumn<Cake, String> flavour = new TableColumn<>("Flavour");
        TableColumn<Cake, Double> price = new TableColumn<>("Price");
        tableView.getColumns().addAll(flavour,price);

        flavour.setCellValueFactory(new PropertyValueFactory<>("flavour"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
//        ObservableList<Cake> menuItems = getObservableListMenu();
        System.out.println(getBakedCakes().get(0));
        System.out.println(getCrepeCakes().get(0));
//        tableView.setItems(menuItems);
        setTable(tableView);
    }
}
