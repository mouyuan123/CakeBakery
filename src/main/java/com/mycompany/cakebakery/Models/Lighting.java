package com.mycompany.cakebakery.Models;

import com.mycompany.cakebakery.Constants.DirConstant;

public class Lighting {
    
    private String LightingEffect;
    
    public Lighting(){
        this.off();
    }
    
    public void on(){
        this.LightingEffect = DirConstant.BACKGROUND_PATH + "/light-on-cafe-bakery.png";
    };
    
    public void off(){
        this.LightingEffect = DirConstant.BACKGROUND_PATH + "/light-closed-cafe-bakery.png";
    };

    public String getLightingEffect() {
        return LightingEffect;
    }

    public void setLightingEffect(String LightingEffect) {
        this.LightingEffect = LightingEffect;
    } 
}
