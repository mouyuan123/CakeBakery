package com.mycompany.cakebakery.FactoryMethod;

public class CrepeCakeFactory extends CakeFactory {
    @Override
    Cake createCake(String item) {
        if (item.equals("matcha")) {
            return new MatchaCrepeCake();
        } else if (item.equals("chocolate")) {
            return new ChocolateCrepeCake();
        } else if (item.equals("red velvet")) {
            return new RedVelvetCrepeCake();
        } else if (item.equals("vanilla")) {
            return new VanillaCrepeCake();
        }else if (item.equals("tiramisu")) {
            return new TiramisuCrepeCake();
        } else return null;
    }
}
