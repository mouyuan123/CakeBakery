//package com.mycompany.cakebakery;
//
//import com.mycompany.cakebakery.Command.*;
//import com.mycompany.cakebakery.Facade.CakeBakeryFacade;
//import com.mycompany.cakebakery.Models.Background;
//import com.mycompany.cakebakery.Models.Menu;
//import com.mycompany.cakebakery.Models.*;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.geometry.HPos;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.geometry.VPos;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//import com.mycompany.cakebakery.Constants.DirConstant;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Optional;
//
///**
// * JavaFX App
// */
//public class CakeBakeryApplication extends Application {
//
//    private static Scene scene;
//    private static int width = 1000;
//    private static int height = 700;
//    private Label budgetLabel;
//    // Add a flag to track if the 'Open Restaurant' button has been clicked
//    private boolean isFirstTimeOpenRestaurant = true;
//    // Initialise Remote Control
//    RemoteControl remote;
//    // Initialise a "waiter" (OrderInvoker)
//    OrderInvoker waiter;
//    Media media;
//    MediaPlayer mediaPlayer;
//    // CakeBakeryLayout
//    GridPane CakeBakeryLayout;
//    // Cake Menu Layout
//    VBox CakeMenuLayout;
//    VBox CakeLayout;
//    // Control Panel
//    VBox CakeBakeryControlPanel;
//    HBox MenuControlPanel;
//    HBox CakeControlPanel;
//    //Budget Control Panel (Singleton)
//    HBox CakeChoiceMenuLayout;
//
//    HBox BudgetControlPanel;
//    // Check for selected cake at "Menu" screen
//    Cake selectedCake;
//    VBox overlayPane = new VBox(10);
//    @Override
//    public void start(Stage stage) throws IOException {
//        // 1. Set up the layout to display the GUI
//        this.CakeBakeryLayout = this.initializeLayout();
//        this.CakeMenuLayout = this.initializeMenuLayout();
//        this.CakeLayout = this.initializeCakeLayout();
//        this.CakeChoiceMenuLayout = this.initializeChoiceMenuLayout();
//
//        // 2. Instantiate Cake Bakery object (Singleton)
//        CakeBakery cakeBakery = CakeBakery.getCakeBakeryInstance();
//
//        // 3. Instantiate Budget object (Singleton)
//        Budget budget = Budget.getBudgetInstance();
////        Text budgetTxt = new Text("Point: " + budget.getBudget());
////        budgetTxt.setFont(Font.font("Verdana", 30));
//
//        // 4. Initialise all the necessary set up for Command Design Pattern using cakeBakery instance
//        // Get the "Receiver" instance from the `CakeBakery`
//        Lighting lighting = cakeBakery.getLight();
//        Music music = cakeBakery.getMusic();
//        setUpCommandPattern(cakeBakery, lighting, music);
//
//        // 5. Initialise all the buttons for remote control
//        Button lightingOnButton = new Button("Lighting On");
//        Button lightingOffButton = new Button("Lighting Off");
//        Button musicOnButton = new Button("Speaker On");
//        Button musicOffButton = new Button("Speaker Off");
//        Button swapPrevMusicButton = new Button("Previous Music");
//        Button swapNextMusicButton = new Button("Next Music");
//
//        // 5. Initialise all the buttons for placing / canceling order
//        Button placeOrderButton = new Button("Place Order");
//        Button cancelOrderButton = new Button("Cancel Order");
//
//        // 5. Initialise the CakeBakeryFacade
//        CakeBakeryFacade cakeBakeryFacade = new CakeBakeryFacade(cakeBakery, budget, waiter);
//        Button onOpenRestaurantButton = new Button("Open Restaurant");
//        Button onCloseRestaurantButton = new Button("Close Restaurant");
//
//        Button toMenuSceneButton = new Button("Menu");
//        Button fromMenuToLayoutSceneButton = new Button("Back");
//        Button fromCakeToMenuSceneButton = new Button("Back to Menu");
//
//        // 5. Initialise the button for top up budget (Singleton)
//        Button topUpButton = new Button("Top Up");
//
//        initializeCakeBakeryControlPanel(lightingOnButton, lightingOffButton, musicOnButton, musicOffButton, swapPrevMusicButton, swapNextMusicButton);
//        initializeMenuControlPanel(fromMenuToLayoutSceneButton);
//        initializeCakeControlPanel(fromCakeToMenuSceneButton);
//        initializeBudgetControlPanel(topUpButton); // Singleton
//
//        // 6. Set up CakeBakeryLayout && CakeMenuLayout
//        displayCakeBakery(cakeBakery, true, onOpenRestaurantButton, onCloseRestaurantButton, toMenuSceneButton);
//        TableView<Cake> menu = displayMenu(cakeBakery, placeOrderButton);
//
//        // 7. Initialise the button to change from one scene to another
//        // 8. Different scenes for different layout
//        Scene CakeBakeryLayoutScene = new Scene(CakeBakeryLayout, width, height);
//        Scene CakeMenuLayoutScene = new Scene(CakeMenuLayout, width, height);
//        Scene CakeLayoutScene = new Scene(CakeLayout, width, height);
//        Scene CakeChoiceMenuLayoutScene = new Scene(CakeChoiceMenuLayout, width, height);
//
//
//        this.CakeBakeryControlPanel.setViewOrder(-1.0);
//        this.MenuControlPanel.setViewOrder(-1.0);
//        this.CakeControlPanel.setViewOrder(-1.0);
//        onOpenRestaurantButton.setViewOrder(-1.0);
//        onCloseRestaurantButton.setViewOrder(-1.0);
//        toMenuSceneButton.setViewOrder(-1.0);
//
//        //Singleton
//        this.BudgetControlPanel.setViewOrder(-1.0);
//
//        // 7. Set the default layout as `CakeBakery` layout
//        stage.setScene(CakeBakeryLayoutScene);
//        stage.setTitle("Virtual Space - CakeBakery");
//        stage.show();
//
//        overlayPane.setAlignment(Pos.CENTER);
//        overlayPane.setStyle("-fx-background-color: rgba(255, 255, 255, 0.7); -fx-padding: 20; -fx-border-color: black; -fx-border-width: 1;");
//        overlayPane.setMaxWidth(300); // Set maximum width
//        overlayPane.setMaxHeight(200); // Set maximum height
//        overlayPane.setVisible(false); // Initially invisible
//
//        toMenuSceneButton.setOnAction(e -> {
//            overlayPane.getChildren().clear(); // Clear previous content if any
//
//            Button tile1 = new Button("Baked Cake");
//            tile1.setPrefSize(100, 100);
//            String path1 = new File(DirConstant.BAKED_CAKES_PATH).toURI().toString(); // Convert the file path to a URI
//            tile1.setStyle("-fx-background-image: url('" + path1 + "');"
//                    + "-fx-background-size: cover;"
//                    + "-fx-background-repeat: no-repeat;"
//                    + "-fx-background-position: center;");
//            tile1.setOnAction(event -> {
//                overlayPane.setVisible(false);
//                // Action for Tile 1
//            });
//
//            Button tile2 = new Button("Crepe Cake");
//            tile2.setPrefSize(100, 100);
//            String path2 =new File(DirConstant.CREPE_CAKES_PATH).toURI().toString();
//            tile2.setStyle("-fx-background-image: url('" + path2 + "');"
//                    + "-fx-background-size: cover;"
//                    + "-fx-background-repeat: no-repeat;"
//                    + "-fx-background-position: center;");
//            tile2.setOnAction(event -> {
//                overlayPane.setVisible(false);
//                // Action for Tile 2
//            });
//
//            overlayPane.getChildren().addAll(tile1, tile2);
//            overlayPane.setVisible(true); // Show the overlay
//        });
//
//
//
//        fromMenuToLayoutSceneButton.setOnAction(e -> {
//            this.selectedCake = null;
//            stage.setScene(CakeBakeryLayoutScene);
//        });
//
//
////        fromCakeToMenuSceneButton.setOnAction(e -> {
////            // Tile 1
////            Button tile1 = new Button("Tile 1");
////            tile1.setPrefSize(100, 100);
////            tile1.setOnAction(event -> {
////                // Navigate to page 1
//////            navigateToPage1(primaryStage);
////            });
////
////            // Tile 2
////            Button tile2 = new Button("Tile 2");
////            tile2.setPrefSize(100, 100);
////            tile2.setOnAction(event -> {
////                // Navigate to page 2
//////            navigateToPage2(primaryStage);
////            });
////
////            CakeChoiceMenuLayout.getChildren().addAll(tile1, tile2);
////            stage.setScene(CakeChoiceMenuLayoutScene);
////
////        });
//
//
//
//
//        // Facade Button Action
//        onOpenRestaurantButton.setOnAction(event -> {
//            if (mediaPlayer != null) {
//                mediaPlayer.stop();
//            }
//            cakeBakeryFacade.onOpen();
//            displayCakeBakery(cakeBakery, false, onOpenRestaurantButton, onCloseRestaurantButton, toMenuSceneButton);
//
//            // Show the budget input dialog only for first time entering customer (Singleton)
//            if (isFirstTimeOpenRestaurant) {
//                showBudgetInputDialog(cakeBakeryFacade, stage, onOpenRestaurantButton, onCloseRestaurantButton, toMenuSceneButton);
//                isFirstTimeOpenRestaurant = false;
//            }
//        });
//
//        onCloseRestaurantButton.setOnAction(event -> {
//            if (mediaPlayer != null) {
//                mediaPlayer.stop();
//            }
//            cakeBakeryFacade.onClose();
//            displayCakeBakery(cakeBakery, true, onOpenRestaurantButton, onCloseRestaurantButton, toMenuSceneButton);
//        });
//
//        // Command Button Action
//        lightingOnButton.setOnAction(event -> {
//            this.remote.leftButtonPressed(0);
//            this.updateImageInUI(this.CakeBakeryLayout, lighting.getLightingEffect(), 400, 700, 0, 0, 4, 3);
//        });
//
//        lightingOffButton.setOnAction(event -> {
//            this.remote.rightButtonPressed(0);
//            this.updateImageInUI(this.CakeBakeryLayout, lighting.getLightingEffect(), 400, 700, 0, 0, 4, 3);
//        });
//
//        musicOnButton.setOnAction(event -> {
//            this.remote.leftButtonPressed(1);
//            controlBackgroundMusic(music);
//            this.updateImageInUI(this.CakeBakeryLayout, music.getMusicImg(), 400, 400, 3, 2, 4, 4);
//        });
//
//        musicOffButton.setOnAction(event -> {
//            if (mediaPlayer != null) {
//                mediaPlayer.stop();
//            }
//            this.remote.rightButtonPressed(1);
//            controlBackgroundMusic(music);
//            this.updateImageInUI(this.CakeBakeryLayout, music.getMusicImg(), 400, 400, 3, 2, 4, 4);
//        });
//
//        swapPrevMusicButton.setOnAction(event -> {
//            if (mediaPlayer != null) {
//                mediaPlayer.stop();
//            }
//            this.remote.leftButtonPressed(2);
//            if (!music.isOff()) {
//                controlBackgroundMusic(music);
//            }
//        });
//
//        swapNextMusicButton.setOnAction(event -> {
//            if (mediaPlayer != null) {
//                mediaPlayer.stop();
//            }
//            this.remote.rightButtonPressed(2);
//            if (!music.isOff()) {
//                controlBackgroundMusic(music);
//            }
//        });
//
//        menu.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, selected) -> {
//            if (selected != null) {
//                this.selectedCake = selected;
//            }
//        });
//
//        placeOrderButton.setOnAction(event -> {
//            if (selectedCake != null) {
//                if (!cakeBakeryFacade.placeNewOrder(selectedCake)) {
//                    this.alertWarning(cakeBakeryFacade.getMessage());
//                } else {
//                    displayCake(this.selectedCake, fromCakeToMenuSceneButton, cancelOrderButton);
//                    stage.setScene(CakeLayoutScene);
//                }
//            }
//        });
//
//        cancelOrderButton.setOnAction(event -> {
//            cakeBakeryFacade.cancelCurrentOrder();
//            stage.setScene(CakeMenuLayoutScene);
//        });
//
//        //Singleton Button Action
//        topUpButton.setOnAction(event -> {
//            showBudgetTopUpDialog(topUpButton);
//        });
//    }
//
//    static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml));
//    }
//
//    private static Parent loadFXML(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(CakeBakeryApplication.class.getResource(fxml + ".fxml"));
//        return fxmlLoader.load();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//
//    // Render the entire Layout
//    public void displayCakeBakery(CakeBakery cakeBakery, boolean isClose, Button onOpenRestaurantButton, Button onCloseRestaurantButton, Button menuButton) {
//        CakeBakeryLayout.getChildren().clear();
//        String background = cakeBakery.getBackground();
//        Lighting lighting = cakeBakery.getLight();
//        Music music = cakeBakery.getMusic();
//
//        // Set image in layoutScene
//        try {
//            // 1. Create background UI
//            setImageInUI(CakeBakeryLayout, Background.displayView(width, height, background), 0, 0, 4, 4);
//
//            // 2. Create lighting UI
//            setImageInUI(CakeBakeryLayout, Background.displayView(400, 700, lighting.getLightingEffect()), 0, 0, 4, 3);
//
//            // 3. Create music UI
//            setImageInUI(CakeBakeryLayout, Background.displayView(400, 400, music.getMusicImg()), 3, 2, 4, 4);
//
//            // 4. Dynamic layout / buttons based on the open / close of cake bakery
//            if (isClose) {
//                String closed_sign = cakeBakery.getClosed_sign();
//                // 4. Create Black Background when cake bakery is closed
//                setImageInUI(CakeBakeryLayout, Background.displayBlackBackground(width, height, 0.4), 0, 0, 4, 4);
//                // 5. Create Closed sign UI
//                setImageInUI(CakeBakeryLayout, Background.displayView(300, 300, closed_sign), 0, 0, 4, 4);
//                CakeBakeryLayout.add(onOpenRestaurantButton, 3, 3, 1, 1);
//            } else {
//                String waiter = cakeBakery.getWaiter();
//                StackPane stackpane = Background.displayView(400, 400, waiter);
//                stackpane.setViewOrder(-1.0);
//                setImageInUI(CakeBakeryLayout, stackpane, 1, 1, 4, 4);
//                GridPane.setMargin(menuButton, new Insets(0, 0, 0, 5));
//                CakeBakeryLayout.add(menuButton, 0, 3);
//                CakeBakeryLayout.add(onCloseRestaurantButton, 3, 3, 1, 4);
//                CakeBakeryLayout.add(CakeBakeryControlPanel, 0, 0, 3, 3);
//                //Singleton
//                CakeBakeryLayout.add(BudgetControlPanel, 3, 0);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        CakeBakeryLayout.add(overlayPane, 0, 0, 4, 4); // It spans the entire grid
//        GridPane.setHalignment(overlayPane, HPos.CENTER);
//        GridPane.setValignment(overlayPane, VPos.CENTER);
//
//        controlBackgroundMusic(cakeBakery.getMusic());
//    }
//
//    // Render the entire Layout
//    public void displayCake(Cake selectedCake, Button backButton, Button cancelOrderButton) {
//        CakeLayout.getChildren().clear();
//        CakeLayout.getChildren().add(backButton);
//        String cake = selectedCake.getCakeImg();
//        CakeLayout.getChildren().add(Background.displayView(400, 400, cake));
//        CakeLayout.getChildren().add(cancelOrderButton);
//    }
//
//    public TableView<Cake> displayMenu(CakeBakery cakeBakery, Button placeOrderButton) {
//        Menu cakes = cakeBakery.getMenu();
//        cakes.generateTableView();
//        TableView<Cake> menu = cakes.getTable();
//        CakeMenuLayout.getChildren().clear();
//        CakeMenuLayout.getChildren().addAll(MenuControlPanel, menu, placeOrderButton);
//        return menu;
//    }
//
//    public void setImageInUI(GridPane gridPane, StackPane stackPane, int columnIndex, int rowIndex, int columnSpan, int rowSpan) {
//        try {
//            gridPane.add(stackPane, columnIndex, rowIndex, columnSpan, rowSpan);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void updateImageInUI(GridPane gridPane, String imagePath, double width, double height, int columnIndex, int rowIndex, int columnSpan, int rowSpan) {
//
//        gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == columnIndex && GridPane.getRowIndex(node) == rowIndex && GridPane.getColumnSpan(node) == columnSpan && GridPane.getRowSpan(node) == rowSpan);
//        gridPane.add(Background.displayView(width, height, imagePath), columnIndex, rowIndex, columnSpan, rowSpan);
//    }
//
//    public GridPane initializeLayout() {
//        // Initialize layout
//        GridPane gridPaneLayoutScene = new GridPane();
//        gridPaneLayoutScene.setHgap(10);
//        gridPaneLayoutScene.setVgap(10);
//
//        // Total 4 column where each column.width == 25% parent.width
//        ColumnConstraints column1 = new ColumnConstraints();
//        column1.setPercentWidth(25);
//        ColumnConstraints column2 = new ColumnConstraints();
//        column2.setPercentWidth(25);
//        ColumnConstraints column3 = new ColumnConstraints();
//        column3.setPercentWidth(25);
//        ColumnConstraints column4 = new ColumnConstraints();
//        column4.setPercentWidth(25);
//        gridPaneLayoutScene.getColumnConstraints().addAll(column1, column2, column3, column4);
//
//        // Total 4 row where each row.height == 25% parent.height
//        RowConstraints row1 = new RowConstraints();
//        row1.setPercentHeight(25);
//        RowConstraints row2 = new RowConstraints();
//        row2.setPercentHeight(25);
//        RowConstraints row3 = new RowConstraints();
//        row3.setPercentHeight(25);
//        RowConstraints row4 = new RowConstraints();
//        row4.setPercentHeight(25);
//        gridPaneLayoutScene.getRowConstraints().addAll(row1, row2, row3, row4);
//        return gridPaneLayoutScene;
//    }
//
//    public VBox initializeMenuLayout() {
//        VBox box = new VBox(3);
//        return box;
//    }
//
//    public HBox initializeChoiceMenuLayout() {
//        HBox box = new HBox(10);
//        return box;
//    }
//
//    public VBox initializeCakeLayout() {
//        VBox box = new VBox(3);
//        box.setAlignment(Pos.CENTER);
//        return box;
//    }
//
//    public void initializeCakeBakeryControlPanel(Button lightingOnButton, Button lightingOffButton, Button musicOnButton, Button musicOffButton, Button swapPrevMusicButton, Button swapNextMusicButton) {
//        CakeBakeryControlPanel = new VBox(3);
//        HBox light_buttons = new HBox(2);
//        light_buttons.getChildren().addAll(lightingOnButton, lightingOffButton);
//        HBox music_buttons = new HBox(2);
//        music_buttons.getChildren().addAll(musicOnButton, musicOffButton);
//        HBox swap_music_buttons = new HBox(2);
//        swap_music_buttons.getChildren().addAll(swapPrevMusicButton, swapNextMusicButton);
//        CakeBakeryControlPanel.getChildren().addAll(light_buttons, music_buttons, swap_music_buttons);
//        CakeBakeryControlPanel.setPadding(new Insets(3, 0, 0, 5));
//    }
//
//    public void initializeMenuControlPanel(Button backButton) {
//        MenuControlPanel = new HBox(2);
//        MenuControlPanel.getChildren().add(backButton);
//    }
//
//    public void initializeCakeControlPanel(Button backButton) {
//        CakeControlPanel = new HBox(2);
//    }
//
//    //Singleton
//    public void initializeBudgetControlPanel(Button topUp) {
//        BudgetControlPanel = new HBox(10);
//        budgetLabel = new Label("Budget: " + Budget.getBudgetInstance().getBudget());
//        budgetLabel.setFont(new Font("Arial", 14));
//        BudgetControlPanel.getChildren().addAll(budgetLabel, topUp);
//        BudgetControlPanel.setAlignment(Pos.CENTER_LEFT); // Adjust alignment as needed
//    }
//
//    public void setUpCommandPattern(CakeBakery cakeBakery, Lighting lighting, Music music) {
//        // Initialise Remote Control
//        remote = new RemoteControl();
//        // Initialise a "waiter" (OrderInvoker)
//        waiter = new OrderInvoker();
//        // Initialise the "Command" objects
//        LightingOnCommand lightOnCommand = new LightingOnCommand(lighting);
//        LightingOffCommand lightOffCommand = new LightingOffCommand(lighting);
//        MusicOnCommand musicOnCommand = new MusicOnCommand(music);
//        MusicOffCommand musicOffCommand = new MusicOffCommand(music);
//        SwapNextMusicCommand swapNextMusicCommand = new SwapNextMusicCommand(music);
//        SwapPrevMusicCommand swapPrevMusicCommand = new SwapPrevMusicCommand(music);
//        // Set up our "Invoker" with the "Command" objects conditionally based on what button was pressed
//        remote.setCommand(0, lightOnCommand, lightOffCommand);
//        remote.setCommand(1, musicOnCommand, musicOffCommand);
//        remote.setCommand(2, swapPrevMusicCommand, swapNextMusicCommand);
//        remote.rightButtonPressed(0);
//        remote.rightButtonPressed(1);
//    }
//
//    public void controlBackgroundMusic(Music music) {
//        String path = music.getCurr_music();
//        if (path != null) {
//            media = new Media(new File(path).toURI().toString());
//            mediaPlayer = new MediaPlayer(media);
//            mediaPlayer.setAutoPlay(true);
//        }
//    }
//
//    public void alertWarning(String message) {
//        Alert alertBox = new Alert(Alert.AlertType.WARNING);
//        alertBox.setContentText(message);
//        alertBox.show();
//    }
//
//    //Singleton
//    public void updateBudgetDisplay() {
//        double currentBudget = Budget.getBudgetInstance().getBudget();
//        budgetLabel.setText("Budget: " + currentBudget);
//    }
//
//    // Method to show the budget input dialog
//    private void showBudgetInputDialog(CakeBakeryFacade cakeBakeryFacade, Stage stage, Button onOpenRestaurantButton, Button onCloseRestaurantButton, Button menuButton) {
//        boolean validInput = false;
//
//        while (!validInput) {
//            TextInputDialog budgetInputDialog = new TextInputDialog();
//            budgetInputDialog.setTitle("Budget Top Up Counter");
//            budgetInputDialog.setHeaderText("Welcome To Cafe Bakery!");
//            budgetInputDialog.setContentText("Please Enter Your Budget:");
//            budgetInputDialog.setGraphic(null); // Remove the alert icon
//
//            // Way to get the response value.
//            Optional<String> result = budgetInputDialog.showAndWait();
//
//            if (result.isPresent()) {
//                try {
//                    double budgetValue = Double.parseDouble(result.get());
//                    Budget.getBudgetInstance().setBudget(budgetValue);
//                    updateBudgetDisplay();
//                    // Open the restaurant if the budget is set
//                    cakeBakeryFacade.onOpen();
//                    displayCakeBakery(CakeBakery.getCakeBakeryInstance(), false, onOpenRestaurantButton, onCloseRestaurantButton, menuButton);
//                    stage.show();
//                    validInput = true; // Break the loop on valid input
//                } catch (NumberFormatException e) {
//                    // Handle invalid number input by showing the dialog again
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Invalid Input");
//                    alert.setHeaderText("Invalid Budget");
//                    alert.setContentText("Please Enter A Valid Number For The Budget.");
//                    alert.showAndWait();
//                    // Loop will continue if the input is not valid
//                }
//            } else {
//                // User canceled the dialog
//                validInput = true; // Exit the loop if the user cancels the dialog
//            }
//        }
//    }
//
//    // Method to show the budget top up dialog
//    private void showBudgetTopUpDialog(Button topUpButton) {
//        boolean validInput = false;
//
//        while (!validInput) {
//            TextInputDialog budgetTopUpDialog = new TextInputDialog();
//            budgetTopUpDialog.setTitle("Budget Top Up Counter");
//            budgetTopUpDialog.setHeaderText("Thank You and Have A Nice Day!");
//            budgetTopUpDialog.setContentText("Please Enter Your Budget:");
//            budgetTopUpDialog.setGraphic(null); // Remove the icon
//
//            Optional<String> result = budgetTopUpDialog.showAndWait();
//
//            if (result.isPresent()) {
//                try {
//                    double budgetValue1 = Double.parseDouble(result.get());
//                    Budget.getBudgetInstance().topUp(budgetValue1);
//                    updateBudgetDisplay();
//                    validInput = true; // Break the loop on valid input
//                } catch (NumberFormatException e) {
//                    // Handle invalid number input by showing the dialog again
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Invalid Input");
//                    alert.setHeaderText("Invalid Budget");
//                    alert.setContentText("Please Enter A Valid Number For The Budget.");
//                    alert.showAndWait();
//                }
//            } else {
//                // User canceled the dialog
//                validInput = true; // Exit the loop if the user cancels the dialog
//            }
//        }
//    }
//
//}
package com.mycompany.cakebakery;

