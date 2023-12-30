package com.mycompany.cakebakery.FactoryMethod;



import com.mycompany.cakebakery.Models.Cake;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public abstract class CakeFactory {

    abstract Cake createCake(String item);

    public Cake orderCake(String item, ImageView imageView, Label label) {
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

                Platform.runLater(() -> cake.decorate(imageView, label));
                Thread.sleep(2000);

                Platform.runLater(() -> cake.chill(imageView, label));
                Thread.sleep(2000);

                Platform.runLater(() -> cake.box(imageView, label));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return cake;
    }

}




