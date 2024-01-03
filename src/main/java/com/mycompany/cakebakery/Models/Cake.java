package com.mycompany.cakebakery.Models;

import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.SimpleFactory.CondimentFactory;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public abstract class Cake extends CakeItem {

    String cakeType;
    ArrayList<Condiment> condiments = new ArrayList<Condiment>();

    public Cake(String cakeName, double price, String cakeImg, String cakeType) {
        this.cakeItemName = cakeName;
        this.cakeItemPrice = price;
        this.cakeItemImg = cakeImg;
        this.cakeType = cakeType;
    }

    public void prepare(ImageView imageView, Label label) {
        label.setText("Preparing ...");
        imageView.setImage(loadImage(DirConstant.FACTORY_PROCESS_PATH + "/1-Prepare.png"));
    }


    public void bake(ImageView imageView, Label label) {
        label.setText("Baking the cake...");
        imageView.setImage(loadImage(DirConstant.FACTORY_PROCESS_PATH + "/2-Bake.png"));
    }


    public void prepareCakeComponents(ImageView imageView, Label label) {
        label.setText("Preparing Cake Components...");
        imageView.setImage(loadImage(DirConstant.FACTORY_PROCESS_PATH + "/3-Prepare-Bake-Components.png"));

    }

    public void assemble(ImageView imageView, Label label) {
        label.setText("Assembling the cake...");
        imageView.setImage(loadImage(DirConstant.FACTORY_PROCESS_PATH + "/4-Assemble.png"));
    }


    public void decorate(ImageView imageView, Label label, List<String> condimentsName) {
        label.setText("Adding Decorations to the cake...");
        imageView.setImage(loadImage(DirConstant.FACTORY_PROCESS_PATH + "/5-Decorate.png"));

        new Thread(() -> {
            for (int i = 0; i < condimentsName.size(); i++) {
                try {
                    Thread.sleep(1000);
                    final int index = i;
                    Platform.runLater(() -> {
                        CondimentFactory condimentFactory = new CondimentFactory();
                        Condiment condiment = condimentFactory.addCondiment(condimentsName.get(index).toLowerCase(), label);
                        condiments.add(condiment);
                    });
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }


    public void showcase(ImageView imageView, Label label, List<ImageView> condimentsImageView, ImageView finalCakeImageView, AnchorPane finalCakeAp) {
        imageView.setVisible(false);
        finalCakeAp.setVisible(true);
        finalCakeImageView.setImage(loadImage(this.cakeItemImg));
        for (int i = 0; i < condimentsImageView.size(); i++) {
            condimentsImageView.get(i).setImage(null);
        }
        for (int i = 0; i < condiments.size(); i++) {
            condimentsImageView.get(i).setImage(loadImage(condiments.get(i).getCakeItemImg()));
        }
        label.setText("Final cake prepared...");
    }

    public void chill(ImageView imageView, Label label, AnchorPane finalCakeAp) {
        imageView.setVisible(true);
        finalCakeAp.setVisible(false);
        label.setText("Chilling the cake...");
        imageView.setImage(loadImage(DirConstant.FACTORY_PROCESS_PATH + "/6-Chill.png"));
    }


    public void box(ImageView imageView, Label label) {
        label.setText("Box the cake...");
        imageView.setImage(loadImage(DirConstant.FACTORY_PROCESS_PATH + "/7-Box.png"));

    }

    public void serve(ImageView imageView, Label label) {
        label.setText("Thanks for your Order! Welcome Again!");
        imageView.setImage(loadImage(DirConstant.FACTORY_PROCESS_PATH + "/8-Serve.png"));
    }

    private Image loadImage(String resourcePath) {
        InputStream stream = getClass().getResourceAsStream(resourcePath);
        if (stream == null) {
            throw new RuntimeException("Cannot get resource " + resourcePath);
        }
        return new Image(stream);
    }

    public String getCakeType() {
        return cakeType;
    }

    public void setCakeType(String cakeType) {
        this.cakeType = cakeType;
    }

    public abstract Cake copy();

}