import com.mycompany.cakebakery.Command.LightingOffCommand;
import com.mycompany.cakebakery.Command.LightingOnCommand;
import com.mycompany.cakebakery.Command.MusicOffCommand;
import com.mycompany.cakebakery.Command.MusicOnCommand;
import com.mycompany.cakebakery.Command.OrderInvoker;
import com.mycompany.cakebakery.Command.RemoteControl;
import com.mycompany.cakebakery.Command.SwapNextMusicCommand;
import com.mycompany.cakebakery.Command.SwapPrevMusicCommand;
import com.mycompany.cakebakery.Facade.CakeBakeryFacade;
import com.mycompany.cakebakery.FactoryMethod.BakedCakeFactory;
import com.mycompany.cakebakery.FactoryMethod.CrepeCakeFactory;
import com.mycompany.cakebakery.Models.*;

import java.io.File;

import com.mycompany.cakebakery.Models.Menu;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static javafx.application.Application.launch;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

/**
 * JavaFX App
 */
public class CakeBakeryApplication extends Application {

    private static Scene scene;
    private static int width = 1000;
    private static int height = 700;
    private Label budgetLabel;
    // Add a flag to track if the 'Open Restaurant' button has been clicked
    private boolean isFirstTimeOpenRestaurant = true;
    // Initialise Remote Control
    RemoteControl remote;
    // Initialise a "waiter" (OrderInvoker)
    OrderInvoker waiter;
    Media media;
    MediaPlayer mediaPlayer;
    // CakeBakeryLayout
    GridPane CakeBakeryLayout;
    // Cake Menu Layout
    VBox CakeMenuLayout;
    VBox CakeLayout;
    // Control Panel
    VBox CakeBakeryControlPanel;
    HBox MenuControlPanel;
    HBox CakeControlPanel;
    //Budget Control Panel (Singleton)
    HBox BudgetControlPanel;
    // Check for selected cake at "Menu" screen

//    @FXML
//    private StackPane spMain; // This is linked to the StackPane in FXML
//    @FXML
//    private GridPane gpControl; // This is linked to the StackPane in FXML
//    @FXML
//    private ImageView imgTopUp; // This is linked to the StackPane in FXML
//    @FXML
//    private ImageView imgControlInterior;
//    @FXML
//    private ImageView imgSpeakerNotes;
//    @FXML
//    private Circle btnLightOn;
//    @FXML
//    private Circle btnLightOff;
//    @FXML
//    private Circle btnPreviousSong;
//    @FXML
//    private Circle btnNextSong;
//    @FXML
//    private Ellipse btnStopMusic;
//    @FXML
//    private Ellipse btnPlayMusic;
//    @FXML
//    private Ellipse btnCounter1;
//    @FXML
//    private Ellipse btnCounter2;
//    @FXML
//    private Ellipse btnCounter3;
//    @FXML
//    private Circle btnCloseControl;
//    @FXML
//    private SplitPane spCakeType;
//    @FXML
//    private Button btnCrossCakeType;
//    @FXML
//    private GridPane gpBakedCakes;
//    @FXML
//    private GridPane gpCrepeCakes;
//    @FXML
//    private SplitPane spBaseCake;
//    @FXML
//    private Button btnCrossBaseCake;
//    @FXML
//    private GridPane gpChocolateCake;
//    @FXML
//    private Label labelChocolateCake;
//    @FXML
//    private GridPane gpVanillaCake;
//    @FXML
//    private Label labelVanillaCake;
//    @FXML
//    private GridPane gpTiramisuCake;
//    @FXML
//    private Label labelTiramisuCake;
//    @FXML
//    private GridPane gpRedVelvetCake;
//    @FXML
//    private Label labelRedVelvetCake;
//    @FXML
//    private GridPane gpMatchaCake;
//    @FXML
//    private Label labelMatchaCake;
//    @FXML
//    private SplitPane spCrepeCake;
//    @FXML
//    private Button btnCrossCrepeCake;
//    @FXML
//    private GridPane gpChocolateCrepeCake;
//    @FXML
//    private Label labelChocolateCrepeCake;
//    @FXML
//    private GridPane gpVanillaCrepeCake;
//    @FXML
//    private Label labelVanillaCrepeCake;
//    @FXML
//    private GridPane gpTiramisuCrepeCake;
//    @FXML
//    private Label labelTiramisuCrepeCake;
//    @FXML
//    private GridPane gpRedVelvetCrepeCake;
//    @FXML
//    private Label labelRedVelvetCrepeCake;
//    @FXML
//    private GridPane gpMatchaCrepeCake;
//    @FXML
//    private Label labelMatchaCrepeCake;
//    @FXML
//    private SplitPane spCondiments;
//    @FXML
//    private Button btnCrossCondiments;
//    @FXML
//    private GridPane gpMacron;
//    @FXML
//    private GridPane gpStrawberry;
//    private GridPane gpStrawberry;
//    @FXML
//    private ImageView imgChoosedCake;
//    @FXML
//    private ImageView imgCondimentOne;
//    @FXML
//    private ImageView imgCondimentTwo;
//    @FXML
//    private ImageView imgCondimentThree;
//    @FXML
//    private Label labelChoosedCakeName;
//    @FXML
//    private Label labelTotalPrice;
//    @FXML
//    private GridPane gpChocolate;
//    @FXML
//    private Button btnPay;
//    @FXML
//    private Button btnCancel;
//    Music music;

