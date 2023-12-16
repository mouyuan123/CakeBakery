package com.mycompany.cakebakery.Models;

import com.mycompany.cakebakery.Constants.DirConstant;

public class Lighting {
    
    private String LightingEffect;
    
    public Lighting(){
        this.off();
    }
    
    public void on(){
        this.LightingEffect = DirConstant.LIGHTING_PATH + "/lighting_on.png";
    };
    
    public void off(){
        this.LightingEffect = DirConstant.LIGHTING_PATH + "/lighting_off.png";
    };

    public String getLightingEffect() {
        return LightingEffect;
    }

    public void setLightingEffect(String LightingEffect) {
        this.LightingEffect = LightingEffect;
    } 
}
