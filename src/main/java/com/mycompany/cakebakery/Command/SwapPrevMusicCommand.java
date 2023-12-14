package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.Music;

public class SwapPrevMusicCommand implements Command {
    
    private Music music;
    
    public SwapPrevMusicCommand(Music music){
        this.music = music;
    }

    @Override
    public void execute() {
        this.music.swapLeft();
    }
    
}