    String selectedCakeType;

    @FXML
    private AnchorPane imgBakeryClosedBackground;
    @FXML
    private Button btnOpenBakery;
    @FXML
    private Button btnCloseBakery;
    @FXML
    private StackPane spMain; // This is linked to the StackPane in FXML
    @FXML
    private GridPane gpControl; // This is linked to the StackPane in FXML
    @FXML
    private ImageView imgTopUp; // This is linked to the StackPane in FXML
    @FXML
    private ImageView imgControlInterior;
    @FXML
    private ImageView imgBackground;
    @FXML
    private ImageView imgSpeakerNotes;

    @FXML
    private ImageView imgBakedCake1;
    @FXML
    private ImageView imgBakedCake2;
    @FXML
    private ImageView imgBakedCake3;
    @FXML
    private ImageView imgBakedCake4;
    @FXML
    private ImageView imgBakedCake5;

    @FXML
    private Label labelBakedCake1;
    @FXML
    private Label labelBakedCake2;
    @FXML
    private Label labelBakedCake3;
    @FXML
    private Label labelBakedCake4;
    @FXML
    private Label labelBakedCake5;

    @FXML
    private Label labelBakedCakePrice1;
    @FXML
    private Label labelBakedCakePrice2;
    @FXML
    private Label labelBakedCakePrice3;
    @FXML
    private Label labelBakedCakePrice4;
    @FXML
    private Label labelBakedCakePrice5;

