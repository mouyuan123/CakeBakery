package com.mycompany.cakebakery.SimpleFactory;

import com.mycompany.cakebakery.Decorator.Chocolate;
import com.mycompany.cakebakery.Decorator.Macaroon;
import com.mycompany.cakebakery.Decorator.Strawberry;
import com.mycompany.cakebakery.Models.Cake;
import com.mycompany.cakebakery.Models.Condiment;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class CondimentFactory {
    public Condiment createCondiment(String type) {
        switch (type) {
            case "chocolate":
                return new Chocolate();
            case "macaroon":
                return new Macaroon();
            case "strawberry":
                return new Strawberry();
            default:
                throw new IllegalArgumentException("No Such Condiment");
        }
    }

    public Condiment addCondiment(String item,Label label){
        Condiment condiment = createCondiment(item);
        condiment.add(label);
        return condiment;
    }


}
