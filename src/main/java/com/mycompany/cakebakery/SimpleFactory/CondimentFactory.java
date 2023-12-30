package com.mycompany.cakebakery.SimpleFactory;

import com.mycompany.cakebakery.Models.Condiment;

public class CondimentFactory {
    public Condiment createCondiment(String type) {
        switch (type) {
            case "chocolate chips":
                return new Chocolate();
            case "macaron":
                return new Macaroon();
            case "strawberry":
                return new Strawberry();
            default:
                throw new IllegalArgumentException("No Such Condiment");
        }
    }
}
