package com.mycompany.cakebakery.Models;

import com.mycompany.cakebakery.Constants.DirConstant;

public class CakeBakery {
    
    private volatile static CakeBakery uniqueCakeBakeryInstance;
    
    private final String background = DirConstant.BACKGROUND_PATH + "/background.jpg";
    private final String waiter = DirConstant.WORKER_PATH + "/waiter.png";
    private final String closed_sign = DirConstant.BACKGROUND_PATH + "/closed_sign.png";
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

    public void setLight(Lighting light) {
        this.light = light;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public String getBackground() {
        return background;
    }

    public String getWaiter() {
        return waiter;
    }

    public String getClosed_sign() {
        return closed_sign;
    }

    public Menu getMenu() {
        return menu;
    }
}
