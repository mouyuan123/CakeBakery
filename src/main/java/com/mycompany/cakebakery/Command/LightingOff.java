package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.Lighting;



public class LightingOff implements Command{
    
    private Lighting light;

    public LightingOff(Lighting light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.off();
    }
}
