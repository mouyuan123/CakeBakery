package com.mycompany.cakebakery.Command;

import com.mycompany.cakebakery.Models.Music;


public class MusicOffCommand implements Command{
    
    private Music music;

    public MusicOffCommand(Music music) {
        this.music = music;
    }
    
    @Override
    public void execute() {
        music.off();
    }
}
