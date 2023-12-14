package com.mycompany.cakebakery;

import com.mycompany.cakebakery.Command.CancelOrderCommand;
import com.mycompany.cakebakery.Command.LightingOffCommand;
import com.mycompany.cakebakery.Command.LightingOnCommand;
import com.mycompany.cakebakery.Command.MusicOffCommand;
import com.mycompany.cakebakery.Command.MusicOnCommand;
import com.mycompany.cakebakery.Command.OrderInvoker;
import com.mycompany.cakebakery.Command.PlaceOrderCommand;
import com.mycompany.cakebakery.Command.RemoteControl;
import com.mycompany.cakebakery.Command.SwapNextMusicCommand;
import com.mycompany.cakebakery.Command.SwapPrevMusicCommand;
import com.mycompany.cakebakery.Models.Background;
import com.mycompany.cakebakery.Models.CakeOrder;
import com.mycompany.cakebakery.Models.Lighting;
import com.mycompany.cakebakery.Models.Music;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 * JavaFX App
 */
public class CakeBakery extends Application {

    private static Scene scene;
    // Initialise Remote Control
    RemoteControl remote;
    // Initialise a "waiter" (OrderInvoker)
    OrderInvoker waiter;

    @Override
    public void start(Stage stage) throws IOException {
        StackPane base_pane = new StackPane();
        base_pane.getChildren().add(Background.displayBakery(1000, 700));
        base_pane.getChildren().add(Background.displayBlackBackground(1000, 700, 0.4));
        base_pane.getChildren().add(Background.displayClosedSign(300, 300));
        Scene scene =new Scene(base_pane, 1000, 700);
        stage.setScene(scene);
        stage.show();
        
        // Initialise Remote Control
        remote = new RemoteControl();
        // Initialise a "waiter" (OrderInvoker)
        waiter = new OrderInvoker();
        // Initialise all the "Receiver" objects （Singleton)
        Lighting light = new Lighting();
        Music music = Music.createMusicInstance();
        // Initialise the "Command" objects
        LightingOnCommand lightOnCommand = new LightingOnCommand(light);
        LightingOffCommand lightOffCommand = new LightingOffCommand(light);
        MusicOnCommand musicOnCommand = new MusicOnCommand(music);
        MusicOffCommand musicOffCommand = new MusicOffCommand(music);
        SwapNextMusicCommand swapNextMusicCommand = new SwapNextMusicCommand(music);
        SwapPrevMusicCommand swapPrevMusicCommand = new SwapPrevMusicCommand(music);
        // Set up our "Invoker" with the "Command" objects conditionally based on what button was pressed
        remote.setCommand(0, lightOnCommand, lightOffCommand);
        remote.setCommand(1, musicOnCommand, musicOffCommand);
        remote.setCommand(2, swapPrevMusicCommand, swapNextMusicCommand);
        remote.leftButtonPressed(1);
        // Called when a cake is selected to place order
        placeOrder("Chocolate Cake");
        cancelOrder();
        
        
//        scene = new Scene(loadFXML("primary"), 640, 480);
//        stage.setScene(scene);
//        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CakeBakery.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    // Set up the application (e.g., layout, controls, backgroun)
    public static void initializeSetUp(){
        
    }
    
    public void placeOrder(String cake){
        CakeOrder order = new CakeOrder(cake);
        PlaceOrderCommand orderCommand = new PlaceOrderCommand(order);
        CancelOrderCommand cancelCommand = new CancelOrderCommand(order);
        waiter.setCommand(orderCommand, cancelCommand);
        waiter.onOrderPlaced();
    }
    
    public void cancelOrder(){
        waiter.onOrderCancel();
    }
}