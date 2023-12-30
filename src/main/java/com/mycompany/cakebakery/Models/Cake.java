package com.mycompany.cakebakery.Models;

import com.mycompany.cakebakery.Constants.DirConstant;
import javafx.scene.layout.StackPane;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Cake {

    private String flavour;
    private double price;
    private String cakeImg;

    private String cakeType;
    private List<String> decorations;

    public Cake(String flavour, double price, String cakeImg, String cakeType) {
        this.flavour = flavour;
        this.price = price;
        this.cakeImg = cakeImg;
         this.cakeType = cakeType;
        this.decorations = new ArrayList<>();
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

    public String getCakeType() {
        return cakeType;
    }

    public void setCakeType(String cakeType) {
        this.cakeType = cakeType;
    }

    public StackPane display(double width, double height) {
    StackPane pane = new StackPane();
    try {
        FileInputStream cakeInput = new FileInputStream(cakeImg);
        Image cakeImage = new Image(cakeInput, width, height, false, true);
        ImageView cakeImageView = new ImageView(cakeImage);
        pane.getChildren().add(cakeImageView);
    } catch (FileNotFoundException e) {
        System.out.println("Base cake image not found: " + e.getMessage());
    }

    double decorationSpacingX = 40.0; 
    double decorationWidth = width * 0.15; 
    double decorationHeight = height * 0.15;
    double totalDecorationWidth = decorationWidth * decorations.size() + decorationSpacingX * (decorations.size() - 1);
    double initialTranslateX = -totalDecorationWidth / 2 + decorationWidth / 2; 

    for (int i = 0; i < decorations.size(); i++) {
        String decoration = decorations.get(i);
        try {
            String decorationPath = DirConstant.CAKE_PATH + "/" + decoration;
            FileInputStream decorationInput = new FileInputStream(decorationPath);
            Image decorationImage = new Image(decorationInput, width, height, false, true);
            ImageView decorationImageView = new ImageView(decorationImage);

            decorationImageView.setFitWidth(decorationWidth);
            decorationImageView.setFitHeight(decorationHeight);

            // Position each decoration side by side
            double translateX = initialTranslateX + i * (decorationWidth + decorationSpacingX);
            double translateY = -height * 0.2; // Adjust this value as needed

            decorationImageView.setTranslateX(translateX);
            decorationImageView.setTranslateY(translateY);

            pane.getChildren().add(decorationImageView);
        } catch (FileNotFoundException e) {
            System.out.println("Decoration image not found: " + e.getMessage());
        }
    }

    return pane;
}

    public void addDecoration(String decoration) {
        decorations.add(decoration);
    }

    public List<String> getDecorations() {
        return decorations;
    }

}
