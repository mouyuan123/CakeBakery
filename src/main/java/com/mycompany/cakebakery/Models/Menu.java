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
    
    private List<Cake> cakes;
    private static TableView table;

    private Menu() {
        this.cakes = new ArrayList<>();
        // Set up the menu for different base cakes
        this.cakes.add(new Cake("Matcha", 30.00, DirConstant.CAKE_PATH + "/matcha.png"));
        this.cakes.add(new Cake("Chocolate", 20.00, "2"));
        this.cakes.add(new Cake("Tiramisu", 25.00, "3"));
        this.cakes.add(new Cake("Oolong", 27.00, "4"));
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

    public List<Cake> getCakes() {
        return cakes;
    }

    public void setCakes(List<Cake> cakes) {
        this.cakes = cakes;
    }

    public TableView<Cake> getTable() {
        return table;
    }

    public void setTable(TableView table) {
        Menu.table = table;
    }
    
    public ObservableList<Cake> getObservableListMenu(){
        return FXCollections.observableList(getCakes());
    }
    
    
    public void generateTableView(){
        TableView tableView = new TableView();
        TableColumn<Cake, String> flavour = new TableColumn<>("Flavour");
        TableColumn<Cake, Double> price = new TableColumn<>("Price");
        tableView.getColumns().addAll(flavour,price);

        flavour.setCellValueFactory(new PropertyValueFactory<>("flavour"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        ObservableList<Cake> menuItems = getObservableListMenu();
        System.out.println(getCakes().get(0));
        tableView.setItems(menuItems);
        setTable(tableView);
    }
}