    @FXML
    private ImageView imgCrepeCake1;
    @FXML
    private ImageView imgCrepeCake2;
    @FXML
    private ImageView imgCrepeCake3;
    @FXML
    private ImageView imgCrepeCake4;
    @FXML
    private ImageView imgCrepeCake5;

    @FXML
    private Label labelCrepeCake1;
    @FXML
    private Label labelCrepeCake2;
    @FXML
    private Label labelCrepeCake3;
    @FXML
    private Label labelCrepeCake4;
    @FXML
    private Label labelCrepeCake5;

    @FXML
    private Label labelCrepeCakePrice1;
    @FXML
    private Label labelCrepeCakePrice2;
    @FXML
    private Label labelCrepeCakePrice3;
    @FXML
    private Label labelCrepeCakePrice4;
    @FXML
    private Label labelCrepeCakePrice5;

    @FXML
    private GridPane gpBakedCake1;
    @FXML
    private GridPane gpBakedCake2;
    @FXML
    private GridPane gpBakedCake3;
    @FXML
    private GridPane gpBakedCake4;
    @FXML
    private GridPane gpBakedCake5;

    @FXML
    private GridPane gpCrepeCake1;
    @FXML
    private GridPane gpCrepeCake2;
    @FXML
    private GridPane gpCrepeCake3;
    @FXML
    private GridPane gpCrepeCake4;
    @FXML
    private GridPane gpCrepeCake5;

    @FXML
    private ImageView imgCondiment1;
    @FXML
    private ImageView imgCondiment2;
    @FXML
    private ImageView imgCondiment3;

    @FXML
    private GridPane gpCondiment1;
    @FXML
    private GridPane gpCondiment2;
    @FXML
    private GridPane gpCondiment3;

    @FXML
    private Label labelCondiment1;

    @FXML
    private Label labelCondiment2;

    @FXML
    private Label labelCondiment3;

    @FXML
    private Label labelCondimentPrice1;

    @FXML
    private Label labelCondimentPrice2;

    @FXML
    private Label labelCondimentPrice3;

    @FXML
    private Spinner<Integer> spinnerCondiment1;
    @FXML
    private Spinner<Integer> spinnerCondiment2;

    @FXML
    private Spinner<Integer> spinnerCondiment3;


    @FXML
    private Circle btnLightOn;
    @FXML
    private Circle btnLightOff;
    @FXML
    private Circle btnPreviousSong;
    @FXML
    private Circle btnNextSong;
    @FXML
    private Ellipse btnStopMusic;
    @FXML
    private Ellipse btnPlayMusic;
    @FXML
    private Ellipse btnCounter1;
    @FXML
    private Ellipse btnCounter2;
    @FXML
    private Ellipse btnCounter3;
    @FXML
    private Circle btnCloseControl;
    @FXML
    private SplitPane spCakeType;
    @FXML
    private Button btnCrossCakeType;
    @FXML
    private GridPane gpBakedCakes;
    @FXML
    private GridPane gpCrepeCakes;
    @FXML
    private SplitPane spBaseCake;
    @FXML
    private Button btnCrossBaseCake;
    @FXML
    private GridPane gpChocolateCake;
    @FXML
    private Label labelChocolateCake;
    @FXML
    private GridPane gpVanillaCake;
    @FXML
    private Label labelVanillaCake;
    @FXML
    private GridPane gpTiramisuCake;
    @FXML
    private Label labelTiramisuCake;
    @FXML
    private GridPane gpRedVelvetCake;
    @FXML
    private Label labelRedVelvetCake;
    @FXML
    private GridPane gpMatchaCake;
    @FXML
    private Label labelMatchaCake;
    @FXML
    private SplitPane spCrepeCake;
    @FXML
    private Button btnCrossCrepeCake;
    @FXML
    private GridPane gpChocolateCrepeCake;
    @FXML
    private Label labelChocolateCrepeCake;
    @FXML
    private GridPane gpVanillaCrepeCake;
    @FXML
    private Label labelVanillaCrepeCake;
    @FXML
    private GridPane gpTiramisuCrepeCake;
    @FXML
    private Label labelTiramisuCrepeCake;
    @FXML
    private GridPane gpRedVelvetCrepeCake;
    @FXML
    private Label labelRedVelvetCrepeCake;
    @FXML
    private GridPane gpMatchaCrepeCake;
    @FXML
    private Label labelMatchaCrepeCake;
    @FXML
    private SplitPane spCondiments;
    @FXML
    private Button btnCrossCondiments;
    @FXML
    private GridPane gpMacron;
    @FXML
    private GridPane gpStrawberry;
    @FXML
    private ImageView imgChoosedCake;
    @FXML
    private ImageView imgCondimentOne;
    @FXML
    private ImageView imgCondimentTwo;
    @FXML
    private ImageView imgCondimentThree;
    @FXML
    private Label labelChoosedCakeName;
    @FXML
    private Label labelTotalPrice;
    @FXML
    private GridPane gpChocolate;
    @FXML
    private Button btnPay;
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnTopUpCancel;
    @FXML
    private TextArea taTopUpValue;


    @FXML
    private Button btnTopUpOK;
    @FXML
    private ImageView imgFactoryProcess;
    @FXML
    private Label labelFactoryProcess;
    @FXML
    private GridPane gpFactoryProcess;

    @FXML
    private GridPane gpTopUp;

    @FXML
    private AnchorPane apFinalCakeItem;

    @FXML
    private ImageView imgFinalCake;

    @FXML
    private ImageView imgFinalCondiment1;
    @FXML
    private ImageView imgFinalCondiment2;
    @FXML
    private ImageView imgFinalCondiment3;


    Music music;
    Lighting light;
    CakeBakeryFacade cakeBakeryFacade;

    List<Cake> bakedCakesList;

    List<Cake> crepeCakesList;

    List<Condiment> condimentsList;

    Cake choosedCake;
    ArrayList<String> choosedCondimentNameList = new ArrayList<String>();
    ArrayList<ImageView> choosedCondimentImageViewList = new ArrayList<ImageView>();


