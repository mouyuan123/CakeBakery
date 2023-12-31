package com.mycompany.cakebakery.SimpleFactory;

import com.mycompany.cakebakery.Decorator.Chocolate;
import com.mycompany.cakebakery.Decorator.Macaroon;
import com.mycompany.cakebakery.Decorator.Strawberry;
import com.mycompany.cakebakery.Models.Condiment;
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

    public Condiment addCondiment(String type,Label label){
        Condiment condiment = createCondiment(type);
        condiment.add(label);
        return condiment;
    }


}
