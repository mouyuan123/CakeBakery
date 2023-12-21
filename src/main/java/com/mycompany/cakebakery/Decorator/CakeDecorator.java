package com.mycompany.cakebakery.Decorator;

import com.mycompany.cakebakery.Models.Cake;
import javafx.scene.layout.StackPane;

public abstract class CakeDecorator extends Cake {

    protected Cake cake;

    public CakeDecorator(Cake newCake) {
        super(newCake.getFlavour(), newCake.getPrice(), newCake.getCakeImg());
        this.cake = newCake;
    }

    @Override
    public abstract StackPane display(double width, double height);

}
