package com.mycompany.cakebakery.Models;

import com.mycompany.cakebakery.Constants.DirConstant;
import java.util.ArrayList;
import java.util.List;
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
        this.bakedCakes.add(new Cake("Matcha", 30.00, DirConstant.BAKED_CAKE_PATH+ "/matcha-baked-cake.png","Baked Cake"));
        this.bakedCakes.add(new Cake("Chocolate", 20.00, DirConstant.BAKED_CAKE_PATH + "/chocolate-baked-cake.png","Baked Cake"));
        this.bakedCakes.add(new Cake("Tiramisu", 25.00, DirConstant.BAKED_CAKE_PATH + "/tiramisu-baked-cake.png","Baked Cake"));
        this.bakedCakes.add(new Cake("Vanilla", 27.00, DirConstant.BAKED_CAKE_PATH + "/vanilla-baked-cake.png","Baked Cake"));
        this.bakedCakes.add(new Cake("Red Velvet", 27.00, DirConstant.BAKED_CAKE_PATH + "/red-velvet-baked-cake.png","Baked Cake"));
        this.crepeCakes.add(new Cake("Matcha", 40.00, DirConstant.CREPE_CAKE_PATH+ "/matcha-crepe-cake.png","Crepe Cake"));
        this.crepeCakes.add(new Cake("Chocolate", 30.00, DirConstant.CREPE_CAKE_PATH + "/chocolate-crepe-cake.png","Crepe Cake"));
        this.crepeCakes.add(new Cake("Tiramisu", 35.00, DirConstant.CREPE_CAKE_PATH + "/tiramisu-crepe-cake.png","Crepe Cake"));
        this.crepeCakes.add(new Cake("Vanilla", 37.00, DirConstant.CREPE_CAKE_PATH + "/vanilla-crepe-cake.png","Crepe Cake"));
        this.crepeCakes.add(new Cake("Red Velvet", 37.00, DirConstant.CREPE_CAKE_PATH + "/red-velvet-crepe-cake.png","Crepe Cake"));
        this.condiments.add(new Condiment("Chocolate",5.00,DirConstant.CONDIMENTS_PATH + "/chocolates.png"));
        this.condiments.add(new Condiment("Macaroon",8.00,DirConstant.CONDIMENTS_PATH + "/macron.png"));
        this.condiments.add(new Condiment("Strawberry",9.00,DirConstant.CONDIMENTS_PATH + "/strawberries.png"));
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
