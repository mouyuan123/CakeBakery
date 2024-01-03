package com.mycompany.cakebakery.FactoryMethod;



import com.mycompany.cakebakery.Models.Cake;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.List;

public abstract class CakeFactory {

    abstract Cake createCake(String item);

    public Cake orderCake(String item, ImageView imageView, Label label, List<String> condimentsName, List<ImageView> condimentsImageView, ImageView finalCakeImageView, AnchorPane finalCakeAp, GridPane gpFactoryProcess, StackPane spMain) {
        Cake cake = createCake(item);
        System.out.println("--- Making a " + cake.getCakeItemName() + " ---");

        new Thread(() -> {
            try {
                Platform.runLater(() -> cake.prepare(imageView, label));
                Thread.sleep(2000);

                Platform.runLater(() -> cake.bake(imageView, label));
                Thread.sleep(2000);

                Platform.runLater(() -> cake.prepareCakeComponents(imageView, label));
                Thread.sleep(2000);

                Platform.runLater(() -> cake.assemble(imageView, label));
                Thread.sleep(2000);

                Platform.runLater(() -> {
                        cake.decorate(imageView, label,condimentsName);
                });
                Thread.sleep(4000);

                Platform.runLater(() -> cake.showcase(imageView, label, condimentsName, condimentsImageView, finalCakeImageView, finalCakeAp));
                Thread.sleep(2000);

                Platform.runLater(() -> cake.chill(imageView, label, finalCakeAp));
                Thread.sleep(2000);

                Platform.runLater(() -> cake.box(imageView, label));
                Thread.sleep(2000);

                Platform.runLater(() -> cake.serve(imageView, label));
                Thread.sleep(2000);

                gpFactoryProcess.setVisible(false);
                spMain.setVisible(false);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return cake;
    }

}