    @Override
    public void start(Stage primaryStage) {
        try {
            CakeBakery cakeBakery = CakeBakery.getCakeBakeryInstance();
            //Initialise Command Patterns
            this.light = cakeBakery.getLight();
            this.music = cakeBakery.getMusic();
            // Initialise Remote Control
            this.remote = new RemoteControl();
            // Initialise a "waiter" (OrderInvoker)
            this.waiter = new OrderInvoker();
            // Initialise the "Command" objects
            LightingOnCommand lightOnCommand = new LightingOnCommand(this.light);
            LightingOffCommand lightOffCommand = new LightingOffCommand(this.light);
            MusicOnCommand musicOnCommand = new MusicOnCommand(music);
            MusicOffCommand musicOffCommand = new MusicOffCommand(music);
            SwapNextMusicCommand swapNextMusicCommand = new SwapNextMusicCommand(music);
            SwapPrevMusicCommand swapPrevMusicCommand = new SwapPrevMusicCommand(music);
            // Set up our "Invoker" with the "Command" objects conditionally based on what button was pressed
            this.remote.setCommand(0, lightOnCommand, lightOffCommand);
            this.remote.setCommand(1, musicOnCommand, musicOffCommand);
            this.remote.setCommand(2, swapPrevMusicCommand, swapNextMusicCommand);
            this.remote.rightButtonPressed(0);
            this.remote.rightButtonPressed(1);

            // Initialise Budget Singleton
            Budget budget = Budget.getBudgetInstance();

            // Initialise Cake Bakery Facade
            this.cakeBakeryFacade = new CakeBakeryFacade(cakeBakery, budget, waiter);

//            // 2. Instantiate Cake Bakery object (Singleton)
//        CakeBakery cakeBakery = CakeBakery.getCakeBakeryInstance();
//
//        // 3. Instantiate Budget object (Singleton)
//        Budget budget = Budget.getBudgetInstance();
////        Text budgetTxt = new Text("Point: " + budget.getBudget());
////        budgetTxt.setFont(Font.font("Verdana", 30));
//

            FXMLLoader loader = new FXMLLoader(getClass().getResource("main-cake-bakery.fxml"));
            loader.setController(this);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Cake Bakery");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onBtnOpenBakeryClick(MouseEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        cakeBakeryFacade.onOpen();
        this.imgBackground.setImage(loadImage(this.light.getLightingEffect()));
        controlBackgroundMusic(music);
        imgBakeryClosedBackground.setVisible(false);
        Menu menu = Menu.getMenuInstance();
        setMenu(menu);
        if (isFirstTimeOpenRestaurant) {
            spMain.setVisible(true);
            gpTopUp.setVisible(true);
//            btnTopUpCancel.setVisible(false);
            isFirstTimeOpenRestaurant = false;
        }
    }

    public void setMenu(Menu menu) {
        bakedCakesList = menu.getBakedCakes();
        imgBakedCake1.setImage(loadImage(bakedCakesList.get(0).getCakeItemImg()));
        labelBakedCake1.setText(bakedCakesList.get(0).getCakeItemName());
        labelBakedCakePrice1.setText("$" + Double.toString(bakedCakesList.get(0).getCakeItemPrice()));
        imgBakedCake2.setImage(loadImage(bakedCakesList.get(1).getCakeItemImg()));
        labelBakedCake2.setText(bakedCakesList.get(1).getCakeItemName());
        labelBakedCakePrice2.setText("$" + Double.toString(bakedCakesList.get(1).getCakeItemPrice()));
        imgBakedCake3.setImage(loadImage(bakedCakesList.get(2).getCakeItemImg()));
        labelBakedCake3.setText(bakedCakesList.get(2).getCakeItemName());
        labelBakedCakePrice3.setText("$" + Double.toString(bakedCakesList.get(2).getCakeItemPrice()));
        imgBakedCake4.setImage(loadImage(bakedCakesList.get(3).getCakeItemImg()));
        labelBakedCake4.setText(bakedCakesList.get(3).getCakeItemName());
        labelBakedCakePrice4.setText("$" + Double.toString(bakedCakesList.get(3).getCakeItemPrice()));
        imgBakedCake5.setImage(loadImage(bakedCakesList.get(4).getCakeItemImg()));
        labelBakedCake5.setText(bakedCakesList.get(4).getCakeItemName());
        labelBakedCakePrice5.setText("$" + Double.toString(bakedCakesList.get(4).getCakeItemPrice()));

        crepeCakesList = menu.getCrepeCakes();
        imgCrepeCake1.setImage(loadImage(crepeCakesList.get(0).getCakeItemImg()));
        labelCrepeCake1.setText(crepeCakesList.get(0).getCakeItemName());
        labelCrepeCakePrice1.setText("$" + Double.toString(crepeCakesList.get(0).getCakeItemPrice()));
        imgCrepeCake2.setImage(loadImage(crepeCakesList.get(1).getCakeItemImg()));
        labelCrepeCake2.setText(crepeCakesList.get(1).getCakeItemName());
        labelCrepeCakePrice2.setText("$" + Double.toString(crepeCakesList.get(1).getCakeItemPrice()));
        imgCrepeCake3.setImage(loadImage(crepeCakesList.get(2).getCakeItemImg()));
        labelCrepeCake3.setText(crepeCakesList.get(2).getCakeItemName());
        labelCrepeCakePrice3.setText("$" + Double.toString(crepeCakesList.get(2).getCakeItemPrice()));
        imgCrepeCake4.setImage(loadImage(crepeCakesList.get(3).getCakeItemImg()));
        labelCrepeCake4.setText(crepeCakesList.get(3).getCakeItemName());
        labelCrepeCakePrice4.setText("$" + Double.toString(crepeCakesList.get(3).getCakeItemPrice()));
        imgCrepeCake5.setImage(loadImage(crepeCakesList.get(4).getCakeItemImg()));
        labelCrepeCake5.setText(crepeCakesList.get(4).getCakeItemName());
        labelCrepeCakePrice5.setText("$" + Double.toString(crepeCakesList.get(4).getCakeItemPrice()));

        condimentsList = menu.getCondiments();
        imgCondiment1.setImage(loadImage(condimentsList.get(0).getCakeItemImg()));
        labelCondiment1.setText(condimentsList.get(0).getCakeItemName());
        labelCondimentPrice1.setText("$" + Double.toString(condimentsList.get(0).getCakeItemPrice()));
        imgCondiment2.setImage(loadImage(condimentsList.get(1).getCakeItemImg()));
        labelCondiment2.setText(condimentsList.get(1).getCakeItemName());
        labelCondimentPrice2.setText("$" + Double.toString(condimentsList.get(1).getCakeItemPrice()));
        imgCondiment3.setImage(loadImage(condimentsList.get(2).getCakeItemImg()));
        labelCondiment3.setText(condimentsList.get(2).getCakeItemName());
        labelCondimentPrice3.setText("$" + Double.toString(condimentsList.get(2).getCakeItemPrice()));

    }


    @FXML
    private void onBtnCloseBakeryClick(MouseEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        cakeBakeryFacade.onClose();
        controlBackgroundMusic(music);
        this.imgBakeryClosedBackground.setVisible(true);
    }

    @FXML
    public void onImgControlClicked(MouseEvent event) {
        spMain.setVisible(true);
        gpControl.setVisible(true);
    }

    @FXML
    private void onBtnCounterClick(MouseEvent event) {
        spMain.setVisible(true);
        spCakeType.setVisible(true);
    }

    @FXML
    private void onTopUpCancelClick(MouseEvent event) {

        spMain.setVisible(false);
        gpTopUp.setVisible(false);
    }


    @FXML
    private void onbtnTopUpOKClick(MouseEvent event) {
        taTopUpValue.getText();
        System.out.println(taTopUpValue.getText()
        );
        taTopUpValue.setText("");
        spMain.setVisible(false);
        gpTopUp.setVisible(false);
    }


    @FXML
    private void onImgCashTagClick(MouseEvent event) {
        // Handle click on imgCashTag
    }

    @FXML
    private void onImgTopUpClick(MouseEvent event) {
        spMain.setVisible(true);
        gpTopUp.setVisible(true);
    }

    @FXML
    private void onSpMainClick(MouseEvent event) {
        // Handle click on spMain
    }

    @FXML
    private void onGpControlClick(MouseEvent event) {
        // Handle click on gpControl
    }

    @FXML
    private void onImgControlInteriorClick(MouseEvent event) {
        // Handle click on imgControlInterior
    }

    @FXML
    private void onBtnLightOnClick(MouseEvent event) {
        // Handle click on btnLightOn
        this.remote.leftButtonPressed(0);
        this.imgBackground.setImage(loadImage(this.light.getLightingEffect()));
    }

    @FXML
    private void onBtnLightOffClick(MouseEvent event) {
        // Handle click on btnLightOff
        this.remote.rightButtonPressed(0);
        this.imgBackground.setImage(loadImage(this.light.getLightingEffect()));
    }

    @FXML
    private void onBtnPreviousSongClick(MouseEvent event) {
        if (mediaPlayer != null) mediaPlayer.stop();
        this.remote.leftButtonPressed(2);
        if (!music.isOff()) {
            controlBackgroundMusic(music);
        }
    }

    @FXML
    private void onBtnNextSongClick(MouseEvent event) {
        if (mediaPlayer != null) mediaPlayer.stop();
        this.remote.rightButtonPressed(2);
        if (!music.isOff()) {
            controlBackgroundMusic(music);
        }
    }

    @FXML
    private void onBtnStopMusicClick(MouseEvent event) {
        if (mediaPlayer != null) mediaPlayer.stop();
        this.remote.rightButtonPressed(1);
        controlBackgroundMusic(music);
//        imgSpeakerNotes.setVisible(false);
    }

    @FXML
    private void onBtnPlayMusicClick(MouseEvent event) {
        if (mediaPlayer == null || !mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING)) {
            this.remote.leftButtonPressed(1);
            controlBackgroundMusic(music);
//            imgSpeakerNotes.setVisible(true);
        }
    }

    @FXML
    private void onSpCakeTypeClick(MouseEvent event) {
        // Handle click on spCakeType
    }

    @FXML
    private void onBtnCloseControlClick(MouseEvent event) {
        spMain.setVisible(false);
        gpControl.setVisible(false);
    }

    @FXML
    private void onBtnCrossCakeTypeClick(MouseEvent event) {
        // Handle click on btnCrossCakeType
        spMain.setVisible(false);
        spCakeType.setVisible(false);
    }

    @FXML
    private void onGpBakedCakesClick(MouseEvent event) {
        spCakeType.setVisible(false);
        spBaseCake.setVisible(true);
    }

    @FXML
    private void onGpCrepeCakesClick(MouseEvent event) {
        spCakeType.setVisible(false);
        spCrepeCake.setVisible(true);
    }

    @FXML
    private void onBtnCrossBaseCakeClick(MouseEvent event) {
        spMain.setVisible(false);
        spBaseCake.setVisible(false);
    }

    @FXML
    private void onGpBakedCakeChoice1Click(MouseEvent event) {
        choosedCake = bakedCakesList.get(0);
        setSelectedCakeUI(choosedCake);
    }

    @FXML
    private void onGpBakedCakeChoice2Click(MouseEvent event) {
        choosedCake = bakedCakesList.get(1);
        setSelectedCakeUI(choosedCake);
    }

    @FXML
    private void onGpBakedCakeChoice3Click(MouseEvent event) {
        choosedCake = bakedCakesList.get(2);
        setSelectedCakeUI(choosedCake);
    }

    @FXML
    private void onGpBakedCakeChoice4Click(MouseEvent event) {
        choosedCake = bakedCakesList.get(3);
        setSelectedCakeUI(choosedCake);
    }

    @FXML
    private void onGpBakedCakeChoice5Click(MouseEvent event) {
        choosedCake = bakedCakesList.get(4);
        setSelectedCakeUI(choosedCake);
    }

    ;

    @FXML
    private void onGpCrepeCakeChoice1Click(MouseEvent event) {
        choosedCake = crepeCakesList.get(0);
        setSelectedCakeUI(choosedCake);
    }

    @FXML
    private void onGpCrepeCakeChoice2Click(MouseEvent event) {
        choosedCake = crepeCakesList.get(1);
        setSelectedCakeUI(choosedCake);
    }

    @FXML
    private void onGpCrepeCakeChoice3Click(MouseEvent event) {
        choosedCake = crepeCakesList.get(2);
        setSelectedCakeUI(choosedCake);
    }

    @FXML
    private void onGpCrepeCakeChoice4Click(MouseEvent event) {
        choosedCake = crepeCakesList.get(3);
        setSelectedCakeUI(choosedCake);
    }

    @FXML
    private void onGpCrepeCakeChoice5Click(MouseEvent event) {
        choosedCake = crepeCakesList.get(4);
        setSelectedCakeUI(choosedCake);
    }

    ;
//    @FXML
//    private void onGpChocolateCakeClick(MouseEvent event) {
//        setSelectedCakeUI("Chocolate", "Baked Cake");
//
//    }
//
//    @FXML
//    private void onGpVanillaCakeClick(MouseEvent event) {
//        setSelectedCakeUI("Vanilla", "Baked Cake");
//
//    }
//
//    @FXML
//    private void onGpTiramisuCakeClick(MouseEvent event) {
//        setSelectedCakeUI("Tiramisu", "Baked Cake");
//
//    }
//
//    @FXML
//    private void onGpRedVelvetCakeClick(MouseEvent event) {
//        setSelectedCakeUI("Red Velvet", "Baked Cake");
//
//    }
//
//    @FXML
//    private void onGpMatchaCakeClick(MouseEvent event) {
//        setSelectedCakeUI("Matcha", "Baked Cake");
//
//    }

    @FXML
    private void onBtnCrossCrepeCakeClick(MouseEvent event) {
        spMain.setVisible(false);
        spCrepeCake.setVisible(false);
    }

//    @FXML
//    private void onGpChocolateCrepeCakeClick(MouseEvent event) {
//        setSelectedCakeUI("Chocolate", "Crepe Cake");
//
//    }
//
//    @FXML
//    private void onGpVanillaCrepeCakeClick(MouseEvent event) {
//        setSelectedCakeUI("Vanilla", "Crepe Cake");
//
//    }
//
//    @FXML
//    private void onGpTiramisuCrepeCakeClick(MouseEvent event) {
//        setSelectedCakeUI("Tiramisu", "Crepe Cake");
//
//    }
//
//    @FXML
//    private void onGpRedVelvetCrepeCakeClick(MouseEvent event) {
//        setSelectedCakeUI("Red Velvet", "Crepe Cake");
//    }
//
//    @FXML
//    private void onGpMatchaCrepeCakeClick(MouseEvent event) {
//        setSelectedCakeUI("Matcha", "Crepe Cake");
//    }

