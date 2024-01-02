package com.mycompany.cakebakery;

import com.mycompany.cakebakery.Command.LightingOffCommand;
import com.mycompany.cakebakery.Command.LightingOnCommand;
import com.mycompany.cakebakery.Command.MusicOffCommand;
import com.mycompany.cakebakery.Command.MusicOnCommand;
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

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * JavaFX App
 */
public class CakeBakeryApplication extends Application {

    private Label budgetLabel;
    // Add a flag to track if the 'Open Restaurant' button has been clicked
    private boolean isFirstTimeOpenRestaurant = true;
    // Initialise Remote Control
    RemoteControl remote;
    Media media;
    MediaPlayer mediaPlayer;
//    Music music;
//    Lighting light;
    CakeBakery cakeBakery;
    CakeBakeryFacade cakeBakeryFacade;

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

    List<Cake> bakedCakesList;

    List<Cake> crepeCakesList;

    List<Condiment> condimentsList;

    Cake choosedCake;

    CakeItem choosedCakeItem;

    CakeItem historyCakeItem;
    ArrayList<String> choosedCondimentNameList = new ArrayList<String>();
    ArrayList<ImageView> choosedCondimentImageViewList = new ArrayList<ImageView>();
    Stack<CakeItem> decoratorsStack = new Stack<>();

    ChangeListener<Number> listener1;
    ChangeListener<Number> listener2;
    ChangeListener<Number> listener3;


