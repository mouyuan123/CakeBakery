package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.Lighting;



public class LightingOffCommand implements Command{
    
    private Lighting light;

    public LightingOffCommand(Lighting light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.off();
    }
}
