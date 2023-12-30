package com.mycompany.cakebakery.FactoryMethod;

import com.mycompany.cakebakery.Constants.DirConstant;
import com.mycompany.cakebakery.Models.Condiment;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.ArrayList;

public abstract class Cake {

    private String flavour;
    private double price;
    private String cakeImg;
    ArrayList<Condiment> condiments = new ArrayList<Condiment>();


    public Cake(String flavour, double price, String cakeImg) {
        this.flavour = flavour;
        this.price = price;
        this.cakeImg = cakeImg;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCakeImg() {
        return cakeImg;
    }

    public void setCakeImg(String cakeImg) {
        this.cakeImg = cakeImg;
    }

    void prepare(ImageView imageView, Label label) {
        label.setText("Preparing ...");
        imageView.setImage(loadImage("/com/mycompany/cakebakery/picture/factory-process/1-Prepare.png"));
    }


    void bake(ImageView imageView, Label label) {
        label.setText("Baking the cake...");
        imageView.setImage(loadImage("/com/mycompany/cakebakery/picture/factory-process/2-Bake.png"));
    }


    void prepareCakeComponents(ImageView imageView, Label label) {
        label.setText("Preparing Cake Components...");
        imageView.setImage(loadImage("/com/mycompany/cakebakery/picture/factory-process/3-Prepare-Bake-Components.png"));

    }

    void assemble(ImageView imageView, Label label) {
        label.setText("Assembling the cake...");
        imageView.setImage(loadImage("/com/mycompany/cakebakery/picture/factory-process/4-Assemble.png"));
    }


    void decorate(ImageView imageView, Label label) {
        System.out.println("Adding condiments: ");
        for (Condiment condiment : condiments) {
            System.out.println("   " + condiment.getCondimentName());
        }
        label.setText("Adding Condiments to the cake...");
        imageView.setImage(loadImage("/com/mycompany/cakebakery/picture/factory-process/5-Decorate.png"));
    }


    void chill(ImageView imageView, Label label) {
        label.setText("Chilling the cake...");
        imageView.setImage(loadImage("/com/mycompany/cakebakery/picture/factory-process/6-Chill.png"));
    }


    void box(ImageView imageView, Label label) {
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

}
