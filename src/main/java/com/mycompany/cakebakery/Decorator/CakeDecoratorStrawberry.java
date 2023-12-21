package com.mycompany.cakebakery.Decorator;

import com.mycompany.cakebakery.Models.Cake;
import javafx.scene.layout.StackPane;

public class CakeDecoratorStrawberry extends CakeDecorator {

    public CakeDecoratorStrawberry(Cake cake) {
        super(cake);
        this.cake.addDecoration("cake_decoration_strawberry.png");
    }

    @Override
    public StackPane display(double width, double height) {
        return this.cake.display(width, height);
    }

}
