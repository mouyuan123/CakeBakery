package com.mycompany.cakebakery.Models;

import com.mycompany.cakebakery.Constants.DirConstant;
import java.io.FileInputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Background{
    
    private static final String Background_Path = DirConstant.BACKGROUND_PATH + "/background.jpg";
    private static final String Closed_Sign_Path = DirConstant.BACKGROUND_PATH + "/closed_sign.png";
    
    public static StackPane displayBakery(double width, double height){
        StackPane stackpane = new StackPane();
        try{
            FileInputStream input = new FileInputStream(Background_Path);
            Image image = new Image(input, width, height, false, false);
            ImageView imageView = new ImageView(image);
            stackpane.getChildren().add(imageView);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return stackpane;
    }
    
    public static StackPane displayBlackBackground(double width, double height, double opacity){
        StackPane stackpane = new StackPane();
        try{
            Rectangle rectangle = new Rectangle(width, height, Color.BLACK);
            rectangle.setOpacity(opacity);
            stackpane.getChildren().add(rectangle);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return stackpane;
    }
    
    public static StackPane displayClosedSign(double width, double height){
        StackPane stackpane = new StackPane();
        try{
            FileInputStream input = new FileInputStream(Closed_Sign_Path);
            Image image = new Image(input, width, height, false, false);
            ImageView imageView = new ImageView(image);
            stackpane.getChildren().add(imageView);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return stackpane;
    }
    
    public static StackPane displayView(double width, double height, String imgPath){
        StackPane stackpane = new StackPane();
        try{
            FileInputStream input = new FileInputStream(imgPath);
            Image image = new Image(input, width, height, false, false);
            ImageView imageView = new ImageView(image);
            stackpane.getChildren().add(imageView);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return stackpane;
    }
}