    @Override
    public void start(Stage primaryStage) {
        try {
            this.cakeBakery = CakeBakery.getCakeBakeryInstance();
            // Initialise Remote Control
            this.remote = new RemoteControl();
            // Initialise the "Command" objects
            LightingOnCommand lightOnCommand = new LightingOnCommand(this.cakeBakery.getLight());
            LightingOffCommand lightOffCommand = new LightingOffCommand(this.cakeBakery.getLight());
            MusicOnCommand musicOnCommand = new MusicOnCommand(this.cakeBakery.getMusic());
            MusicOffCommand musicOffCommand = new MusicOffCommand(this.cakeBakery.getMusic());
            SwapNextMusicCommand swapNextMusicCommand = new SwapNextMusicCommand(this.cakeBakery.getMusic());
            SwapPrevMusicCommand swapPrevMusicCommand = new SwapPrevMusicCommand(this.cakeBakery.getMusic());
            // Set up our "Invoker" with the "Command" objects conditionally based on what button was pressed
            this.remote.setCommand(0, lightOnCommand, lightOffCommand);
            this.remote.setCommand(1, musicOnCommand, musicOffCommand);
            this.remote.setCommand(2, swapPrevMusicCommand, swapNextMusicCommand);
            this.remote.rightButtonPressed(0);
            this.remote.rightButtonPressed(1);

            // Initialise Budget Singleton
            Budget budget = Budget.getBudgetInstance();
            
            // Initialise Factory to make cake
            CrepeCakeFactory crepeCakeFactory = new CrepeCakeFactory();
            BakedCakeFactory bakedCakeFactory = new BakedCakeFactory();

            // Initialise Cake Bakery Facade
            this.cakeBakeryFacade = new CakeBakeryFacade(cakeBakery, budget, crepeCakeFactory, bakedCakeFactory);

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
        this.imgBackground.setImage(loadImage(this.cakeBakery.getLight().getLightingEffect()));
        controlBackgroundMusic(this.cakeBakery.getMusic());
        imgBakeryClosedBackground.setVisible(false);
        Menu menu = this.cakeBakery.getMenu();
        setMenu(menu);
        if (isFirstTimeOpenRestaurant) {
            spMain.setVisible(true);
            gpTopUp.setVisible(true);
//            btnTopUpCancel.setVisible(false);
            initializeListener();
            isFirstTimeOpenRestaurant = false;
        }
    }

    private void initializeListener(){
        listener1 = (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (!ignoreChange) {
                ignoreChange = true; // Set flag to ignore subsequent changes
                updateSpinnerMaximums();
                updateCondimentTotalPrice1(oldValue.intValue(), newValue.intValue());
                updateImageViews();
                ignoreChange = false; // Reset flag
            }
        };
        listener2 = (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (!ignoreChange) {
                ignoreChange = true; // Set flag to ignore subsequent changes
                updateSpinnerMaximums();
                updateCondimentTotalPrice2(oldValue.intValue(), newValue.intValue());
                updateImageViews();
                ignoreChange = false; // Reset flag
            }
        };
        listener3 = (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (!ignoreChange) {
                ignoreChange = true; // Set flag to ignore subsequent changes
                updateSpinnerMaximums();
                updateCondimentTotalPrice3(oldValue.intValue(), newValue.intValue());
                updateImageViews();
                ignoreChange = false; // Reset flag
            }
        };

//        updateImageViews();
        spinnerCondiment2.valueProperty().addListener(listener2);
        spinnerCondiment1.valueProperty().addListener(listener1);
        spinnerCondiment3.valueProperty().addListener(listener3);

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
        controlBackgroundMusic(this.cakeBakery.getMusic());
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
        this.imgBackground.setImage(loadImage(this.cakeBakery.getLight().getLightingEffect()));
    }

    @FXML
    private void onBtnLightOffClick(MouseEvent event) {
        // Handle click on btnLightOff
        this.remote.rightButtonPressed(0);
        this.imgBackground.setImage(loadImage(this.cakeBakery.getLight().getLightingEffect()));
    }

    @FXML
    private void onBtnPreviousSongClick(MouseEvent event) {
        if (mediaPlayer != null) mediaPlayer.stop();
        this.remote.leftButtonPressed(2);
        if (!this.cakeBakery.getMusic().isOff()) {
            controlBackgroundMusic(this.cakeBakery.getMusic());
        }
    }

    @FXML
    private void onBtnNextSongClick(MouseEvent event) {
        if (mediaPlayer != null) mediaPlayer.stop();
        this.remote.rightButtonPressed(2);
        if (!this.cakeBakery.getMusic().isOff()) {
            controlBackgroundMusic(this.cakeBakery.getMusic());
        }
    }

    @FXML
    private void onBtnStopMusicClick(MouseEvent event) {
        if (mediaPlayer != null) mediaPlayer.stop();
        this.remote.rightButtonPressed(1);
        controlBackgroundMusic(this.cakeBakery.getMusic());
    }

    @FXML
    private void onBtnPlayMusicClick(MouseEvent event) {
        if (mediaPlayer == null || !mediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING)) {
            this.remote.leftButtonPressed(1);
            controlBackgroundMusic(this.cakeBakery.getMusic());
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

    @FXML
    private void onBtnCrossCrepeCakeClick(MouseEvent event) {
        spMain.setVisible(false);
        spCrepeCake.setVisible(false);
    }

    @FXML
    private void onBtnCrossCondimentsClick(MouseEvent event) {
        spMain.setVisible(false);
        spCondiments.setVisible(false);
    }

    @FXML
    private void onBtnPayClick(MouseEvent event) throws InterruptedException {
        spCondiments.setVisible(false);
        gpFactoryProcess.setVisible(true);
        decoratorsStack = new Stack<>();
        System.out.println(choosedCondimentNameList);
        choosedCondimentImageViewList.add(imgFinalCondiment1);
        choosedCondimentImageViewList.add(imgFinalCondiment2);
        choosedCondimentImageViewList.add(imgFinalCondiment3);
        if (choosedCake.getCakeType().equals("Crepe Cake")) {
            CrepeCakeFactory crepeCakeFactory = new CrepeCakeFactory();
            crepeCakeFactory.orderCake(choosedCake.getCakeItemName().toLowerCase(), imgFactoryProcess, labelFactoryProcess, choosedCondimentNameList, choosedCondimentImageViewList, imgFinalCake, apFinalCakeItem, gpFactoryProcess, spMain);
        } else if (choosedCake.getCakeType().equals("Baked Cake")) {
            BakedCakeFactory bakedCakeFactory = new BakedCakeFactory();
            bakedCakeFactory.orderCake(choosedCake.getCakeItemName().toLowerCase(), imgFactoryProcess, labelFactoryProcess, choosedCondimentNameList, choosedCondimentImageViewList, imgFinalCake, apFinalCakeItem, gpFactoryProcess, spMain);
        }
        choosedCake = null;
        resetAllSpinners();
        choosedCakeItem = null;
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


    private boolean ignoreChange = false; // flag to ignore listener when programmatically setting value

    private void resetAllSpinners() {
        spinnerCondiment2.getValueFactory().setValue(0);
        spinnerCondiment1.getValueFactory().setValue(0);
        spinnerCondiment3.getValueFactory().setValue(0);
        // Center alignment can be set here or in the FXML/CSS
    }



    private void initializeSpinner() {
        choosedCakeItem = choosedCake.copy();
        decoratorsStack.push(choosedCakeItem);

    }

    private void safeUpdateSpinner(Spinner<Integer> spinner, ChangeListener<Number> listener, int min, int max, int value) {
        spinner.valueProperty().removeListener(listener);
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, value));
        spinner.valueProperty().addListener(listener);
    }



//    private void updateSpinnerMaximums() {
//        int total = calculateTotal();
//
//        int maxForCondiment2 = Math.max(0, 3 - total + spinnerCondiment2.getValue());
//        spinnerCondiment2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, maxForCondiment2, spinnerCondiment2.getValue()));
//        int maxForCondiment1 = Math.max(0, 3 - total + spinnerCondiment1.getValue());
//        spinnerCondiment1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, maxForCondiment1, spinnerCondiment1.getValue()));
//        int maxForCondiment3 = Math.max(0, 3 - total + spinnerCondiment3.getValue());
//        spinnerCondiment3.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, maxForCondiment3, spinnerCondiment3.getValue()));
//    }

    private void updateSpinnerMaximums() {
        int total = calculateTotal();

        int maxForCondiment2 = Math.max(0, 3 - total + spinnerCondiment2.getValue());
        safeUpdateSpinner(spinnerCondiment2, listener2, 0, maxForCondiment2, spinnerCondiment2.getValue());

        int maxForCondiment1 = Math.max(0, 3 - total + spinnerCondiment1.getValue());
        safeUpdateSpinner(spinnerCondiment1, listener1, 0, maxForCondiment1, spinnerCondiment1.getValue());

        int maxForCondiment3 = Math.max(0, 3 - total + spinnerCondiment3.getValue());
        safeUpdateSpinner(spinnerCondiment3, listener3, 0, maxForCondiment3, spinnerCondiment3.getValue());
    }


    private void updateCondimentTotalPrice1(int oldValue, int newValue) {

//        if(oldValue>newValue){
//            if(historyCakeItem instanceof Condiment)
//            {   Condiment historyCondiment =  (Condiment) historyCakeItem.getCakeItem();
//                choosedCakeItem =
//}
//        choosedCakeItem = historyCakeItem.getCakeItem();
//        }
        if (newValue > oldValue) {
            Condiment cakeItem = condimentsList.get(0).copy();
            cakeItem.setCakeItem(choosedCakeItem);
            choosedCakeItem = cakeItem;
            Condiment temp = ((Condiment) choosedCakeItem);
            decoratorsStack.push(choosedCakeItem);
        } else if (newValue < oldValue) removeLastDecorator();
        System.out.println("Total Price: $" + choosedCakeItem.getCakeItemPrice());

        labelTotalPrice.setText("Total Price: $" + choosedCakeItem.getCakeItemPrice());


    }

    private void updateCondimentTotalPrice2(int oldValue, int newValue) {
//        condimentsList.get(1).setCakeItem(choosedCakeItem);
//        choosedCakeItem = condimentsList.get(1);
//        System.out.println(choosedCakeItem.getCakeItemPrice());
//
//        labelTotalPrice.setText("Total Price: $" + choosedCakeItem.getCakeItemPrice());

        if (newValue > oldValue) {
            Condiment cakeItem = condimentsList.get(1).copy();
            cakeItem.setCakeItem(choosedCakeItem);
            choosedCakeItem = cakeItem;
            decoratorsStack.push(choosedCakeItem);
        } else if (newValue < oldValue) removeLastDecorator();
        System.out.println("Total Price: $" + choosedCakeItem.getCakeItemPrice());

        labelTotalPrice.setText("Total Price: $" + choosedCakeItem.getCakeItemPrice());

    }

    private void updateCondimentTotalPrice3(int oldValue, int newValue) {
//        condimentsList.get(2).setCakeItem(choosedCakeItem);
//        choosedCakeItem = condimentsList.get(2);
//        System.out.println(choosedCakeItem.getCakeItemPrice());
//        labelTotalPrice.setText("Total Price: $" + choosedCakeItem.getCakeItemPrice());
        if (newValue > oldValue) {
            Condiment cakeItem = condimentsList.get(2).copy();
            cakeItem.setCakeItem(choosedCakeItem);
            choosedCakeItem = cakeItem;
            decoratorsStack.push(choosedCakeItem);
        } else if (newValue < oldValue) removeLastDecorator();
        System.out.println("Total Price: $" + choosedCakeItem.getCakeItemPrice());
        labelTotalPrice.setText("Total Price: $" + choosedCakeItem.getCakeItemPrice());

    }

    public void removeLastDecorator() {
        if (!decoratorsStack.isEmpty()) {
            decoratorsStack.pop(); // Remove the latest decorator
            choosedCakeItem = decoratorsStack.isEmpty() ? choosedCake : decoratorsStack.peek();
        }
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

    public static void main(String[] args) throws IOException {
        launch();
    }


    public void controlBackgroundMusic(Music music) {
        String path = music.getCurr_music();
        if (path != null) {
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
        } else {
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
