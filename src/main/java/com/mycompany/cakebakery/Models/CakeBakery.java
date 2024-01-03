package com.mycompany.cakebakery.Models;

public class CakeBakery {
    
    private volatile static CakeBakery uniqueCakeBakeryInstance;
    private Lighting light;
    private Music music;
    private Menu menu;
    
    private CakeBakery(){
        this.light = new Lighting();
        this.music = Music.getMusicInstance();
        this.menu = Menu.getMenuInstance();
    };
    
    public static CakeBakery getCakeBakeryInstance(){
        if (uniqueCakeBakeryInstance == null) {
            synchronized(CakeBakery.class) {
                if (uniqueCakeBakeryInstance == null) {
                    uniqueCakeBakeryInstance = new CakeBakery();
                }
            }
        }
        return uniqueCakeBakeryInstance;
    }

    public Lighting getLight() {
        return light;
    }

    public Music getMusic() {
        return music;
    }
    
    public Menu getMenu() {
        return menu;
    }
}