    @FXML
    private void onBtnCrossCondimentsClick(MouseEvent event) {
        spMain.setVisible(false);
        spCondiments.setVisible(false);
    }

    @FXML
    private void onBtnPayClick(MouseEvent event) throws InterruptedException {
        spCondiments.setVisible(false);
        gpFactoryProcess.setVisible(true);
        System.out.println(choosedCondimentNameList);
        choosedCondimentImageViewList.add(imgFinalCondiment1);
        choosedCondimentImageViewList.add(imgFinalCondiment2);
        choosedCondimentImageViewList.add(imgFinalCondiment3);
        if (choosedCake.getCakeType().equals("Crepe Cake")) {
            CrepeCakeFactory crepeCakeFactory = new CrepeCakeFactory();
            crepeCakeFactory.orderCake(choosedCake.getCakeItemName().toLowerCase(), imgFactoryProcess, labelFactoryProcess,choosedCondimentNameList,choosedCondimentImageViewList,imgFinalCake,apFinalCakeItem, gpFactoryProcess, spMain);
        } else if (choosedCake.getCakeType().equals("Baked Cake")) {
            BakedCakeFactory bakedCakeFactory = new BakedCakeFactory();
            bakedCakeFactory.orderCake(choosedCake.getCakeItemName().toLowerCase(), imgFactoryProcess, labelFactoryProcess,choosedCondimentNameList,choosedCondimentImageViewList,imgFinalCake,apFinalCakeItem, gpFactoryProcess, spMain);
        }
        resetAllSpinners();
    }

    private void createFactoryProcessImage() {


    }


    @FXML
    private void onBtnCancelClick(MouseEvent event) {
        spMain.setVisible(false);
        spCondiments.setVisible(false);
        resetAllSpinners();
    }

    private void showCondimentPageSettings() {
        imgCondimentOne.setImage(new Image(""));
        imgCondimentTwo.setImage(new Image(""));
        imgCondimentThree.setImage(new Image(""));

    }

    private void setSelectedCakeUI(Cake cake) {
        // Set the visibility of the panels
        spCrepeCake.setVisible(false);
        spBaseCake.setVisible(false);
        spCondiments.setVisible(true);

        // Construct the image path using the cakeName and cakeType
//        String imagePath = String.format("com/mycompany/cakebakery/picture/cake/%ss/%s-%s.png", cake.getCakeType().toLowerCase().replace(" ", "-"), cake.getCakeItemName().toLowerCase().replace(" ", "-"), cake.getCakeType().toLowerCase().replace(" ", "-"));

        // Set the image to the ImageView
        imgChoosedCake.setImage(new Image(cake.getCakeItemImg()));

        // Update the label text
        labelChoosedCakeName.setText(cake.getCakeItemName() + " " + cake.getCakeType());
        labelTotalPrice.setText("Total Price: " + cake.getCakeItemPrice());
        initializeSpinner();

    }

    private Alert alert = null;

    // ...

    private boolean ignoreChange = false; // flag to ignore listener when programmatically setting value

    // ...

//    private void initializeSpinner() {
//        ChangeListener<Number> listener = (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
//            if (!ignoreChange) {
//                int total = calculateTotal();
//                if (total > 3) {
//                    ignoreChange = true; // Set the flag to ignore subsequent changes
//
//                    resetAllSpinners(); // Reset all spinners to zero immediately
//
//                    Platform.runLater(() -> {
//                        showAlert(); // Show the alert
//                        // The flag will be reset after the alert is dismissed within showAlert
//                    });
//                }
//            }
//        };
//
//        spinnerStrawberry.valueProperty().addListener(listener);
//        spinnerMarcron.valueProperty().addListener(listener);
//        spinnerChocolate.valueProperty().addListener(listener);
//    }
//
//
//    private void resetAllSpinners() {
//        spinnerStrawberry.getValueFactory().setValue(0);
//        spinnerMarcron.getValueFactory().setValue(0);
//        spinnerChocolate.getValueFactory().setValue(0);
//        spinnerChocolate.getEditor().setAlignment(Pos.CENTER);
//        spinnerMarcron.getEditor().setAlignment(Pos.CENTER);
//        spinnerStrawberry.getEditor().setAlignment(Pos.CENTER);
//    }
//
//    private void showAlert() {
//        // Only create a new alert if there isn't one already showing
//        if (alert == null || !alert.isShowing()) {
//            alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Limit Exceeded");
//            alert.setHeaderText(null);
//            alert.setContentText("The total cannot exceed 3.");
//
//            // This will block the calling thread, so it's okay to reset the ignoreChange flag after it
//            alert.showAndWait();
//
//            // After the alert is dismissed, reset the flag
//            ignoreChange = false;
//
////            initializeSpinner();
//        }
//    }

    //    private void initializeSpinner() {
//        ChangeListener<Number> listener = (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
//            if (!ignoreChange) {
//                int total = calculateTotal();
//                if (total > 3) {
//                    ignoreChange = true; // Set the flag to ignore subsequent changes
//
//                    resetAllSpinners(); // Reset all spinners to zero immediately
//
//                    Platform.runLater(() -> {
//                        showAlert(); // Show the alert
//                    });
//                }
//            }
//        };
//
//        spinnerStrawberry.valueProperty().addListener(listener);
//        spinnerMarcron.valueProperty().addListener(listener);
//        spinnerChocolate.valueProperty().addListener(listener);
//    }
//
    private void resetAllSpinners() {
        spinnerCondiment2.getValueFactory().setValue(0);
        spinnerCondiment1.getValueFactory().setValue(0);
        spinnerCondiment3.getValueFactory().setValue(0);
        // Center alignment can be set here or in the FXML/CSS
    }
//
//    private void showAlert() {
//        if (alert == null || !alert.isShowing()) {
//            alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Limit Exceeded");
//            alert.setHeaderText(null);
//            alert.setContentText("The total cannot exceed 3.");
//            alert.showAndWait();
//            ignoreChange = false;
//        }
//    }
//
//    private int calculateTotal() {
//        return spinnerStrawberry.getValue() + spinnerMarcron.getValue() + spinnerChocolate.getValue();
//    }

    private void initializeSpinner() {
        ChangeListener<Number> listener = (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (!ignoreChange) {
                updateSpinnerMaximums();
                updateTotalPrice();
            }
            updateImageViews();
        };

        updateImageViews();
        spinnerCondiment2.valueProperty().addListener(listener);
        spinnerCondiment1.valueProperty().addListener(listener);
        spinnerCondiment3.valueProperty().addListener(listener);
    }

    private void updateSpinnerMaximums() {
        int total = calculateTotal();

        int maxForCondiment2 = Math.max(0, 3 - total + spinnerCondiment2.getValue());
        spinnerCondiment2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, maxForCondiment2, spinnerCondiment2.getValue()));
        int maxForCondiment1 = Math.max(0, 3 - total + spinnerCondiment1.getValue());
        spinnerCondiment1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, maxForCondiment1, spinnerCondiment1.getValue()));
        int maxForCondiment3 = Math.max(0, 3 - total + spinnerCondiment3.getValue());
        spinnerCondiment3.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, maxForCondiment3, spinnerCondiment3.getValue()));
    }

    private void updateTotalPrice() {
        System.out.println(choosedCake.getCakeItemPrice());
    }


    private int calculateTotal() {
        return spinnerCondiment2.getValue() + spinnerCondiment1.getValue() + spinnerCondiment3.getValue();
    }

    private void updateImageViews() {
        // First, clear all images
        imgCondimentOne.setImage(null);
        imgCondimentTwo.setImage(null);
        imgCondimentThree.setImage(null);
        choosedCondimentNameList = new ArrayList<String>();

        // Now, load the images based on the spinner values
        int totalCondiments = 0;
        Image condimentOneImage = loadImage(condimentsList.get(0).getCakeItemImg());
        Image condimentTwoImage = loadImage(condimentsList.get(1).getCakeItemImg());
        Image condimentThreeImage = loadImage(condimentsList.get(2).getCakeItemImg());


        // Update for strawberries
        for (int i = 0; i < spinnerCondiment2.getValue(); i++) {
            updateCondimentImageView(totalCondiments, imgCondimentOne, imgCondimentTwo, imgCondimentThree, condimentTwoImage, condimentsList.get(1).getCakeItemName());
            totalCondiments++;
        }

        // Update for macrons
        for (int i = 0; i < spinnerCondiment1.getValue(); i++) {
            updateCondimentImageView(totalCondiments, imgCondimentOne, imgCondimentTwo, imgCondimentThree, condimentOneImage, condimentsList.get(0).getCakeItemName());
            totalCondiments++;
        }

        // Update for chocolate
        for (int i = 0; i < spinnerCondiment3.getValue(); i++) {
            updateCondimentImageView(totalCondiments, imgCondimentOne, imgCondimentTwo, imgCondimentThree, condimentThreeImage, condimentsList.get(2).getCakeItemName());
            totalCondiments++;
        }
    }
    private void updateCondimentImageView(int totalCondiments, ImageView imgOne, ImageView imgTwo, ImageView imgThree, Image condimentImage, String condimentName) {
        if (totalCondiments == 0) {
            imgOne.setImage(condimentImage);
            choosedCondimentNameList.add(condimentName);
        } else if (totalCondiments == 1) {
            imgTwo.setImage(condimentImage);
            if (choosedCondimentNameList.size() < 2) {
                choosedCondimentNameList.add(condimentName);
            } else {
                choosedCondimentNameList.set(1, condimentName);
            }
        } else if (totalCondiments == 2) {
            imgThree.setImage(condimentImage);
            if (choosedCondimentNameList.size() < 3) {
                choosedCondimentNameList.add(condimentName);
            } else {
                choosedCondimentNameList.set(2, condimentName);
            }
        }
    }

    private Image loadImage(String resourcePath) {
        InputStream stream = getClass().getResourceAsStream(resourcePath);
        if (stream == null) {
            throw new RuntimeException("Cannot get resource " + resourcePath);
        }
        return new Image(stream);
    }

//    private void showAlert() {
//        if (alert == null || !alert.isShowing()) {
//            Platform.runLater(() -> {
//                alert = new Alert(Alert.AlertType.WARNING);
//                alert.setTitle("Limit Exceeded");
//                alert.setHeaderText(null);
//                alert.setContentText("The total cannot exceed 3.");
//                alert.showAndWait();
//            });
//        }
//    }


