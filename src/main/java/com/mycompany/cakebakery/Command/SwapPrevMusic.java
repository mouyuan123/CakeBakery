package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.Music;

public class SwapPrevMusic implements Command {
    
    private Music music;
    
    public SwapPrevMusic(Music music){
        this.music = music;
    }

    @Override
    public void execute() {
        this.music.swapLeft();
    }
    
}
