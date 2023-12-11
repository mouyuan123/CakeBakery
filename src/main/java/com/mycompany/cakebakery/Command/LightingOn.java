package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.Lighting;


public class LightingOn implements Command{
    
    private Lighting light;

    public LightingOn(Lighting light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