//    @Override
//    public void start(Stage stage) throws IOException {
//        // 1. Set up the layout to display the GUI
//        this.CakeBakeryLayout = this.initializeLayout();
//        this.CakeMenuLayout = this.initializeMenuLayout();
//        this.CakeLayout = this.initializeCakeLayout();
//
//        // 2. Instantiate Cake Bakery object (Singleton)
//        CakeBakery cakeBakery = CakeBakery.getCakeBakeryInstance();
//
//        // 3. Instantiate Budget object (Singleton)
//        Budget budget = Budget.getBudgetInstance();
////        Text budgetTxt = new Text("Point: " + budget.getBudget());
////        budgetTxt.setFont(Font.font("Verdana", 30));
//
//        // 4. Initialise all the necessary set up for Command Design Pattern using cakeBakery instance
//        // Get the "Receiver" instance from the `CakeBakery`
//        Lighting lighting = cakeBakery.getLight();
//        Music music = cakeBakery.getMusic();
//        setUpCommandPattern(cakeBakery, lighting, music);
//
//        // 5. Initialise all the buttons for remote control
//        Button lightingOnButton = new Button("Lighting On");
//        Button lightingOffButton = new Button("Lighting Off");
//        Button musicOnButton = new Button("Speaker On");
//        Button musicOffButton = new Button("Speaker Off");
//        Button swapPrevMusicButton = new Button("Previous Music");
//        Button swapNextMusicButton = new Button("Next Music");
//
//        // 5. Initialise all the buttons for placing / canceling order
//        Button placeOrderButton = new Button("Place Order");
//        Button cancelOrderButton = new Button("Cancel Order");
//
//        // 5. Initialise the CakeBakeryFacade
//        CakeBakeryFacade cakeBakeryFacade = new CakeBakeryFacade(cakeBakery, budget, waiter);
//        Button onOpenRestaurantButton = new Button("Open Restaurant");
//        Button onCloseRestaurantButton = new Button("Close Restaurant");
//
//        Button toMenuSceneButton = new Button("Menu");
//        Button fromMenuToLayoutSceneButton = new Button("Back");
//        Button fromCakeToMenuSceneButton = new Button("Back to Menu");
//
//        // 5. Initialise the button for top up budget (Singleton)
//        Button topUpButton = new Button("Top Up");
//
//        initializeCakeBakeryControlPanel(lightingOnButton, lightingOffButton, musicOnButton, musicOffButton, swapPrevMusicButton, swapNextMusicButton);
//        initializeMenuControlPanel(fromMenuToLayoutSceneButton);
//        initializeCakeControlPanel(fromCakeToMenuSceneButton);
//        initializeBudgetControlPanel(topUpButton); // Singleton
//
//        // 6. Set up CakeBakeryLayout && CakeMenuLayout
//        displayCakeBakery(cakeBakery, true, onOpenRestaurantButton, onCloseRestaurantButton, toMenuSceneButton);
//        TableView<Cake> menu = displayMenu(cakeBakery, placeOrderButton);
//
//        // 7. Initialise the button to change from one scene to another
//        // 8. Different scenes for different layout
//        Scene CakeBakeryLayoutScene = new Scene(CakeBakeryLayout, width, height);
//        Scene CakeMenuLayoutScene = new Scene(CakeMenuLayout, width, height);
//        Scene CakeLayoutScene = new Scene(CakeLayout, width, height);
//
//        this.CakeBakeryControlPanel.setViewOrder(-1.0);
//        this.MenuControlPanel.setViewOrder(-1.0);
//        this.CakeControlPanel.setViewOrder(-1.0);
//        onOpenRestaurantButton.setViewOrder(-1.0);
//        onCloseRestaurantButton.setViewOrder(-1.0);
//        toMenuSceneButton.setViewOrder(-1.0);
//
//        //Singleton
//        this.BudgetControlPanel.setViewOrder(-1.0);
//
//        // 7. Set the default layout as `CakeBakery` layout
//        stage.setScene(CakeBakeryLayoutScene);
//        stage.setTitle("Virtual Space - CakeBakery");
//        stage.show();
//
//        toMenuSceneButton.setOnAction(e -> stage.setScene(CakeMenuLayoutScene));
//        fromMenuToLayoutSceneButton.setOnAction(e -> {
////            this.selectedCake = null;
//            stage.setScene(CakeBakeryLayoutScene);
//        });
//        fromCakeToMenuSceneButton.setOnAction(e -> stage.setScene(CakeMenuLayoutScene));
//
//        // Facade Button Action
//        onOpenRestaurantButton.setOnAction(event -> {
//            if (mediaPlayer != null) {
//                mediaPlayer.stop();
//            }
//            cakeBakeryFacade.onOpen();
//            displayCakeBakery(cakeBakery, false, onOpenRestaurantButton, onCloseRestaurantButton, toMenuSceneButton);
//
//            // Show the budget input dialog only for first time entering customer (Singleton)
//            if (isFirstTimeOpenRestaurant) {
//                showBudgetInputDialog(cakeBakeryFacade, stage, onOpenRestaurantButton, onCloseRestaurantButton, toMenuSceneButton);
//                isFirstTimeOpenRestaurant = false;
//            }
//        });
//
//        onCloseRestaurantButton.setOnAction(event -> {
//            if (mediaPlayer != null) {
//                mediaPlayer.stop();
//            }
//            cakeBakeryFacade.onClose();
//            displayCakeBakery(cakeBakery, true, onOpenRestaurantButton, onCloseRestaurantButton, toMenuSceneButton);
//        });
//
//        // Command Button Action
//        lightingOnButton.setOnAction(event -> {
//            this.remote.leftButtonPressed(0);
//            this.updateImageInUI(this.CakeBakeryLayout, lighting.getLightingEffect(), 400, 700, 0, 0, 4, 3);
//        });
//
//        lightingOffButton.setOnAction(event -> {
//            this.remote.rightButtonPressed(0);
//            this.updateImageInUI(this.CakeBakeryLayout, lighting.getLightingEffect(), 400, 700, 0, 0, 4, 3);
//        });
//
//        musicOnButton.setOnAction(event -> {
//            this.remote.leftButtonPressed(1);
//            controlBackgroundMusic(music);
//            this.updateImageInUI(this.CakeBakeryLayout, music.getMusicImg(), 400, 400, 3, 2, 4, 4);
//        });
//
//        musicOffButton.setOnAction(event -> {
//            if (mediaPlayer != null) {
//                mediaPlayer.stop();
//            }
//            this.remote.rightButtonPressed(1);
//            controlBackgroundMusic(music);
//            this.updateImageInUI(this.CakeBakeryLayout, music.getMusicImg(), 400, 400, 3, 2, 4, 4);
//        });
//
//        swapPrevMusicButton.setOnAction(event -> {
//            if (mediaPlayer != null) {
//                mediaPlayer.stop();
//            }
//            this.remote.leftButtonPressed(2);
//            if (!music.isOff()) {
//                controlBackgroundMusic(music);
//            }
//        });
//
//        swapNextMusicButton.setOnAction(event -> {
//            if (mediaPlayer != null) {
//                mediaPlayer.stop();
//            }
//            this.remote.rightButtonPressed(2);
//            if (!music.isOff()) {
//                controlBackgroundMusic(music);
//            }
//        });
//
//        menu.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, selected) -> {
//            this.selectedCake = selected;
//        });
//
//        placeOrderButton.setOnAction(event -> {
//            if (selectedCake != null) {
//                if (!cakeBakeryFacade.placeNewOrder(selectedCake)) {
//                    this.alertWarning(cakeBakeryFacade.getMessage());
//                } else {
//                    displayCake(this.selectedCake, fromCakeToMenuSceneButton, cancelOrderButton);
//                    this.updateBudgetDisplay();
//                    stage.setScene(CakeLayoutScene);
//                }
//            }
//        });
//
//        cancelOrderButton.setOnAction(event -> {
//            cakeBakeryFacade.cancelCurrentOrder();
//            stage.setScene(CakeMenuLayoutScene);
//        });
//
//        //Singleton Button Action
//        topUpButton.setOnAction(event -> {
//            showBudgetTopUpDialog(topUpButton);
//        });
//
//        setRoot("main-cake-bakery");
//
//    }


