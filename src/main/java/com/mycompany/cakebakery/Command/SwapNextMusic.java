package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.Music;

public class SwapNextMusic implements Command {
    
    private Music music;
    
    public SwapNextMusic(Music music){
        this.music = music;
    }

    @Override
    public void execute() {
        this.music.swapRight();
    }
    
}
