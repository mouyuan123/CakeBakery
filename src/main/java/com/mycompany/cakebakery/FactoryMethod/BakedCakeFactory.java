package com.mycompany.cakebakery.FactoryMethod;

public class BakedCakeFactory extends CakeFactory {
    @Override
    Cake createCake(String item) {
        if (item.equals("matcha")) {
            return new MatchaCake();
        } else if (item.equals("chocolate")) {
            return new ChocolateCake();
        } else if (item.equals("red velvet")) {
            return new RedVelvetCake();
        } else if (item.equals("vanilla")) {
            return new VanillaCake();
        }else if (item.equals("tiramisu")) {
            return new TiramisuCake();
        } else return null;
    }
}
