package com.mycompany.cakebakery.FactoryMethod;


public abstract class CakeFactory {

    abstract Cake createCake(String item);

    public Cake orderCake(String type) {
        Cake cake = createCake(type);
        System.out.println("--- Making a " + cake.getFlavour() + " ---");
        cake.prepare();
        cake.bake();
        cake.prepareCakeComponents();
        cake.assemble();
        cake.decorate();
        cake.chill();
        cake.box();
        return cake;
    }
}




