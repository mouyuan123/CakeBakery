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
    private StackPane bakeryBackground;
    private Rectangle blackBackground;
    private BorderPane closedSignBackground;
    
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
    
    public static Rectangle displayBlackBackground(double width, double height, double opacity){
        Rectangle rectangle = new Rectangle(width, height, Color.BLACK);
        rectangle.setOpacity(opacity);
        return rectangle;
    }
    
    public static BorderPane displayClosedSign(double width, double height){
        BorderPane borderpane = new BorderPane();
        try{
            FileInputStream input = new FileInputStream(Closed_Sign_Path);
            Image image = new Image(input, width, height, false, false);
            ImageView imageView = new ImageView(image);
            borderpane.setCenter(imageView);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return borderpane;
    }
}