//    static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml));
//    }
//
//    private static Parent loadFXML(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(CakeBakeryApplication.class.getResource(fxml + ".fxml"));
//        return fxmlLoader.load();
//    }

    public static void main(String[] args) throws IOException {
        launch();
    }

    // Render the entire Layout
    public void displayCakeBakery(CakeBakery cakeBakery, boolean isClose, Button onOpenRestaurantButton, Button onCloseRestaurantButton, Button menuButton) {
        CakeBakeryLayout.getChildren().clear();
        String background = cakeBakery.getBackground();
        Lighting lighting = cakeBakery.getLight();
        Music music = cakeBakery.getMusic();

        // Set image in layoutScene
        try {
            // 1. Create background UI
            setImageInUI(CakeBakeryLayout, Background.displayView(width, height, background), 0, 0, 4, 4);

            // 2. Create lighting UI
            setImageInUI(CakeBakeryLayout, Background.displayView(400, 700, lighting.getLightingEffect()), 0, 0, 4, 3);

            // 3. Create music UI
//            setImageInUI(CakeBakeryLayout, Background.displayView(400, 400, music.getMusicImg()), 3, 2, 4, 4);

            // 4. Dynamic layout / buttons based on the open / close of cake bakery
            if (isClose) {
                String closed_sign = cakeBakery.getClosed_sign();
                // 4. Create Black Background when cake bakery is closed
                setImageInUI(CakeBakeryLayout, Background.displayBlackBackground(width, height, 0.4), 0, 0, 4, 4);
                // 5. Create Closed sign UI
                setImageInUI(CakeBakeryLayout, Background.displayView(300, 300, closed_sign), 0, 0, 4, 4);
                CakeBakeryLayout.add(onOpenRestaurantButton, 3, 3, 1, 1);
            } else {
                String waiter = cakeBakery.getWaiter();
                StackPane stackpane = Background.displayView(400, 400, waiter);
                stackpane.setViewOrder(-1.0);
                setImageInUI(CakeBakeryLayout, stackpane, 1, 1, 4, 4);
                GridPane.setMargin(menuButton, new Insets(0, 0, 0, 5));
                CakeBakeryLayout.add(menuButton, 0, 3);
                CakeBakeryLayout.add(onCloseRestaurantButton, 3, 3, 1, 4);
                CakeBakeryLayout.add(CakeBakeryControlPanel, 0, 0, 3, 3);

                //Singleton
                CakeBakeryLayout.add(BudgetControlPanel, 3, 0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        controlBackgroundMusic(cakeBakery.getMusic());
    }

    // Render the entire Layout
//    public void displayCake(Cake selectedCake, Button backButton, Button cancelOrderButton) {
//        CakeLayout.getChildren().clear();
//        CakeLayout.getChildren().add(backButton);
//        // Container for the cake image
//        StackPane cakeDisplayContainer = new StackPane();
//        cakeDisplayContainer.getChildren().add(selectedCake.display(400, 400));
//
//        // Container for the buttons
//        VBox buttonBox = new VBox(10);
//        buttonBox.setAlignment(Pos.CENTER);
//
//        // Add buttons to the VBox
//        Button addStrawberryButton = new Button("Add Strawberry");
//        addStrawberryButton.setOnAction(e -> {
//            selectedCake.addDecoration("cake_decoration_strawberry.png");
//            updateCakeDisplay(selectedCake, cakeDisplayContainer);
//        });
//        buttonBox.getChildren().add(addStrawberryButton);
//
//        Button addBlueberryButton = new Button("Add Blueberry");
//        addBlueberryButton.setOnAction(e -> {
//            selectedCake.addDecoration("cake_decoration_blueberry.png");
//            updateCakeDisplay(selectedCake, cakeDisplayContainer);
//        });
//        buttonBox.getChildren().add(addBlueberryButton);
//
//        Button addFrostingButton = new Button("Add Frosting");
//        addFrostingButton.setOnAction(e -> {
//            selectedCake.addDecoration("cake_decoration_frosting.png");
//            updateCakeDisplay(selectedCake, cakeDisplayContainer);
//        });
//        buttonBox.getChildren().add(addFrostingButton);
//
//        // Layout for cake and buttons
//        HBox cakeAndButtons = new HBox(10, cakeDisplayContainer, buttonBox);
//        cakeAndButtons.setAlignment(Pos.CENTER);
//
//        CakeLayout.getChildren().addAll(cakeAndButtons, cancelOrderButton);
//    }
//
//    public void updateCakeDisplay(Cake cake, StackPane cakeDisplayContainer) {
//        cakeDisplayContainer.getChildren().clear();
//        cakeDisplayContainer.getChildren().add(cake.display(400, 400));
//    }


    public TableView<Cake> displayMenu(CakeBakery cakeBakery, Button placeOrderButton) {
        Menu cakes = cakeBakery.getMenu();
        cakes.generateTableView();
        TableView<Cake> menu = cakes.getTable();
        CakeMenuLayout.getChildren().clear();
        CakeMenuLayout.getChildren().addAll(MenuControlPanel, menu, placeOrderButton);
        return menu;
    }

    public void setImageInUI(GridPane gridPane, StackPane stackPane, int columnIndex, int rowIndex, int columnSpan, int rowSpan) {
        try {
            gridPane.add(stackPane, columnIndex, rowIndex, columnSpan, rowSpan);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateImageInUI(GridPane gridPane, String imagePath, double width, double height, int columnIndex, int rowIndex, int columnSpan, int rowSpan) {

        gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == columnIndex && GridPane.getRowIndex(node) == rowIndex && GridPane.getColumnSpan(node) == columnSpan && GridPane.getRowSpan(node) == rowSpan);
        gridPane.add(Background.displayView(width, height, imagePath), columnIndex, rowIndex, columnSpan, rowSpan);
    }

    public GridPane initializeLayout() {
        // Initialize layout
        GridPane gridPaneLayoutScene = new GridPane();
        gridPaneLayoutScene.setHgap(10);
        gridPaneLayoutScene.setVgap(10);

        // Total 4 column where each column.width == 25% parent.width
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(25);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(25);
        gridPaneLayoutScene.getColumnConstraints().addAll(column1, column2, column3, column4);

        // Total 4 row where each row.height == 25% parent.height
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(25);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(25);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(25);
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(25);
        gridPaneLayoutScene.getRowConstraints().addAll(row1, row2, row3, row4);
        return gridPaneLayoutScene;
    }

    public VBox initializeMenuLayout() {
        VBox box = new VBox(3);
        return box;
    }

    public VBox initializeCakeLayout() {
        VBox box = new VBox(3);
        box.setAlignment(Pos.CENTER);
        return box;
    }

    public void initializeCakeBakeryControlPanel(Button lightingOnButton, Button lightingOffButton, Button musicOnButton, Button musicOffButton, Button swapPrevMusicButton, Button swapNextMusicButton) {
        CakeBakeryControlPanel = new VBox(3);
        HBox light_buttons = new HBox(2);
        light_buttons.getChildren().addAll(lightingOnButton, lightingOffButton);
        HBox music_buttons = new HBox(2);
        music_buttons.getChildren().addAll(musicOnButton, musicOffButton);
        HBox swap_music_buttons = new HBox(2);
        swap_music_buttons.getChildren().addAll(swapPrevMusicButton, swapNextMusicButton);
        CakeBakeryControlPanel.getChildren().addAll(light_buttons, music_buttons, swap_music_buttons);
        CakeBakeryControlPanel.setPadding(new Insets(3, 0, 0, 5));
    }

    public void initializeMenuControlPanel(Button backButton) {
        MenuControlPanel = new HBox(2);
        MenuControlPanel.getChildren().add(backButton);
    }

    public void initializeCakeControlPanel(Button backButton) {
        CakeControlPanel = new HBox(2);
    }

    //Singleton
    public void initializeBudgetControlPanel(Button topUp) {
        BudgetControlPanel = new HBox(10);
        budgetLabel = new Label("Budget: " + Budget.getBudgetInstance().getBudget());
        budgetLabel.setFont(new Font("Arial", 22));
        BudgetControlPanel.getChildren().addAll(budgetLabel, topUp);
        BudgetControlPanel.setAlignment(Pos.CENTER_LEFT); // Adjust alignment as needed
    }

    public void setUpCommandPattern(CakeBakery cakeBakery, Lighting lighting, Music music) {
        // Initialise Remote Control
        remote = new RemoteControl();
        // Initialise a "waiter" (OrderInvoker)
        waiter = new OrderInvoker();
        // Initialise the "Command" objects
        LightingOnCommand lightOnCommand = new LightingOnCommand(lighting);
        LightingOffCommand lightOffCommand = new LightingOffCommand(lighting);
        MusicOnCommand musicOnCommand = new MusicOnCommand(music);
        MusicOffCommand musicOffCommand = new MusicOffCommand(music);
        SwapNextMusicCommand swapNextMusicCommand = new SwapNextMusicCommand(music);
        SwapPrevMusicCommand swapPrevMusicCommand = new SwapPrevMusicCommand(music);
        // Set up our "Invoker" with the "Command" objects conditionally based on what button was pressed
        remote.setCommand(0, lightOnCommand, lightOffCommand);
        remote.setCommand(1, musicOnCommand, musicOffCommand);
        remote.setCommand(2, swapPrevMusicCommand, swapNextMusicCommand);
        remote.rightButtonPressed(0);
        remote.rightButtonPressed(1);
    }

    public void controlBackgroundMusic(Music music) {
        String path = music.getCurr_music();
        if (path != null){
            media = new Media(new File(path).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
            imgSpeakerNotes.setVisible(true);
            // Add an event listener for the end of the media
            mediaPlayer.setOnEndOfMedia(() -> {
                // Get the next music to play
                this.remote.rightButtonPressed(2);
                // Update the media player with the next music
                mediaPlayer.stop();
                controlBackgroundMusic(music);
            });
        }
        else{
            imgSpeakerNotes.setVisible(false);
        }
    }

    public void alertWarning(String message) {
        Alert alertBox = new Alert(Alert.AlertType.WARNING);
        alertBox.setContentText(message);
        alertBox.show();
    }

    //Singleton
    public void updateBudgetDisplay() {
        double currentBudget = Budget.getBudgetInstance().getBudget();
        budgetLabel.setText("Budget: " + currentBudget);
    }

    // Method to show the budget input dialog (Singleton)
    private void showBudgetInputDialog(CakeBakeryFacade cakeBakeryFacade, Stage stage, Button onOpenRestaurantButton, Button onCloseRestaurantButton, Button menuButton) {
        boolean validInput = false;

        while (!validInput) {
            TextInputDialog budgetInputDialog = new TextInputDialog();
            budgetInputDialog.setTitle("Budget Top Up Counter");
            budgetInputDialog.setHeaderText("Welcome To Cafe Bakery!");
            budgetInputDialog.setContentText("Please Enter Your Budget:");
            budgetInputDialog.setGraphic(null); // Remove the alert icon

            // Way to get the response value.
            Optional<String> result = budgetInputDialog.showAndWait();

            if (result.isPresent()) {
                try {
                    double budgetValue = Double.parseDouble(result.get());
                    Budget.getBudgetInstance().setBudget(budgetValue);
                    updateBudgetDisplay();
                    validInput = true; // Break the loop on valid input
                } catch (NumberFormatException e) {
                    // Handle invalid number input by showing the dialog again
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Input");
                    alert.setHeaderText("Invalid Budget");
                    alert.setContentText("Please Enter A Valid Number For The Budget.");
                    alert.showAndWait();
                    // Loop will continue if the input is not valid
                }
            } else {
                // User canceled the dialog
                validInput = true; // Exit the loop if the user cancels the dialog
            }
        }
    }

    // Method to show the budget top up dialog (Singleton)
    private void showBudgetTopUpDialog(Button topUpButton) {
        boolean validInput = false;

        while (!validInput) {
            TextInputDialog budgetTopUpDialog = new TextInputDialog();
            budgetTopUpDialog.setTitle("Budget Top Up Counter");
            budgetTopUpDialog.setHeaderText("Thank You and Have A Nice Day!");
            budgetTopUpDialog.setContentText("Please Enter Your Budget:");
            budgetTopUpDialog.setGraphic(null); // Remove the icon

            Optional<String> result = budgetTopUpDialog.showAndWait();

            if (result.isPresent()) {
                try {
                    double budgetValue1 = Double.parseDouble(result.get());
                    Budget.getBudgetInstance().topUp(budgetValue1);
                    updateBudgetDisplay();
                    validInput = true; // Break the loop on valid input
                } catch (NumberFormatException e) {
                    // Handle invalid number input by showing the dialog again
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Input");
                    alert.setHeaderText("Invalid Budget");
                    alert.setContentText("Please Enter A Valid Number For The Budget.");
                    alert.showAndWait();
                }
            } else {
                // User canceled the dialog
                validInput = true; // Exit the loop if the user cancels the dialog
            }
        }
    }

}
