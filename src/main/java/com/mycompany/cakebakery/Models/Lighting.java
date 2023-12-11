package com.mycompany.cakebakery.Models;

public class Lighting {
    
    private String LightingEffect;
    
    public Lighting(){
        System.out.println("The light is off");
    }
    
    public void on(){
        System.out.println("The light is off");
    };
    
    public void off(){
        System.out.println("The light is on");
    };

    public String getLightingEffect() {
        return LightingEffect;
    }

    public void setLightingEffect(String LightingEffect) {
        this.LightingEffect = LightingEffect;
    } 
}
