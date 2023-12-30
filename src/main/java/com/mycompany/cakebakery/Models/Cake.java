package com.mycompany.cakebakery.Models;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.ArrayList;

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
        imageView.setImage(loadImage("/com/mycompany/cakebakery/picture/factory-process/1-Prepare.png"));
    }


    public void bake(ImageView imageView, Label label) {
        label.setText("Baking the cake...");
        imageView.setImage(loadImage("/com/mycompany/cakebakery/picture/factory-process/2-Bake.png"));
    }


    public void prepareCakeComponents(ImageView imageView, Label label) {
        label.setText("Preparing Cake Components...");
        imageView.setImage(loadImage("/com/mycompany/cakebakery/picture/factory-process/3-Prepare-Bake-Components.png"));

    }

    public void assemble(ImageView imageView, Label label) {
        label.setText("Assembling the cake...");
        imageView.setImage(loadImage("/com/mycompany/cakebakery/picture/factory-process/4-Assemble.png"));
    }


    public void decorate(ImageView imageView, Label label) {
        System.out.println("Adding condiments: ");
//        for (Condiment condiment : condiments) {
//            System.out.println("   " + condiment.getCondimentName());
//        }
        label.setText("Adding Condiments to the cake...");
        imageView.setImage(loadImage("/com/mycompany/cakebakery/picture/factory-process/5-Decorate.png"));
    }


    public void chill(ImageView imageView, Label label) {
        label.setText("Chilling the cake...");
        imageView.setImage(loadImage("/com/mycompany/cakebakery/picture/factory-process/6-Chill.png"));
    }


    public void box(ImageView imageView, Label label) {
        label.setText("Box the cake...");
        imageView.setImage(loadImage("/com/mycompany/cakebakery/picture/factory-process/7-Box.png"));

    }

    void serve(ImageView imageView){

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
}
