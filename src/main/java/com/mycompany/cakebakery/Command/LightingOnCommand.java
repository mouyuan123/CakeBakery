package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.Lighting;


public class LightingOnCommand implements Command{
    
    private Lighting light;

    public LightingOnCommand(Lighting light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
