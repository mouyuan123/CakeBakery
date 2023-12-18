package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.Music;

public class SwapNextMusicCommand implements Command {
    
    private Music music;
    
    public SwapNextMusicCommand(Music music){
        this.music = music;
    }

    @Override
    public void execute() {
        this.music.swapRight();
    }
    
}
